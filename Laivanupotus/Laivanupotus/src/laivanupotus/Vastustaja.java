
package laivanupotus;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class Vastustaja {   
    String KaytettavatKirjaimet = "ABCDEFGHIJ";
    ArrayList VastustajanLaivat = new ArrayList(); 
    HashMap KaytettavatRuudut = new HashMap<String, Integer>();     
    HashMap KaytetytRuudut = new HashMap();  //mahdollisesti turha. Jaakoot.
    
    Random arpoja = new Random();
    int i = 0;
    
    public Vastustaja() {
        
    }
    public void TaydennaKaytettavatRuudut(){ //taydentaa kaytettavien ruutujen listaa
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k <= 10; k++) {
                KaytettavatRuudut.put(j, k);
            }
        }
    }
    
    public void TulostaKaytettavatRuudut(int j){          //Kesken
        System.out.println(KaytettavatRuudut.containsKey(j));
    }
    
    public void Aseta(){  //asettaa laivat laudalle. Kunhan on valmis.
        Arpoja();
        
    }
    
    public void Arpoja(){  //Kertausmetodi. Jaakoot toistaiseksi.
        while (i<10) {
            System.out.println(arpoja.nextInt(10));
            i++;
        }
    }
    
    public void Upota(){ //Take a quess
        
    }
}
