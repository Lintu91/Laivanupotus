
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
    String nimi;
    
    public Pelaaja(){
        
    }
    
    public void Upota(){ //Jaa'a, mitakojan tama tekee...
        
    }
    
    public void kysyNimi(){
       this.nimi = lukija.nextLine();
    }
    
    public void setKirjainJaNumero(String kirjain, Integer numero) {
        
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
        
    }
    public String annaNimi(){
        return nimi;
    }
    
    public String getKirjain() {
        
        return nykyinenKirjain;
        
    }
    public Integer getNumero() {
        
        return nykyinenNumero;
        
    }
}
