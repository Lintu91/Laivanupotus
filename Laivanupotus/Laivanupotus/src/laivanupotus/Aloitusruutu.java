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
    
    public Aloitusruutu(final JFrame frame){
        this.setLayout(new BorderLayout());
        JButton nappula = new JButton("Lol toimiiko xD");
        JTextArea tekstialue = new JTextArea(1,20);
        tekstialue.setEditable(true);        
        nappula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Toimii näemmä! Loistoo!");
                
            }
            
        });
        
        JPanel panel = new JPanel();
        panel.add(nappula);
        panel.add(tekstialue);
        this.add(panel, BorderLayout.SOUTH);
        
    }
    
}
