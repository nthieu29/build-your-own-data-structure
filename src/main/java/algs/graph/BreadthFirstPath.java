package algs.graph;

import algs.graph.undirected.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BreadthFirstPath {
    private int source;
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPath(Graph graph, int source) {
        this.source = source;
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
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
