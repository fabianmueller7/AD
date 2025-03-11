package e4.performanceComparison.stack;

public class CStack implements StackInterface {

    private final String[] stack;
    private int top;
    private final int size;

    public CStack(final int stackSize) {
        top = -1;
        size = stackSize;
        stack = new String[stackSize];
    }

    @Override
    public boolean push(String o) {
        if (top == size - 1) {
            return false;
        }
        this.stack[++top] = o;
        return true;
    }

    @Override
    public Object pop() {
        if (top == -1) {
            return null;
        }
        return this.stack[top--];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
