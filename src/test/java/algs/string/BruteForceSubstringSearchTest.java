package algs.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BruteForceSubstringSearchTest {
    @Test
    public void searchShouldReturnLengthOfInputWhenInputDoesNotContainPattern() {
        BruteForceSubstringSearch bruteForceSearch = new BruteForceSubstringSearch("super");
        String searchText = "We are champion!";
        int index = bruteForceSearch.search(searchText);
        Assertions.assertEquals(searchText.length(), index);
    }

    @Test
    public void searchShouldReturnIndexOfPatternInInput() {
        BruteForceSubstringSearch bruteForceSearch = new BruteForceSubstringSearch("captain");
        String searchText = "I like captain america";
        int index = bruteForceSearch.search(searchText);
        Assertions.assertEquals(7, index);
    }
}