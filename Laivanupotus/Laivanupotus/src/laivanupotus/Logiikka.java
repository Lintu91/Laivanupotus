
package laivanupotus;
import java.util.Scanner;

public class Logiikka {
    
    Scanner lukija = new Scanner(System.in);
    GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma();
    int laivanPituus;
    
    public String kyseleSarake() { //Kysyy pelaajalta sarakkeen
        
        String valittavatKirjaimet = "ABCDEFGHIJ";
        System.out.print("Valitse sarake, välillä A-J: ");
        String valittuKirjain = lukija.nextLine();
        
        valittuKirjain = valittuKirjain.toUpperCase();
        
        while (!valittavatKirjaimet.contains(valittuKirjain) || valittuKirjain.length() != 1) {
            
            System.out.print("Valitsemasi kirjain ei ole pyydetyllä välillä. Valitse uudestaan: ");
            valittuKirjain = lukija.nextLine();
            
        }
        return valittuKirjain;
        
    } 
    
    public Integer kyseleRivi() { //Kysyy pelaajalta rivin
        int valittuNumero = Integer.MAX_VALUE;
        
        while (! (valittuNumero >= 0 && valittuNumero < 10 )) {
            
            System.out.print("Valitse rivi, välillä 0-9: ");
            
            try {
                valittuNumero = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ei ollut numero, kirjoita uudestaan");
            }
        }
        
        return valittuNumero;
    }
    
    public void kyseleNimi(Pelaaja pelaaja){
        String nimi = lukija.nextLine();
        
        pelaaja.setNimi(nimi);
    }
    
    
}
