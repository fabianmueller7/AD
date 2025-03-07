package e3.mathSuchbaum;

import java.util.List;

public class Mul extends Node {

    private Node a,b;

    public Mul(Node a, Node b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() * b.eval();
    }

    @Override
    public String toString() {
        return "(" + a.toString() + " * " + b.toString() + ")";
    }

    @Override
    public List<String> compile(List<String> args) {
        a.compile(args);
        b.compile(args);
        args.add("MUL");
        return args;
    }
}
