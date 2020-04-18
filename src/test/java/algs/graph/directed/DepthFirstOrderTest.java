package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DepthFirstOrderTest {
    private static DepthFirstOrder depthFirstOrder;

    @BeforeAll
    public static void setup() {
        DirectedGraph directedGraph = new DirectedGraph(7);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(0, 5);
        directedGraph.addEdge(1, 4);
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(3, 2);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(3, 5);
        directedGraph.addEdge(3, 6);
        directedGraph.addEdge(6, 0);
        directedGraph.addEdge(6, 4);
        depthFirstOrder = new DepthFirstOrder(directedGraph);
    }

    @Test
    public void preOrder() {
        Iterable<Integer> expected = Arrays.asList(0, 1, 4, 2, 5, 3, 6);
        Assertions.assertIterableEquals(expected, depthFirstOrder.preOrder());
    }

    @Test
    public void postOrder() {
        Iterable<Integer> expected = Arrays.asList(4, 1, 2, 5, 0, 6, 3);
        Assertions.assertIterableEquals(expected, depthFirstOrder.postOrder());
    }

    @Test
    public void reversePostOrder() {
        Iterable<Integer> expected = Arrays.asList(3, 6, 0, 5, 2, 1, 4);
        Assertions.assertIterableEquals(expected, depthFirstOrder.reversePostOrder());
    }
}