
package laivanupotus;
import java.util.Scanner;

public class Logiikka {
    
    Pelaaja pelaaja1 = new Pelaaja();
    Pelaaja pelaaja2 = new Pelaaja();
    Pelaaja vastustaja = null;
    Pelaaja pelaaja = null;
    int status = 0;
    
    private LaivanasetusLogiikka llogiikka = new LaivanasetusLogiikka();
    private TaisteluLogiikka tlogiikka = new TaisteluLogiikka();
    
    public LaivanasetusLogiikka annaLaivanasetusLogiikka(){
        return llogiikka;
    }
    
    public TaisteluLogiikka annaTaisteluLogiikka(){
        return tlogiikka;
    }
    public int annaStatus(){
        return status;
    }
    
    public Logiikka() {
        vastustaja = pelaaja2;
        pelaaja = pelaaja1;
    }
    
    public void vuoronvaihto(){
        
        
        if (pelaaja == pelaaja1){
            vastustaja= pelaaja1;
            pelaaja = pelaaja2;
        } else {
            vastustaja = pelaaja2;
            pelaaja = pelaaja1;
        }
        
        if(status == 0) {
            if (llogiikka.vuoronvaihto()){
                status=1;
            }
        }
        else {
            if(tlogiikka.vuoronvaihto()) {
                status = 2;
            }
        }
    }
    public Pelaaja annaPelaaja(){
        return pelaaja;
    }
    
    public Pelaaja annaVastustaja(){
        return vastustaja;
    }
    
    public void siirryPeliin(){
        status = 1;
    }
    
    
}
