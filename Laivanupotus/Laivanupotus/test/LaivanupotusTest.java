
import laivanupotus.Pelaaja;
import laivanupotus.Pelilauta;
import laivanupotus.Logiikka;
import laivanupotus.Laivat;
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
    public void asettaaPelaajanNimenOikein(){
        
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setNimi("Pelaaja");
        String vastaus = pelaaja.getNimi();
        
        assertEquals("Pelaaja", vastaus);
    }
    
    @Test
    public void laivojenNimetVastaavatPituutta(){
        
        Laivat laivat = new Laivat();
        String vastaus = laivat.getNimi(4) + ", " + laivat.getNimi(3)+ ", " + laivat.getNimi(2) + ", " + laivat.getNimi(1) + ".";
        
        assertEquals("Lentotukialus, Risteilijä, Hävittäjä, Sukellusvene.", vastaus);
    }
    
    @Test 
    public void listaOnAluksiTyhja(){
        
        Pelaaja pelaaja = new Pelaaja();
        boolean vastaus = pelaaja.viimeinenLaivaUpotettu();
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void lisaaLaivanListaanOikein(){
        
        Laivat laiva = new Laivat();
        Pelaaja pelaaja = new Pelaaja();
        
        pelaaja.lisaaLaiva(laiva);
        boolean vastaus = pelaaja.viimeinenLaivaUpotettu();
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void poistaaLaivanListasta(){ 
        
        Laivat laiva = new Laivat();
        Pelaaja pelaaja = new Pelaaja();
        
        pelaaja.lisaaLaiva(laiva);
        pelaaja.upotaLaiva(laiva);
        boolean vastaus = pelaaja.viimeinenLaivaUpotettu();
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void tarkistaaOnkoRuudullaLaiva(){

        Pelilauta pelilauta = new Pelilauta();
        
        pelilauta.varaaRuutu(4, 4);
        boolean vastaus = pelilauta.onkoRuudullaLaiva("D", 4);
        
        assertEquals(true,vastaus);
    }

}
