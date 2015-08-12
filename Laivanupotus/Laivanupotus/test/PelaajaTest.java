
import laivanupotus.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    public PelaajaTest() {
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
    public void asettaaPelaajanNimenOikein(){
        
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setNimi("Pelaaja");
        String vastaus = pelaaja.getNimi();
        
        assertEquals("Pelaaja", vastaus);
    }
    
      @Test 
    public void listaOnAluksiTyhja(){
        
        Pelaaja pelaaja = new Pelaaja();
        boolean vastaus = pelaaja.getPelilauta().viimeinenLaivaUpotettu();
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void lisaaLaivanListaanOikein(){
        
        
    }
//    
    @Test
    public void poistaaLaivanListasta(){ 
        
        
    }
}
