package e3.mathSuchbaum;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Node n = new Mul(
                new Add(new Number(2), new Number(2)),
                new Number(3)
        );

        System.out.println(n.eval());
        System.out.println(n.toString());

        List<String> operants = n.compile();
        System.out.println(operants);
    }
}
