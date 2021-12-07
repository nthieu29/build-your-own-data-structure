package algs.graph.undirected;

public class Cycle {
    private boolean hasCycle;
    private boolean[] marked;

    public Cycle(UndirectedGraph graph) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(graph, i, i);
        }
    }

    private void dfs(UndirectedGraph graph, int toVertex, int fromVertex) {
        marked[toVertex] = true;
        for (Integer adjacentVertex : graph.adj(toVertex)) {
            if (!marked[adjacentVertex]) {
                dfs(graph, adjacentVertex, toVertex);
            } else if (adjacentVertex != fromVertex) {
                hasCycle = true;
            }
        }
    }

    public boolean isHasCycle() {
        return this.hasCycle;
    }
}
