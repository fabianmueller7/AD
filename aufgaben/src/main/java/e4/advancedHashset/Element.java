package e4.advancedHashset;

public class Element {

    private int hash;
    private int data;

    Element(int hash, int data) {
        this.hash = hash;
        this.data = data;
    }

    public int getHash() {
        return hash;
    }

    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if(!(object instanceof Element)) {
            return false;
        }
        return  (((Element) object).getHash() == this.getHash()) && (((Element) object).getData() == this.getData());
    }

    @Override
    public String toString() {
        return "Element [hash=" + hash + ", data=" + data + "]";
    }
}
