package algs.st.hash;

import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.st.SymbolTable;

public class LinearProbingHashTable<Key, Value> implements SymbolTable<Key, Value> {
    private static final int DEFAULT_CAPACITY = 8;
    private Key[] keys;
    private Value[] values;
    private int count;
    private int capacity;

    public LinearProbingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.keys = (Key[]) new Object[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        if (count >= capacity / 2) resize(2 * capacity);
        int index;
        for (index = hash(key); keys[index] != null; index = (index + 1) % capacity) {
            if (keys[index].equals(key)) break;
        }
        keys[index] = key;
        values[index] = value;
        count++;
    }

    private int hash(Key key) {
        return key.hashCode() % capacity;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        int index;
        for (index = hash(key); keys[index] != null; index = (index + 1) % capacity) {
            if (keys[index].equals(key)) return values[index];
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
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
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) queue.offer(keys[i]);
        }
        return queue;
    }

    public void resize(int newCapacity) {
        LinearProbingHashTable<Key, Value> newHashTable = new LinearProbingHashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newHashTable.put(keys[i], values[i]);
            }
        }
        this.keys = newHashTable.keys;
        this.values = newHashTable.values;
        this.capacity = newCapacity;
    }
}
