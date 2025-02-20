package e0;

import java.util.Objects;

public class Wagen {

    private final String id;
    private final int plaetze;
    private Wagen nachfolger;

    Wagen(String id, int plaetze) {
        this.id = id;
        this.plaetze = plaetze;
        this.nachfolger = null;
    }

    Wagen(String id, int plaetze, Wagen nachfolger) {
        this.id = id;
        this.plaetze = plaetze;
        this.nachfolger = nachfolger;
    }

    public static int berechneGesamtPlätze(Wagen wagen) {
        int sum = wagen.plaetze;
        while(wagen.getNachfolger() != null) {
            wagen = wagen.getNachfolger();
            sum += wagen.plaetze;
        }
        return sum;
    }

    public String getId() {
        return id;
    }

    public int getAnzahlPlaetze() {
        return this.plaetze;
    }

    public Wagen getNachfolger() {
        return nachfolger;
    }

    public void setNachfolger(Wagen nachfolger) {
        this.nachfolger = nachfolger;
    }

    @Override
    public String toString() {
        return "Wagen: " + this.id + ", Plätze: " + this.plaetze;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if(!(object instanceof Wagen)) {
            return false;
        }
        return  (((Wagen) object).id.equals(this.id)) && (((Wagen) object).plaetze == this.plaetze);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.plaetze);
    }
}
