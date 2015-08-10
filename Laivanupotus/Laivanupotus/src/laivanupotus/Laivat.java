package laivanupotus;

public class Laivat {

    String nimi;
    String laiva1 = "Lentotukialus";
    String laiva2 = "Risteilija";
    String laiva3 = "Havittaja";
    String laiva4 = "Sukellusvene";

    public Laivat() {

    }

    public String getNimi(Integer pituus) {

        if (pituus == 4) {
            return "Lentotukialus";
        } else if (pituus == 3) {
            return "Risteilijä";
        } else if (pituus == 3) {
            return "Hävittäjä";
        } else {
            return "Sukellusvene";
        }

    }

}
