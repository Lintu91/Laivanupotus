
package laivanupotus;

public class TaisteluLogiikka {
    
    private Pelaaja pelaaja;
    private int vuorojenMaara = 1;
    
    public TaisteluLogiikka(){
        
    }
    
    public boolean vuoronvaihto() { //Vaihtaa vuoron
        vuorojenMaara++;
        return false;
    }
    
    public boolean kaikkiLaivatUpotettu(Pelaaja pelaaja){ //kun pelaajan kaikki laivat on upotettu, peli päättyy
        
        if (pelaaja.getPelilauta().viimeinenLaivaUpotettu())
            return true;
        
        return false;
    }
    public Integer getVuorojenMaara(){
        return vuorojenMaara;
    }
}
