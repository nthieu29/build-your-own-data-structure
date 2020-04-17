package algs.uf;

/**
 * Quick Union with 2 improvements to avoid tall tree:
 * - Always merge smaller tree to larger tree.
 * - Path compression.
 */
public class QuickUnion implements UF {
    private int[] id;
    private int[] size;

    public QuickUnion(int numberOfElements) {
        this.id = new int[numberOfElements];
        this.size = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        int pointer = i;
        while (id[pointer] != pointer) {
            id[pointer] = id[id[pointer]]; // path compression
            pointer = id[pointer];
        }
        return pointer;
    }

    @Override
    public void union(int a, int b) {
        int rootOfa = root(a);
        int rootOfb = root(b);
        if (size[rootOfa] < size[rootOfb]) { // always choose smaller tree to merge
            id[rootOfa] = id[rootOfb];
            size[rootOfb] = size[rootOfb] + size[rootOfa];
        } else {
            id[rootOfb] = id[rootOfa];
            size[rootOfa] = size[rootOfa] + size[rootOfb];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
