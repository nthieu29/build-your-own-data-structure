package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DirectedGraphTest {
    private static DirectedGraph directedGraph;

    @BeforeAll
    public static void setup() {
        directedGraph = new DirectedGraph(3);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
    }

    @Test
    public void getNumberOfEdgeShouldReturnCorrectly() {
        Assertions.assertEquals(2, directedGraph.getNumberOfEdges());
    }

    @Test
    public void getNumberOfVerticesShouldReturnCorrectly() {
        Assertions.assertEquals(3, directedGraph.getNumberOfVertices());
    }

    @Test
    public void adjShouldReturnCorrectly() {
        Iterable<Integer> expected = Arrays.asList(1);
        Assertions.assertIterableEquals(expected, directedGraph.adj(0));
    }

    @Test
    public void reverseShouldReturnReverseGraph() {
        DirectedGraph expected = new DirectedGraph(3);
        expected.addEdge(2, 1);
        expected.addEdge(1, 0);
        Assertions.assertEquals(expected, directedGraph.reverse());
    }

}