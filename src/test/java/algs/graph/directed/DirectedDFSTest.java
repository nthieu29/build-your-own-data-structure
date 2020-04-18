package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DirectedDFSTest {
    private static DirectedDFS directedDFS;

    @BeforeAll
    public static void setup() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        directedDFS = new DirectedDFS(graph, 0);
    }

    @Test
    public void hasPathTo3ShouldReturnFalse() {
        Assertions.assertFalse(directedDFS.hasPathTo(3));
    }

    @Test
    public void hasPathTo2ShouldReturnTrue() {
        Assertions.assertTrue(directedDFS.hasPathTo(2));
    }

    @Test
    public void pathTo2ShouldReturnCorrectly() {
        Iterable<Integer> expected = Arrays.asList(0, 1, 2);
        Iterable<Integer> actual = directedDFS.pathTo(2);
        Assertions.assertIterableEquals(expected, actual);
    }

}