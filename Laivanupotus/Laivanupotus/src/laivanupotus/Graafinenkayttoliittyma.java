
package laivanupotus;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Graafinenkayttoliittyma implements Runnable{

    private JFrame frame;
    
    private Logiikka logiikka;
    
    public Graafinenkayttoliittyma(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Kyllä me selvitään!");
        frame.setPreferredSize(new Dimension(1200,800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1,2));
        Aloitusruutu aloitus = new Aloitusruutu(frame);
        frame.getContentPane().add(aloitus);
        Karttanakyma kartta = new Karttanakyma(logiikka);
        kartta.rakennaKarttaLaivanAsetus();
        frame.getContentPane().add(kartta);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
   
    
    
}
