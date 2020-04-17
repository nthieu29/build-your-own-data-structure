package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DigraphTest {
    private static Digraph digraph;

    @BeforeAll
    public static void setup() {
        digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
    }

    @Test
    public void getNumberOfEdgeShouldReturnCorrectly() {
        Assertions.assertEquals(2, digraph.getNumberOfEdges());
    }

    @Test
    public void getNumberOfVerticesShouldReturnCorrectly() {
        Assertions.assertEquals(3, digraph.getNumberOfVertices());
    }

    @Test
    public void adjShouldReturnCorrectly() {
        Iterable<Integer> expected = Arrays.asList(1);
        Assertions.assertIterableEquals(expected, digraph.adj(0));
    }

    @Test
    public void reverseShouldReturnReverseGraph() {
        Digraph expected = new Digraph(3);
        expected.addEdge(2, 1);
        expected.addEdge(1, 0);
        Assertions.assertEquals(expected, digraph.reverse());
    }

}