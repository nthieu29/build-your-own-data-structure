package algs.graph.weighted.undirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class KruskalMSTTest {
    private static MST mst;
    private static Set<Edge> expectedMST;

    @BeforeAll
    public static void setup() {
        initMST();
        initExpectedSet();
    }

    private static void initExpectedSet() {
        expectedMST = new HashSet<>();
        expectedMST.add(new Edge(0, 7, 0.16));
        expectedMST.add(new Edge(2, 3, 0.17));
        expectedMST.add(new Edge(1, 7, 0.19));
        expectedMST.add(new Edge(0, 2, 0.26));
        expectedMST.add(new Edge(5, 7, 0.28));
        expectedMST.add(new Edge(4, 5, 0.35));
        expectedMST.add(new Edge(6, 2, 0.40));
    }

    private static void initMST() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));
        mst = new KruskalMST(graph);
    }

    @Test
    public void edgesShouldReturnMSTCorrectly() {
        Iterable<Edge> actual = mst.edges();
        int actualSize = 0;
        for (Edge edge : actual) {
            Assertions.assertTrue(expectedMST.contains(edge));
            actualSize++;
        }
        Assertions.assertEquals(expectedMST.size(), actualSize);
    }

    @Test
    public void weightShouldReturnCorrectly() {
        double expected = expectedMST.stream().mapToDouble(Edge::getWeight).sum();
        double actual = mst.weight();
        Assertions.assertEquals(expected, actual);
    }
}