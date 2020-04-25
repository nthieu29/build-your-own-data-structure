package algs.graph.weighted.directed;

import algs.queue.ArrayQueue;
import algs.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightDirectedGraph {
    private List<DirectedEdge>[] adj;
    private int numberOfEdges;
    private int numberOfVertices;

    public EdgeWeightDirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        this.adj = new List[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge edge) {
        int from = edge.from();
        adj[from].add(edge);
        numberOfEdges++;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Queue<DirectedEdge> queue = new ArrayQueue<>();
        for (int i = 0; i < numberOfVertices; i++) {
            for (DirectedEdge edge : adj[i]) {
                queue.offer(edge);
            }
        }
        return queue;
    }
}
