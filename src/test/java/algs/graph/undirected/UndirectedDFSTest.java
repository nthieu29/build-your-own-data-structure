package algs.graph.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UndirectedDFSTest {
    private static UndirectedDFS undirectedDFS;

    @BeforeAll
    public static void setup() {
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        undirectedDFS = new UndirectedDFS(graph, 0);
    }

    @Test
    public void hasPathShouldReturnTrue() {
        Assertions.assertTrue(undirectedDFS.hasPathTo(4));
    }

    @Test
    public void hasPathShouldReturnFalse() {
        Assertions.assertFalse(undirectedDFS.hasPathTo(5));
    }

    @Test
    public void pathToShouldReturnCorrectly() {
        Iterable<Integer> actual = undirectedDFS.pathTo(4);
        Iterable<Integer> expected = Arrays.asList(0, 2, 3, 4);
        Assertions.assertIterableEquals(actual, expected);
    }

}