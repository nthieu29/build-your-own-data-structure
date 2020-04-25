package algs.graph.weighted.directed;

public interface ShortestPath {
    double distTo(int vertex);

    Iterable<DirectedEdge> pathTo(int vertex);
}
