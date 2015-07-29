
package laivanupotus;
public class Laivanupotus {

    public static void main(String[] args) {
        Vastustaja vastustaja = new Vastustaja();
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        
        vastustaja.Arpoja(); //Pelkkaa kertausta
        
        for (int i = vastustaja.KaytettavatRuudut.size(); i > 0; i--) {//hahmotelmaa. Kesken.
            vastustaja.TulostaKaytettavatRuudut(i);
        }
    }
    
}
