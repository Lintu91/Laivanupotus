
package laivanupotus;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Karttanakyma extends JPanel {
    
    public Karttanakyma(){
        this.setLayout(new GridLayout(11,11));
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i == 0 && j == 0) {
                    this.add(new JLabel(""));
                }
                else if (i==0 && j>0){
                    String kirjaimet = "ABCDEFGHIJ";
                    char kirjain = kirjaimet.charAt(j-1);
                    this.add(new JLabel(kirjain + ""));
                }
                else if (j==0 && i> 0){
                    this.add(new JLabel((i-1) + ""));
                } else {
                    this.add(new JButton("xD"));
                }
            }
        }
    }
    
}
