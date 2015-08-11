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
        indeksi++;
        return ruudut[indeksi][rivi];

    }

    public boolean onkoRuutuVapaa(Integer sarake, Integer rivi) {

        return ruudut[sarake][rivi];

    }

    public void varaaRuutu(int sarake, int rivi) { //Varaa käsiteltävän ruudun

        ruudut[sarake][rivi] = true;

    }

    public void asetaPituus(Integer pituus) { //Pitää kirjaa käsiteltävän laivan pituudesta
        laivanPituus = pituus;
    }

    public boolean varaaTilaa(String kirjain, Integer numero, Integer pituus, String suunta) { //Varaa tilaa laivalle

        int sarake = kirjaimet.indexOf(kirjain);

        if (suunta.equals("V")) {

            if (varaaTilaaVasemmalle(sarake, numero, pituus)) {

                return true;
            }

        } else if (suunta.equals("O")) {

            if (varaaTilaaOikealle(sarake, numero, pituus)) {

                return true;
            }
        } else if (suunta.equals("Y")) {

            if (varaaTilaaYlos(sarake, numero, pituus)) {

                return true;
            }

        } else if (suunta.equals("A")) {

            if (varaaTilaaAlas(sarake, numero, pituus)) {

                return true;
            }
        }
        return false;

    }

    public boolean varaaTilaaVasemmalle(Integer sarake, Integer numero, Integer pituus) { //Varaa laivalle tilaa vasemmalle, jos mahdollista

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

    public boolean varaaTilaaOikealle(Integer sarake, Integer numero, Integer pituus) { //Varaa laivalle tilaa oikealle, jos mahdollista

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

    public boolean varaaTilaaYlos(Integer sarake, Integer numero, Integer pituus) { //Varaa laivalle tilaa ylös, jos mahdollista

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

    public boolean varaaTilaaAlas(Integer sarake, Integer numero, Integer pituus) { //varaa laivalle tilaa alas, jos mahdollista

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

    public boolean onkoRuudullaLaiva(String sarake, Integer rivi) {
        
        int indeksi = kirjaimet.indexOf(sarake);
        indeksi++;
        return ruudut[indeksi][rivi];
    }

}
