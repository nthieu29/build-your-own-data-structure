package algs.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndexMinPQTest {
    private IndexMinPQ<Integer> indexMinPQ;

    @BeforeEach
    public void setup() {
        indexMinPQ = new IndexMinPQ<>(8);
    }

    @Test
    public void insertShouldWorkCorrectly() {
        indexMinPQ.insert(0, 1);
        indexMinPQ.insert(2, 3);
        indexMinPQ.insert(3, 4);
        indexMinPQ.insert(1, 2);
        Assertions.assertEquals(0, indexMinPQ.delMin());
        Assertions.assertEquals(1, indexMinPQ.delMin());
        Assertions.assertEquals(2, indexMinPQ.delMin());
        Assertions.assertEquals(3, indexMinPQ.delMin());
    }

    @Test
    public void decreaseKeyShouldWorkCorrectly() {
        indexMinPQ.insert(0, 1);
        indexMinPQ.insert(1, 9);
        indexMinPQ.decreaseKey(1, 0);
        Assertions.assertEquals(1, indexMinPQ.delMin());
    }

    @Test
    public void increaseKeyShouldWorkCorrectly() {
        indexMinPQ.insert(0, 1);
        indexMinPQ.insert(1, 9);
        indexMinPQ.increaseKey(0, 10);
        Assertions.assertEquals(1, indexMinPQ.delMin());
    }
}