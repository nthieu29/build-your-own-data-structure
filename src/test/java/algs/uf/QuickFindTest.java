package algs.uf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuickFindTest {
    private static UF uf;

    @BeforeAll
    public static void setup() {
        uf = new QuickFind(6);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(4, 5);
    }

    @Test
    public void connected0And1ShouldTrue() {
        Assertions.assertTrue(uf.connected(0, 1));
    }

    @Test
    public void connected1And2ShouldTrue() {
        Assertions.assertTrue(uf.connected(1, 2));
    }

    @Test
    public void connected0And2ShouldTrue() {
        Assertions.assertTrue(uf.connected(0, 2));
    }

    @Test
    public void connected4And5ShouldTrue() {
        Assertions.assertTrue(uf.connected(4, 5));
    }

    @Test
    public void connected3And4ShouldFalse() {
        Assertions.assertFalse(uf.connected(3, 4));
    }

}