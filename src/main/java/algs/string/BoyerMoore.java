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
        for (int i = 0; i < textLength - patternLength; i = i + skip) {
            skip = 0;
            for (int j = pattern.length() - 1; j >= 0; j--) {
                char charInPattern = pattern.charAt(j);
                char charInText = text.charAt(i + j);
                if (charInPattern != charInText) {
                    skip = Math.max(1, j - right[charInText]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return textLength;
    }
}
