package algs.graph.weighted.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DijkstraForUndirectedEdgeWeightGraphTest {
    @Test
    public void test1() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(5);
        graph.addEdge(new Edge(0, 1, 6));
        graph.addEdge(new Edge(1, 2, 5));
        graph.addEdge(new Edge(3, 0, 1));
        graph.addEdge(new Edge(3, 1, 2));
        graph.addEdge(new Edge(3, 4, 1));
        graph.addEdge(new Edge(4, 2, 5));
        graph.addEdge(new Edge(4, 1, 2));
        DijkstraForUndirectedEdgeWeightGraph dijkstra = new DijkstraForUndirectedEdgeWeightGraph(graph, 0);
        Assertions.assertEquals(7, dijkstra.distTo(2));
        Assertions.assertEquals(3, dijkstra.distTo(1));
    }
}