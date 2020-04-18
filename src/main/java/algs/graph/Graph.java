package algs.graph;

public interface Graph {
    int getNumberOfVertices();

    int getNumberOfEdges();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int vertex);
}
