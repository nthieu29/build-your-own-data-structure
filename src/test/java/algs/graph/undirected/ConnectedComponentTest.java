package algs.graph.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConnectedComponentTest {
    private static ConnectedComponent connectedComponent;

    @BeforeAll
    public static void setup() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        connectedComponent = new ConnectedComponent(graph);
    }

    @Test
    public void connectedShouldReturnTrue() {
        Assertions.assertTrue(connectedComponent.connected(7, 8));
    }

    @Test
    public void connectedShouldReturnFalse() {
        Assertions.assertFalse(connectedComponent.connected(7, 9));
    }

    @Test
    public void idShouldBeCorrect() {
        Assertions.assertEquals(0, connectedComponent.id(0));
    }
}