package algs.graph.undirected;

import algs.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph implements Graph {
    private final int numberOfVertices;
    private int numberOfEdges;
    private List<Integer>[] adj;

    public UndirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        this.adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.numberOfEdges++;
    }

    @Override
    public Iterable<Integer> adj(int vertex) {
        return this.adj[vertex];
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }
}
