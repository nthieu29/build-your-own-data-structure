package algs.sorting;

import java.util.Random;

public class ElementarySort {
    public static void shuffle(Comparable[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int randomIndex = random.nextInt(i + 1);
            exchange(a, i, randomIndex);
        }
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
