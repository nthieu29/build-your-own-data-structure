package algs.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * Array implementation for Queue.
 * Main idea is use the circular array. Circular array is the array with last index + 1 = first index.
 * We will need to keep track the first index pointer and last index pointer, current count.
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private E[] queue;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private int count;

    public ArrayQueue() {
        this.count = 0;
        this.queue = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueue(int capacity) {
        this.count = 0;
        this.queue = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) {
        if (size() == queue.length - 1) resize(2 * queue.length);
        queue[lastIndex] = e;
        increaseLastIndex();
        count++;
    }

    @Override
    public E poll() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!");
        E result = queue[firstIndex];
        queue[firstIndex] = null;
        increaseFirstIndex();
        count--;
        if (size() == queue.length / 4 && size() > 0) resize(queue.length / 2);
        return result;
    }

    private void resize(int newCapacity) {
        E[] newQueue = (E[]) new Object[newCapacity];
        int indexInNewQueue = 0;
        for (int i = firstIndex; i != lastIndex; i = getNextIndexOf(i)) {
            newQueue[indexInNewQueue] = queue[i];
            indexInNewQueue++;
        }
        this.queue = newQueue;
        firstIndex = 0;
        lastIndex = count;
    }

    private void increaseLastIndex() {
        lastIndex = getNextIndexOf(lastIndex);
    }

    private void increaseFirstIndex() {
        firstIndex = getNextIndexOf(firstIndex);
    }

    private int getNextIndexOf(int index) {
        if (index == queue.length - 1) {
            return 0;
        } else {
            return index + 1;
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

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<E> {
        private int currentIndex = firstIndex;

        @Override
        public boolean hasNext() {
            return currentIndex != lastIndex;
        }

        @Override
        public E next() {
            E result = queue[currentIndex];
            currentIndex = getNextIndexOf(currentIndex);
            return result;
        }
    }
}
