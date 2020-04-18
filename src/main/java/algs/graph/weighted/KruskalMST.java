package algs.graph.weighted;

import algs.uf.QuickUnion;
import algs.uf.UF;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST implements MST {
    private Queue<Edge> minimumSpanningTree;

    public KruskalMST(EdgeWeightedGraph graph) {
        this.minimumSpanningTree = new ArrayDeque<>();
        Queue<Edge> priorityQueue = buildPriorityQueueFrom(graph);
        UF unionFind = new QuickUnion(graph.getNumberOfVertices());
        while (!priorityQueue.isEmpty()) {
            Edge minEdge = priorityQueue.poll();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!unionFind.connected(v, w)) {
                unionFind.union(v, w);
                minimumSpanningTree.add(minEdge);
            }
        }
    }

    private Queue<Edge> buildPriorityQueueFrom(EdgeWeightedGraph graph) {
        Queue<Edge> priorityQueue = new PriorityQueue<>();
        for (Edge edge : graph.edges()) {
            priorityQueue.add(edge);
        }
        return priorityQueue;
    }

    @Override
    public Iterable<Edge> edges() {
        return this.minimumSpanningTree;
    }

    @Override
    public double weight() {
        return this.minimumSpanningTree.stream().mapToDouble(Edge::getWeight).sum();
    }
}
