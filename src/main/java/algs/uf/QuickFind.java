package algs.uf;

public class QuickFind implements UF {
    private int[] id;

    public QuickFind(int numberOfElements) {
        this.id = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
