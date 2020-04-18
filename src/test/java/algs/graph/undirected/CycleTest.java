package algs.graph.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CycleTest {
    @Test
    public void hasCycleShouldReturnTrue() {
        UndirectedGraph graph = new UndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        Cycle cycle = new Cycle(graph);
        Assertions.assertTrue(cycle.isHasCycle());
    }

    @Test
    public void hasCycleShouldReturnFalse() {
        UndirectedGraph graph = new UndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        Cycle cycle = new Cycle(graph);
        Assertions.assertFalse(cycle.isHasCycle());
    }
}