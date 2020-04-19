package algs.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private E[] stack;
    private int count;

    public ArrayStack() {
        this.count = 0;
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.count = 0;
        this.stack = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (count == stack.length) resize(stack.length * 2);
        stack[count] = e;
        count++;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = stack[i];
        }
        this.stack = newArray;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty!");
        E result = stack[count - 1];
        stack[count - 1] = null;
        count--;
        if (count > 0 && count == stack.length / 4) resize(stack.length / 2);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int currentIndex = size();

        @Override
        public boolean hasNext() {
            return currentIndex > 0;
        }

        @Override
        public E next() {
            E result = stack[currentIndex - 1];
            currentIndex--;
            return result;
        }
    }
}
