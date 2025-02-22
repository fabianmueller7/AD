package e1;

public class Ackermann {

    private int counter = 0;

    public static void main(String[] args) {
        Ackermann ackermann = new Ackermann();
        System.out.println(ackermann.ack(2,2));
        System.out.println("Counter: " + ackermann.counter);
    }

    public int ack(int n, int m) {
        counter++;
            if (n == 0) {
                return m + 1;
            }
         else if (m == 0) {
                return ack(n - 1, 1);
            }
         else
            return ack(n - 1, ack(n, m - 1));
    }
}
