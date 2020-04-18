package algs.graph.directed;

import algs.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DirectedGraph implements Graph {
    private List<Integer>[] adj;
    private int numberOfVertices;
    private int numberOfEdges;

    public DirectedGraph(int numberOfVertices) {
        this.numberOfEdges = 0;
        this.numberOfVertices = numberOfVertices;
        this.adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        numberOfEdges++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public DirectedGraph reverse() {
        DirectedGraph directedGraph = new DirectedGraph(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            for (Integer v : adj(i)) {
                directedGraph.addEdge(v, i);
            }
        }
        return directedGraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedGraph directedGraph = (DirectedGraph) o;
        return numberOfVertices == directedGraph.numberOfVertices &&
                numberOfEdges == directedGraph.numberOfEdges &&
                Arrays.equals(adj, directedGraph.adj);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfVertices, numberOfEdges);
        result = 31 * result + Arrays.hashCode(adj);
        return result;
    }
}
