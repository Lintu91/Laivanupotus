
import laivanupotus.Laiva;
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
    
    @Test
    public void lisaaLaivanJosMahdollista(){
        
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(3, "Risteilijä");
        boolean vastaus = pelilauta.lisaaLaiva(laiva, "D", 3, "V");
        
        assertEquals(true, vastaus);
    }
    
    @Test 
    public void eiLisaaLaivaaJosEiOleMahdollista(){
        
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(3, "Risteilijä");
        boolean vastaus = pelilauta.lisaaLaiva(laiva, "A", 1, "V");
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void eiLisaaLaivaaJosRuudussaOnLaiva(){
        
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva1 = new Laiva(3, "Risteilijä");
        pelilauta.lisaaLaiva(laiva1, "D", 3, "V");
        Laiva laiva2 = new Laiva(3, "Risteilijä");
        boolean vastaus = pelilauta.lisaaLaiva(laiva2, "D", 3, "V");
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void pelaajanLaivaSiirtyyListaan(){
        
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(3, "Risteilijä");
        pelilauta.lisaaLaiva(laiva, "D", 3, "V");
        
        int vastaus = pelilauta.getListaSize();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void sukellusveneUppoaaOikein(){
        
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(1, "Sukellusvene");
        pelilauta.lisaaLaiva(laiva, "D", 3, "V");
        pelilauta.ammuRuutuun("D", 3);
        boolean vastaus = pelilauta.viimeinenLaivaUpotettu();
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void ammuRuutuunToimii(){
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(2, "Hävittäjä");
        pelilauta.lisaaLaiva(laiva, "D", 3, "A");
        pelilauta.ammuRuutuun("D", 3);
        int vastaus = laiva.getElinvoima();
        
        assertEquals(1, vastaus);
    }
    @Test
    public void sanomaKunHuti(){
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(2, "Hävittäjä");
        pelilauta.lisaaLaiva(laiva, "D", 3, "A");
        int vastaus = pelilauta.ammuRuutuun("E", 3);
        
        assertEquals(0, vastaus);
    }
    @Test 
    public void sanomaKunOsuma(){
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(2, "Hävittäjä");
        pelilauta.lisaaLaiva(laiva, "D", 3, "A");
        int vastaus = pelilauta.ammuRuutuun("D", 4);
        
        assertEquals(1, vastaus);
    }
    @Test
    public void sanomaKunUpposi(){
        Pelilauta pelilauta = new Pelilauta();
        Laiva laiva = new Laiva(2, "Hävittäjä");
        pelilauta.lisaaLaiva(laiva, "D", 3, "A");
        pelilauta.ammuRuutuun("D", 4);
        int vastaus = pelilauta.ammuRuutuun("D", 3);
        
        assertEquals(2, vastaus);
    }
}
