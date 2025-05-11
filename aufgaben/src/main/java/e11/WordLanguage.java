package e11;

public class WordLanguage {

    public static boolean isWordLanguage(final String s) {
        if (s == null || s.isEmpty()) return false;
        char[] chars = s.toCharArray();

        if (chars[0] != '0') return false;                  // muss mit 0 starten
        if (chars[chars.length - 1] != '0') return false;   // muss mit 0 enden

        int i = 1;  // beginne nach der ersten 0

        while (i < chars.length) {
            // prüfe Gruppe von Einsen
            int oneCount = 0;
            while (i < chars.length && chars[i] == '1') {
                oneCount++;
                i++;
            }

            // Falls keine 1-Gruppe (z. B. doppelte 0 oder 0 direkt am Ende)
            if (oneCount == 0 || oneCount % 2 == 0) return false;

            // danach MUSS genau eine 0 folgen
            if (i >= chars.length || chars[i] != '0') return false;

            i++; // weiter nach der 0
        }

        return true;
    }
}
