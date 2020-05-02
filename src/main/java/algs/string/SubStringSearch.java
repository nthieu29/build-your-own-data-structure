package algs.string;

public abstract class SubStringSearch {
    protected String pattern;

    public SubStringSearch(String pattern) {
        this.pattern = pattern;
    }

    abstract int search(String text);
}
