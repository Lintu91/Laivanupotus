
package laivanupotus;
import java.util.Scanner;

public class Pelaaja {
    
    Scanner lukija = new Scanner(System.in);
    String nykyinenKirjain;
    int nykyinenNumero;
    String nimi;
    int status = 10;
    Pelilauta pelilauta = new Pelilauta();
    
    public Pelaaja(){
    }

    public void setKirjainJaNumero(String kirjain, Integer numero) { //Asettaa pelaajan valitseman kirjaimen ja numeron,
                                                                      // eli sarakkeen ja rivin  
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
    }
    public void setKirjain(String kirjain){
        nykyinenKirjain = kirjain;
    }
    public void setNumero(Integer numero){
        nykyinenNumero=numero;
    }
  
    public String getKirjain() { //Palauttaa pelaajan valitseman kirjaimen, eli sarakkeen
        
        return nykyinenKirjain;
        
    }
    public Integer getNumero() { //Palauttaa pelaajan valitseman numeron, eli rivin
        
        return nykyinenNumero;
        
    }
    public void setNimi(String asetettuNimi){ //Asettaa pelaajalle nimen
        
        nimi=asetettuNimi;
    }
    public String getNimi(){ //Palauttaa pelaajan nimen
        return nimi;
    }
    
    public Pelilauta getPelilauta(){
        
        return pelilauta;
    }
    public Integer laivojaJaljella(){
        return status;
    }
    
    public void vahennaLaiva(){
        status--;
    }
    
}
