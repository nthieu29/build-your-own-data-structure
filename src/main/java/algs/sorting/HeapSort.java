package algs.sorting;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            exchange(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exchange(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int j, int i) {
        return pq[j - 1].compareTo(pq[i - 1]) < 0;
    }

    private static void exchange(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }
}
