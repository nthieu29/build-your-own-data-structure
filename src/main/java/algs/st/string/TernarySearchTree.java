package algs.st.string;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

public class TernarySearchTree<Value> implements StringSymbolTable<Value> {
    private int count;
    private Node root;

    public TernarySearchTree() {
        this.count = 0;
        this.root = null;
    }

    @Override
    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, Value value, int indexInKey) {
        char currentCharacter = key.charAt(indexInKey);
        if (node == null) node = new Node(currentCharacter);
        if (currentCharacter < node.character) {
            node.left = put(node.left, key, value, indexInKey);
        } else if (currentCharacter > node.character) {
            node.right = put(node.right, key, value, indexInKey);
        } else if (indexInKey < key.length() - 1) {
            node.mid = put(node.mid, key, value, indexInKey + 1);
        } else {
            if (node.value == null) count++;
            node.value = value;
        }
        return node;
    }

    @Override
    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return node.value;
    }

    private Node get(Node node, String key, int indexInKey) {
        if (node == null) return null;
        char currentCharacter = key.charAt(indexInKey);
        if (currentCharacter < node.character) {
            return get(node.left, key, indexInKey);
        } else if (currentCharacter > node.character) {
            return get(node.right, key, indexInKey);
        } else if (indexInKey < key.length() - 1) {
            return get(node.mid, key, indexInKey + 1);
        } else {
            return node;
        }
    }

    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> queue = new ArrayQueue<>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new ArrayQueue<>();
        Node rootNodeOfPrefix = get(root, prefix, 0);
        if (rootNodeOfPrefix == null) return queue;
        if (rootNodeOfPrefix.value != null) queue.offer(prefix);
        collect(rootNodeOfPrefix.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    private void collect(Node node, StringBuilder prefix, Queue<String> queue) {
        if (node == null) return;
        collect(node.left, prefix, queue);
        if (node.value != null) {
            queue.offer(prefix.toString() + node.character);
        }
        collect(node.mid, prefix.append(node.character), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(node.right, prefix, queue);
    }

    private class Node {
        private Value value;
        private char character;
        private Node left;
        private Node right;
        private Node mid;

        public Node(char character) {
            this.character = character;
        }
    }
}
