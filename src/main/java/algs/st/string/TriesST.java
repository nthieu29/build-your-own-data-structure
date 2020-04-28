package algs.st.string;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

public class TriesST<Value> implements StringSymbolTable<Value> {
    private static final int R = 256;
    private Node root;
    private int count;

    public TriesST() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public void put(String key, Value value) {
        this.root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, Value value, int indexInKey) {
        if (node == null) node = new Node();
        if (indexInKey == key.length()) {
            if (node.value == null) count++;
            node.value = value;
            return node;
        }
        char nextChar = key.charAt(indexInKey);
        node.next[nextChar] = put(node.next[nextChar], key, value, indexInKey + 1);
        return node;
    }

    @Override
    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int indexInKey) {
        if (node == null) return null;
        if (indexInKey == key.length()) return node;
        char nextChar = key.charAt(indexInKey);
        return get(node.next[nextChar], key, indexInKey + 1);
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("Key must be not null");
        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int indexInKey) {
        if (node == null) return null;
        if (indexInKey == key.length()) {
            count--;
            node.value = null;
        } else {
            char nextChar = key.charAt(indexInKey);
            node.next[nextChar] = delete(node.next[nextChar], key, indexInKey + 1);
        }
        // remove subtrie rooted at x if it is completely empty
        if (node.value != null) return node;
        for (int c = 0; c < R; c++)
            if (node.next[c] != null)
                return node;
        return null;
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
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node == null) return;
        if (node.value != null) queue.offer(prefix);
        for (char c = 0; c < R; c++) {
            collect(node.next[c], prefix + c, queue);
        }
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new ArrayQueue<>();
        Node rootNodeOfPrefix = get(root, prefix, 0);
        collect(rootNodeOfPrefix, prefix, queue);
        return queue;
    }

    private static class Node {
        Object value;
        Node[] next = new Node[R];
    }

}
