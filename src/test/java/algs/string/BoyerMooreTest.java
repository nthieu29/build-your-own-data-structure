package algs.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoyerMooreTest {
    @Test
    public void searchShouldReturnLengthOfInputWhenInputDoesNotContainPattern() {
        BoyerMoore boyerMoore = new BoyerMoore("super");
        String searchText = "We are champion!";
        int index = boyerMoore.search(searchText);
        Assertions.assertEquals(searchText.length(), index);
    }

    @Test
    public void searchShouldReturnIndexOfPatternInInput() {
        BoyerMoore boyerMoore = new BoyerMoore("captain");
        String searchText = "I like captain america";
        int index = boyerMoore.search(searchText);
        Assertions.assertEquals(7, index);
    }
}