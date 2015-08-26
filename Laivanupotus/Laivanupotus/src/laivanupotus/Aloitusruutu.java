
package laivanupotus;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class Aloitusruutu extends JPanel{
    
    public Aloitusruutu(final JFrame frame){
        JButton nappula = new JButton("Lol toimiiko xD");
        nappula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Toimii näemmä! Loistoo!");
            }
            
        });
        this.add(nappula);
        
    }
    
}
