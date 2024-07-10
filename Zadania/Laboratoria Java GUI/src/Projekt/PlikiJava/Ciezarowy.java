package Projekt.PlikiJava;

import java.util.Objects;

public class Ciezarowy extends Pojazd
{
    private NadwozieCiezarowy nadwozie;
    private int liczbaDrzwi;
    private int ladownosc;
    private int liczbaKol;

    public Ciezarowy(Rodzaj rodzaj, NadwozieCiezarowy nadwozie, Marka marka, String model, Kolor kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaDrzwi, int ladownosc, int liczbaKol)
    {
        super(rodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.nadwozie = nadwozie;
        this.liczbaDrzwi = liczbaDrzwi;
        this.ladownosc = ladownosc;
        this.liczbaKol = liczbaKol;
        this.pojazd = new Object[] {this.getRodzaj().toString(), this.getNadwozie(), this.getMarka().toString(),
                this.getModel(), this.getKolor().toString(), this.getPojSilnika(), this.getMocSilnika(),
                this.getWaga(), this.getRokProd(), this.getPrzebieg(), this.getCena(), this.getMaxPredkosc(),
                this.getLiczbaMiejsc(), this.getLiczbaDrzwi(), this.getLadownosc(), this.getLiczbaKol()};
    }

    @Override
    public Object[] zwrocPojazd() { return pojazd; }

    @Override
    public String toString()
    {
        return "Rodzaj." + getRodzaj() + ";NadwozieCiezarowy." + getNadwozie() + ";Marka." + getMarka() + ";" +
                getModel() + ";Kolor." + getKolor() + ";" + getPojSilnika() + ";" + getMocSilnika() + ";" +
                getMaxPredkosc() + ";" + getWaga() + ";" + getRokProd() + ";" + getPrzebieg() + ";" + getCena() + ";" +
                getLiczbaMiejsc() + ";" + getLiczbaDrzwi() + ";" + getLadownosc() + ";" + getLiczbaKol() + "\n";
    }

    @Override
    public String getNadwozie() { return nadwozie.name(); }
    public void setNadwozie(NadwozieCiezarowy nadwozie) { this.nadwozie = nadwozie; }
    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public int getLadownosc() { return ladownosc; }
    public void setLadownosc(int ladownosc) { this.ladownosc = ladownosc; }
    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        Ciezarowy ciezarowy = (Ciezarowy) obj;
        return Objects.equals(getRodzaj(), ciezarowy.getRodzaj()) &&
                Objects.equals(getNadwozie(), ciezarowy.getNadwozie()) &&
                Objects.equals(getMarka(), ciezarowy.getMarka()) &&
                Objects.equals(getModel(), ciezarowy.getModel()) &&
                Objects.equals(getKolor(), ciezarowy.getKolor()) &&
                Double.compare(getPojSilnika(), ciezarowy.getPojSilnika()) == 0 &&
                getMocSilnika() == ciezarowy.getMocSilnika() &&
                Double.compare(getWaga(), ciezarowy.getWaga()) == 0 &&
                getRokProd() == ciezarowy.getRokProd() &&
                getPrzebieg() == ciezarowy.getPrzebieg() &&
                getCena() == ciezarowy.getCena() &&
                getMaxPredkosc() == ciezarowy.getMaxPredkosc() &&
                getLiczbaMiejsc() == ciezarowy.getLiczbaMiejsc() &&
                getLiczbaDrzwi() == ciezarowy.getLiczbaDrzwi() &&
                getLadownosc() == ciezarowy.getLadownosc() &&
                getLiczbaKol() == ciezarowy.getLiczbaKol();
    }
    @Override
    public int hashCode() { return Objects.hash(getRodzaj(), getNadwozie(), getMarka(), getModel(), getKolor(),
            getPojSilnika(), getMocSilnika(), getWaga(), getRokProd(), getPrzebieg(), getCena(), getMaxPredkosc(),
            getLiczbaMiejsc(), getLiczbaDrzwi(), getLadownosc(), getLiczbaKol()); }
}
