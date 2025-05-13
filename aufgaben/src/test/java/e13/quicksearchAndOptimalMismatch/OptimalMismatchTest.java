package e13.quicksearchAndOptimalMismatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalMismatchTest {

    @Test
    void testExactMatch() {
        assertEquals(0, OptimalMismatch.optimalMismatch("gaga", "gaga"));
    }

    @Test
    void testMatchAtBeginning() {
        assertEquals(0, OptimalMismatch.optimalMismatch("gagababa", "gaga"));
    }

    @Test
    void testMatchAtMiddle() {
        assertEquals(2, OptimalMismatch.optimalMismatch("aagagaga", "gaga"));
    }

    @Test
    void testMatchAtEnd() {
        assertEquals(4, OptimalMismatch.optimalMismatch("babbgaga", "gaga"));
    }

    @Test
    void testNoMatch() {
        assertEquals(-1, OptimalMismatch.optimalMismatch("abcdefgh", "gaga"));
    }

    @Test
    void testPatternLongerThanText() {
        assertEquals(-1, OptimalMismatch.optimalMismatch("abc", "abcdef"));
    }

    @Test
    void testMultipleOccurrences() {
        assertEquals(0, OptimalMismatch.optimalMismatch("gagagaga", "gaga")); // only first match counts
    }

}