package algs.graph.weighted.directed.sp;


import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import algs.stack.ArrayStack;
import algs.stack.Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * Compute the shortest path of the non-negative weight directed graph by Dijkstra's algorithm.
 * Main idea:
 * - Consider vertices in increasing order of distance from source (non-tree vertex with lowest distTo[] value).
 * - Add vertex to the tree and relax all edges pointing from that vertex.
 * Time complexity: E log V
 * Space complexity: V
 */

public class DijkstraSP implements ShortestPath {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private Queue<Integer> queue;
    private boolean[] marked;

    public DijkstraSP(EdgeWeightDirectedGraph graph, int source) {
        this.edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        this.distTo = new double[graph.getNumberOfVertices()];
        this.queue = new PriorityQueue<>(Comparator.comparingDouble(a -> distTo[a]));
        this.marked = new boolean[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[source] = 0;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            marked[currentVertex] = true;
            for (DirectedEdge edge : graph.adj(currentVertex)) {
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge) {
        int from = edge.from();
        int to = edge.to();
        if (distTo[to] > distTo[from] + edge.getWeight()) {
            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = edge;
            if (!marked[to]) {
                queue.offer(to);
            } // else if marked[to] -> remove -> add again
        }
    }

    @Override
    public double distTo(int vertex) {
        return this.distTo[vertex];
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int vertex) {
        Stack<DirectedEdge> stack = new ArrayStack<>();
        for (DirectedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()])
            stack.push(edge);
        return stack;
    }
}
