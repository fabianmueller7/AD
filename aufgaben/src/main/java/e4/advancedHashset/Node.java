package e4.advancedHashset;

import java.util.Objects;

public class Node {

    private Node next;
    private Element data;

    public Node(Node next, Element data) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if(!(object instanceof Node)) {
            return false;
        }
        return  (((Node) object).data.equals(this.data)) && (((Node) object).next == this.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.next);
    }

    @Override
    public String toString() {
        return "{hash: " + data.getHash() + ", value: "+ data.getData() + "}";
    }
}
