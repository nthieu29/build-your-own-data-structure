package algs.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private E[] array;
    private int count;

    public ArrayStack() {
        this.count = 0;
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.count = 0;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (count == array.length) resize(array.length * 2);
        array[count] = e;
        count++;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty!");
        E result = array[count - 1];
        array[count - 1] = null;
        count--;
        if (count > 0 && count == array.length / 4) resize(array.length / 2);
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
}
