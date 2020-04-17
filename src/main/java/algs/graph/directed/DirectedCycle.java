package algs.graph.directed;

import java.util.ArrayDeque;
import java.util.Deque;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Deque<Integer> cycle;

    public DirectedCycle(Digraph graph) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.onStack = new boolean[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(graph, i);
        }
    }

    private void dfs(Digraph graph, int vertex) {
        onStack[vertex] = true;
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (hasCycle()) return;
            if (!marked[adjacentVertex]) {
                edgeTo[adjacentVertex] = vertex;
                dfs(graph, adjacentVertex);
            } else if (onStack[adjacentVertex]) {
                cycle = new ArrayDeque<>();
                for (int x = vertex; x != adjacentVertex; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(adjacentVertex);
                cycle.push(vertex);
            }
        }
        onStack[vertex] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return this.cycle;
    }
}
