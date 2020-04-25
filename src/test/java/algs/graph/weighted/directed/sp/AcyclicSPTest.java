package algs.graph.weighted.directed.sp;

import algs.graph.weighted.directed.DirectedEdge;
import algs.graph.weighted.directed.EdgeWeightDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AcyclicSPTest {
    private static AcyclicSP sp;

    @BeforeAll
    public static void setup() {
        EdgeWeightDirectedGraph graph = new EdgeWeightDirectedGraph(6);
        graph.addEdge(new DirectedEdge(0, 1, 1));
        graph.addEdge(new DirectedEdge(0, 2, 1));
        graph.addEdge(new DirectedEdge(1, 3, 2));
        graph.addEdge(new DirectedEdge(3, 5, 5));
        graph.addEdge(new DirectedEdge(2, 4, 3));
        graph.addEdge(new DirectedEdge(4, 5, 2));
        sp = new AcyclicSP(graph, 0);
    }

    @Test
    public void distToShouldReturnCorrectly() {
        Assertions.assertEquals(6, sp.distTo(5));
    }

    @Test
    public void pathToShouldReturnCorrectly() {
        Iterable<DirectedEdge> expected = Arrays.asList(
                new DirectedEdge(0, 2, 1),
                new DirectedEdge(2, 4, 3),
                new DirectedEdge(4, 5, 2)
        );
        Assertions.assertIterableEquals(expected, sp.pathTo(5));
    }
}