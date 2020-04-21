package algs.st;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

import java.util.NoSuchElementException;

public class RedBlackTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private Node root;

    public RedBlackTree() {
        this.root = null;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.isRed;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1, true);
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColor(node);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        rightChild.isRed = node.isRed;
        rightChild.left.isRed = true;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.isRed = node.isRed;
        leftChild.right.isRed = true;
        return leftChild;
    }

    private void flipColor(Node node) {
        node.left.isRed = false;
        node.right.isRed = false;
        node.isRed = true;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must be not null");
        Node node = this.root;
        while (node != null) {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                node = node.left;
            } else if (compare > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Empty symbol table!");
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Empty symbol table!");
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new ArrayQueue<>();
        inOrder(root, queue);
        return queue;
    }

    private void inOrder(Node node, Queue<Key> queue) {
        if (node == null) return;
        inOrder(node.left, queue);
        queue.offer(node.key);
        inOrder(node.right, queue);
    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        boolean isRed;

        Node(Key key, Value value, int size, boolean isRed) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.isRed = isRed;
        }

        boolean isRed() {
            return isRed;
        }
    }
}
