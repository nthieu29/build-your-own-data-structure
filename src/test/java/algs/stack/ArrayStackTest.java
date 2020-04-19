package algs.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class ArrayStackTest {
    private Stack<Integer> stack;

    @BeforeEach
    public void setupEachTest() {
        stack = new ArrayStack<>();
    }

    @Test
    public void pushAndSizeShouldWorkCorrectlyWhenAdd1Element() {
        stack.push(5);
        int expectedPop = 5;
        int expectedSize = 1;
        Assertions.assertEquals(expectedSize, stack.size());
        Assertions.assertEquals(expectedPop, stack.pop());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoElement() {
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereIsElement() {
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void addAndPopShouldWorkCorrectlyWhenDataIsLargerThanDefaultCapacity() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(9, stack.pop());
        Assertions.assertEquals(8, stack.pop());
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertEquals(6, stack.pop());
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertEquals(0, stack.pop());
    }

    @Test
    public void shouldThrowExceptionWhenPopOnEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}