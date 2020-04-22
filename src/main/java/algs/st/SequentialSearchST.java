package algs.st;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

import java.util.NoSuchElementException;

public class SequentialSearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private Node first;
    private int count;

    public SequentialSearchST() {
        this.count = 0;
        this.first = null;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        if (value == null) {
            delete(key);
            return;
        }
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            Key currentKey = currentNode.key;
            if (currentKey.equals(key)) {
                currentNode.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        count++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        if (first.key.equals(key)) {
            first = null;
            count--;
        } else if (size() > 1) {
            Node previousNode = first;
            for (Node currentNode = first.next; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.key.equals(key)) {
                    count--;
                    previousNode.next = currentNode.next;
                }
                previousNode = previousNode.next;
            }
        }
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must be not null!");
        if (isEmpty()) throw new NoSuchElementException("Symbol table is empty!");
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            Key currentKey = currentNode.key;
            if (key.equals(currentKey)) return currentNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
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
    public Iterable<Key> keys() {
        Queue<Key> queue = new ArrayQueue<>();
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            queue.offer(currentNode.key);
        }
        return queue;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
