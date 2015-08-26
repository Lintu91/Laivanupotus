
package laivanupotus;

import java.util.Scanner;

public class Tekstikayttoliittyma {
    Scanner lukija = new Scanner(System.in);
    Peli peli;
    
    public Tekstikayttoliittyma(Peli peli){
        this.peli=peli;
    }
    
    public void tervehdi(){
        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
    }
    
    public void kysyNimi(int pelaajaNro){
        
        System.out.print("Pelaaja" + pelaajaNro + ", millä nimellä haluat sinua kutsuttavan? : ");
        String nimi = lukija.nextLine();
        
        peli.nimiValittu(nimi);
    }
    public void asetaLaiva(Pelaaja pelaaja, Laiva laiva){
        
        System.out.println("Pelaaja " + pelaaja.getNimi() + ", aseta " + laiva.getNimi() + " ruudulle!");
                    String kirjain = kysyKirjain();
                    int numero = kysyNumero();
                                    
                    while (pelaaja.getPelilauta().onkoRuutuVarattu(kirjain, numero)) {
                        ruutuOnVarattu();
                        kirjain = kysyKirjain();
                        numero = kysyNumero(); 
                    }

                    pelaaja.setKirjain(kirjain);
                    pelaaja.setNumero(numero);
                    
                    ilmoitaValittuRuutu(pelaaja);

                    kysySuunta();

                    String suunta = lukija.nextLine();

                    while (pelaaja.getPelilauta().lisaaLaiva(laiva, pelaaja.getKirjain(), pelaaja.getNumero(), suunta) == false) { 

                        valitseUusiSuunta();
                        suunta = lukija.nextLine();
                    }

                    laivanAsettaminenOnnistui();
    }
    public String kysyKirjain(){
        System.out.print("Valitse sarake, välillä A-J: ");
        String valittavatKirjaimet = "ABCDEFGHIJ";
        
        String valittuKirjain = lukija.nextLine();
        
        valittuKirjain = valittuKirjain.toUpperCase();
        
        while (!valittavatKirjaimet.contains(valittuKirjain) || valittuKirjain.length() != 1) {
            valittuKirjainError();
            valittuKirjain = lukija.nextLine();
            valittuKirjain = valittuKirjain.toUpperCase();
        }
        
        return valittuKirjain;  
    }
    public Integer kysyNumero(){
        System.out.print("Valitse rivi, välillä 0-9: ");
        int valittuNumero = Integer.MAX_VALUE;
        try {
          valittuNumero = Integer.parseInt(lukija.nextLine());
        } catch(NumberFormatException e) {
            System.err.println("Ei ollut numero, kirjoita uudestaan");
        }
        
        while (! (valittuNumero >= 0 && valittuNumero < 10 )) {
            System.out.print("Numero ei ole annetulla välillä, valitse uudelleen: ");
            try {
                valittuNumero = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ei ollut numero, kirjoita uudestaan");

            }
        }
        return valittuNumero;
    }
    
    public void ammuRuutuun(Pelaaja pelaaja, Pelaaja vastustaja) {
        mihinAmmutaan(pelaaja);
        
        String kirjain =kysyKirjain();
        int numero = kysyNumero();
        pelaaja.setKirjain(kirjain);
        pelaaja.setNumero(numero);
  
        int tulos = vastustaja.getPelilauta().ammuRuutuun(pelaaja.getKirjain(), pelaaja.getNumero());
        if (tulos == 0){
            System.out.println("Huti!");
        } else if (tulos == 1 ){
            System.out.println("Osui!");
        } else {
            System.out.println("Osui ja upposi!");
        }
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
        System.out.println(pelaaja.getNimi() + ", mihin ruutuun haluat ampua?");
    }
}
