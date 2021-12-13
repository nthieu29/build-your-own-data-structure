package algs.string;

public class BoyerMoore extends SubStringSearch {
    private static final int RADIX = 256;
    private int[] right;

    public BoyerMoore(String pattern) {
        super(pattern);
        computeIndexOfRightMostCharacterInPattern();
    }

    private void computeIndexOfRightMostCharacterInPattern() {
        this.right = new int[RADIX];
        for (int i = 0; i < RADIX; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            right[pattern.charAt(i)] = i;
        }
    }

    @Override
    public int search(String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int skip;
        for (int pointerInText = 0; pointerInText < textLength - patternLength; pointerInText = pointerInText + skip) {
            skip = 0;
            for (int pointerInPattern = pattern.length() - 1; pointerInPattern >= 0; pointerInPattern--) {
                char charInPattern = pattern.charAt(pointerInPattern);
                char charInText = text.charAt(pointerInText + pointerInPattern);
                if (charInPattern != charInText) {
                    skip = Math.max(1, pointerInPattern - right[charInText]);
                    break;
                }
            }
            if (skip == 0) return pointerInText; // found
        }
        return textLength; // not found
    }
}
