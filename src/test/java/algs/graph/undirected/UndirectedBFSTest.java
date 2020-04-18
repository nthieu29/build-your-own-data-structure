package algs.graph.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UndirectedBFSTest {
    private static UndirectedBFS undirectedBFS;

    @BeforeAll
    public static void setup() {
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);
        undirectedBFS = new UndirectedBFS(graph, 0);
    }

    @Test
    public void hasPathToShouldReturnTrue() {
        Assertions.assertTrue(undirectedBFS.hasPathTo(4));
    }

    @Test
    public void pathToShouldBeCorrect() {
        Iterable<Integer> actual = undirectedBFS.pathTo(4);
        Iterable<Integer> expected = Arrays.asList(0, 2, 4);
        Assertions.assertIterableEquals(expected, actual);
    }

}