package e0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WagenTest {

    private Wagen wagen1;
    private Wagen wagen2;
    private Wagen wagen3;

    @BeforeEach
    void setUp() {
        this.wagen1 = new Wagen("W001", 60);
        this.wagen2 = new Wagen("W002", 40);
        this.wagen3 = new Wagen("W003", 80);
    }

    @Test
    void berechneGesamtPlätze() {
        wagen1.setNachfolger(wagen2);
        wagen2.setNachfolger(wagen3);
        assertEquals(180, Wagen.berechneGesamtPlätze(wagen1));
    }

    @Test
    void berechneGesamtPlätze2() {
        Wagen w = new Wagen("W001", 60,
                new Wagen("W002", 40,
                        new Wagen("W003", 80)));
        assertEquals(180, Wagen.berechneGesamtPlätze(w));
    }

    @Test
    void testEquals() {
        assertTrue(wagen1.equals(wagen1));
        assertFalse(wagen1.equals(wagen2));
    }
}