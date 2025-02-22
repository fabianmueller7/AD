package e1;

import java.util.ArrayList;

public class Fibonacci {

    private ArrayList<Integer> fibonacciTable = new ArrayList<>();

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.createFibonacciTable(15);
    }

    public int fibonacciRec(int n) {
        if (n <= 2) { //Die Basiszahlen von Fobonacci sind 1 und 2.
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2); //Fibonacci besteht immer aus der letzten und vorletzten Zahl.
    }

    public void createFibonacciTable(int n) {
        for (int i = 1; i < n; i++) {
            fibonacciTable.add(fibonacciRec(i));
        }
    }

    public int fibonacciTable(int n) {
        return fibonacciTable.get(n - 1);
    }

    public int fibonacciIter(int n) {
        if (n <= 2) {
            return n;
        }

        int fib1 = 2;
        int fib2 = 1;

        for (int i = 3; i <= n; i++) {
            int nextFib = fib1 + fib2;
            fib2 = fib1;
            fib1 = nextFib;
        }
        return fib1;
    }
}
