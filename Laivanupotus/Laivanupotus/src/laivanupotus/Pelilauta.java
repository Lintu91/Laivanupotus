
package laivanupotus;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelilauta {
    boolean[][] ruudut = new boolean[10][10];
    
    public boolean onkoRuutuVarattu(String sarake, Integer rivi) { 
        
        String kirjaimet = "ABCDEFGHIJ";
        int indeksi = kirjaimet.indexOf(sarake);
        return ruudut[rivi][indeksi];
        
    }
    
    public boolean onkoRuutuVapaa(Integer sarake, Integer rivi){
        
        return ruudut[rivi][sarake];
        
    }
    
    public void varaaRuutu(int sarake, int rivi) {
        
        ruudut[rivi][sarake] = true;
        
    }
    
     public boolean varaaTilaa(String kirjain, int numero, Integer ruutumaara, String suunta) {
         
         String kirjaimet = "ABCDEFGHIJKL";
         int sarake = kirjaimet.indexOf(kirjain);
         
         if (suunta.equals("V")) {
             if (sarake - ruutumaara < 0) {
                 return false;
             }
             
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenSarake = sarake-i;
                 
                 if (onkoRuutuVapaa(nykyinenSarake, numero)){
                     return false;
                 }
             }
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenSarake = sarake-i;
                 varaaRuutu(nykyinenSarake, numero);
             }
         }
         
         else if (suunta.equals("O")) {
             if (sarake + ruutumaara > 10) {
                 
                 return false;
                 
             }
             for (int i = 0; i < ruutumaara; i++) {
                 int nykyinenSarake=sarake+1;
                 if (onkoRuutuVapaa(nykyinenSarake, numero)){
                     return false;
                 }
                 
             }
             for (int i = 0; i < ruutumaara; i++) {
                 int nykyinenSarake = sarake + i;
                 varaaRuutu(nykyinenSarake,numero);
             }
             
         }
         else if (suunta.equals("Y")) {
             
             if (numero - ruutumaara < 0) {
                 return false;
             }
             
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenRivi = numero-i;
                 
                 if (onkoRuutuVapaa(nykyinenRivi, numero)){
                     return false;
                 }
             }
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenRivi = sarake-i;
                 varaaRuutu(nykyinenRivi, numero);
             }
             
         }
         
         else if (suunta.equals("A")) {
             
             if (numero + ruutumaara > 10) {
                 return false;
             }
             
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenRivi = numero+i;
                 
                 if (onkoRuutuVapaa(nykyinenRivi, numero)){
                     return false;
                 }
             }
             for (int i = 0; i < ruutumaara; i++) {
                 
                 int nykyinenRivi = numero+i;
                 varaaRuutu(nykyinenRivi, numero);
             }
             
         }
         else{
             
             return false;
         }
                 
         return true;
     }
}
