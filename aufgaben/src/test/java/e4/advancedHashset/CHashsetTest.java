package e4.advancedHashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CHashsetTest {

    private CHashset hashset;

    @BeforeEach
    void setUp() {
        this.hashset = new CHashset();
        hashset.add(1);
        hashset.add(3);
        hashset.add(5);
        hashset.add(7);
    }

    @Test
    void exits() {
        assertTrue(hashset.exits(new Element(124,1)));
    }

    @Test
    void getIndexOf() {
        assertEquals(4,hashset.getIndexOf(124));
    }

    @Test
    void size() {
        assertEquals(4,hashset.used());
    }


    @Test
    void isFull() {
        hashset.add(10);
        hashset.add(20);
        hashset.add(30);
        hashset.add(40);
        hashset.add(50);
        hashset.add(60);
        hashset.add(70);
        assertTrue(hashset.isFull());
    }
}