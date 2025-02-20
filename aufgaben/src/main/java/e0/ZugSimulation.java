package e0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static e0.Wagen.berechneGesamtPlätze;

public final class ZugSimulation {

    public static void main(final String[] args) {

        Logger LOG = LoggerFactory.getLogger(ZugSimulation.class);

        // Personenwagen erzeugen,
        // mit unterschiedlichen Kapazitäten
        Wagen wagen1 = new Wagen("W001", 60);
        Wagen wagen2 = new Wagen("W002", 40);
        Wagen wagen3 = new Wagen("W003", 80);

        // Verkettung der Wagen
        wagen1.setNachfolger(wagen2);
        wagen2.setNachfolger(wagen3);

        // Berechnung der Gesamtanzahl Plätze
        int gesamt = berechneGesamtPlätze(wagen1);
        LOG.info("Gesamtanzahl Plätze: " + gesamt);
    }
}
