package algs.graph.weighted;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return v == edge.v &&
                w == edge.w &&
                Double.compare(edge.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, w, weight);
    }
}
