package algs.st;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SequentialSearchSTTest {
    private SequentialSearchST<Integer, String> symbolTable;

    @BeforeEach
    public void setupBeforeEachTest() {
        symbolTable = new SequentialSearchST<>();
    }

    @Test
    public void putAndGetShouldWorkCorrectly() {
        symbolTable.put(1, "one");
        symbolTable.put(2, "two");
        Assertions.assertEquals("one", symbolTable.get(1));
        Assertions.assertEquals("two", symbolTable.get(2));
    }

    @Test
    public void sizeShouldBeIncreasedWhenPut() {
        symbolTable.put(1, "one");
        Assertions.assertEquals(1, symbolTable.size());
        symbolTable.put(2, "two");
        Assertions.assertEquals(2, symbolTable.size());
    }

    @Test
    public void putShouldOverwriteOldValue() {
        symbolTable.put(1, "one");
        Assertions.assertEquals("one", symbolTable.get(1));
        symbolTable.put(1, "newOne");
        Assertions.assertEquals("newOne", symbolTable.get(1));
    }

    @Test
    public void getShouldThrowExceptionWhenInputKeyNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> symbolTable.get(null));
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(symbolTable.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        symbolTable.put(1, "one");
        Assertions.assertFalse(symbolTable.isEmpty());
    }

    @Test
    public void keysShouldReturnOrderedKeys() {
        symbolTable.put(3, "three");
        symbolTable.put(2, "two");
        symbolTable.put(1, "one");
        symbolTable.put(0, "zero");
        List<Integer> expectedOrder = Arrays.asList(0, 1, 2, 3);
        int indexInExpectedOrder = 0;
        for (Integer currentKey : symbolTable.keys()) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentKey);
            indexInExpectedOrder++;
        }
    }

    @Test
    public void deleteShouldRemoveKeyAndValue() {
        symbolTable.put(1, "one");
        symbolTable.put(2, "two");
        symbolTable.delete(1);
        Assertions.assertNull(symbolTable.get(1));
    }

    @Test
    public void containsShouldReturnFalseWhenNoElementFound() {
        symbolTable.put(1, "one");
        Assertions.assertFalse(symbolTable.contains(2));
    }

    @Test
    public void containsShouldReturnTrueWhenElementFound() {
        symbolTable.put(1, "one");
        Assertions.assertTrue(symbolTable.contains(1));
    }
}