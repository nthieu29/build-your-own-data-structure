package algs.graph.directed;

import algs.graph.Path;
import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.stack.ArrayStack;
import algs.stack.Stack;


public class DirectedBFS implements Path {
    private int[] edgeTo;
    private boolean[] marked;
    private int source;

    public DirectedBFS(DirectedGraph graph, int source) {
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(DirectedGraph graph, int source) {
        Queue<Integer> queue = new ArrayQueue<>();
        marked[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Integer adjacentVertex : graph.adj(vertex)) {
                if (!marked[adjacentVertex]) {
                    marked[adjacentVertex] = true;
                    edgeTo[adjacentVertex] = vertex;
                    queue.offer(adjacentVertex);
                }
            }
        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return this.marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new ArrayStack<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
