package laivanupotus;

public class Laivat {

    public Laivat() {

    }

    public String getNimi(Integer pituus) { //palauttaa laivan nimen pituuden perusteella

        if (pituus == 4) {
            return "Lentotukialus";
        }
        if (pituus == 3) {
            return "Risteilijä";
        }
        if (pituus == 2) {
            return "Hävittäjä";
        } else {
            return "Sukellusvene";
        }

    }

}
