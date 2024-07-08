package Projekt.PlikiJava;

public class Ciezarowy extends Pojazd
{
    private int liczbaDrzwi;
    private double ladownosc;
    private int liczbaKol;

    public Ciezarowy()
    {
        this.liczbaDrzwi = 0;
        this.ladownosc = 0;
        this.liczbaKol = 0;
    }
    public Ciezarowy(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaDrzwi, double ladownosc, int liczbaKol)
    {
        super(rodzaj, podrodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.liczbaDrzwi = liczbaDrzwi;
        this.ladownosc = ladownosc;
        this.liczbaKol = liczbaKol;
    }

    @Override
    String opis()
    {
        return "\nDane samochodu ciężarowego\nPodrodzaj: " + getPodrodzaj() + "\nMarka: " + getMarka() +
                "\nModel: " + getModel() + "\nKolor: " + getKolor() + "\nPojemność silnika (dm^3): " + getPojSilnika() +
                "\nMoc silnika (KM): " + getMocSilnika() + "\nMaksymalna prędkość (km/h): " + getMaxPredkosc() +
                "\nWaga (kg): " + getWaga() + "\nRok produkcji: " + getRokProd() + "\nPrzebieg (km): " + getPrzebieg() +
                "\nCena (PLN): " + getCena() + "\nLiczba miejsc: " + getLiczbaMiejsc() +
                "\nLiczba drzwi: " + getLiczbaDrzwi() + "\nŁadowność (kg): " + getLadownosc() +
                "\nLiczba kół: " + getLiczbaKol() + "\n";
    }

    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public double getLadownosc() { return ladownosc; }
    public void setLadownosc(double ladownosc) { this.ladownosc = ladownosc; }
    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }
}
