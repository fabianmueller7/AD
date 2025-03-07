package e3.mathSuchbaum;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    public abstract int eval();

    public abstract String toString();

    public abstract List<String> compile(List<String> args);

    public String toString(Node node){
        return "" + this.toString();
    }
    public List<String> compile() {
        List<String> list = new ArrayList<>();
        return this.compile(list);
    }
}
