
package laivanupotus;

public class TaisteluLogiikka {
    
    private Pelaaja pelaaja;
    private int vuorojenMaara = 1;
    
    public TaisteluLogiikka(){
        
    }
    
    public boolean vuoronvaihto() {
        vuorojenMaara++;
        return false;
    }
    
    public boolean kaikkiLaivatUpotettu(Pelaaja pelaaja){
        
        if (pelaaja.getPelilauta().viimeinenLaivaUpotettu())
            return true;
        
        return false;
    }
    public Integer getVuorojenMaara(){
        return vuorojenMaara;
    }
}
