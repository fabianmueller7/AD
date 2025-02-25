package e2.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue('H');
        queue.enqueue('E');
        queue.enqueue('L');
        queue.enqueue('L');
        queue.enqueue('O');
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('F');
        System.out.println(queue.toString());
    }
}
