package algs.stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node first;
    private int count;

    public LinkedStack() {
        this.first = null;
        this.count = 0;
    }

    @Override
    public void push(E e) {
        Node newNode = new Node();
        newNode.element = e;
        newNode.next = first;
        this.first = newNode;
        count++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty!");
        E result = first.element;
        first = first.next;
        count--;
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

    private class Node {
        E element;
        Node next;
    }


}
