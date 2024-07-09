package Projekt.PlikiJava;

public class Autobus extends Pojazd
{
    private int liczbaDrzwi;
    private double pojBagaz;
    private int liczbaKol;

    public Autobus()
    {
        this.liczbaDrzwi = 0;
        this.pojBagaz = 0;
        this.liczbaKol = 0;
    }
    public Autobus(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                     int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                     int liczbaDrzwi, double pojBagaz, int liczbaKol)
    {
        super(rodzaj, podrodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.liczbaDrzwi = liczbaDrzwi;
        this.pojBagaz = pojBagaz;
        this.liczbaKol = liczbaKol;
    }

    @Override
    String opis()
    {
        return "\nDane autobusu\nPodrodzaj: " + getPodrodzaj() + "\nMarka: " + getMarka() +
                "\nModel: " + getModel() + "\nKolor: " + getKolor() + "\nPojemność silnika (dm^3): " + getPojSilnika() +
                "\nMoc silnika (KM): " + getMocSilnika() + "\nMaksymalna prędkość (km/h): " + getMaxPredkosc() +
                "\nWaga (kg): " + getWaga() + "\nRok produkcji: " + getRokProd() + "\nPrzebieg (km): " + getPrzebieg() +
                "\nCena (PLN): " + getCena() + "\nLiczba miejsc: " + getLiczbaMiejsc() +
                "\nLiczba drzwi: " + getLiczbaDrzwi() + "\nPojemność bagażnika (dm^3): " + getPojBagaz() +
                "\nLiczba kół: " + getLiczbaKol() + "\n";
    }

    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public double getPojBagaz() { return pojBagaz; }
    public void setPojBagaz(double pojBagaz) { this.pojBagaz = pojBagaz; }
    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }
}
