package laivanupotus;

import java.util.ArrayList;
import java.util.HashMap;

public class Pelilauta {

    Laivat laivat = new Laivat();
    boolean[][] ruudut = new boolean[10][10];
    String kirjaimet = "ABCDEFGHIJ";
    int laivanPituus;

    public boolean onkoRuutuVarattu(String sarake, Integer rivi) {

        int indeksi = kirjaimet.indexOf(sarake);
        return ruudut[rivi][indeksi];

    }

    public boolean onkoRuutuVapaa(Integer sarake, Integer rivi) {

        return ruudut[rivi][sarake];

    }

    public void varaaRuutu(int sarake, int rivi) {

        ruudut[rivi][sarake] = true;

    }

    public void asetaPituus(Integer pituus) {
        laivanPituus = pituus;
    }

    public boolean varaaTilaa1(String kirjain, Integer numero, String suunta) { //Tulee korvaamaan osittain hirviömetodin

        int sarake = kirjaimet.indexOf(kirjain);

        if (suunta.equals("V")) {

            return false;
        }    
        return false;
    } 

    public boolean varaaTilaa(String kirjain, int numero, Integer pituus, String suunta) {

        int sarake = kirjaimet.indexOf(kirjain);

        if (suunta.equals("V")) {
            if (sarake - pituus < 0) {
                return false;
            }

            for (int i = 0; i < pituus; i++) {

                int nykyinenSarake = sarake - i;

                if (onkoRuutuVapaa(nykyinenSarake, numero)) {
                    return false;
                }
            }
            for (int i = 0; i < pituus; i++) {

                int nykyinenSarake = sarake - i;
                varaaRuutu(nykyinenSarake, numero);
            }
        } else if (suunta.equals("O")) {
            if (sarake + pituus > 10) {

                return false;

            }
            for (int i = 0; i < pituus; i++) {
                int nykyinenSarake = sarake + 1;
                if (onkoRuutuVapaa(nykyinenSarake, numero)) {
                    return false;
                }

            }
            for (int i = 0; i < pituus; i++) {
                int nykyinenSarake = sarake + i;
                varaaRuutu(nykyinenSarake, numero);
            }

        } else if (suunta.equals("Y")) {

            if (numero - pituus < 0) {
                return false;
            }

            for (int i = 0; i < pituus; i++) {

                int nykyinenRivi = numero - i;

                if (onkoRuutuVapaa(nykyinenRivi, numero)) {
                    return false;
                }
            }
            for (int i = 0; i < pituus; i++) {

                int nykyinenRivi = sarake - i;
                varaaRuutu(nykyinenRivi, numero);
            }

        } else if (suunta.equals("A")) {

            if (numero + pituus > 10) {
                return false;
            }

            for (int i = 0; i < pituus; i++) {

                int nykyinenRivi = numero + i;

                if (onkoRuutuVapaa(nykyinenRivi, numero)) {
                    return false;
                }
            }
            for (int i = 0; i < pituus; i++) {

                int nykyinenRivi = numero + i;
                varaaRuutu(nykyinenRivi, numero);
            }

        } else {

            return false;
        }

        return true;
    }
}
