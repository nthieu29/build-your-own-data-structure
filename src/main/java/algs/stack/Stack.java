package algs.stack;

public interface Stack<E> {
    void push(E e);

    E pop();

    boolean isEmpty();

    int size();
}
