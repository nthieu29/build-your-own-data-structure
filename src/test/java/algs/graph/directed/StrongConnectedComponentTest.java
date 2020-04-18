package algs.graph.directed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StrongConnectedComponentTest {
    private static StrongConnectedComponent scc;

    @BeforeAll
    public static void setup() {
        DirectedGraph graph = new DirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 7);
        scc = new StrongConnectedComponent(graph);
    }

    @Test
    public void thereIs3ConnectedComponent() {
        Assertions.assertEquals(3, scc.getNumberOfStronglyConnectedComponent());
    }

    @Test
    public void shouldReturnTrueWhenCheck0And2() {
        Assertions.assertTrue(scc.isStronglyConnected(0, 2));
    }

    @Test
    public void shouldReturnFalseWhenCheck0And4() {
        Assertions.assertFalse(scc.isStronglyConnected(0, 4));
    }

    @Test
    public void shouldReturnFalseWhenCheck2And7() {
        Assertions.assertFalse(scc.isStronglyConnected(2, 7));
    }
}