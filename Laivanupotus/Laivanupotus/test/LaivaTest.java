
import laivanupotus.Laiva;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivaTest {
    
    public LaivaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void getNimiToimiiOikein(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        String vastaus = laiva.getNimi();
        
        assertEquals("Risteilijä", vastaus);
    }
    
    @Test
    public void getPituusToimiiOikein(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        int vastaus = laiva.getPituus();
        
        assertEquals(3, vastaus);
    }
    
    @Test 
    public void getElinvoimaToimiiOikein(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        int vastaus = laiva.getElinvoima();
        
        assertEquals(3, vastaus);
    }
    
    @Test
    public void elinvoimaVaheneeOikein(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        laiva.osuma();
        int vastaus = laiva.getElinvoima();
        
        assertEquals(2, vastaus);
    }
    
    @Test
    public void kertooOnkoLaivaAloitusruudussaan(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        laiva.asetuLaudalle(3, 3, "V");
        boolean vastaus = laiva.onRuudussa(3, 3);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void kertooOnkoLaivaRuudussa(){ //Jossain muussa kuin laivan alkupääruudussa
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        laiva.asetuLaudalle(3, 3, "V");
        boolean vastaus = laiva.onRuudussa(2, 3);
        
        assertEquals(true, vastaus);
    }
    
    @Test 
    public void palauttaaFalseKunLaivaEiOleKysytyssaRuudussa(){
        
        Laiva laiva = new Laiva(3, "Risteilijä");
        laiva.asetuLaudalle(3, 3, "V");
        boolean vastaus = laiva.onRuudussa(4, 4);
        
        assertEquals(false, vastaus);
    }
}
