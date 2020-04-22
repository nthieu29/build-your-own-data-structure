package algs.st.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SeparateChainingHashTableTest {

    private SeparateChainingHashTable<Integer, String> hashTable;

    @BeforeEach
    public void setupBeforeEachTest() {
        hashTable = new SeparateChainingHashTable<>();
    }

    @Test
    public void putAndGetShouldWorkCorrectly() {
        hashTable.put(1, "one");
        hashTable.put(2, "two");
        Assertions.assertEquals("one", hashTable.get(1));
        Assertions.assertEquals("two", hashTable.get(2));
    }

    @Test
    public void sizeShouldBeIncreasedWhenPut() {
        hashTable.put(1, "one");
        Assertions.assertEquals(1, hashTable.size());
        hashTable.put(2, "two");
        Assertions.assertEquals(2, hashTable.size());
    }

    @Test
    public void putShouldOverwriteOldValue() {
        hashTable.put(1, "one");
        Assertions.assertEquals("one", hashTable.get(1));
        hashTable.put(1, "newOne");
        Assertions.assertEquals("newOne", hashTable.get(1));
    }

    @Test
    public void getShouldThrowExceptionWhenInputKeyNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> hashTable.get(null));
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(hashTable.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        hashTable.put(1, "one");
        Assertions.assertFalse(hashTable.isEmpty());
    }

    @Test
    public void keysShouldReturnOrderedKeys() {
        hashTable.put(3, "three");
        hashTable.put(2, "two");
        hashTable.put(1, "one");
        hashTable.put(0, "zero");
        List<Integer> expectedOrder = Arrays.asList(0, 1, 2, 3);
        int indexInExpectedOrder = 0;
        for (Integer currentKey : hashTable.keys()) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentKey);
            indexInExpectedOrder++;
        }
    }

    @Test
    public void deleteShouldRemoveKeyAndValue() {
        hashTable.put(1, "one");
        hashTable.delete(1);
        Assertions.assertNull(hashTable.get(1));
    }

    @Test
    public void hashTableShouldIncreaseCapacityCorrectly() {
        for (int i = 0; i < 90; i++) {
            hashTable.put(i, "");
        }
        for (int i = 0; i < 90; i++) {
            Assertions.assertEquals("", hashTable.get(i));
        }
    }

    @Test
    public void hashTableShouldDecreaseCapacityCorrectly() {
        for (int i = 0; i < 90; i++) {
            hashTable.put(i, "");
        }
        for (int i = 0; i < 90; i++) {
            hashTable.delete(i);
        }
        hashTable.put(1, "one");
        Assertions.assertEquals(1, hashTable.size());
        Assertions.assertEquals("one", hashTable.get(1));
    }


}