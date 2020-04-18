package algs.graph.directed;

import algs.graph.Path;

import java.util.ArrayDeque;
import java.util.Deque;

public class DirectedDFS implements Path {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DirectedDFS(DirectedGraph graph, int source) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(DirectedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                edgeTo[adjacentVertex] = vertex;
                dfs(graph, adjacentVertex);
            }
        }
    }

    @Override
    public boolean hasPathTo(int vertex) {
        return this.marked[vertex];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
