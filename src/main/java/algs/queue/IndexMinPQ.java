package algs.queue;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int count;
    private Key[] keys;
    private int[] heap;
    private int[] indexInHeap;

    public IndexMinPQ(int capacity) {
        this.count = 0;
        this.keys = (Key[]) new Comparable[capacity];
        this.indexInHeap = new int[capacity];
        this.heap = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            indexInHeap[i] = -1;
        }
    }

    public void insert(int index, Key key) {
        this.count++;
        indexInHeap[index] = count;
        heap[count] = index;
        keys[index] = key;
        swim(count);
    }

    private void swim(int k) {
        while (k > 1 && isGreaterThan(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && isGreaterThan(j, j + 1)) j++;
            if (!isGreaterThan(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int a, int b) {
        int swap = heap[a];
        heap[a] = heap[b];
        heap[b] = swap;
        indexInHeap[heap[a]] = a;
        indexInHeap[heap[b]] = b;
    }

    private boolean isGreaterThan(int a, int b) {
        return keys[heap[a]].compareTo(keys[heap[b]]) > 0;
    }

    public int delMin() {
        int min = heap[1];
        exchange(1, count);
        count--;
        sink(1);
        indexInHeap[min] = -1;
        keys[min] = null;
        heap[count + 1] = -1;
        return min;
    }

    public void decreaseKey(int index, Key key) {
        keys[index] = key;
        swim(indexInHeap[index]);
    }

    public void increaseKey(int index, Key key) {
        keys[index] = key;
        sink(indexInHeap[index]);
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean contains(int index) {
        return indexInHeap[index] != -1;
    }
}
