package algs.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PriorityQueueTest {
    private PriorityQueue<Integer> priorityQueue;

    @Test
    public void offerAndPollShouldWorkCorrectly() {
        priorityQueue = new PriorityQueue<>(8, false);
        priorityQueue.offer(4);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(5);
        priorityQueue.offer(8);
        priorityQueue.offer(6);
        priorityQueue.offer(7);
        Assertions.assertEquals(8, priorityQueue.poll());
        Assertions.assertEquals(7, priorityQueue.poll());
        Assertions.assertEquals(6, priorityQueue.poll());
        Assertions.assertEquals(5, priorityQueue.poll());
        Assertions.assertEquals(4, priorityQueue.poll());
        Assertions.assertEquals(3, priorityQueue.poll());
        Assertions.assertEquals(2, priorityQueue.poll());
        Assertions.assertEquals(1, priorityQueue.poll());
    }

    @Test
    public void offerAndPollShouldWorkCorrectlyWhenUseMinOrderTrue() {
        priorityQueue = new PriorityQueue<>(8, true);
        priorityQueue.offer(4);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(5);
        priorityQueue.offer(8);
        priorityQueue.offer(6);
        priorityQueue.offer(7);
        Assertions.assertEquals(1, priorityQueue.poll());
        Assertions.assertEquals(2, priorityQueue.poll());
        Assertions.assertEquals(3, priorityQueue.poll());
        Assertions.assertEquals(4, priorityQueue.poll());
        Assertions.assertEquals(5, priorityQueue.poll());
        Assertions.assertEquals(6, priorityQueue.poll());
        Assertions.assertEquals(7, priorityQueue.poll());
        Assertions.assertEquals(8, priorityQueue.poll());
    }

    @Test
    public void sizeShouldBe0WhenCreateObject() {
        priorityQueue = new PriorityQueue<>(8);
        Assertions.assertEquals(0, priorityQueue.size());
    }

    @Test
    public void sizeShouldBeIncreasedWhenOffered() {
        priorityQueue = new PriorityQueue<>(8);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        Assertions.assertEquals(2, priorityQueue.size());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        priorityQueue = new PriorityQueue<>(8);
        Assertions.assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        priorityQueue = new PriorityQueue<>(8);
        priorityQueue.offer(1);
        Assertions.assertFalse(priorityQueue.isEmpty());
    }

    @Test
    public void shouldBeIterableCorrectlyWhenMaxOrder() {
        priorityQueue = new PriorityQueue<>(8);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        priorityQueue.offer(8);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        List<Integer> expectedOrder = Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1);
        int indexInExpectedOrder = 0;
        for (Integer currentInteger : priorityQueue) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentInteger);
            indexInExpectedOrder++;
        }
    }

    @Test
    public void shouldBeIterableCorrectlyWhenMinOrder() {
        priorityQueue = new PriorityQueue<>(8, true);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        priorityQueue.offer(8);
        priorityQueue.offer(5);
        priorityQueue.offer(7);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int indexInExpectedOrder = 0;
        for (Integer currentInteger : priorityQueue) {
            Assertions.assertEquals(expectedOrder.get(indexInExpectedOrder), currentInteger);
            indexInExpectedOrder++;
        }
    }
}