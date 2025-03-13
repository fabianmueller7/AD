package e4.advancedHashset;

public class CHashset {

    private Element[] hashset;

    public static void main(String[] args) {
        CHashset hashset = new CHashset();
        hashset.add(1);
        hashset.add(3);
        hashset.add(5);
        hashset.add(7);
        hashset.add(11);
        hashset.add(13);
        hashset.add(17);
        hashset.add(19);
        hashset.add(22);
        hashset.add(23);
        hashset.add(24);
        hashset.add(25);

        System.out.println(hashset.toString());

        System.out.println("Index of Hash 775: "+ hashset.getIndexOf(775));
    }

    public CHashset() {
        this.hashset = new Element[10];
    }

    public void add(final int value) {

        Element element = new Element(this.hash(value),value);

        if(this.exits(element)){
            return; //Element already exists in list.
        }

        int prefferedIndex = this.hashCodeToArrayIndex(element.getHash());
        int index = this.findEmptySlot(prefferedIndex); //If array is full, preferred slot is used.

        this.hashset[index] = element;
    }

    public boolean exits(Element element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.hashset[i] != null && this.hashset[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOf(final int hashcode) {
        final int start = this.hashCodeToArrayIndex(hashcode);
        int slot = start;

        do {
            if(this.getByIndex(slot).getHash() == hashcode) {
                return slot;
            }
            slot = (slot + 1) % this.size();
        } while(this.getByIndex(slot) != null && slot != start);
        return -1;
    }

    public int size() {
        return hashset.length;
    }

    public Element getByIndex(final int index) {
        return hashset[index];
    }

    private int hashCodeToArrayIndex(final int hashCode) {
        return hashCode % this.hashset.length;
    }

    private int hash(final int value){
        return (value + 3) * 31;
    }

    /*
    First it tries the preferred index.
    If this doesn´t work, it goes through the whole array to find an empty slot.
    If no empty slot is found, is uses the preferred slot.
     */
    private int findEmptySlot(final int startindex) {
        int slot = startindex;
        do {
            if(this.hashset[slot] == null) {
                return slot;
            }
            slot = (slot + 1) % this.hashset.length;
        } while(this.getByIndex(slot) != null && slot != startindex);
        return slot;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < this.size(); i++) {
            if(this.hashset[i] != null) {
                str += i + " " + this.hashset[i].toString( ) + ", prefPos: " + hashCodeToArrayIndex(hashset[i].getHash()) +  ";\n";
            }
            else {
                str += i + " null\n";
            }
        }
        return str;
    }

    public boolean isFull(){
        return (this.used() == this.size());
    }

    public int used(){
        int occupied = 0;
        for(Element element : this.hashset) {
            if(element != null) {
                occupied++;
            }
        }
        return occupied;
    }
}
