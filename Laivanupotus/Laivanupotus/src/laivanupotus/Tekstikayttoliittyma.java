
package laivanupotus;

public class Tekstikayttoliittyma {
    
    public void tervehdi(){
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
    }
    
    public void kysyEkaNimi(){
        System.out.print("Pelaaja 1, millä nimellä haluat sinua kutsuttavan? : ");
    }
    public void kysyTokaNimi(){
        System.out.print("Pelaaja 2, millä nimellä haluat sinua kutsuttavan? : ");
    }
    public void kysyKirjain(){
        System.out.print("Valitse sarake, välillä A-J: ");
    }
    public void kysyNumero(){
        System.out.print("Valitse rivi, välillä 0-9: ");
    }
    public void valittuKirjainError(){
        System.out.print("Valitsemasi kirjain ei ole pyydetyllä välillä. Valitse uudestaan: ");
    }
    public void valittuNumeroError(){
        System.out.println("Lol");
    }
    public void ilmoitaValittuRuutu(Pelaaja pelaaja){
        System.out.println("Valitsit ruudun " + pelaaja.getKirjain() + pelaaja.getNumero());
    }
    public void ruutuOnVarattu(){
        System.out.println("Valittu ruutu on varattu, valitse uudestaan!");
    }
    public void kysySuunta(){
        System.out.print("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas: ");
    }
    public void valitseUusiSuunta(){
        System.out.print("Ei kelpaa, valitse uusi suunta: ");
    }
    public void laivanAsettaminenOnnistui(){
         System.out.println("Laivan asettaminen onnistui!");
    }
    public void mihinAmmutaan(Pelaaja pelaaja){
        System.out.println(pelaaja.getNimi() + " , mihin ruutuun haluat ampua?");
    }
}
