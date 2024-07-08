package Projekt.PlikiJava;

public class Osobowy extends Pojazd
{
    private int liczbaDrzwi;
    private double pojBagaz;

    public Osobowy()
    {
        this.liczbaDrzwi = 0;
        this.pojBagaz = 0;
    }
    public Osobowy(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaDrzwi, double pojBagaz)
    {
        super(rodzaj, podrodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.liczbaDrzwi = liczbaDrzwi;
        this.pojBagaz = pojBagaz;
    }

    @Override
    String opis()
    {
        return "\nDane samochodu osobowego\nPodrodzaj: " + getPodrodzaj() + "\nMarka: " + getMarka() +
                "\nModel: " + getModel() + "\nKolor: " + getKolor() + "\nPojemność silnika (dm^3): " + getPojSilnika() +
                "\nMoc silnika (KM): " + getMocSilnika() + "\nMaksymalna prędkość (km/h): " + getMaxPredkosc() +
                "\nWaga (kg): " + getWaga() + "\nRok produkcji: " + getRokProd() + "\nPrzebieg (km): " + getPrzebieg() +
                "\nCena (PLN): " + getCena() + "\nLiczba miejsc: " + getLiczbaMiejsc() +
                "\nLiczba drzwi: " + getLiczbaDrzwi() + "\nPojemność bagażnika (dm^3): " + getPojBagaz() + "\n";
    }

    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public double getPojBagaz() { return pojBagaz; }
    public void setPojBagaz(double pojBagaz) { this.pojBagaz = pojBagaz; }
}
