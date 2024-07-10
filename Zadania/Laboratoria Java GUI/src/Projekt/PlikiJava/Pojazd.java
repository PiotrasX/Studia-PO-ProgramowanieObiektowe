package Projekt.PlikiJava;

import java.util.ArrayList;

public abstract class Pojazd
{
    private Rodzaj rodzaj;
    private Marka marka;
    private String model;
    private Kolor kolor;
    private double pojSilnika;
    private int mocSilnika;
    private int maxPredkosc;
    private double waga;
    private int rokProd;
    private int przebieg;
    private int cena;
    private int liczbaMiejsc;
    public static ArrayList<Pojazd> pojazdyList = new ArrayList<>();
    public static ArrayList<Object[]> pojazdyListWyswietlTabela = new ArrayList<>();
    protected Object[] pojazd;

    public Pojazd(Rodzaj rodzaj, Marka marka, String model, Kolor kolor, double pojSilnika,
                  int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc)
    {
        this.rodzaj = rodzaj;
        this.marka = marka;
        this.model = model;
        this.kolor = kolor;
        this.pojSilnika = pojSilnika;
        this.mocSilnika = mocSilnika;
        this.maxPredkosc = maxPredkosc;
        this.waga = waga;
        this.rokProd = rokProd;
        this.przebieg = przebieg;
        this.cena = cena;
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public abstract Object[] zwrocPojazd();
    public abstract String toString();
    public abstract String getNadwozie();

    public Rodzaj getRodzaj() { return rodzaj; }
    public void setRodzaj(Rodzaj rodzaj) { this.rodzaj = rodzaj; }
    public Marka getMarka() { return marka; }
    public void setMarka(Marka marka) { this.marka = marka; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Kolor getKolor() { return kolor; }
    public void setKolor(Kolor kolor) { this.kolor = kolor; }
    public double getPojSilnika() { return pojSilnika; }
    public void setPojSilnika(double pojSilnika) { this.pojSilnika = pojSilnika; }
    public int getMocSilnika() { return mocSilnika; }
    public void setMocSilnika(int mocSilnika) { this.mocSilnika = mocSilnika; }
    public int getMaxPredkosc() { return maxPredkosc; }
    public void setMaxPredkosc(int maxPredkosc) { this.maxPredkosc = maxPredkosc; }
    public double getWaga() { return waga; }
    public void setWaga(double waga) { this.waga = waga; }
    public int getRokProd() { return rokProd; }
    public void setRokProd(int rokProd) { this.rokProd = rokProd; }
    public int getPrzebieg() { return przebieg; }
    public void setPrzebieg(int przebieg) { this.przebieg = przebieg; }
    public int getCena() { return cena; }
    public void setCena(int cena) { this.cena = cena; }
    public int getLiczbaMiejsc() { return liczbaMiejsc; }
    public void setLiczbaMiejsc(int liczbaMiejsc) { this.liczbaMiejsc = liczbaMiejsc; }
}
