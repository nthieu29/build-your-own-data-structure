package algs.graph.undirected;

import algs.graph.Path;
import algs.stack.ArrayStack;
import algs.stack.Stack;


public class UndirectedDFS implements Path {
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

    @Override
    public boolean hasPathTo(int destination) {
        return marked[destination];
    }

    @Override
    public Iterable<Integer> pathTo(int destination) {
        if (!hasPathTo(destination)) return null;
        Stack<Integer> stack = new ArrayStack<>();
        for (int x = destination; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
