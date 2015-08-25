
package laivanupotus;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.WindowConstants;
public class GraafinenKayttoliittyma implements Runnable{

    private JFrame frame;
    
    @Override
    public void run() {
        frame = new JFrame("Kyllä me selvitään!");
        frame.setPreferredSize(new Dimension(1200,800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AloitusRuutu aloitus = new AloitusRuutu(frame);
        frame.getContentPane().add(aloitus);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
   
    
    
}
