package algs.queue;

public interface Queue<E> extends Iterable<E> {
    void offer(E e);

    E poll();

    int size();

    boolean isEmpty();
}
