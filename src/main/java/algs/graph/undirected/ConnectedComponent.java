package algs.graph.undirected;

public class ConnectedComponent {
    private int count;
    private int[] id;
    private boolean[] marked;

    public ConnectedComponent(UndirectedGraph graph) {
        int numberOfVertices = graph.getNumberOfVertices();
        this.marked = new boolean[numberOfVertices];
        this.id = new int[numberOfVertices];
        this.count = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            if (!marked[i]) {
                dfs(graph, i);
                count++;
            }
        }
    }

    private void dfs(UndirectedGraph graph, int vertex) {
        marked[vertex] = true;
        id[vertex] = count;
        for (Integer adjacentVertex : graph.adj(vertex)) {
            if (!marked[adjacentVertex]) {
                dfs(graph, adjacentVertex);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }
}
