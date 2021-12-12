package algs.string;

/***
 * Abstract class for sub-string search: search "pattern" in "text".
 * Return index of first character of pattern in text if found.
 * Return length of text if not found.
 */
public abstract class SubStringSearch {
    protected String pattern;

    public SubStringSearch(String pattern) {
        this.pattern = pattern;
    }

    abstract int search(String text);
}
