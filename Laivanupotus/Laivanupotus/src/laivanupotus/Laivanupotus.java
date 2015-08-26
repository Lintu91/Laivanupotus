
package laivanupotus;
import javax.swing.SwingUtilities;

public class Laivanupotus {
    
    public static void main(String[] args) {
        Peli peli = new Peli();
        Graafinenkayttoliittyma kayttis = new Graafinenkayttoliittyma();
        SwingUtilities.invokeLater(kayttis);
        peli.AloitaPeli();  //Let the game begin!
        
        
    }
    
    
    
}
