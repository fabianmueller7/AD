package e2.stackmaschine;


public class Stackmaschine {

    private final Stack stack;

    public Stackmaschine() {
        this.stack = new Stack(100);
    }

    public void LOAD (final int value) {
        stack.push(value);
    }

    public void ADD() {
        stack.push(stack.pop()+stack.pop());
    }

    public void SUB() {
        stack.push(stack.pop()-stack.pop());
    }

    public void MUL() {
        stack.push(stack.pop()*stack.pop());
    }

    public void DIV() {
        stack.push(stack.pop()/stack.pop());
    }

    public int PRINT() {
        return stack.pop();
    }
}
