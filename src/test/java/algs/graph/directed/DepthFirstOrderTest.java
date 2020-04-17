package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DepthFirstOrderTest {
    private static DepthFirstOrder depthFirstOrder;

    @BeforeAll
    public static void setup() {
        Digraph digraph = new Digraph(7);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 5);
        digraph.addEdge(1, 4);
        digraph.addEdge(5, 2);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 4);
        digraph.addEdge(3, 5);
        digraph.addEdge(3, 6);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        depthFirstOrder = new DepthFirstOrder(digraph);
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