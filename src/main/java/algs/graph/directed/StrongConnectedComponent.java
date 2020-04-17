package algs.graph.directed;

public class StrongConnectedComponent {
    private int[] id;
    private boolean[] marked;
    private int count;

    public StrongConnectedComponent(Digraph graph) {
        this.id = new int[graph.getNumberOfVertices()];
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.count = 0;
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        for (Integer vertex : depthFirstOrder.reversePostOrder()) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, Integer vertex) {
        marked[vertex] = true;
        id[vertex] = count;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                dfs(graph, adjacentVertex);
            }
        }
    }

    public boolean isStronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
}
