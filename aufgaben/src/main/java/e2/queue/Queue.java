package e2.queue;

public class Queue {

    private final char[] queue;
    private int front;
    private int rear;

    public Queue() {
        this.queue = new char[8];
    }

    public void enqueue(char c) {
        queue[rear] = c;
        rear = (rear + 1) % queue.length;
    }

    public char dequeue() {
        char temp =queue[front];
        front = (front + 1) % queue.length;
        return temp;
    }

    public char peek() {
        return queue[front];
    }

    public String toString() {
        return new String(queue);
    }
}
