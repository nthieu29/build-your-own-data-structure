package algs.graph.directed;

public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph graph) {
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
