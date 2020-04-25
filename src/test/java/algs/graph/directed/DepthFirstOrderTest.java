package algs.graph.directed;

import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DepthFirstOrderTest {

    private DirectedGraph createDirectedGraph() {
        DirectedGraph directedGraph = new DirectedGraph(7);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(0, 5);
        directedGraph.addEdge(1, 4);
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(3, 2);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(3, 5);
        directedGraph.addEdge(3, 6);
        directedGraph.addEdge(6, 0);
        directedGraph.addEdge(6, 4);
        return directedGraph;
    }

    private EdgeWeightDirectedGraph createEdgeWeightDirectedGraph() {
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(7);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 1));
        graph.addEdge(new DirectedEdge(0, 5, 1));
        graph.addEdge(new DirectedEdge(1, 4, 1));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(3, 2, 1));
        graph.addEdge(new DirectedEdge(3, 4, 1));
        graph.addEdge(new DirectedEdge(3, 5, 1));
        graph.addEdge(new DirectedEdge(3, 6, 1));
        graph.addEdge(new DirectedEdge(6, 0, 1));
        graph.addEdge(new DirectedEdge(6, 4, 1));
        return graph;
    }


    @Test
    public void preOrderShouldWorkCorrectlyWhenGivenDirectedGraph() {
        DirectedGraph graph = createDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(0, 1, 4, 2, 5, 3, 6);
        Assertions.assertIterableEquals(expected, depthFirstOrder.preOrder());
    }

    @Test
    public void postOrderShouldWorkCorrectlyWhenGivenDirectedGraph() {
        DirectedGraph graph = createDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(4, 1, 2, 5, 0, 6, 3);
        Assertions.assertIterableEquals(expected, depthFirstOrder.postOrder());
    }

    @Test
    public void reversePostOrderShouldWorkCorrectlyWhenGivenDirectedGraph() {
        DirectedGraph graph = createDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(3, 6, 0, 5, 2, 1, 4);
        Assertions.assertIterableEquals(expected, depthFirstOrder.reversePostOrder());
    }

    @Test
    public void preOrderShouldWorkCorrectlyWhenGivenEdgeWeightDirectedGraph() {
        EdgeWeightDirectedGraph graph = createEdgeWeightDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(0, 1, 4, 2, 5, 3, 6);
        Assertions.assertIterableEquals(expected, depthFirstOrder.preOrder());
    }

    @Test
    public void postOrderShouldWorkCorrectlyWhenGivenEdgeWeightDirectedGraph() {
        EdgeWeightDirectedGraph graph = createEdgeWeightDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(4, 1, 2, 5, 0, 6, 3);
        Assertions.assertIterableEquals(expected, depthFirstOrder.postOrder());
    }

    @Test
    public void reversePostOrderShouldWorkCorrectlyWhenGivenEdgeWeightDirectedGraph() {
        EdgeWeightDirectedGraph graph = createEdgeWeightDirectedGraph();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Iterable<Integer> expected = Arrays.asList(3, 6, 0, 5, 2, 1, 4);
        Assertions.assertIterableEquals(expected, depthFirstOrder.reversePostOrder());
    }
}