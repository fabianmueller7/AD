package e2.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        this.stack = new Stack(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
    }

    @Test
    void push() {
        stack.push("d");
        assertEquals("d", stack.pop());
    }

    @Test
    void pop() {
        assertEquals("c", stack.pop());
    }

    @Test
    void size() {
        assertEquals(3, stack.size());
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void MaxstackSize() {
        Stack stack = new Stack(1);
        assertTrue(stack.push("a"));
        assertFalse(stack.push("b"));
        stack.pop();
        assertTrue(stack.push("c"));
    }
}