package algs.graph.weighted.directed.sp;

import algs.graph.weighted.directed.DirectedEdge;

public interface ShortestPath {
    double distTo(int vertex);

    Iterable<DirectedEdge> pathTo(int vertex);
}
