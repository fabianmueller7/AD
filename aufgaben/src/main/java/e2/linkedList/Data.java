package e2.linkedList;

import java.util.Objects;

public class Data {

    private final int datavalue;

    public Data(int datavalue) {
        this.datavalue = datavalue;
    }

    public int getDatavalue() {
        return datavalue;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if(!(object instanceof Data)) {
            return false;
        }
        return  (((Data) object).getDatavalue() == this.getDatavalue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDatavalue());
    }
}
