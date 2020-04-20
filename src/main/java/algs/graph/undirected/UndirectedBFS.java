package algs.graph.undirected;

import algs.graph.Path;
import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.stack.ArrayStack;
import algs.stack.Stack;

public class UndirectedBFS implements Path {
    private int source;
    private boolean[] marked;
    private int[] edgeTo;

    public UndirectedBFS(UndirectedGraph graph, int source) {
        this.source = source;
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        bfs(graph, source);
    }

    private void bfs(UndirectedGraph graph, int source) {
        Queue<Integer> queue = new ArrayQueue<>();
        marked[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (Integer adjacentVertex : graph.adj(currentVertex)) {
                if (!marked[adjacentVertex]) {
                    queue.offer(adjacentVertex);
                    marked[adjacentVertex] = true;
                    edgeTo[adjacentVertex] = currentVertex;
                }
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
