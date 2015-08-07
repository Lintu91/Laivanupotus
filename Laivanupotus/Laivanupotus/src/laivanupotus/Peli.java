
package laivanupotus;
import java.util.Scanner;

public class Peli {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    Scanner lukija = new Scanner(System.in);
    Pelilauta pelilauta1 = new Pelilauta();
    Pelilauta pelilauta2 =  new Pelilauta();
    
    String valittuKirjain;
    int valittuNumero = 0;
    Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        
    public void AloitaPeli(){
        
        pelaaja1 = new Pelaaja();    
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        System.out.println("Pelaaja, aseta laivasi ruudulle!");
        System.out.println("Asetetaan ensin pelin coolein alus, Lentotukialus!");
        valittuKirjain = kayttoliittyma.kyseleSarake();
        valittuNumero = kayttoliittyma.kyseleRivi();
        
        pelaaja1.setKirjainJaNumero(valittuKirjain, valittuNumero);  
        System.out.println("Valitsit ruudun " + pelaaja1.getKirjain() + pelaaja1.getNumero());
        System.out.println("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas");
        String suunta = lukija.nextLine();
        
        while (pelilauta1.varaaTilaa(pelaaja1.getKirjain(), pelaaja1.getNumero(), 4, suunta)==false){ //Tama on muuttamassa joskus
            
            System.out.print("Ei kelpaa, Valitse uusi suunta: ");
            suunta = lukija.nextLine();     
        }
       
        System.out.println("Seuraavaksi asetetaan kaksi Risteilijää!");
        valittuKirjain = kayttoliittyma.kyseleSarake();
        valittuNumero = kayttoliittyma.kyseleRivi();
        while (pelilauta1.onkoRuutuVarattu(valittuKirjain, valittuNumero)==false){
            System.out.print("Ruutu on varattu, valitse uusi ruutu: ");
            valittuKirjain = kayttoliittyma.kyseleSarake();
            valittuNumero = kayttoliittyma.kyseleRivi();
        }
        
        
        System.out.println("Kolme Hävittäjää kiitos!");
        valittuKirjain = kayttoliittyma.kyseleSarake();
        valittuNumero = kayttoliittyma.kyseleRivi();
        
        System.out.println("Lopuksi asetetaan neljä Sukellusvenettä!");
        valittuKirjain = kayttoliittyma.kyseleSarake();
        valittuNumero = kayttoliittyma.kyseleRivi();
    }
}
