package laivanupotus;

import java.util.Scanner;

public class Peli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;

    Scanner lukija = new Scanner(System.in);

    Logiikka logiikka = new Logiikka();
    Tekstikayttoliittyma tekstis = new Tekstikayttoliittyma();
    public void AloitaPeli() {
        
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();

        tekstis.tervehdi();
        tekstis.kysyEkaNimi();
        logiikka.kyseleNimi(pelaaja1);
        tekstis.kysyTokaNimi();
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
                    tekstis.kysyKirjain();
                    while (!logiikka.kyseleSarake(pelaaja)){
                        tekstis.valittuKirjainError();
                    }
                    tekstis.kysyNumero();
                    while (!logiikka.kyseleRivi(pelaaja)){
                        tekstis.valittuKirjainError();
                    }
                                    
                    while (pelaaja.getPelilauta().onkoRuutuVarattu(pelaaja.getKirjain(), pelaaja.getNumero())) {

                        tekstis.ruutuOnVarattu();
                        tekstis.kysyKirjain();
                        while (!logiikka.kyseleSarake(pelaaja)){
                            tekstis.valittuKirjainError();
                        }
                        tekstis.kysyNumero();
                        while (!logiikka.kyseleRivi(pelaaja)) {
                            tekstis.kysyNumero();
                        }
                            
                    }

                    tekstis.ilmoitaValittuRuutu(pelaaja);

                    tekstis.kysySuunta();

                    String suunta = lukija.nextLine();

                    while (pelaaja.getPelilauta().lisaaLaiva(laiva, pelaaja.getKirjain(), pelaaja.getNumero(), suunta) == false) { 

                        tekstis.valitseUusiSuunta();
                        suunta = lukija.nextLine();
                    }

                    tekstis.laivanAsettaminenOnnistui();
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

            tekstis.mihinAmmutaan(pelaaja);
            tekstis.kysyKirjain();
            while (!logiikka.kyseleSarake(pelaaja)){
                tekstis.valittuKirjainError();
            }
            tekstis.kysyNumero();
            while (!logiikka.kyseleRivi(pelaaja)){
                tekstis.valittuNumeroError();
            }
           // valittuNumero = logiikka.kyseleRivi();

            pelaaja.getPelilauta().ammuRuutuun(pelaaja.getKirjain(), pelaaja.getNumero());

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
