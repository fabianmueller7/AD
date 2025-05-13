package e13.optimierterSuchautomat;

public class AnanasSearch {

    public static int[] randTabelle = {0,0,1,2,3,0};

    public static int kmpSearch(final String text, String pattern) {
        int[] tabelle = randTabelle;
        int j = 0; // Index im Pattern = Zustand des Automaten

        for(int i=0; i < text.length() ; i++) {

            while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = tabelle[j-1]; //Automat gemass Randtabelle zurücksetzen
            }


            if (text.charAt(i) == pattern.charAt(j)) {
                j++; // Match, nächstes zeichen im Pattern
            }

            //Pattern gefunden? Startposition zurückliefern
            if(j == pattern.length()) {
                return  i-j+1;
            }
        }

        return -1; // Pattern nicht gefunden
    }

    public static void main(String[] args) {
        String test1 = "ananasnanasnanaanan";
        int restult = AnanasSearch.kmpSearch(test1, "ananas");
        System.out.println("Gefunden bei: " + restult);
    }

}
