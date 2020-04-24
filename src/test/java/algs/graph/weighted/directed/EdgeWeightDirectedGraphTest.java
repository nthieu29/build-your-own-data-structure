package algs.graph.weighted.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EdgeWeightDirectedGraphTest {
    private static EdgeWeightDirectedGraph graph;

    @BeforeAll
    public static void setup() {
        graph = new EdgeWeightDirectedGraph(5);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 1));
        graph.addEdge(new DirectedEdge(1, 3, 1));
        graph.addEdge(new DirectedEdge(1, 4, 1));
    }

    @Test
    public void getNumberOfEdgesShouldReturn4() {
        Assertions.assertEquals(4, graph.getNumberOfEdges());
    }

    @Test
    public void getNumberOfVerticesShouldReturn5() {
        Assertions.assertEquals(5, graph.getNumberOfVertices());
    }

    @Test
    public void adjShouldReturnCorrectly() {
        Iterable<DirectedEdge> expected = Arrays.asList(
                new DirectedEdge(1, 3, 1),
                new DirectedEdge(1, 4, 1)
        );
        Iterable<DirectedEdge> actual = graph.adj(1);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void edgesShouldReturnAllEdges() {
        Iterable<DirectedEdge> expected = Arrays.asList(
                new DirectedEdge(0, 1, 1),
                new DirectedEdge(0, 2, 1),
                new DirectedEdge(1, 3, 1),
                new DirectedEdge(1, 4, 1)
        );
        Iterable<DirectedEdge> actual = graph.edges();
        Assertions.assertIterableEquals(expected, actual);
    }
}