
package laivanupotus;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelaaja {
    
    Laivat laiva = new Laivat();
    ArrayList PelaajanLaivat = new ArrayList();
    Scanner lukija = new Scanner(System.in);
    String nykyinenKirjain;
    int nykyinenNumero;
    
    public Pelaaja(){
        
    }
    
    public void AsetaLaiva(){ //Asettaa laivan haluttuun ruutuun
        
    }
    public void Upota(){ //Jaa'a, mitakojan tama tekee...
        
    }
    
    public void setKirjainJaNumero(String kirjain, Integer numero) {
        
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
        
    }
    
    public String getKirjain() {
        
        return nykyinenKirjain;
        
    }
    public Integer getNumero() {
        
        return nykyinenNumero;
        
    }
}
