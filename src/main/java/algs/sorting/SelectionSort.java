package algs.sorting;

public class SelectionSort extends ElementarySort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[minIndex])) minIndex = j;
            }
            exchange(a, i, minIndex);
        }
    }
}
