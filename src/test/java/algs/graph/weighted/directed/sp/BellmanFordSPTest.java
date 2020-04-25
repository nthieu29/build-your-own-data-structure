package algs.graph.weighted.directed.sp;

import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BellmanFordSPTest {

    private EdgeWeightDirectedGraph createGraphWithNoNegativeCycle() {
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(1, 2, 1));
        graph.addEdge(new DirectedEdge(2, 3, 1));
        graph.addEdge(new DirectedEdge(3, 4, 1));
        graph.addEdge(new DirectedEdge(4, 5, -1));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(5, 6, 1));
        graph.addEdge(new DirectedEdge(4, 7, 1));
        return graph;
    }

    private EdgeWeightDirectedGraph createGraphWithNegativeCycle() {
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(1, 2, 1));
        graph.addEdge(new DirectedEdge(2, 3, -1));
        graph.addEdge(new DirectedEdge(3, 4, -1));
        graph.addEdge(new DirectedEdge(4, 5, -1));
        graph.addEdge(new DirectedEdge(5, 2, -1));
        graph.addEdge(new DirectedEdge(5, 6, 1));
        graph.addEdge(new DirectedEdge(4, 7, 1));
        return graph;
    }

    @Test
    public void pathToShouldWorkCorrectlyWhenGivenGraphWithNoNegativeCycle() {
        EdgeWeightDirectedGraph graph = createGraphWithNoNegativeCycle();
        BellmanFordSP sp = new BellmanFordSP(graph, 0);
        Iterable<DirectedEdge> expected = Arrays.asList(
                new DirectedEdge(0, 1, 1),
                new DirectedEdge(1, 2, 1),
                new DirectedEdge(2, 3, 1),
                new DirectedEdge(3, 4, 1),
                new DirectedEdge(4, 5, -1),
                new DirectedEdge(5, 6, 1)
        );
        Iterable<DirectedEdge> actual = sp.pathTo(6);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void distToShouldWorkCorrectlyWhenGivenGraphWithNoNegativeCycle() {
        EdgeWeightDirectedGraph graph = createGraphWithNoNegativeCycle();
        BellmanFordSP sp = new BellmanFordSP(graph, 0);
        Assertions.assertEquals(4, sp.distTo(6));
    }

    @Test
    public void hasNegativeCycleShouldReturnFalseWhenGivenGraphWithNoNegativeCycle() {
        EdgeWeightDirectedGraph graph = createGraphWithNoNegativeCycle();
        BellmanFordSP sp = new BellmanFordSP(graph, 0);
        Assertions.assertFalse(sp.hasNegativeCycle());
    }

    @Test
    public void hasNegativeCycleShouldReturnTrueWhenGivenGraphWithNegativeCycle() {
        EdgeWeightDirectedGraph graph = createGraphWithNegativeCycle();
        BellmanFordSP sp = new BellmanFordSP(graph, 0);
        Assertions.assertTrue(sp.hasNegativeCycle());
    }

    @Test
    public void negativeCycleShouldWorkCorrectlyWhenGivenGraphWithNegativeCycle() {
        EdgeWeightDirectedGraph graph = createGraphWithNegativeCycle();
        BellmanFordSP sp = new BellmanFordSP(graph, 0);
        Iterable<DirectedEdge> expected = Arrays.asList(
                new DirectedEdge(2, 3, -1),
                new DirectedEdge(3, 4, -1),
                new DirectedEdge(4, 5, -1),
                new DirectedEdge(5, 2, -1)
        );
        Iterable<DirectedEdge> actual = sp.negativeCycle();
        Assertions.assertIterableEquals(expected, actual);
    }
}