
package laivanupotus;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelaaja {
    
    Laivat laiva = new Laivat();
    ArrayList pelaajanLaivat = new ArrayList();
    Scanner lukija = new Scanner(System.in);
    String nykyinenKirjain;
    int nykyinenNumero;
    String nimi;
    
    public Pelaaja(){
    }

    public void setKirjainJaNumero(String kirjain, Integer numero) { //Asettaa pelaajan valitseman kirjaimen ja numeron,
                                                                      // eli sarakkeen ja rivin  
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
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
    
    public void lisaaLaiva(Laivat laiva){ //Lisää laivan pelaajan laivalistaan
        
       pelaajanLaivat.add(laiva);
    }
    
    public void upotaLaiva(Laivat laiva){ //Poistaa laivan pelaajan laivalistasta
        
        pelaajanLaivat.remove(laiva);
    }
    
    public boolean viimeinenLaivaUpotettu(){ //Jos pelaajan kaikki laivat on upotettu, peli päättyy
        
        if (pelaajanLaivat.isEmpty()){
            
            return true;
        }
        
        return false;
    }
    
}
