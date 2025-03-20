package e4.hashsetLinkedList;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        int temp = 0;
        Node next = head;
        while (next != null) {
            temp++;
            next = next.getNext();
        }
        return temp;
    }

    public void add(Element data) {
        this.head = new Node(head,data);
    }

    public Node getNode(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public Node removeHead() {
        Node temp = this.head;
        this.head = this.head.getNext();
        return temp;
    }

    public void remove(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            if(i == index-1) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }

    public void remove(Element data) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getNode(i).getData().equals(data)) {
                this.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String temp = "{";
        Node next = this.head;
        while (next != null) {
            temp += next.toString() + ",";
            next = next.getNext();
        }
        temp += "}";
        return temp;
    }
}
