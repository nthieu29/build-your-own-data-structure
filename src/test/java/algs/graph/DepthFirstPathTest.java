package algs.graph;

import algs.graph.undirected.UndirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DepthFirstPathTest {
    private static DepthFirstPath depthFirstPath;

    @BeforeAll
    public static void setup() {
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        depthFirstPath = new DepthFirstPath(graph, 0);
    }

    @Test
    public void hasPathShouldReturnTrue() {
        Assertions.assertTrue(depthFirstPath.hasPathTo(4));
    }

    @Test
    public void hasPathShouldReturnFalse() {
        Assertions.assertFalse(depthFirstPath.hasPathTo(5));
    }

    @Test
    public void pathToShouldReturnCorrectly() {
        Iterable<Integer> actual = depthFirstPath.pathTo(4);
        Iterable<Integer> expected = Arrays.asList(0, 2, 3, 4);
        Assertions.assertIterableEquals(actual, expected);
    }

}