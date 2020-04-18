package algs.graph;

public interface Path {
    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);
}
