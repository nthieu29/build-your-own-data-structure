package algs.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortUnitTest {
    private final Integer[] input = {5, 7, 8, 0, 9, 1, 4, 2, 3, 6};

    @Test
    public void testShuffle() {
        Integer[] origin = {1, 2, 3, 4, 5, 6, 7};
        Integer[] actual = origin.clone();
        ElementarySort.shuffle(actual);
        Assertions.assertFalse(Arrays.equals(origin, actual));
    }

    @Test
    public void testIsSort() {
        Integer[] actual = {0, 1, 2, 3, 4, 5};
        Assertions.assertTrue(ElementarySort.isSorted(actual));
    }

    @Test
    public void testSelectionSort() {
        Integer[] actual = input.clone();
        SelectionSort.sort(actual);
        Assertions.assertTrue(ElementarySort.isSorted(actual));
    }

    @Test
    public void testInsertionSort() {
        Integer[] actual = input.clone();
        InsertionSort.sort(actual);
        Assertions.assertTrue(ElementarySort.isSorted(actual));
    }

    @Test
    public void testMergeSort() {
        Integer[] actual = input.clone();
        MergeSort.sort(actual);
        System.out.println("Merge sort:");
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(actual));
        Assertions.assertTrue(ElementarySort.isSorted(actual));
    }

    @Test
    public void testQuickSort() {
        Integer[] actual = input.clone();
        QuickSort.sort(actual);
        System.out.println("Quick sort:");
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(actual));
        Assertions.assertTrue(ElementarySort.isSorted(actual));
    }
}