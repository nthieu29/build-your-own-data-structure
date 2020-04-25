package algs.graph.weighted.directed;

import algs.stack.ArrayStack;
import algs.stack.Stack;

public class EdgeWeightDirectedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;
    private DirectedEdge[] edgeTo;

    public EdgeWeightDirectedCycle(EdgeWeightDirectedGraph graph) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.onStack = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new DirectedEdge[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(graph, i);
        }
    }

    private void dfs(EdgeWeightDirectedGraph graph, int vertex) {
        onStack[vertex] = true;
        marked[vertex] = true;
        for (DirectedEdge edge : graph.adj(vertex)) {
            int toVertex = edge.to();
            if (cycle != null) return;
            if (!marked[toVertex]) {
                edgeTo[toVertex] = edge;
                dfs(graph, toVertex);
            } else if (onStack[toVertex]) {
                cycle = new ArrayStack<>();
                cycle.push(edge);
                for (DirectedEdge edgeInCycle = edgeTo[vertex]; edgeInCycle != null; edgeInCycle = edgeTo[edgeInCycle.from()])
                    cycle.push(edgeInCycle);
                return;
            }
        }
        onStack[vertex] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle() {
        return this.cycle;
    }
}
