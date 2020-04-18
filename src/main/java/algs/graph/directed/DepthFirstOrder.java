package algs.graph.directed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DepthFirstOrder {
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Deque<Integer> reversePostOrder;

    private boolean[] marked;

    public DepthFirstOrder(DirectedGraph directedGraph) {
        this.preOrder = new ArrayDeque<>();
        this.postOrder = new ArrayDeque<>();
        this.reversePostOrder = new ArrayDeque<>();
        this.marked = new boolean[directedGraph.getNumberOfVertices()];
        for (int i = 0; i < directedGraph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(directedGraph, i);
        }
    }

    private void dfs(DirectedGraph directedGraph, int vertex) {
        preOrder.add(vertex);
        marked[vertex] = true;
        for (Integer adjacentVertex : directedGraph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                dfs(directedGraph, adjacentVertex);
            }
        }
        postOrder.add(vertex);
        reversePostOrder.push(vertex);
    }

    public Iterable<Integer> preOrder() {
        return this.preOrder;
    }

    public Iterable<Integer> postOrder() {
        return this.postOrder;
    }

    public Iterable<Integer> reversePostOrder() {
        return this.reversePostOrder;
    }
}
