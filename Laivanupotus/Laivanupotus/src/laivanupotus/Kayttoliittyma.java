
package laivanupotus;
import java.util.Scanner;

public class Kayttoliittyma {
    
    Scanner lukija = new Scanner(System.in);
    
    public String KyseleSarake() {
        
        String valittavatKirjaimet = "ABCDEFGHIJ";
        System.out.print("Valitse sarake, välillä A-J: ");
        String valittuKirjain = lukija.nextLine();
        
        while (!(valittavatKirjaimet.contains(valittuKirjain))) {
            
            System.out.print("Valitsemasi kirjain ei ole pyydetyllä välillä tai se on kirjoitettu pienellä. Valitse uudestaan: ");
            valittuKirjain = lukija.nextLine();
            
        }
        
        return valittuKirjain;
        
    } 
    
    public Integer KyseleRivi() {
        
        System.out.print("Valitse rivi, välillä 1-10: ");
        int valittuNumero = Integer.parseInt(lukija.nextLine());
        
        while (valittuNumero<1 || valittuNumero>10) {
            
            System.out.print("Valitsemasi numero ei ole pyydetyllä välillä, koitetaas uudestaan: ");
            valittuNumero = Integer.parseInt(lukija.nextLine());
            
        }
        
        return valittuNumero;
        
    }
}
