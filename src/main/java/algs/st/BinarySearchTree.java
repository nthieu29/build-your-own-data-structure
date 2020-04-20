package algs.st;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public Value get(Key key) {
        Node currentNode = root;
        while (currentNode != null) {
            int compare = key.compareTo(currentNode.key);
            if (compare < 0) {
                currentNode = currentNode.left;
            } else if (compare > 0) {
                currentNode = currentNode.right;
            } else {
                return currentNode.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
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
        return root == null;
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

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
}
