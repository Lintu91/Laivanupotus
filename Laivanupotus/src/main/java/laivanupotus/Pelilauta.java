package laivanupotus;

import java.util.ArrayList;

public class Pelilauta {

    boolean[][] ruudut = new boolean[10][10];
    boolean[][] ammututRuudut = new boolean[10][10];
    String kirjaimet = "ABCDEFGHIJ";
    int laivanPituus;
    ArrayList<Laiva> pelaajanLaivat = new ArrayList<>();
    
    
    public boolean onkoRuutuVarattu(String sarake, Integer rivi) {

        int indeksi = kirjaimet.indexOf(sarake);
        return ruudut[indeksi][rivi];
    }

    public boolean onkoRuutuVarattu(Integer sarake, Integer rivi) {

        return ruudut[sarake][rivi];
    }

    public void varaaRuutu(int sarake, int rivi) { //Varaa käsiteltävän ruudun

        ruudut[sarake][rivi] = true;
    }

    public void asetaPituus(Integer pituus) { //Pitää kirjaa käsiteltävän laivan pituudesta
        laivanPituus = pituus;
    }

    public boolean varaaTilaa(Integer sarake, Integer numero, Integer pituus, String suunta) {
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
    public boolean varaaTilaa(String kirjain, Integer numero, Integer pituus, String suunta) { //Varaa tilaa laivalle

        int sarake = kirjaimet.indexOf(kirjain);
        return varaaTilaa(sarake, numero, pituus, suunta);
    }

    public boolean varaaTilaaVasemmalle(Integer sarake, Integer numero, Integer pituus) { //Varaa laivalle tilaa vasemmalle, jos mahdollista

        int laivanPituus = pituus;

        if (sarake - pituus < -1) {
            return false;
        }

        for (int i = 0; i < pituus; i++) {

            int nykyinenSarake = sarake - i;

            if (onkoRuutuVarattu(nykyinenSarake, numero)) {
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
            int nykyinenSarake = sarake + i;
            if (onkoRuutuVarattu(nykyinenSarake, numero)) {
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

        if (numero - pituus < -1) {
            return false;
        }

        for (int i = 0; i < pituus; i++) {

            int nykyinenRivi = numero - i;

            if (onkoRuutuVarattu(sarake, nykyinenRivi)) {
                return false;
            }
        }

        for (int i = 0; i < pituus; i++) {

            int nykyinenRivi = numero - i;
            varaaRuutu(sarake, nykyinenRivi);
        }

        return true;
    }

    public boolean varaaTilaaAlas(Integer sarake, Integer numero, Integer pituus) { //varaa laivalle tilaa alas, jos mahdollista

        if (numero + pituus > 10) {
            return false;
        }

        for (int i = 0; i < pituus; i++) {

            int nykyinenRivi = numero + i;

            if (onkoRuutuVarattu(sarake, nykyinenRivi)) {
                return false;
            }
        }

        for (int i = 0; i < pituus; i++) {

            int nykyinenRivi = numero + i;
            varaaRuutu(sarake, nykyinenRivi);
        }

        return true;
    }

    public boolean lisaaLaiva(Laiva laiva, String sarake, Integer rivi, String suunta) { //Lisää laivan pelaajan laivalistaan
        int sarakeInt = kirjaimet.indexOf(sarake);
        return lisaaLaiva(laiva, sarakeInt, rivi, suunta);
    }
    
    public boolean lisaaLaiva(Laiva laiva, Integer sarake, Integer rivi, String suunta){
        if (varaaTilaa(sarake, rivi, laiva.getPituus(), suunta)) {
            laiva.asetuLaudalle(sarake, rivi, suunta);
            pelaajanLaivat.add(laiva);
            return true;
        }
        return false;
    }

    public boolean viimeinenLaivaUpotettu() { //Jos pelaajan kaikki laivat on upotettu, peli päättyy
        
        for (int i = 0; i < pelaajanLaivat.size(); i++) {
            if (pelaajanLaivat.get(i).getElinvoima() > 0){
                return false;
            }
        }
        return true;
    }
    
    public boolean onkoRuutuunAmmuttu(Integer sarake, Integer rivi){
        
        return ammututRuudut[sarake][rivi];
    }
    
    public Laiva annaLaivaJokaOnRuudussa(Integer sarake, Integer rivi) {
        
        for (int i = 0; i < pelaajanLaivat.size(); i++) {
            
            Laiva laiva = pelaajanLaivat.get(i);
            if (laiva.onRuudussa(sarake, rivi)) {
                
                return laiva;
            }
        }
        
        return null;
    }
    
    public Integer ammuRuutuun(Integer sarake, Integer rivi){
        
        ammututRuudut[sarake][rivi]=true;
        for (int i = 0; i < pelaajanLaivat.size(); i++) {
            
            Laiva laiva = pelaajanLaivat.get(i);
            if (laiva.onRuudussa(sarake, rivi)) {
                laiva.osuma();
                
                if (laiva.getElinvoima()==0) {
                     return 2;
                }
                return 1;
            }
        }
        return 0;
    }
    public Integer ammuRuutuun(String sarake, Integer rivi){
        
        int indeksi = kirjaimet.indexOf(sarake);
        return ammuRuutuun(indeksi,rivi);
    }
    
    public Integer getListaSize(){
        
        return pelaajanLaivat.size();
    }
    

}
