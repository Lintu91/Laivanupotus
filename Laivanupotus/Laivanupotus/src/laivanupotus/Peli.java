package laivanupotus;

import java.util.Scanner;

public class Peli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;

    Scanner lukija = new Scanner(System.in);

    Logiikka logiikka = new Logiikka();
    Tekstikayttoliittyma tekstis;
    public void AloitaPeli() {
        
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        
        tekstis = new Tekstikayttoliittyma(this);

        tekstis.tervehdi();
        pelaaja = pelaaja1;
        tekstis.kysyNimi(1);
        pelaaja = pelaaja2;
        tekstis.kysyNimi(2);

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

                    tekstis.asetaLaiva(pelaaja, laiva);
                }
            }
        }

        vastustaja = new Pelaaja();
        int kierroksia = 0;

        while (true) { //Tämä osa ei ole vielä toiminnassa

            if ((kierroksia % 2) == 0) {

                pelaaja = pelaaja1;
                vastustaja = pelaaja2;
            } else {

                pelaaja = pelaaja2;
                vastustaja = pelaaja1;
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

            vastustaja.getPelilauta().ammuRuutuun(pelaaja.getKirjain(), pelaaja.getNumero());

            kierroksia++;

            if (vastustaja.getPelilauta().viimeinenLaivaUpotettu() == true) {
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
    
    public void nimiValittu(String nimi) {
        logiikka.asetaNimi(pelaaja, nimi);
    }
    
    public void kirjainValittu(String kirjain){
        
    }
    public void numeroValittu(Integer numero){
        
    }
}
