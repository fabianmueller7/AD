package e3.mathSuchbaum;

import java.util.List;

public class Number extends Node {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int eval() {
        return getNumber();
    }

    @Override
    public String toString() {
        return "" + getNumber();
    }


    @Override
    public List<String> compile(List<String> args) {
        args.add("" + getNumber());
        return args;
    }
}
