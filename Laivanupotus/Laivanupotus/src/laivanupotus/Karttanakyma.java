
package laivanupotus;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Karttanakyma extends JPanel {
    private JButton[][] taulukko = new JButton[10][10];
    private String[] suuntavaihtoehdot = {"V", "O", "A" , "Y"};
    Graafinenkayttoliittyma gLiittyma;
    Logiikka logiikka;
    
    public Karttanakyma(Logiikka logiikka, Graafinenkayttoliittyma gLiittyma){
        this.logiikka = logiikka;
        this.gLiittyma = gLiittyma;
        
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
                    JButton nappi = new JButton("");
                    this.add(nappi);
                    taulukko[j-1][i-1] = nappi;
                }
            }
        }
    }
    public void rakennaKarttaAmpuminen(){
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                final JButton nappi = taulukko[j][i];
                final int sarake = j;
                final int rivi = i;
                nappi.setText("");
                for(ActionListener al : nappi.getActionListeners()) {
                    nappi.removeActionListener(al);
                }
                final Pelilauta lauta = logiikka.annaVastustaja().getPelilauta();
                if (lauta.onkoRuutuunAmmuttu(sarake, rivi)){
                    if (lauta.onkoRuutuVarattu(sarake, rivi)){
                        nappi.setText("O");
                    } else {
                        nappi.setText("X");
                    }
                    
                } else {
                    nappi.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            lauta.ammuRuutuun(sarake, rivi);
                            for (int k = 0; k < 10; k++) {
                                for (int l = 0; l < 10; l++) {
                                    if (lauta.onkoRuutuVarattu(k, l)){
                                        taulukko[k][l].setText("O");
                                    } else {
                                        taulukko[k][l].setText("X");
                                    }
                                }
                            }
                            logiikka.vuoronvaihto();
                            rakennaKarttaAmpuminen();
                        }

                    });
                }
            }
        }
    }
    
    public void rakennaKarttaLaivanAsetus(){
        
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                
                final JButton nappi = taulukko[j][i];
                final int sarake = j;
                final int rivi = i;
                nappi.setText("");
                for(ActionListener al : nappi.getActionListeners()) {
                    nappi.removeActionListener(al);
                }
                
                Pelilauta lauta = logiikka.annaPelaaja().getPelilauta();
                
                if(lauta.onkoRuutuVarattu(j, i)) {
                    nappi.setText("O");
                }
                else {
                    nappi.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String suunta = kysySuunta();
                            if(suunta != null) {
                                asetaLaiva(nappi, sarake, rivi, suunta);
                            }
                        }

                    });
                }
            }
        }
    }
    
    public String kysySuunta() {
        String suunta = (String)JOptionPane.showInputDialog(this, "Valitse suunta", "Suunnan valinta", JOptionPane.PLAIN_MESSAGE, null, suuntavaihtoehdot, null);
        return suunta;
    }
    
    private Laiva nykyinenLaiva = null;
    public void asetaLaiva(JButton nappi, int sarake, int rivi, String suunta){
        if(nykyinenLaiva == null) {
            nykyinenLaiva = logiikka.annaLaivanasetusLogiikka().annaLaiva();
        }
        
        if(logiikka.annaPelaaja().getPelilauta().lisaaLaiva(nykyinenLaiva, sarake, rivi, suunta)) {
            nykyinenLaiva = null;
            if(logiikka.annaLaivanasetusLogiikka().kaikkiLaivatLaitettu()) {
                logiikka.vuoronvaihto();
            }
        }
        
        if (logiikka.annaStatus()==0){
            rakennaKarttaLaivanAsetus();
        } else {
            rakennaKarttaAmpuminen();
        }
        
    }
    
}
