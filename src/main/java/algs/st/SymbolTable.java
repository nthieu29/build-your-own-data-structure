package algs.st;

public interface SymbolTable<Key, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    boolean contains(Key key);

    int size();

    boolean isEmpty();

    Iterable<Key> keys();
}
