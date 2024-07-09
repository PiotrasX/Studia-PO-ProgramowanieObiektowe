package Projekt.PlikiJava;

public abstract class Pojazd
{
    private String rodzaj;
    private String podrodzaj;
    private String marka;
    private String model;
    private String kolor;
    private double pojSilnika;
    private int mocSilnika;
    private int maxPredkosc;
    private double waga;
    private int rokProd;
    private int przebieg;
    private int cena;
    private int liczbaMiejsc;

    public Pojazd()
    {
        this.rodzaj = "N/A";
        this.podrodzaj = "N/A";
        this.marka = "N/A";
        this.model = "N/A";
        this.kolor = "N/A";
        this.pojSilnika = 0;
        this.mocSilnika = 0;
        this.maxPredkosc = 0;
        this.waga = 0;
        this.rokProd = 0;
        this.przebieg = 0;
        this.cena = 0;
        this.liczbaMiejsc = 0;
    }
    public Pojazd(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                  int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc)
    {
        this.rodzaj = rodzaj;
        this.podrodzaj = podrodzaj;
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

    abstract String opis();

    public String getRodzaj() { return rodzaj; }
    public void setRodzaj(String rodzaj) { this.rodzaj = rodzaj; }
    public String getPodrodzaj() { return podrodzaj; }
    public void setPodrodzaj(String podrodzaj) { this.podrodzaj = podrodzaj; }
    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getKolor() { return kolor; }
    public void setKolor(String kolor) { this.kolor = kolor; }
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
