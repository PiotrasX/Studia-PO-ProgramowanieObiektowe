package Projekt.PlikiJava;

public class CiagnikRol extends Pojazd
{
    private int liczbaDrzwi;
    private double maxMasaCiagniecia;

    public CiagnikRol()
    {
        this.liczbaDrzwi = 0;
        this.maxMasaCiagniecia = 0;
    }
    public CiagnikRol(String rodzaj, String podrodzaj, String marka, String model, String kolor, double pojSilnika,
                      int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                      int liczbaDrzwi, double maxMasaCiagniecia)
    {
        super(rodzaj, podrodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.liczbaDrzwi = liczbaDrzwi;
        this.maxMasaCiagniecia = maxMasaCiagniecia;
    }

    @Override
    String opis()
    {
        return "\nDane ciągnika rolniczego\nPodrodzaj: " + getPodrodzaj() + "\nMarka: " + getMarka() +
                "\nModel: " + getModel() + "\nKolor: " + getKolor() + "\nPojemność silnika (dm^3): " + getPojSilnika() +
                "\nMoc silnika (KM): " + getMocSilnika() + "\nMaksymalna prędkość (km/h): " + getMaxPredkosc() +
                "\nWaga (kg): " + getWaga() + "\nRok produkcji: " + getRokProd() + "\nPrzebieg (km): " + getPrzebieg() +
                "\nCena (PLN): " + getCena() + "\nLiczba miejsc: " + getLiczbaMiejsc() +
                "\nLiczba drzwi: " + getLiczbaDrzwi() +
                "\nMaksymalny ciężar do uciągniecia (kg): " + getMaxMasaCiagniecia() + "\n";
    }

    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public double getMaxMasaCiagniecia() { return maxMasaCiagniecia; }
    public void setMaxMasaCiagniecia(double maxMasaCiagniecia) { this.maxMasaCiagniecia = maxMasaCiagniecia; }
}
