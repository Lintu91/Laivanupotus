
package laivanupotus;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class Graafinenkayttoliittyma implements Runnable{

    private JFrame frame;
    
    private Logiikka logiikka;
    private JTextArea tekstikentta;
    
    private Aloitusruutu aloitus;
    private Karttanakyma kartta;
    
    public Graafinenkayttoliittyma(Logiikka logiikka) {
        this.logiikka = logiikka;
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(1200,800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1,2));
        aloitus = new Aloitusruutu(frame, this, logiikka);
        frame.getContentPane().add(aloitus);
        kartta = new Karttanakyma(logiikka, this);
        frame.getContentPane().add(kartta);
        frame.pack();
        frame.setVisible(true);
        tekstikentta = new JTextArea();
        aloitus.add(tekstikentta);
    }
    
    public void aloitaPeli() {
        aloitus.aloita();
        kartta.ekaVuoro();
    }
    
    public void paivitaInforuutu(String viesti){
        String vanhaViesti = tekstikentta.getText();
        tekstikentta.setText("Vuoro " + logiikka.annaTaisteluLogiikka().getVuorojenMaara() + ": " + viesti + "\n");
        tekstikentta.append(vanhaViesti);
    }
    
    
    
   
    
    
}
