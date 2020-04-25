package algs.graph.weighted.directed.sp;

import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedCycle;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.stack.ArrayStack;
import algs.stack.Stack;

public class BellmanFordSP implements ShortestPath {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQueue;
    private Queue<Integer> queue;
    private Iterable<DirectedEdge> cycle;
    private int cost; //number of calls to relax()

    public BellmanFordSP(EdgeWeightDirectedGraph graph, int source) {
        this.distTo = new double[graph.getNumberOfVertices()];
        this.edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        this.onQueue = new boolean[graph.getNumberOfVertices()];
        this.queue = new ArrayQueue<>();
        this.cycle = null;
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[source] = 0;
        // Bellman-Ford algorithm
        this.queue = new ArrayQueue<>();
        queue.offer(source);
        this.onQueue[source] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int currentVertex = queue.poll();
            onQueue[currentVertex] = false;
            relax(graph, currentVertex);
        }
    }

    private void relax(EdgeWeightDirectedGraph graph, int vertex) {
        for (DirectedEdge edge : graph.adj(vertex)) {
            int fromVertex = edge.from();
            int toVertex = edge.to();
            if (distTo[toVertex] > distTo[fromVertex] + edge.getWeight()) {
                distTo[toVertex] = distTo[fromVertex] + edge.getWeight();
                edgeTo[toVertex] = edge;
                if (!onQueue[toVertex]) {
                    queue.offer(toVertex);
                    onQueue[toVertex] = true;
                }
            }
            if (++cost % graph.getNumberOfVertices() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;
            }
        }
    }

    private void findNegativeCycle() {
        int numberOfVertices = edgeTo.length;
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            if (edgeTo[i] != null) {
                graph.addEdge(edgeTo[i]);
            }
        }
        EdgeWeightDirectedCycle cycleFinder = new EdgeWeightDirectedCycle(graph);
        this.cycle = cycleFinder.cycle();
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

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return this.cycle;
    }
}
