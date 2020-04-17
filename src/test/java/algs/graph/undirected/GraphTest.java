package algs.graph.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GraphTest {
    private static Graph graph;

    @BeforeAll
    public static void setup() {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
    }

    @Test
    public void getNumberOfVerticesShouldReturnCorrectly() {
        Assertions.assertEquals(4, graph.getNumberOfVertices());
    }

    @Test
    public void getNumberOfEdgesShouldReturnCorrectly() {
        Assertions.assertEquals(3, graph.getNumberOfEdges());
    }

    @Test
    public void adjShouldReturnCorrectly() {
        Iterable<Integer> actual = graph.adj(0);
        Iterable<Integer> expected = Arrays.asList(1, 2, 3);
        Assertions.assertIterableEquals(expected, actual);
    }
}