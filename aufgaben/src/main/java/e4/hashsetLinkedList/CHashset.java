package e4.hashsetLinkedList;

public class CHashset {

    private LinkedList[] hashset;

    public static void main(String[] args) {
        CHashset hashset = new CHashset();

        hashset.add(1);
        hashset.add(1);

        hashset.add(3);
        hashset.add(5);
        hashset.add(7);
        hashset.add(9);
        hashset.add(11);
        hashset.add(13);
        hashset.add(15);
        hashset.add(17);
        hashset.add(19);
        hashset.add(21);
        hashset.add(22);
        hashset.add(23);

        System.out.println("Size: " + hashset.size());
        System.out.println(hashset.toString());
    }

    public CHashset() {
        this.hashset = new LinkedList[10];
        for (int i = 0; i < hashset.length; i++) {
            hashset[i] = new LinkedList();
        }
    }

    public void add(final int value) {

        Element element = new Element(this.hash(value),value);

        if(this.exits(element)){
            return; //Don't do anything, if  element already exists.
        }

        int index = this.hashCodeToArrayIndex(element.getHash());
        this.hashset[index].add(element);
    }

    public boolean exits(Element element) {
        final int index = this.hashCodeToArrayIndex(element.getHash());

        Node node = this.hashset[index].getHead();

        while (node != null) {
            if(node.getData().equals(element)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int size() {
        int temp = 0;
        for (int i = 0; i < this.hashset.length; i++) {
            temp += this.hashset[i].getSize();
        }
        return temp;
    }

    public Element getByIndex(final int index, final int position) {
        return hashset[index].getNode(position).getData();
    }

    public int getPosition(Element element) {
        int index = this.hashCodeToArrayIndex(element.getHash());
        Node node = this.hashset[index].getHead();
        int temp = 0;
        while (node != null) {
            if(node.getData().equals(element)) {
                return temp;
            }
            node = node.getNext();
            temp++;
        }
        return -1;
    }

    private int hashCodeToArrayIndex(final int hashCode) {
        return hashCode % this.hashset.length;
    }

    private int hash(final int value){
        return (value + 3) * 31;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < this.hashset.length; i++) {
            str += i + " : " + this.hashset[i].toString() +  ";\n";
        }
        return str;
    }
}
