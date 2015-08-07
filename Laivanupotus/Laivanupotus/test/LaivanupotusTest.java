
import laivanupotus.Pelaaja;
import laivanupotus.Pelilauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivanupotusTest {
    
    public LaivanupotusTest() {
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
    public void pelaajanValitsemaKirjaiOnOikein(){
        
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setKirjainJaNumero("A", 9);
        String vastaus = pelaaja.getKirjain();
        
        assertEquals("A", vastaus);
    }
    
    @Test
    public void pelaajanValitsemaNumeroOnOikein(){
        
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setKirjainJaNumero("A", 9);
        int vastaus = pelaaja.getNumero();
        
        assertEquals(9,vastaus);
    }
    
    @Test
    public void tarkistaaOnkoTyjhaRuutuVarattu(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.onkoRuutuVarattu("A", 9);
        
        assertEquals(false, vastaus);
        
    }
    
    @Test 
    public void eiVaraaVarattuaRuutua(){
        
        Pelilauta pelilauta = new Pelilauta();
        pelilauta.varaaRuutu(9, 9);
        boolean vastaus = pelilauta.onkoRuutuVarattu("I", 9);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void eiVaraaTilaaJosVasemmallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("A", 9, 4, "V");
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void varaaTilaaJosVasemmallaTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("I", 4, 4, "V");
        
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void eiVaraaTilaaJosOikeallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("J", 9, 4, "O");
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosOikeallaOnTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("A", 9, 4, "O");
        
        assertEquals(true, vastaus);
        
    }
    
    @Test
    public void eiVaraaTilaaJosYlhaallaEiOleTilaa(){
        
        Pelilauta peilauta = new Pelilauta();
        boolean vastaus = peilauta.varaaTilaa("A", 1, 4, "Y");
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosYlhaallaOnTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("E", 4, 4, "Y");
        
        assertEquals(true, vastaus);
        
    }
    
    @Test 
    public void eiVaraaTilaaJosAlhaallaEiOleTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("J", 10, 4, "A");
        
        assertEquals(false, vastaus);
        
    }
    
    @Test
    public void varaaTilaaJosAlhaallaOTilaa(){
        
        Pelilauta pelilauta = new Pelilauta();
        boolean vastaus = pelilauta.varaaTilaa("J", 1, 4, "A");
        
        assertEquals(true, vastaus);
    }

}
