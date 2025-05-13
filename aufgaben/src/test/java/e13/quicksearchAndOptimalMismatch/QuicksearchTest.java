package e13.quicksearchAndOptimalMismatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksearchTest {

    @Test
    void testExactMatch() {
        assertEquals(0, Quicksearch.quickSearch("gaga", "gaga"));
    }

    @Test
    void testMatchAtBeginning() {
        assertEquals(0, Quicksearch.quickSearch("gagababa", "gaga"));
    }

    @Test
    void testMatchAtMiddle() {
        assertEquals(2, Quicksearch.quickSearch("aagagaga", "gaga"));
    }

    @Test
    void testMatchAtEnd() {
        assertEquals(4, Quicksearch.quickSearch("babbgaga", "gaga"));
    }

    @Test
    void testNoMatch() {
        assertEquals(-1, Quicksearch.quickSearch("abcdefgh", "gaga"));
    }

    @Test
    void testPatternLongerThanText() {
        assertEquals(-1, Quicksearch.quickSearch("abc", "abcdef"));
    }

    @Test
    void testMultipleOccurrences() {
        assertEquals(0, Quicksearch.quickSearch("gagagaga", "gaga")); // only first match counts
    }
}