
package laivanupotus;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Karttanakyma extends JPanel {
    private JButton[][] taulukko = new JButton[10][10];
    private String[] suuntavaihtoehdot = {"Vasen", "Oikea", "Alas" , "Ylös"};
    Graafinenkayttoliittyma gLiittyma;
    Logiikka logiikka;
    JFrame frame;
    
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
    
    public void ekaVuoro(){
        rakennaKarttaLaivanAsetus();
        
        JOptionPane.showMessageDialog(this, "Sinun vuorosi, " + logiikka.annaPelaaja().getNimi());
    }
    public void rakennaKarttaAmpuminen(){
        putsaaKartta();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                final JButton nappi = taulukko[j][i];
                final int sarake = j;
                final int rivi = i;
                final Pelilauta lauta = logiikka.annaVastustaja().getPelilauta();
                
                if (lauta.onkoRuutuunAmmuttu(sarake, rivi)){
                    
                    if (lauta.onkoRuutuVarattu(sarake, rivi)){
                        
                        Laiva l = lauta.annaLaivaJokaOnRuudussa(sarake, rivi);
                        
                        if(l != null && l.getElinvoima() == 0) {
                            
                            nappi.setText("Z");
                        }
                        else {
                            nappi.setText("O");
                        }
                    } else {
                        nappi.setText("X");
                    }
                    
                } else {
                    ampumisnappi(nappi, lauta, sarake, rivi);
                }
            }
        }
    }
    
    private void putsaaKartta() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                final JButton nappi = taulukko[j][i];
                putsaaNappi(nappi);
            }
        }
    }
    private void putsaaNappi(JButton nappi) {
        nappi.setText("");
        for(ActionListener al : nappi.getActionListeners()) {
            nappi.removeActionListener(al);
        }
    }
    
    private void ampumisnappi(JButton nappi, final Pelilauta lauta, final Integer sarake, final Integer rivi){
        final Karttanakyma kartta = this;
                    nappi.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int tapahtuma = lauta.ammuRuutuun(sarake, rivi);
                            
                            if (tapahtuma==0){
                                gLiittyma.paivitaInforuutu(logiikka.annaPelaaja().getNimi() + ": Huti! Lol! N00b!");
                            }
                            else if (tapahtuma == 1){
                                gLiittyma.paivitaInforuutu(logiikka.annaPelaaja().getNimi() + ": Osuma!");
                            } else {
                                gLiittyma.paivitaInforuutu(logiikka.annaPelaaja().getNimi() + ": Osui ja upposi!");
                            }
                                                      
                            if (logiikka.annaTaisteluLogiikka().kaikkiLaivatUpotettu(logiikka.annaVastustaja())){
                                JOptionPane.showMessageDialog(kartta,logiikka.annaPelaaja().getNimi() + ", voitit pelin");
                                System.exit(0);
                            }
                            
                            vuoronvaihto();
                            rakennaKarttaAmpuminen();
                        }

                    });
    }
    public void vuoronvaihto() {
        logiikka.vuoronvaihto();
        putsaaKartta();
        JOptionPane.showMessageDialog(this, "Sinun vuorosi, " + logiikka.annaPelaaja().getNimi());
    }
    
    public void rakennaKarttaLaivanAsetus(){
        putsaaKartta();
        
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                
                final JButton nappi = taulukko[j][i];
                final int sarake = j;
                final int rivi = i;
                
                Pelilauta lauta = logiikka.annaPelaaja().getPelilauta();
                
                if(lauta.onkoRuutuVarattu(j, i)) {
                    nappi.setText("O");
                }
                else {
                    nappi.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            asetaLaiva(nappi, sarake, rivi);
                        }

                    });
                }
            }
        }
    }
    
    public String kysySuunta() {
        String suunta = (String)JOptionPane.showInputDialog(this, "Valitse suunta", "Suunnan valinta", JOptionPane.PLAIN_MESSAGE, null, suuntavaihtoehdot, null);
        if (suunta!=null){
            if (suunta.equals("Vasen")){
                return "V";
            } else if (suunta.equals("Oikea")) {
                return "O";
            } else if (suunta.equals("Ylös")) {
                return "Y";
            } else if (suunta.equals("Alas")){
                return "A";
            }
        }
        return null;
    }
    public void toiminnanSeuraus(){
        
    }
    
    private Laiva nykyinenLaiva = null;
    public void asetaLaiva(JButton nappi, int sarake, int rivi){
        if(nykyinenLaiva == null) {
            nykyinenLaiva = logiikka.annaLaivanasetusLogiikka().annaLaiva();
        }
        
        String suunta = "V";
        if(nykyinenLaiva.getPituus() > 1) {
            suunta = kysySuunta();
        }
        
        if(suunta == null) {
            return;
        }
        
        if(logiikka.annaPelaaja().getPelilauta().lisaaLaiva(nykyinenLaiva, sarake, rivi, suunta)) {
            nykyinenLaiva = null;
            if(logiikka.annaLaivanasetusLogiikka().kaikkiLaivatLaitettu()) {
                vuoronvaihto();
            }
        }
        
        if (logiikka.annaStatus()==0){
            rakennaKarttaLaivanAsetus();
        } else {
            rakennaKarttaAmpuminen();
        }
        
    }
    
}
