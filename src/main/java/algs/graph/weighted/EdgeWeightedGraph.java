package algs.graph.weighted;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private List<Edge>[] adj;
    private int numberOfVertices;
    private int numberOfEdges;

    public EdgeWeightedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adj = (ArrayList<Edge>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        numberOfEdges++;
    }

    public Iterable<Edge> adj(int vertex) {
        return adj[vertex];
    }

    public Iterable<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            for (Edge edge : adj[i]) {
                if (edge.other(i) > i) edges.add(edge);
            }
        }
        return edges;
    }

    public int getNumberOfEdges() {
        return this.numberOfEdges;
    }

    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }
}
