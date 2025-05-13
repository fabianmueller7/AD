package e12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordLanguageTest {

    @Test
    void isWordLanguage() {

        assertTrue(WordLanguage.isWordLanguage("0"));
        assertTrue(WordLanguage.isWordLanguage("010"));
        assertTrue(WordLanguage.isWordLanguage("01110"));
        assertTrue(WordLanguage.isWordLanguage("0101110101110"));

        assertFalse(WordLanguage.isWordLanguage("01"));
        assertFalse(WordLanguage.isWordLanguage("0111"));
        assertFalse(WordLanguage.isWordLanguage("010110"));
        assertFalse(WordLanguage.isWordLanguage("0101110111"));


    }
}