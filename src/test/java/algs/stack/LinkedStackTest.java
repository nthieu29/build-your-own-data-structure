package algs.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class LinkedStackTest {
    private Stack<Integer> stack;

    @BeforeEach
    public void setupEachTest() {
        stack = new LinkedStack<>();
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
    public void popShouldWorkCorrectly() {
        stack.push(1);
        stack.push(3);
        stack.push(5);
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(1, stack.pop());
    }

    @Test
    public void shouldThrowExceptionWhenPopOnEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}