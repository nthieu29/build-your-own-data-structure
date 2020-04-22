package algs.st.hash;

import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.st.SequentialSearchST;
import algs.st.SymbolTable;

public class SeparateChainingHashTable<Key, Value> implements SymbolTable<Key, Value> {
    private static final int DEFAULT_CAPACITY = 8;
    private SequentialSearchST<Key, Value>[] hashTable;
    private int count;
    private int capacity;

    public SeparateChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public SeparateChainingHashTable(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.hashTable = new SequentialSearchST[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new SequentialSearchST<>();
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key must no be null!");
        if (value == null) {
            delete(key);
            return;
        }
        if (count >= 10 * capacity) resize(2 * capacity);
        int index = hash(key);
        hashTable[index].put(key, value);
        count++;
    }

    public void delete(Key key) {
        int index = hash(key);
        if (contains(key)) count--;
        hashTable[index].delete(key);
        if (size() > DEFAULT_CAPACITY && size() <= 2 * capacity) resize(capacity / 2);
    }

    private int hash(Key key) {
        return key.hashCode() % capacity;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key must no be null!");
        int index = hash(key);
        return hashTable[index].get(key);
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
        for (int i = 0; i < capacity; i++) {
            for (Key key : hashTable[i].keys()) {
                queue.offer(key);
            }
        }
        return queue;
    }

    private void resize(int newCapacity) {
        SeparateChainingHashTable<Key, Value> newHashTable = new SeparateChainingHashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            for (Key key : hashTable[i].keys()) {
                newHashTable.put(key, hashTable[i].get(key));
            }
        }
        this.capacity = newCapacity;
        this.hashTable = newHashTable.hashTable;
        this.count = newHashTable.count;
    }
}
