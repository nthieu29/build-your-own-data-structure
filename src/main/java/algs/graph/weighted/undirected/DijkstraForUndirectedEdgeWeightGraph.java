package algs.graph.weighted.undirected;

import java.util.*;

public class DijkstraForUndirectedEdgeWeightGraph {
    private int source;
    private boolean[] marked;
    private int[] edgeTo;
    private double[] distTo;
    private Queue<Integer> queue;

    public DijkstraForUndirectedEdgeWeightGraph(EdgeWeightedGraph graph, int source) {
        this.source = source;
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.distTo = new double[graph.getNumberOfVertices()];
        this.queue = new PriorityQueue<>(Comparator.comparingDouble(a -> distTo[a]));
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            this.distTo[i] = Double.MAX_VALUE;
        }
        this.distTo[source] = 0;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            marked[currentVertex] = true;
            for (Edge adjacentEdgeOfCurrentVertex : graph.adj(currentVertex)) {
                updateDistance(adjacentEdgeOfCurrentVertex, currentVertex);
            }
        }
    }

    private void updateDistance(Edge edge, int from) {
        int to = edge.other(from);
        if (distTo[to] > distTo[from] + edge.getWeight()) {
            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = from;
            if (!marked[to]) {
                queue.offer(to);
            }
        }
    }

    public double distTo(int vertex) {
        return this.distTo[vertex];
    }

    public Iterable<Integer> pathTo(int destination) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x = edgeTo[destination]; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
