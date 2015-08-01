
package laivanupotus;
import java.util.HashMap;

public class Pelilauta {
    
    static HashMap pelaajanKayttamatRuudut = new HashMap<String, Integer>();
    static boolean onkoVarattu;
    
    public static boolean OnkoPelaajanRuutuVarattu(String sarake, Integer rivi) {
        
        if (pelaajanKayttamatRuudut.containsKey(sarake)){
            
            if (pelaajanKayttamatRuudut.get(sarake)==rivi){
                
                return true;
            }
        }
        pelaajanKayttamatRuudut.put(rivi, sarake);
        
        return false;
    }
    
     public static void VaraaTilaa(Integer ruutumaara, String suunta) {
         
         String kirjain = Laivanupotus.getKirjain();
         int numero = Laivanupotus.getNumero();
         
         if (suunta.equals("V")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
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
         
         if (suunta.equals("V")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
             
         }
     }
}
