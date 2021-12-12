package algs.string;

public class BruteForceSubstringSearch extends SubStringSearch {

    public BruteForceSubstringSearch(String pattern) {
        super(pattern);
    }

    @Override
    int search(String text) {
        int textLength = text.length();
        int patternLength = this.pattern.length();
        for (int pointerInText = 0; pointerInText <= textLength - patternLength; pointerInText++) {
            int pointerInPattern;
            for (pointerInPattern = 0; pointerInPattern < patternLength; pointerInPattern++) {
                if (text.charAt(pointerInText + pointerInPattern) != pattern.charAt(pointerInPattern)) break;
            }
            if (pointerInPattern == patternLength) return pointerInText; // found
        }
        return textLength; // not found
    }
}
