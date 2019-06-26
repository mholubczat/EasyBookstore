package com.example.test;

public class Ksiegarnia {
    String nazwa;
    String miasto;
    double odleglosc;

    public Ksiegarnia(String nazwa, String miasto, double odleglosc) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.odleglosc = odleglosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public double getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(double odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
