package algs.graph.undirected;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndirectedDFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public UndirectedDFS(UndirectedGraph graph, int source) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(UndirectedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                edgeTo[adjacentVertex] = vertex;
                dfs(graph, adjacentVertex);
            }
        }
    }

    public boolean hasPathTo(int destination) {
        return marked[destination];
    }

    public Iterable<Integer> pathTo(int destination) {
        if (!hasPathTo(destination)) return null;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x = destination; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
