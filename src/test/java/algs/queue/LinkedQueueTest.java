package algs.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LinkedQueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setupBeforeEachTest() {
        queue = new LinkedQueue<>();
    }

    @Test
    public void offerAndPollAndSizeShouldWorkCorrectly() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(3, queue.size());
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(2, queue.size());
        Assertions.assertEquals(2, queue.poll());
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        queue.offer(1);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void shouldBeIterableCorrectly() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int indexInExpectedOrder = 0;
        for (Integer currentInteger : queue) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentInteger);
            indexInExpectedOrder++;
        }
    }

}