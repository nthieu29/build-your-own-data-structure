package algs.st;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer, String> bst;

    @BeforeEach
    public void setupBeforeEachTest() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void putAndGetShouldWorkCorrectly() {
        bst.put(1, "one");
        bst.put(2, "two");
        Assertions.assertEquals("one", bst.get(1));
        Assertions.assertEquals("two", bst.get(2));
    }

    @Test
    public void sizeShouldBeIncreasedWhenPut() {
        bst.put(1, "one");
        Assertions.assertEquals(1, bst.size());
        bst.put(2, "two");
        Assertions.assertEquals(2, bst.size());
    }

    @Test
    public void putShouldOverwriteOldValue() {
        bst.put(1, "one");
        Assertions.assertEquals("one", bst.get(1));
        bst.put(1, "newOne");
        Assertions.assertEquals("newOne", bst.get(1));
    }

    @Test
    public void minShouldReturnMinimumKey() {
        bst.put(3, "three");
        bst.put(1, "one");
        bst.put(2, "two");
        Assertions.assertEquals(1, bst.min());
    }

    @Test
    public void maxShouldReturnMaximumKey() {
        bst.put(3, "three");
        bst.put(1, "one");
        bst.put(2, "two");
        Assertions.assertEquals(3, bst.max());
    }

    @Test
    public void minShouldThrowExceptionWhenEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> bst.min());
    }

    @Test
    public void maxShouldThrowExceptionWhenEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> bst.max());
    }

    @Test
    public void getShouldThrowExceptionWhenInputKeyNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bst.get(null));
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(bst.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        bst.put(1, "one");
        Assertions.assertFalse(bst.isEmpty());
    }

    @Test
    public void keysShouldReturnOrderedKeys() {
        bst.put(3, "three");
        bst.put(2, "two");
        bst.put(1, "one");
        bst.put(0, "zero");
        List<Integer> expectedOrder = Arrays.asList(0, 1, 2, 3);
        int indexInExpectedOrder = 0;
        for (Integer currentKey : bst.keys()) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentKey);
            indexInExpectedOrder++;
        }
    }
}