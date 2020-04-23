package algs.graph.weighted.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EdgeWeightedGraphTest {
    private static EdgeWeightedGraph graph;

    @BeforeAll
    public static void setup() {
        graph = new EdgeWeightedGraph(3);
        Edge edge01 = new Edge(0, 1, 1);
        Edge edge02 = new Edge(0, 2, 1);
        Edge edge12 = new Edge(1, 2, 1);
        graph.addEdge(edge01);
        graph.addEdge(edge02);
        graph.addEdge(edge12);
    }

    @Test
    public void adjShouldReturnCorrectly() {
        Iterable<Edge> expected = Arrays.asList(
                new Edge(0, 1, 1),
                new Edge(0, 2, 1));
        Iterable<Edge> actual = graph.adj(0);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void edgesShouldReturnCorrectly() {
        Iterable<Edge> expected = Arrays.asList(
                new Edge(0, 1, 1),
                new Edge(0, 2, 1),
                new Edge(1, 2, 1)
        );
        Iterable<Edge> actual = graph.edges();
        Assertions.assertIterableEquals(expected, actual);
    }
}