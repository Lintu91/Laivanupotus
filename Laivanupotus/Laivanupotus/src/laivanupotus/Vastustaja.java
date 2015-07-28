
package laivanupotus;
import java.util.Random;
import java.util.HashMap;

public class Vastustaja {   
    Random arpoja = new Random();
    int i = 0;
    
    public Vastustaja() {
        
    }
    
    public void Arpoja(){  //Kertausmetodi. Jaakoot toistaiseksi.
        while (i<10) {
            System.out.println(arpoja.nextInt(10));
            i++;
        }
    }
}
