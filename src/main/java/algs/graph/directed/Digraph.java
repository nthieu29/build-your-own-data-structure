package algs.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Digraph {
    private List<Integer>[] adj;
    private int numberOfVertices;
    private int numberOfEdges;

    public Digraph(int numberOfVertices) {
        this.numberOfEdges = 0;
        this.numberOfVertices = numberOfVertices;
        this.adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        numberOfEdges++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            for (Integer v : adj(i)) {
                digraph.addEdge(v, i);
            }
        }
        return digraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digraph digraph = (Digraph) o;
        return numberOfVertices == digraph.numberOfVertices &&
                numberOfEdges == digraph.numberOfEdges &&
                Arrays.equals(adj, digraph.adj);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfVertices, numberOfEdges);
        result = 31 * result + Arrays.hashCode(adj);
        return result;
    }
}
