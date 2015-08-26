
package laivanupotus;
import java.util.Scanner;

public class Logiikka {
    
    Scanner lukija = new Scanner(System.in);
    Graafinenkayttoliittyma kayttoliittyma = new Graafinenkayttoliittyma();
    int laivanPituus;
    Pelaaja pelaaja;
    
    public boolean kyseleSarake(Pelaaja pelaaja) { //Kysyy pelaajalta sarakkeen
        
        String valittavatKirjaimet = "ABCDEFGHIJ";
        
        String valittuKirjain = lukija.nextLine();
        
        valittuKirjain = valittuKirjain.toUpperCase();
        
        while (!valittavatKirjaimet.contains(valittuKirjain) || valittuKirjain.length() != 1) {
                        
            return false;
            
        }
        pelaaja.setKirjain(valittuKirjain);
        return true;
        
    } 
    
    public boolean kyseleRivi(Pelaaja pelaaja) { //Kysyy pelaajalta rivin
        int valittuNumero = Integer.MAX_VALUE;
        
        while (! (valittuNumero >= 0 && valittuNumero < 10 )) {
            
            
            
            try {
                valittuNumero = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ei ollut numero, kirjoita uudestaan");
                return false;
            }
        }
        pelaaja.setNumero(valittuNumero);
        return true;
    }
    
    public void kyseleNimi(Pelaaja pelaaja){
        String nimi = lukija.nextLine();
        
        pelaaja.setNimi(nimi);
    }
    
    
}
