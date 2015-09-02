
package laivanupotus;

public class LaivanasetusLogiikka {
    private boolean vuorovaihdettu=false;
    private int laivaNyt = 4;
    private int laivojaLaitettavaksi = 1;
    
    public boolean vuoronvaihto(){ //Antaa luvan vuoronvaihdolle
        
        laivaNyt = 4;
        laivojaLaitettavaksi = 1;
        if (vuorovaihdettu){
            return true;
        } else {
            vuorovaihdettu=true;
            return false;
        }
    }
    public boolean kaikkiLaivatLaitettu() { //Ilmoittaa onko pelaajalla vielä asetettavia laivoja
        
        return laivaNyt == 0;
    }
    
    public Laiva annaLaiva(){ //antaa nykyisen laivan
        Laiva laiva = null;
        
        if(laivaNyt == 4) {
            laiva = new Laiva(4, "Lentotukialus");
        }
        else if(laivaNyt == 3) {
            laiva = new Laiva(3, "Risteilijä");
        }
        else if(laivaNyt == 2) {
            laiva = new Laiva(2, "Hävittäjä");
        }
        else {
            laiva = new Laiva(1, "Sukellusvene");
        }
        laivojaLaitettavaksi--;
        
        if(laivojaLaitettavaksi == 0) {
            laivaNyt--;
            laivojaLaitettavaksi = 5 - laivaNyt;
        }
        
        return laiva;
    }
}
