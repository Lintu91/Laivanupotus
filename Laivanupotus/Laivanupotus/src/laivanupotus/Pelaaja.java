
package laivanupotus;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelaaja {
    
    Laivat laiva = new Laivat();
    ArrayList PelaajanLaivat = new ArrayList();
    Scanner lukija = new Scanner(System.in);
    String nykyinenKirjain;
    int nykyinenNumero;
    
    public Pelaaja(){
        
    }
    
    public void AsetaLaiva(){ //Asettaa laivan haluttuun ruutuun
        
    }
    public void Upota(){ //Jaa'a, mitakojan tama tekee...
        
    }
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
    public void setKirjainJaNumero(String kirjain, Integer numero) {
        
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
        
    }
    
    public String getKirjain() {
        
        return nykyinenKirjain;
        
    }
    public Integer getNumero() {
        
        return nykyinenNumero;
        
    }
}
