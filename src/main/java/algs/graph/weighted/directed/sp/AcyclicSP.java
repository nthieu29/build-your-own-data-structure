package algs.graph.weighted.directed.sp;

import algs.graph.directed.Topological;
import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import algs.stack.ArrayStack;
import algs.stack.Stack;

/***
 * Compute the shortest path in a directed weight graph by topological sort.
 * Idea:
 *  - Consider the vertices in topological order.
 *      + Relax all edges pointing from that vertex. (Relax means updating the distTo and edgeTo array)
 * Time complexity: E + V
 * Space complexity: V
 */
public class AcyclicSP implements ShortestPath {
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicSP(EdgeWeightDirectedGraph graph, int source) {
        this.distTo = new double[graph.getNumberOfVertices()];
        this.edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[source] = 0;
        Topological topological = new Topological(graph);
        for (Integer vertex : topological.getOrder()) {
            for (DirectedEdge edge : graph.adj(vertex)) {
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
