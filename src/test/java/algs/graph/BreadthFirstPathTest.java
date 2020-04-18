package algs.graph;

import algs.graph.undirected.UndirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BreadthFirstPathTest {
    private static BreadthFirstPath breadthFirstPath;

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
        breadthFirstPath = new BreadthFirstPath(graph, 0);
    }

    @Test
    public void hasPathToShouldReturnTrue() {
        Assertions.assertTrue(breadthFirstPath.hasPathTo(4));
    }

    @Test
    public void pathToShouldBeCorrect() {
        Iterable<Integer> actual = breadthFirstPath.pathTo(4);
        Iterable<Integer> expected = Arrays.asList(0, 2, 4);
        Assertions.assertIterableEquals(expected, actual);
    }

}