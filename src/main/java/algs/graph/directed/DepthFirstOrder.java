package algs.graph.directed;


import algs.queue.ArrayQueue;
import algs.queue.Queue;
import algs.stack.ArrayStack;
import algs.stack.Stack;

public class DepthFirstOrder {
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reversePostOrder;

    private boolean[] marked;

    public DepthFirstOrder(DirectedGraph directedGraph) {
        this.preOrder = new ArrayQueue<>();
        this.postOrder = new ArrayQueue<>();
        this.reversePostOrder = new ArrayStack<>();
        this.marked = new boolean[directedGraph.getNumberOfVertices()];
        for (int i = 0; i < directedGraph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(directedGraph, i);
        }
    }

    private void dfs(DirectedGraph directedGraph, int vertex) {
        preOrder.offer(vertex);
        marked[vertex] = true;
        for (Integer adjacentVertex : directedGraph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                dfs(directedGraph, adjacentVertex);
            }
        }
        postOrder.offer(vertex);
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
