package algs.graph.directed;

import algs.graph.weighted.directed.EdgeWeightDirectedGraph;

public class Topological {
    private Iterable<Integer> order;

    public Topological(DirectedGraph graph) {
        DirectedCycle directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
            this.order = depthFirstOrder.reversePostOrder();
        }
    }

    public Topological(EdgeWeightDirectedGraph graph) {
        DirectedCycle directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
            this.order = depthFirstOrder.reversePostOrder();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }
}
