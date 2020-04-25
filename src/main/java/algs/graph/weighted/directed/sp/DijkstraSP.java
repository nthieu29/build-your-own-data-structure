package algs.graph.weighted.directed.sp;


import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import algs.queue.IndexMinPQ;
import algs.stack.ArrayStack;
import algs.stack.Stack;


public class DijkstraSP implements ShortestPath {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> queue;

    public DijkstraSP(EdgeWeightDirectedGraph graph, int source) {
        this.edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        this.distTo = new double[graph.getNumberOfVertices()];
        this.queue = new IndexMinPQ<>(graph.getNumberOfVertices());
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[source] = 0;
        queue.insert(source, 0.0);
        while (!queue.isEmpty()) {
            int currentVertex = queue.delMin();
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
            if (queue.contains(to)) {
                queue.decreaseKey(to, distTo[to]);
            } else {
                queue.insert(to, distTo[to]);
            }
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
