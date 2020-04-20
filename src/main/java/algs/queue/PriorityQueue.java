package algs.queue;

import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private E[] queue;
    private int count;
    private boolean minOrder;

    public PriorityQueue(int capacity) {
        this.count = 0;
        this.minOrder = false;
        this.queue = (E[]) new Comparable[capacity + 1];
    }

    public PriorityQueue(int capacity, boolean minOrder) {
        this.count = 0;
        this.minOrder = minOrder;
        this.queue = (E[]) new Comparable[capacity + 1];
    }

    @Override
    public void offer(E e) {
        count++;
        queue[count] = e;
        swim(count);
    }

    private void swim(int index) {
        while (index > 1 && less(index / 2, index)) {
            exchange(index / 2, index);
            index = index / 2;
        }
    }

    @Override
    public E poll() {
        E result = queue[1];
        exchange(1, count);
        count--;
        sink(1);
        return result;
    }

    private void sink(int index) {
        while (2 * index <= count) {
            int childIndex = 2 * index;
            if (childIndex < count && less(childIndex, childIndex + 1)) childIndex++;
            if (!less(index, childIndex)) break;
            exchange(index, childIndex);
            index = childIndex;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    private boolean less(int indexA, int indexB) {
        boolean result = false;
        if (queue[indexA].compareTo(queue[indexB]) < 0) result = true;
        if (minOrder) result = !result;
        return result;
    }

    private void exchange(int indexA, int indexB) {
        E temp = queue[indexA];
        queue[indexA] = queue[indexB];
        queue[indexB] = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new PriorityQueueIterator();
    }

    private class PriorityQueueIterator implements Iterator<E> {
        PriorityQueue<E> queueIterator;

        PriorityQueueIterator() {
            queueIterator = new PriorityQueue<>(queue.length, minOrder);
            System.arraycopy(queue, 0, queueIterator.queue, 0, count + 1);
            queueIterator.count = count;
        }

        @Override
        public boolean hasNext() {
            return !queueIterator.isEmpty();
        }

        @Override
        public E next() {
            return queueIterator.poll();
        }
    }
}
