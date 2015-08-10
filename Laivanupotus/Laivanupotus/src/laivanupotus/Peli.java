package laivanupotus;

import java.util.Scanner;

public class Peli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja pelaaja;

    Scanner lukija = new Scanner(System.in);
    Pelilauta pelilauta1 = new Pelilauta();
    Pelilauta pelilauta2 = new Pelilauta();
    Laivat laivat = new Laivat();

    String valittuKirjain;
    int valittuNumero = 0;
    Logiikka logiikka = new Logiikka();

    public void AloitaPeli() {

        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();

        System.out.println("Tervetuloa pelaamaan Laivanupotusta!");
        System.out.print("Pelaaja 1, millä nimellä haluat sinua kutsuttavan? : ");
        logiikka.kyseleNimi(pelaaja1);
        System.out.print("Pelaaja 2, millä nimellä haluat sinua kutsuttavan? : ");
        logiikka.kyseleNimi(pelaaja2);

        for (int i = 0; i < 2; i++) {
            
            if (i == 0) {
                    pelaaja = pelaaja1;
                } 
                if (i ==1) {
                    pelaaja = pelaaja2;
                }
            
            for (int j = 4; j > 0; j--) {
                int pituus = j;
                
                for (int k = 4; k < j; k--) {
                    
                    System.out.println("Pelaaja " + pelaaja.getNimi() + ", aseta " + laivat.getNimi(pituus) + " ruudulle!");

                    valittuKirjain = logiikka.kyseleSarake();
                    valittuNumero = logiikka.kyseleRivi();

                    pelaaja.setKirjainJaNumero(valittuKirjain, valittuNumero);

                    System.out.println("Valitsit ruudun " + pelaaja.getKirjain() + pelaaja.getNumero());

                    System.out.print("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas.");

                    String suunta = lukija.nextLine();

                    while (pelilauta1.varaaTilaa(pelaaja1.getKirjain(), pelaaja1.getNumero(), 4, suunta) == false) { //Tama on muuttamassa joskus

                        System.out.print("Ei kelpaa, Valitse uusi suunta: ");
                        suunta = lukija.nextLine();
                    }
                }

            }
        }

      
    }}
