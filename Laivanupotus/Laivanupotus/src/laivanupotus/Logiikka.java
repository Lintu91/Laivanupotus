
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
        
        while (!(valittavatKirjaimet.contains(valittuKirjain))) {
            
            System.out.print("Valitsemasi kirjain ei ole pyydetyllä välillä tai se on kirjoitettu pienellä. Valitse uudestaan: ");
            valittuKirjain = lukija.nextLine();
            
        }
        return valittuKirjain;
        
    } 
    
    public Integer kyseleRivi() { //Kysyy pelaajalta rivin
        
        System.out.print("Valitse rivi, välillä 0-9: ");
        int valittuNumero = Integer.parseInt(lukija.nextLine());
        
        while (! (valittuNumero >= 0 && valittuNumero < 10) ) {
            
            System.out.print("Valitsemasi numero ei ole pyydetyllä välillä, koitetaas uudestaan: ");
            valittuNumero = Integer.parseInt(lukija.nextLine());           
        }
        
        return valittuNumero;
        
    }
    
    public void kyseleNimi(Pelaaja pelaaja){
        String nimi = lukija.nextLine();
        
        pelaaja.setNimi(nimi);
    }
    
    
}
