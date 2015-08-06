
package laivanupotus;
import java.util.Scanner;

public class Peli {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    Scanner lukija = new Scanner(System.in);
    Pelilauta pelilauta1 = new Pelilauta();
    Pelilauta pelilauta2 =  new Pelilauta();
    
    String valittuKirjain;
    int valittuNumero;
    Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        
    public void AloitaPeli(){
            
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        System.out.println("Pelaaja, aseta laivasi ruudulle!");
        System.out.println("Asetetaan ensin pelin coolein alus, Lentotukialus!");
        valittuKirjain = kayttoliittyma.KyseleSarake();
        valittuNumero = kayttoliittyma.KyseleRivi();
        
        while (pelilauta1.onkoRuutuVarattu(valittuKirjain, valittuNumero)==true) { //nama siirtyvat varmaankin luokkaan Pelilauta
            
            System.out.println("Kyseinen ruutu on jo varattu, valitse uusiksi!");
            valittuKirjain = kayttoliittyma.KyseleSarake();
            valittuNumero = kayttoliittyma.KyseleRivi();
            
        }
        
        pelaaja1.setKirjainJaNumero(valittuKirjain, valittuNumero);
        System.out.println("Valitsit ruudun " + valittuKirjain + valittuNumero);
        System.out.println("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas");
        String suunta = lukija.nextLine();
        
        while (pelilauta1.varaaTilaa(pelaaja1.getKirjain(), pelaaja1.getNumero(), 4, suunta)==false){ //Tama myos on muuttamassa joskus
            
            System.out.println("Ei kelpaa, Valitse uusi suunta: ");
            suunta = lukija.nextLine();
            
        }
        
        
        System.out.println("Seuraavaksi asetetaan kaksi Risteilijää!");
        valittuKirjain = kayttoliittyma.KyseleSarake();
        valittuNumero = kayttoliittyma.KyseleRivi();
        
        System.out.println("Kolme Hävittäjää kiitos!");
        valittuKirjain = kayttoliittyma.KyseleSarake();
        valittuNumero = kayttoliittyma.KyseleRivi();
        
        System.out.println("Lopuksi asetetaan neljä Sukellusvenettä!");
        valittuKirjain = kayttoliittyma.KyseleSarake();
        valittuNumero = kayttoliittyma.KyseleRivi();
    }
}
