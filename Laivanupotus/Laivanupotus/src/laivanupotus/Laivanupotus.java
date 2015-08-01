
package laivanupotus;
import java.util.Scanner;
import java.util.HashMap;

public class Laivanupotus {
    
    static Scanner lukija = new Scanner(System.in);
    static String nykyinenKirjain;
    static int nykyinenNumero;
    
    public static void main(String[] args) {
        
        Vastustaja vastustaja = new Vastustaja();
        String valittuKirjain;
        int valittuNumero;
        
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        System.out.println("Pelaaja, aseta laivasi ruudulle!");
        System.out.println("Asetetaan ensin pelin coolein alus, Lentotukialus!");
        valittuKirjain = KyseleSarake();
        valittuNumero = KyseleRivi();
        
        while (Pelilauta.OnkoPelaajanRuutuVarattu(valittuKirjain, valittuNumero)==true) {
            System.out.println("Kyseinen ruutu on jo varattu, valitse uusiksi!");
            valittuKirjain = KyseleSarake();
            valittuNumero = KyseleRivi();
        }
        
        setKirjainJaNumero(valittuKirjain, valittuNumero);
        System.out.println("Valitsit ruudun " + valittuKirjain + valittuNumero);
        System.out.println("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas");
        String suunta = lukija.nextLine();
        Pelilauta.VaraaTilaa(4, suunta);
        
        System.out.println("Seuraavaksi asetetaan kaksi Risteilijää!");
        valittuKirjain = KyseleSarake();
        valittuNumero = KyseleRivi();
        
        System.out.println("Kolme Hävittäjää kiitos!");
        valittuKirjain = KyseleSarake();
        valittuNumero = KyseleRivi();
        
        System.out.println("Lopuksi asetetaan neljä Sukellusvenettä!");
        valittuKirjain = KyseleSarake();
        valittuNumero = KyseleRivi();
        
    }
    
    public static String KyseleSarake() {
        
        String valittavatKirjaimet = "ABCDEFGHIJ";
        System.out.print("Valitse sarake, välillä A-J: ");
        String valittuKirjain = lukija.nextLine();
        
        while (!(valittavatKirjaimet.contains(valittuKirjain))) {
            
            System.out.print("Valitsemasi kirjain ei ole pyydetyllä välillä tai se on kirjoitettu pienellä. Valitse uudestaan: ");
            valittuKirjain = lukija.nextLine();
            
        }
        
        return valittuKirjain;
        
    } 
    
    public static Integer KyseleRivi() {
        
        System.out.print("Valitse rivi, välillä 1-10: ");
        int valittuNumero = Integer.parseInt(lukija.nextLine());
        
        while (valittuNumero<1 || valittuNumero>10) {
            
            System.out.print("Valitsemasi numero ei ole pyydetyllä välillä, koitetaas uudestaan: ");
            valittuNumero = Integer.parseInt(lukija.nextLine());
            
        }
        
        return valittuNumero;
        
    }
    public static void setKirjainJaNumero(String kirjain, Integer numero) {
        
        nykyinenKirjain = kirjain;
        nykyinenNumero = numero;
        
    }
    
    public static String getKirjain() {
        
        return nykyinenKirjain;
        
    }
    public static Integer getNumero() {
        
        return nykyinenNumero;
        
    }
    
}
