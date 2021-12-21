package algs.sorting;

public class MergeSort extends ElementarySort {
    private static Comparable[] auxiliary;

    public static void sort(Comparable[] a) {
        auxiliary = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int hi) {
        if (hi <= low) return;
        int mid = low + (hi - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, hi);
        merge(a, low, mid, hi);
    }

    public static void merge(Comparable[] a, int low, int mid, int hi) {
        for (int k = low; k <= hi; k++) {
            auxiliary[k] = a[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= hi; k++) {
            if (i > mid) a[k] = auxiliary[j++];
            else if (j > hi) a[k] = auxiliary[i++];
            else if (less(auxiliary[j], auxiliary[i])) a[k] = auxiliary[j++];
            else a[k] = auxiliary[i++];
        }
    }
}
