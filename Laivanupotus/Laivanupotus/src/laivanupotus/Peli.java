
package laivanupotus;
import java.util.Scanner;

public class Peli {
    private Pelaaja pelaaja = new Pelaaja();
    Scanner lukija = new Scanner(System.in);
    Pelilauta pelilauta = new Pelilauta();
    
    String valittuKirjain;
    int valittuNumero;
        
    public void AloitaPeli(){
            
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        System.out.println("Pelaaja, aseta laivasi ruudulle!");
        System.out.println("Asetetaan ensin pelin coolein alus, Lentotukialus!");
        valittuKirjain = pelaaja.KyseleSarake();
        valittuNumero = pelaaja.KyseleRivi();
        
        while (pelilauta.OnkoPelaajanRuutuVarattu(valittuKirjain, valittuNumero)==true) {
            System.out.println("Kyseinen ruutu on jo varattu, valitse uusiksi!");
            valittuKirjain = pelaaja.KyseleSarake();
            valittuNumero = pelaaja.KyseleRivi();
        }
        
        pelaaja.setKirjainJaNumero(valittuKirjain, valittuNumero);
        System.out.println("Valitsit ruudun " + valittuKirjain + valittuNumero);
        System.out.println("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas");
        String suunta = lukija.nextLine();
        pelilauta.VaraaTilaa(pelaaja, 4, suunta);
        
        System.out.println("Seuraavaksi asetetaan kaksi Risteilijää!");
        valittuKirjain = pelaaja.KyseleSarake();
        valittuNumero = pelaaja.KyseleRivi();
        
        System.out.println("Kolme Hävittäjää kiitos!");
        valittuKirjain = pelaaja.KyseleSarake();
        valittuNumero = pelaaja.KyseleRivi();
        
        System.out.println("Lopuksi asetetaan neljä Sukellusvenettä!");
        valittuKirjain = pelaaja.KyseleSarake();
        valittuNumero = pelaaja.KyseleRivi();
    }
}
