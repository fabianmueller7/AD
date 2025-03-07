package e3.mathSuchbaum;

import java.util.List;

public class Add  extends Node {

    private Node a, b;

    public Add(Node a, Node b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() + b.eval();
    }

    @Override
    public String toString() {
        return "(" + a.toString() + " + " + b.toString() + ")";
    }

    @Override
    public List<String> compile(List<String> input) {
        a.compile(input);
        b.compile(input);
        input.add("ADD");
        return input;
    }
}
