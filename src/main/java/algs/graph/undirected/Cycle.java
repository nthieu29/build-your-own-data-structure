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

    private void dfs(UndirectedGraph graph, int v, int u) {
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean isHasCycle() {
        return this.hasCycle;
    }
}
