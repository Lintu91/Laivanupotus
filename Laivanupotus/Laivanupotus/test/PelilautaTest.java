
import laivanupotus.Pelilauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {
    
    public PelilautaTest() {
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
    public void tarkistaaOnkoTyjhaRuutuVarattu(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.onkoRuutuVarattu("A", 9);
        
        assertEquals(false, vastaus);
        
    }
    
     @Test
    public void eiVaraaTilaaJosOikeallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaOikealle(9, 4, 2);
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosOikeallaOnTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaOikealle(1, 4, 2);
        
        assertEquals(true, vastaus);
        
    }
    
    @Test
    public void eiVaraaTilaaJosYlhaallaEiOleTilaa(){
        
        Pelilauta peilauta = new Pelilauta();
        boolean vastaus = peilauta.varaaTilaaYlos(9, 1, 4);
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosYlhaallaOnTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaYlos(9, 9, 2);
        
        assertEquals(true, vastaus);
        
    }
    
    @Test 
    public void eiVaraaTilaaJosAlhaallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaAlas(9, 9, 4);
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosAlhaallaOTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaAlas(1, 1, 1);
        
        assertEquals(true, vastaus);
    }
    
    @Test 
    public void varaaTilaaJosVasemmallaOnTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaVasemmalle(7, 1, 4);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void eiVaraaTilaaJosVasemmallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaaVasemmalle(1, 3, 4);
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void tarkistaaOnkoRuudullaLaiva(){

        Pelilauta pelilauta = new Pelilauta();
        
        pelilauta.varaaRuutu(4, 4);
        boolean vastaus = pelilauta.onkoRuutuVarattu("D", 4);
        
        assertEquals(false,vastaus);
    }
}
