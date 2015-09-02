
package laivanupotus.test;

import laivanupotus.Laiva;
import laivanupotus.LaivanasetusLogiikka;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivanasetusLogiikkaTest {
    
    public LaivanasetusLogiikkaTest() {
    }
    
    @Test
    public void eiAnnaLupaaVuoronVaihdolleAlussa(){
        LaivanasetusLogiikka laivis = new LaivanasetusLogiikka();
        boolean vastaus = laivis.vuoronvaihto();
        
        assertEquals(false, vastaus);
    }
}
