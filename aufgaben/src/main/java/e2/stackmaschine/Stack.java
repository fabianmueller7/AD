package e2.stackmaschine;

import e2.stack.StackInterface;

public class Stack {

    private final int[] stack;
    private int top;
    private final int size;

    public Stack(final int stackSize) {
        top = -1;
        size = stackSize;
        stack = new int[stackSize];
    }

    public boolean push(int value) {
        if (top == size - 1) {
            return false;
        }
        this.stack[++top] = value;
        return true;
    }

    public int pop() {
        if (top == -1) {
            return 0;
        }
        return this.stack[top--];
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}