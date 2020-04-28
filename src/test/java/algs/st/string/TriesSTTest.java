package algs.st.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TriesSTTest {
    private TriesST<Integer> tries;

    @BeforeEach
    public void setup() {
        tries = new TriesST<>();
    }

    @Test
    public void sizeShouldReturnNumberOfElements() {
        tries.put("one", 0);
        tries.put("one", 1);
        tries.put("two", 2);
        Assertions.assertEquals(2, tries.size());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(tries.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        tries.put("one", 1);
        Assertions.assertFalse(tries.isEmpty());
    }

    @Test
    public void putAndGetShouldWorkCorrectlyWhenGivenElements() {
        tries.put("one", 0);
        tries.put("one", 1);
        tries.put("two", 2);
        tries.put("three", 3);
        Assertions.assertEquals(1, tries.get("one"));
        Assertions.assertEquals(2, tries.get("two"));
        Assertions.assertEquals(3, tries.get("three"));
    }

    @Test
    public void deleteShouldDeleteElementInTries() {
        tries.put("one", 1);
        tries.delete("one");
        Assertions.assertNull(tries.get("one"));
    }

    @Test
    public void keysShouldReturnAllKeysInOrdered() {
        tries.put("love", 1);
        tries.put("zone", 1);
        tries.put("are", 1);
        tries.put("by", 1);
        Iterable<String> expected = Arrays.asList(
                "are",
                "by",
                "love",
                "zone"
        );
        Iterable<String> actual = tries.keys();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void keysWithPrefixShouldReturnAllKeysWithInputPrefix() {
        tries.put("she", 1);
        tries.put("sh", 1);
        tries.put("shell", 1);
        tries.put("shock", 1);
        tries.put("see", 1);
        tries.put("six", 1);
        tries.put("seven", 1);
        Iterable<String> expected = Arrays.asList(
                "sh",
                "she",
                "shell",
                "shock"
        );
        Iterable<String> actual = tries.keysWithPrefix("sh");
        Assertions.assertIterableEquals(expected, actual);
    }
}