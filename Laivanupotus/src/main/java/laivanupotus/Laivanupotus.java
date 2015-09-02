
package laivanupotus;
import javax.swing.SwingUtilities;

public class Laivanupotus {
    
    public static void main(String[] args) {
        Logiikka logiikka = new Logiikka();
        Graafinenkayttoliittyma kayttis = new Graafinenkayttoliittyma(logiikka);
        SwingUtilities.invokeLater(kayttis);
        
        
    }
    
    
    
}
