package e4.simpleHashset;

import java.util.ArrayList;

public class CHashset {

    private Element[] hashset;

    public static void main(String[] args) {
        CHashset hashset = new CHashset();
        hashset.add(1);
        hashset.add(3);
        hashset.add(5);
        hashset.add(7);

        System.out.println(hashset);
    }

    public CHashset() {
        this.hashset = new Element[10];
    }

    public void add(final int value) {

            Element element = new Element(this.hash(value),value);
            int prefferedIndex = this.hashCodeToArrayIndex(element.getHash());
            //int index = this.findEmptySlot(prefferedIndex);

            this.hashset[prefferedIndex] = element;
    }

    public int getIndexOf(final int hashcode) {
        int start = this.hashCodeToArrayIndex(hashcode);

        while(this.getByIndex(start) != null) {
            if(this.getByIndex(start).getHash() == hashcode) {
                return start;
            }
            start++;
        }
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
        for(Element element : this.hashset) {
            if(element != null) {
                str += element.toString( ) + ";";
            }
        }
        return str;
    }
}
