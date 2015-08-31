package laivanupotus;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.TextArea;
import java.awt.TextComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Aloitusruutu extends JPanel{
    private Logiikka logiikka;
    
    public Aloitusruutu(final JFrame frame,final Graafinenkayttoliittyma kayttis, Logiikka logiikka){
        this.logiikka = logiikka;
        
        this.setLayout(new BorderLayout());
        JButton nappula = new JButton("Exit");      
        JButton helppi = new JButton("Help");
        JButton aloitus = new JButton("Aloita Peli!");
        nappula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Ei", "Kyllä" };
                int valinta = JOptionPane.showOptionDialog(null, "Oletko varma että haluat lopettaa pelin?", "Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null,options, options[0]);
                
                if (valinta == 1){
                    System.exit(0);
                }
                
            }
            
        });
        
        helppi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Pelaa niinkun laivanupotusta pelataan. Lol nobo. Kyl sä osaat. I trust you.\n");
            }
            
        });
        aloitus.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                kayttis.aloitaPeli();
            }
            
        });
        JPanel panel = new JPanel();
        panel.add(nappula);
        panel.add(helppi);
        panel.add(aloitus);
        this.add(panel, BorderLayout.SOUTH);
        
    }
    private int moneskoPelaaja = 1;
    public void kysyPelaajienNimet(Pelaaja pelaaja){
        String nimi = JOptionPane.showInputDialog("Pelaaja " + moneskoPelaaja + ", kerro nimesi:");
        moneskoPelaaja++;
        pelaaja.setNimi(nimi);
    }
    
    public void aloita() {
        kysyPelaajienNimet(logiikka.pelaaja1);
        kysyPelaajienNimet(logiikka.pelaaja2);
    }
}
