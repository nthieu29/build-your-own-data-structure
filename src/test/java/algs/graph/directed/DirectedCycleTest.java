package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DirectedCycleTest {
    private static DirectedCycle directedCycle;

    @BeforeAll
    public static void setup() {
        Digraph graph = new Digraph(6);
        graph.addEdge(0, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        directedCycle = new DirectedCycle(graph);
    }

    @Test
    public void hasCycleShouldReturnTrue() {
        Assertions.assertTrue(directedCycle.hasCycle());
    }

    @Test
    public void cycleShouldReturnCorrectly() {
        Iterable<Integer> expected = Arrays.asList(3, 5, 4, 3);
        Iterable<Integer> actual = directedCycle.cycle();
        Assertions.assertIterableEquals(expected, actual);
    }

}