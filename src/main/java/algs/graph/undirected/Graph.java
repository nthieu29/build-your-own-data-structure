package algs.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int numberOfVertices;
    private int numberOfEdges;
    private List<Integer>[] adj;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        this.adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.numberOfEdges++;
    }

    public Iterable<Integer> adj(int vertex) {
        return this.adj[vertex];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }
}
