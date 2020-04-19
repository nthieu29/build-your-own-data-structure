package algs.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node first;
    private Node last;
    private int count;

    public LinkedQueue() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    @Override
    public void offer(E e) {
        Node oldLast = last;
        last = new Node();
        last.element = e;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        count++;
    }

    @Override
    public E poll() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!");
        E result = first.element;
        first = first.next;
        count--;
        if (isEmpty()) last = null;
        return result;
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
        return new LinkedQueueIterator();
    }

    private class Node {
        E element;
        Node next;
    }

    private class LinkedQueueIterator implements Iterator<E> {
        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E result = currentNode.element;
            currentNode = currentNode.next;
            return result;
        }
    }
}
