package laivanupotus;

import java.util.Scanner;

public class Peli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;

    Scanner lukija = new Scanner(System.in);

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

        for (int i = 0; i < 2; i++) { //Tämä osio on lähes valmis, toimiva ja buginen!

            if (i == 0) {

                pelaaja = pelaaja1;
            }

            if (i == 1) {

                pelaaja = pelaaja2;
            }

            for (int j = 4; j > 0; j--) {

                int pituus = j;

                for (int k = 5; k > j; k--) {
                    Laiva laiva = null;
                    if (pituus == 4) {
                        laiva = new Laiva(4, "Lentotukialus");
                    } else if (pituus == 3) {
                        laiva = new Laiva(3, "Risteilijä");
                    } else if (pituus == 2) {
                        laiva = new Laiva(2, "Hävittäjä");
                    } else {
                        laiva = new Laiva(1, "Sukellusvene");
                    }

                    System.out.println("Pelaaja " + pelaaja.getNimi() + ", aseta " + laiva.getNimi() + " ruudulle!");

                    valittuKirjain = logiikka.kyseleSarake();
                    valittuNumero = logiikka.kyseleRivi();

                    while (pelaaja.getPelilauta().onkoRuutuVarattu(valittuKirjain, valittuNumero)) {

                        System.out.println("Valittu ruutu on varattu, valitse uudestaan!");
                        valittuKirjain = logiikka.kyseleSarake();
                        valittuNumero = logiikka.kyseleRivi();
                    }

                    pelaaja.setKirjainJaNumero(valittuKirjain, valittuNumero);

                    System.out.println("Valitsit ruudun " + pelaaja.getKirjain() + pelaaja.getNumero());

                    System.out.print("Mihin suuntaan haluat laivan? V=vasen, O=oikea, Y=ylös, A=alas: ");

                    String suunta = lukija.nextLine();

                    while (pelaaja.getPelilauta().lisaaLaiva(laiva, valittuKirjain, valittuNumero, suunta) == false) { //Tama on muuttamassa joskus

                        System.out.print("Ei kelpaa, valitse uusi suunta: ");
                        suunta = lukija.nextLine();
                    }

                    System.out.println("Laivan asettaminen onnistui!");
                }

            }
        }

        vastustaja = new Pelaaja();
        int kierroksia = 0;

        while (true) { //Tämä osa ei ole vielä toiminnassa

            if ((kierroksia % 2) == 0) {

                pelaaja = pelaaja2;
                vastustaja = pelaaja1;
            } else {

                pelaaja = pelaaja1;
                vastustaja = pelaaja2;
            }

            System.out.println("Pelaaja, mihin ruutuun haluat ampua?");
            valittuKirjain = logiikka.kyseleSarake();
            valittuNumero = logiikka.kyseleRivi();

            pelaaja.getPelilauta().ammuRuutuun(valittuKirjain, valittuNumero);

            kierroksia++;

            if (pelaaja.getPelilauta().viimeinenLaivaUpotettu() == true) {
                break;
            }
        }

        if (pelaaja1.getPelilauta().viimeinenLaivaUpotettu() == false) {

            pelaaja = pelaaja1;
        } else {

            pelaaja = pelaaja2;
        }

        System.out.println("Peli päättyi, voittaja on " + pelaaja.getNimi() + "! Onneksi olkoon!");
        System.out.println("Pelivuoroja kertyi " + kierroksia + "kpl");
    }
}
