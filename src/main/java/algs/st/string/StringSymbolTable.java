package algs.st.string;

public interface StringSymbolTable<Value> {
    void put(String key, Value value);

    Value get(String key);

    boolean contains(String key);

    int size();

    boolean isEmpty();

    Iterable<String> keys();

    Iterable<String> keysWithPrefix(String prefix);
}
