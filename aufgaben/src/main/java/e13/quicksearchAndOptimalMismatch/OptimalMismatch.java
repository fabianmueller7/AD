package e13.quicksearchAndOptimalMismatch;

public class OptimalMismatch {

    /**
     * Durchsucht eine Zeichenkette mittels optimal-Mismatch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @param p Pattern
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int optimalMismatch(final String a, final String p) {

        if(p.isEmpty() || a.length() < p.length()) {
            return -1;
        }

        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];

        // Shift-Array erzeugen, Grundbelegung
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        // Shifts aufgrund von Muster eintragen
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        // Suche
        int i = 0; // Text-Index
        int j = 0; // Pattern-Index
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // Match?
                j++;
            } else {
                if ((i + m) < n) { // falls a.charAt(i + m) nicht außerhalb ist…

                    int temp = shift[a.charAt(m - i)];
                    shift[a.charAt(m - i)] = shift[a.charAt(i)];
                    shift[a.charAt(i)] = temp;

                    i += shift[a.charAt(i + m)]; // Sprung
                    j = 0;
                } else {
                    break; // sonst Ende
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i; // Pattern gefunden
        } else {
            return -1; // nicht gefunden
        }
    }
}
