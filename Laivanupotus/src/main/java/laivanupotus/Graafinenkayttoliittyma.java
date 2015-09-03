
package laivanupotus;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Graafinenkayttoliittyma implements Runnable{

    private JFrame frame;
    
    private Logiikka logiikka;
    private JTextArea tekstikentta;
    
    private Aloitusruutu aloitus;
    private Karttanakyma kartta;
    
    public Graafinenkayttoliittyma(Logiikka logiikka) {
        this.logiikka = logiikka;
        
        playSound("musa.wav");
        
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
    
    public void aloitaPeli() { //Pelin aloitus
        aloitus.aloita();
        kartta.ekaVuoro();
    }
    
    public void paivitaInforuutu(String viesti){ //Päivittää inforuutua kun pelissä tapahtuu jotain
        String vanhaViesti = tekstikentta.getText();
        tekstikentta.setText("Vuoro " + logiikka.annaTaisteluLogiikka().getVuorojenMaara() + ", Pelaaja " + viesti + "\n");
        tekstikentta.append(vanhaViesti);
    }
    
    public void playSound(String filename){
        try {
            File yourFile = new File(filename);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            clip.loop(100);
        }
        catch (Exception e) {
            //whatevers
            e.printStackTrace();
        }
    }
}
