package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class WordleTest {

    @Test
    void testWordGeneration() {
        Wordle w = new Wordle();
        assertEquals(w.getWord().length(), 5);
        Wordle w2 = new Wordle("KUTYAFULE");
        assertEquals(w.getWord().length(), 5);
    }

    @Test
    void getWord() {
        Wordle w = new Wordle("KUTYA");
        assertEquals(w.getWord(), "KUTYA");
    }

    @Test
    void isExactMatch() {
        Wordle w = new Wordle("KUTYA");
        assertTrue(w.isExactMatch("KUTYA"));
        assertFalse(w.isExactMatch("KUGYA"));
    }

    @Test
    void isCharacterMatching() {
        Wordle w = new Wordle("KUTYA");
        assertAll(
                () -> assertEquals(w.getWord().charAt(0), 'K'),
                () -> assertEquals(w.getWord().charAt(1), 'U'),
                () -> assertEquals(w.getWord().charAt(2), 'T'),
                () -> assertEquals(w.getWord().charAt(3), 'Y'),
                () -> assertEquals(w.getWord().charAt(4), 'A')
        );
    }

    @Test
    void isContainsCharacter() {
        Wordle w = new Wordle("KUTYA");
        assertAll(
                () -> assertTrue(w.isContainsCharacter('K')),
                () -> assertTrue(w.isContainsCharacter('U')),
                () -> assertTrue(w.isContainsCharacter('T')),
                () -> assertTrue(w.isContainsCharacter('Y')),
                () -> assertTrue(w.isContainsCharacter('A')),
                () -> assertFalse(w.isContainsCharacter('X')),
                () -> assertFalse(w.isContainsCharacter('P')),
                () -> assertFalse(w.isContainsCharacter('S'))
        );
    }
}