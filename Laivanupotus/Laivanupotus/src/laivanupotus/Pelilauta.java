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

    public boolean varaaTilaa(String kirjain, Integer numero, Integer pituus, String suunta) { //Tulee korvaamaan osittain hirviömetodin

        int sarake = kirjaimet.indexOf(kirjain);

        if (suunta.equals("V")) {

            if (varaaTilaaVasemmalle(sarake, numero, pituus)) {

                return true;
            }

        }

        if (suunta.equals("O")) {
            
            if (varaaTilaaOikealle(sarake, numero, pituus)) {
                
                return true;
            }
        }

        else if (suunta.equals("Y")) {
            
            if (varaaTilaaYlos(sarake, numero, pituus)){
                
                return true;
            }

        }
        else if (suunta.equals("A")) {
            
            if (varaaTilaaAlas(sarake, numero, pituus)){
                
                return true;
            }
        }
        return false;

    }

    public boolean varaaTilaaVasemmalle(Integer sarake, Integer numero, Integer pituus) {

        int laivanPituus = pituus;

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
        return true;
    }

    public boolean varaaTilaaOikealle(Integer sarake, Integer numero, Integer pituus) {

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
        return true;
    }

    public boolean varaaTilaaYlos(Integer sarake, Integer numero, Integer pituus) {

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
        return true;
    }

    public boolean varaaTilaaAlas(Integer sarake, Integer numero, Integer pituus) {

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
        return true;
    }
    
}
