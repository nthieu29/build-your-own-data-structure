package algs.st.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TernarySearchTreeTest {
    private TernarySearchTree<Integer> tst;

    @BeforeEach
    public void setup() {
        tst = new TernarySearchTree<>();
    }

    @Test
    public void sizeShouldReturnNumberOfElements() {
        tst.put("one", 0);
        tst.put("one", 1);
        tst.put("two", 2);
        Assertions.assertEquals(2, tst.size());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(tst.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        tst.put("one", 1);
        Assertions.assertFalse(tst.isEmpty());
    }

    @Test
    public void putAndGetShouldWorkCorrectlyWhenGivenElements() {
        tst.put("one", 0);
        tst.put("one", 1);
        tst.put("two", 2);
        tst.put("three", 3);
        Assertions.assertEquals(1, tst.get("one"));
        Assertions.assertEquals(2, tst.get("two"));
        Assertions.assertEquals(3, tst.get("three"));
    }

    @Test
    public void keysShouldReturnAllKeysInOrdered() {
        tst.put("love", 1);
        tst.put("zone", 1);
        tst.put("are", 1);
        tst.put("by", 1);
        Iterable<String> expected = Arrays.asList(
                "are",
                "by",
                "love",
                "zone"
        );
        Iterable<String> actual = tst.keys();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void keysWithPrefixShouldReturnAllKeysWithInputPrefix() {
        tst.put("she", 1);
        tst.put("sh", 1);
        tst.put("shell", 1);
        tst.put("shock", 1);
        tst.put("see", 1);
        tst.put("six", 1);
        tst.put("seven", 1);
        Iterable<String> expected = Arrays.asList(
                "sh",
                "she",
                "shell",
                "shock"
        );
        Iterable<String> actual = tst.keysWithPrefix("sh");
        Assertions.assertIterableEquals(expected, actual);
    }
}