
package laivanupotus;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelilauta {
    boolean[][] ruudut = new boolean[10][10];
    
    public boolean OnkoRuutuVarattu(String sarake, Integer rivi) {
        String kirjaimet = "ABCDEFGHIJKL";
        int indeksi = kirjaimet.indexOf(sarake);
        return ruudut[rivi][indeksi];
    }
    public boolean OnkoRuutuVarattu(Integer sarake, Integer rivi){
        return ruudut[rivi] [sarake];
    }
    
    public void VaraaRuutu(int sarake, int rivi) {
        ruudut[rivi][sarake] = true;
    }
    
     public boolean VaraaTilaa(String kirjain, int numero, Integer ruutumaara, String suunta) {
         
         String kirjaimet = "ABCDEFGHIJKL";
         int sarake = kirjaimet.indexOf(kirjain);
         
         if (suunta.equals("V")) {
             if (sarake - ruutumaara < 0) {
                 return false;
             }
             
             for (int i = 0; i < ruutumaara-1; i++) {
                 
                 int nykyinenSarake = sarake-i;
                 
                 if (OnkoRuutuVarattu(nykyinenSarake, numero)){
                     return false;
                 }
             }
             for (int i = 0; i < ruutumaara-1; i++) {
                 
                 int nykyinenSarake = sarake-i;
                 VaraaRuutu(nykyinenSarake, numero);
             }
         }
         
         else if (suunta.equals("O")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
         }
         
         else if (suunta.equals("Y")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
             
         }
         
         else if (suunta.equals("A")) {
             
             for (int i = 0; i < ruutumaara; i++) {
                 
             }
             
         }
         else{
             return false;
         }
                 
         return true;
     }
}
