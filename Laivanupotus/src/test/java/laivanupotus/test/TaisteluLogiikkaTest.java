
package laivanupotus.test;
import laivanupotus.Pelaaja;
import laivanupotus.Laiva;
import laivanupotus.TaisteluLogiikka;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaisteluLogiikkaTest {
    
    public TaisteluLogiikkaTest() {
      
    }
    @Test
    public void kaikkiLaivatUpotettuToimiiKunLaivojaOnVielaJaljella(){
        TaisteluLogiikka taistis = new TaisteluLogiikka();
        Laiva laiva = new Laiva(4, "Lentotukialus");
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.getPelilauta().lisaaLaiva(laiva, 4, 4, "O");
        boolean vastaus = taistis.kaikkiLaivatUpotettu(pelaaja);
        assertEquals(false, vastaus);
    }
    
    @Test
    public void kaikkiLaivatUpotettuToimiiKunLaivojaEiOle(){
        TaisteluLogiikka taistis = new TaisteluLogiikka();
        Laiva laiva = new Laiva(1,"Sukellusvene");
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.getPelilauta().lisaaLaiva(laiva, 4, 4, "O");
        pelaaja.getPelilauta().ammuRuutuun(4, 4);
        boolean vastaus = taistis.kaikkiLaivatUpotettu(pelaaja);
        
        assertEquals(true, vastaus);
    }
    @Test
    public void aulussaVuorojenMaaraOnYksi(){
        TaisteluLogiikka taistis = new TaisteluLogiikka();
        int vastaus = taistis.getVuorojenMaara();
        
        assertEquals(1, vastaus);
    }
    @Test
    public void vuorojenMaaraKasvaaOikein(){
        TaisteluLogiikka taistis = new TaisteluLogiikka();
        taistis.vuoronvaihto();
        int vastaus = taistis.getVuorojenMaara();
        
        assertEquals(2, vastaus);
    }
}
