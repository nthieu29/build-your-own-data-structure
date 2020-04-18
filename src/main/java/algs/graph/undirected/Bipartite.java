package algs.graph.undirected;

public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean bipartite;

    public Bipartite(Graph graph) {
        this.marked = new boolean[graph.getNumberOfVertices()];
        this.color = new boolean[graph.getNumberOfVertices()];
        this.bipartite = true;
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!marked[i]) dfs(graph, i);
        }
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                color[adjacentVertex] = !color[vertex];
                dfs(graph, adjacentVertex);
            } else if (color[adjacentVertex] == color[vertex]) bipartite = false;
        }
    }

    public boolean isBipartite() {
        return bipartite;
    }
}
