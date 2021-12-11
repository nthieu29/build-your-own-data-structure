package algs.graph.weighted.undirected;

import algs.queue.ArrayQueue;
import algs.queue.PriorityQueue;
import algs.queue.Queue;
import algs.uf.QuickUnion;
import algs.uf.UF;

/***
 * Minimum Spanning Tree (MST) of graph G is the subgraph T that is both:
 *  - Tree (connected and acyclic)
 *  - Spanning (includes all the vertices)
 * Kruskal's algorithm: consider edges in ascending order of weights, add the next edge to tree T unless doing so would
 * create a cycle.
 *  - Build min order priority queue of edges in graph.
 *  - Build Union Find data structure.
 *  - Poll edges from priority queue, for each edge:
 *      + If 2 vertices of edge are not connected in Union Find:
 *          + Add that edge to MST.
 *          + Connect 2 vertices in Union Find
 * Time complexity: E log E
 * Space complexity: E + V
 */
public class KruskalMST implements MST {
    private Queue<Edge> minimumSpanningTree;

    public KruskalMST(EdgeWeightedGraph graph) {
        this.minimumSpanningTree = new ArrayQueue<>();
        Queue<Edge> priorityQueue = buildPriorityQueueFrom(graph);
        UF unionFind = new QuickUnion(graph.getNumberOfVertices());
        while (!priorityQueue.isEmpty()) {
            Edge minEdge = priorityQueue.poll();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!unionFind.connected(v, w)) {
                unionFind.union(v, w);
                minimumSpanningTree.offer(minEdge);
            }
        }
    }

    private Queue<Edge> buildPriorityQueueFrom(EdgeWeightedGraph graph) {
        Queue<Edge> priorityQueue = new PriorityQueue<>(graph.getNumberOfEdges(), true);
        for (Edge edge : graph.edges()) {
            priorityQueue.offer(edge);
        }
        return priorityQueue;
    }

    @Override
    public Iterable<Edge> edges() {
        return this.minimumSpanningTree;
    }

    @Override
    public double weight() {
        double totalWeight = 0;
        for (Edge edge : minimumSpanningTree) {
            totalWeight = totalWeight + edge.getWeight();
        }
        return totalWeight;
    }
}
