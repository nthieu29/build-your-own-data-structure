package algs.graph.undirected;

import algs.graph.Path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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
        Queue<Integer> queue = new ArrayDeque<>();
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
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x = destination; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
