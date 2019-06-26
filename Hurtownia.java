package com.example.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hurtownia {
    static double stawkaTransportowa;
    static List<Zamowienie> listaZamowien = new ArrayList<>();
    static List<Ksiazka> katalogKsiazek = new ArrayList<>();
    static Set<Ksiegarnia> listaKsiegarn = new HashSet<>();

    public static void zlozZamowienie(Zamowienie zamowienie) {
        listaZamowien.add(zamowienie);
        listaKsiegarn.add(zamowienie.getKsiegarnia());
    }

    public static void raportRoczny(int rok) {
        for (int miesiac = 1; miesiac <= 12; miesiac++)
            for (Ksiegarnia k : listaKsiegarn) {
                for (Zamowienie z : listaZamowien) {
                    if (z.getRok() == rok && z.getMiesiac() == miesiac && k.equals(z.getKsiegarnia())) {
                        int ilosc = 0;
                        double wartosc = stawkaTransportowa*k.getOdleglosc();
                        for (pozycjaZamowienia p : z.getSpisPozycji()) {
                            ilosc += p.ilosc;
                            wartosc += p.ilosc*p.ksiazka.getCena();
                        }
                        String raport = "Księgarnia " + k + " zamówiła w " + miesiac + "." + rok + " " + ilosc + " ksiazek za " + wartosc + " zl";
                        System.out.println(raport);

                    }

                }

            }
    }





    public static void main(String[] args) {
        stawkaTransportowa = 5;
        //książki
        Ksiazka book1 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "Asd", 2006, 50);
        Ksiazka book2 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", "Dsa", 2002, 45);
        Ksiazka book3 = new Ksiazka("Pan Kleks", "Jan Brzechwa", "Asd", 2015, 30);
        //księgarnie
        Ksiegarnia ksiegarnia1 = new Ksiegarnia("Mazowiecka", "Warszawa", 10);
        Ksiegarnia ksiegarnia2 = new Ksiegarnia("Pomorska", "Gdańsk", 400);
        Ksiegarnia ksiegarnia3 = new Ksiegarnia("Wielkopolska", "Poznań", 300);
        //zamowienia
        Zamowienie zamowienie1 = new Zamowienie(ksiegarnia1, 2019, 1);
        zamowienie1.dodajPozycje(book1, 15);
        zlozZamowienie(zamowienie1);

        Zamowienie zamowienie2 = new Zamowienie(ksiegarnia1, 2019, 3);
        zamowienie2.dodajPozycje(book2, 13);
        zamowienie2.dodajPozycje(book3, 10);
        zamowienie2.dodajPozycje(book1, 11);
        zlozZamowienie(zamowienie2);

        Zamowienie zamowienie3 = new Zamowienie(ksiegarnia3, 2019, 3);
        zamowienie3.dodajPozycje(book3, 10);
        zlozZamowienie(zamowienie3);

        Zamowienie zamowienie4 = new Zamowienie(ksiegarnia2, 2019, 1);
        zamowienie4.dodajPozycje(book2, 15);
        zamowienie4.dodajPozycje(book1, 10);
        zlozZamowienie(zamowienie4);

        Zamowienie zamowienie5 = new Zamowienie(ksiegarnia2, 2019, 3);
        zamowienie5.dodajPozycje(book1, 5);
        zlozZamowienie(zamowienie5);

        Hurtownia.raportRoczny(2019);

    }

}