package Projekt.PlikiJava;

public class Motocykl extends Pojazd
{
    private int liczbaKol;

    public Motocykl() { this.liczbaKol = 0; }
    public Motocykl(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaKol)
    {
        super(rodzaj, podrodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.liczbaKol = liczbaKol;
    }

    @Override
    String opis()
    {
        return "\nDane motocyklu\nPodrodzaj: " + getPodrodzaj() + "\nMarka: " + getMarka() +
                "\nModel: " + getModel() + "\nKolor: " + getKolor() + "\nPojemność silnika (dm^3): " + getPojSilnika() +
                "\nMoc silnika (KM): " + getMocSilnika() + "\nMaksymalna prędkość (km/h): " + getMaxPredkosc() +
                "\nWaga (kg): " + getWaga() + "\nRok produkcji: " + getRokProd() + "\nPrzebieg (km): " + getPrzebieg() +
                "\nCena (PLN): " + getCena() + "\nLiczba miejsc: " + getLiczbaMiejsc() +
                "\nLiczba kół: " + getLiczbaKol() + "\n";
    }

    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }
}
