package laivanupotus.test;

import laivanupotus.Logiikka;
import laivanupotus.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogiikkaTest {
 
    
    public LogiikkaTest() {
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
    public void statusOikeinAlussa(){
        Logiikka logiikka = new Logiikka();
        int vastaus = logiikka.annaStatus();
        
        assertEquals(0,vastaus);
    }
    
    @Test 
    public void statusMuuttuuOikein(){
        Logiikka logiikka = new Logiikka();
        logiikka.vuoronvaihto();
        logiikka.vuoronvaihto();
        int vastaus = logiikka.annaStatus();
        
        assertEquals(1,vastaus);
    }
    
}
