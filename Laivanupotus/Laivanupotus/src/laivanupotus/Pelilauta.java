
package laivanupotus;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelilauta {
    
    HashMap pelaajanKayttamatRuudut = new HashMap<String, ArrayList<Integer>>();
    boolean onkoVarattu;
    
    public boolean OnkoPelaajanRuutuVarattu(String sarake, Integer rivi) {
        
        if (pelaajanKayttamatRuudut.containsKey(sarake)){
            
            if (pelaajanKayttamatRuudut.get(sarake)==rivi){
                
                return true;
            }
        }
        pelaajanKayttamatRuudut.put(rivi, sarake);
        
        return false;
    }
    
     public void VaraaTilaa(Pelaaja pelaaja, Integer ruutumaara, String suunta) {
         
         String kirjaimet = "ABCDEFGHIJKL";
         String kirjain = pelaaja.getKirjain();
         int numero = pelaaja.getNumero();
         
         if (suunta.equals("V")) {
             
             for (int i = ruutumaara-1; i >= 0; i--) {
                 
             }    
         }
         
         if (suunta.equals("O")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
         }
         
         if (suunta.equals("Y")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
             
         }
         
         if (suunta.equals("A")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
             
         }
     }
}
