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
    private final Logiikka logiikka;
    
    public Aloitusruutu(final JFrame frame,final Graafinenkayttoliittyma kayttis, final Logiikka logiikka){
        this.logiikka = logiikka;
        
        this.setLayout(new BorderLayout());
        JButton nappula = new JButton("Exit");      
        JButton helppi = new JButton("Help");
        JButton aloitus = new JButton("Aloita Peli!");
        
        nappula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Ei", "Kyllä" };
                int lopetus = JOptionPane.showOptionDialog(null, "Oletko varma että haluat lopettaa pelin?", "Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null,options, options[0]);
                
                if (lopetus == 1){
                    System.exit(0);
                }
                
            }
            
        });
        
        helppi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Tervetuloa pelaamaan peliä Laivanupotus!\n"
                        + "\n"
                        + "Laivanupotus on kahden pelaajan pelattava peli, jossa tavoitteena on upottaa vastustajan laivasto.\n"
                        + "Napilla 'Exit' ja 'Kyllä' voit lopettaa pelin milloin vain halutessasi. Painamalla nappia 'Aloita!' pääset aloittamaan pelin!\n"
                        + "\n"
                        + "Alussa pelaajat pääsevät asettamaan itselleen nimen. Kannattaa aluksi sopia kumpi on pelaaja 1 ja kumpi pelaaja 2.\n"
                        + "Kun nimet on asetettu, pelaajat pääsevät vuoron perään asettamaan oman laivastonsa omalle pelilaudalleen.\n"
                        + "Muistattehan molemmat, että pelissä ei ole mitään jännää jos toinen pelaaja kurkkii laivanasetustilanteessa!\n"
                        + "\n"
                        + "Laivoja on yhteensä 10kpl. Ensin asetetaan neljän ruudun pituinen Lentotukialus, seuraavaksi kaksi kolmen ruudun pituista Risteilijää,\n"
                        + "sitten kolme kahden ruudun pituista Hävittäjää ja viimeisenä neljä Sukellusvenettä. Pelaaja klikkaa ruutua josta haluaa laivan alkavan.\n"
                        + "Yli ruudun pituisien laivojen asettamisen jälkeen peli kysyy, mihin suuntaan haluaa laivan jatkuvan.\n"
                        + "Laivoja voi siis asettaa vaaka- ja pystysuoraan. Tässä versiossa vierekkäiset ja peräkkäiset laivat ovat sallittuja.\n"
                        + "\n"
                        + "Kun molemmat pelaajat ovat asettaneet laivastonsa, sota alkaa!\n"
                        + "Pelaajat pääsevät vuorollaan ampumaan vastustajan pelilautaa. Pelin edetessä ruudun vasemmalle puolelle ilmestyy tekstiä pelin tapahtumista.\n"
                        + "Omalla vuorollaan pelaaja näkee vastustajan pelilaudan. Pelilaudalla esiintyy pelin edetessä muutama hyödyllinen symboli:\n"
                        + "\n"
                        + "-Tyhjä ruutu = Ruutu, johon ei ole toteutettu toimintoa. Ammu ja katso mitä tapahtuu!\n"
                        + "- X          = Kyseiseen ruutuun on jo ammuttu mutta siinä ei ollut laivaa.\n"
                        + "- O          = Ruutuun on ammuttu ja siinä on osa laivasta joka ei ole vielä uponnut. Kannattaa ampua viereisiin ruutuihin!\n"
                        + "- Z          = Kyseisessä ruudussa on laiva joka on uponnut.\n"
                        + "\n"
                        + "Peli päättyy kun jomman kumman koko laivasto on upotettu. Peli ilmoittaa tällöin voittajan voittosiirron jälkeen.\n"
                        + "\n"
                        + "Onnea peliin!"
                        , " Help", 1);
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
    
    public void kysyPelaajienNimet(Pelaaja pelaaja){ //Kysyy pelaajien nimet
        
        String nimi = JOptionPane.showInputDialog("Pelaaja " + moneskoPelaaja + ", kerro nimesi:");
        moneskoPelaaja++;
        pelaaja.setNimi(nimi);
        
    }
    
    public void aloita() { //aloittaa pelin kun pelaaja painaa nappia 'Aloita!'
        if (moneskoPelaaja>2){
            JOptionPane.showMessageDialog(this, "Peli on kesken! Jos kuitenkin haluat aloittaa uuden pelin, klikkaa 'Exit', sitten 'Kyllä'.");
        } else {
            kysyPelaajienNimet(logiikka.pelaaja1);
            kysyPelaajienNimet(logiikka.pelaaja2);
        }
    }
}