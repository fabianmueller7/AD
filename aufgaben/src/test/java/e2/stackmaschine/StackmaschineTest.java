package e2.stackmaschine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackmaschineTest {

    private Stackmaschine stackmaschine;

    @BeforeEach
    void setUp() {
        stackmaschine = new Stackmaschine();
    }

    @Test
    void Aufg1() {
        stackmaschine.LOAD(2);
        stackmaschine.LOAD(3);
        stackmaschine.ADD();
        stackmaschine.LOAD(4);
        stackmaschine.MUL();
        assertEquals(20, stackmaschine.PRINT());
    }

    @Test
    void Aufg2() {
        stackmaschine.LOAD(4);
        stackmaschine.LOAD(5);
        stackmaschine.ADD();
        stackmaschine.LOAD(2);
        stackmaschine.LOAD(3);
        stackmaschine.ADD();
        stackmaschine.MUL();
        assertEquals(45, stackmaschine.PRINT());
    }

    @Test
    void Aufg3() {
        stackmaschine.LOAD(4);
        stackmaschine.LOAD(7);
        stackmaschine.SUB();
        stackmaschine.LOAD(6);
        stackmaschine.DIV();
        stackmaschine.LOAD(5);
        stackmaschine.MUL();
        assertEquals(10, stackmaschine.PRINT());
    }


}