package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
        fibonacci.createFibonacciTable(10);
    }

    @Test
    void testFibonacciRec() {
        assertEquals(5,fibonacci.fibonacciRec(4));
        assertEquals(21,fibonacci.fibonacciRec(7));
        assertEquals(8,fibonacci.fibonacciRec(5));
    }

    @Test
    void testFibonacciTable() {
        assertEquals(5,fibonacci.fibonacciTable(4));
        assertEquals(21,fibonacci.fibonacciTable(7));
        assertEquals(8,fibonacci.fibonacciTable(5));
    }

    @Test
    void testFibonacciIter() {
        assertEquals(5,fibonacci.fibonacciIter(4));
        assertEquals(21,fibonacci.fibonacciIter(7));
        assertEquals(8,fibonacci.fibonacciIter(5));
    }
}