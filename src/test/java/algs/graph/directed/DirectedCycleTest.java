package algs.graph.directed;

import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DirectedCycleTest {

    private DirectedGraph createDirectedGraphHasCycle() {
        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(0, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        return graph;
    }

    private EdgeWeightDirectedGraph createEdgeWeighDirectedGraphHasCycle() {
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(6);
        graph.addEdge(new DirectedEdge(0, 5, 1));
        graph.addEdge(new DirectedEdge(5, 4, 1));
        graph.addEdge(new DirectedEdge(4, 3, 1));
        graph.addEdge(new DirectedEdge(3, 5, 1));
        return graph;
    }

    @Test
    public void hasCycleShouldReturnTrueWhenGivenDirectedGraphHasCycle() {
        DirectedGraph graph = createDirectedGraphHasCycle();
        DirectedCycle directedCycle = new DirectedCycle(graph);
        Assertions.assertTrue(directedCycle.hasCycle());
    }

    @Test
    public void cycleShouldReturnCorrectlyWhenGivenDirectedGraphHasCycle() {
        DirectedGraph graph = createDirectedGraphHasCycle();
        DirectedCycle directedCycle = new DirectedCycle(graph);
        Iterable<Integer> expected = Arrays.asList(3, 5, 4, 3);
        Iterable<Integer> actual = directedCycle.cycle();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void hasCycleShouldReturnTrueWhenGivenEdgeWeightDirectedGraphHasCycle() {
        EdgeWeightDirectedGraph graph = createEdgeWeighDirectedGraphHasCycle();
        DirectedCycle directedCycle = new DirectedCycle(graph);
        Assertions.assertTrue(directedCycle.hasCycle());
    }

    @Test
    public void cycleShouldReturnCorrectlyWhenGivenEdgeWeightDirectedGraphHasCycle() {
        EdgeWeightDirectedGraph graph = createEdgeWeighDirectedGraphHasCycle();
        DirectedCycle directedCycle = new DirectedCycle(graph);
        Iterable<Integer> expected = Arrays.asList(3, 5, 4, 3);
        Iterable<Integer> actual = directedCycle.cycle();
        Assertions.assertIterableEquals(expected, actual);
    }

}