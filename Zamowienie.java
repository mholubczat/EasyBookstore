package com.example.test;

import java.util.ArrayList;
import java.util.List;

import static com.example.test.Hurtownia.stawkaTransportowa;


public class Zamowienie implements dodajDoZamowienia {
    Ksiegarnia ksiegarnia;
    int rok;
    int miesiac;
    double wartosc;
    List<pozycjaZamowienia> spisPozycji = new ArrayList<>();

    public Zamowienie(Ksiegarnia ksiegarnia, int rok, int miesiac) {
        this.ksiegarnia = ksiegarnia;
        this.rok = rok;
        this.miesiac = miesiac;
        this.wartosc = ksiegarnia.getOdleglosc()*stawkaTransportowa;
    }

    public Ksiegarnia getKsiegarnia() {
        return ksiegarnia;
    }


    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    public double getWartosc() {
        return wartosc;
    }


    public List<pozycjaZamowienia> getSpisPozycji() {
        return spisPozycji;
    }


    @Override
    public void dodajPozycje(Ksiazka ksiazka, Integer ilosc) {
        spisPozycji.add (new pozycjaZamowienia(ksiazka,ilosc));
        wartosc += ilosc*ksiazka.getCena();
    }
}

