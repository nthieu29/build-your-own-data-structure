package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DirectedBFSTest {
    private static DirectedBFS directedBFS;

    @BeforeAll
    public static void setup() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        directedBFS = new DirectedBFS(graph, 0);
    }

    @Test
    public void hasPathTo3ShouldReturnFalse() {
        Assertions.assertFalse(directedBFS.hasPathTo(3));
    }

    @Test
    public void hasPathTo2ShouldReturnTrue() {
        Assertions.assertTrue(directedBFS.hasPathTo(2));
    }

    @Test
    public void pathTo2ShouldReturnCorrectly() {
        Iterable<Integer> expected = Arrays.asList(0, 1, 2);
        Iterable<Integer> actual = directedBFS.pathTo(2);
        Assertions.assertIterableEquals(expected, actual);
    }
}