package Projekt.PlikiJava;

import java.util.Objects;

public class Autobus extends Pojazd
{
    private NadwozieAutobus nadwozie;
    private int liczbaDrzwi;
    private int pojBagaz;
    private int liczbaKol;

    public Autobus(Rodzaj rodzaj, NadwozieAutobus nadwozie, Marka marka, String model, Kolor kolor, double pojSilnika,
                     int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                     int liczbaDrzwi, int pojBagaz, int liczbaKol)
    {
        super(rodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.nadwozie = nadwozie;
        this.liczbaDrzwi = liczbaDrzwi;
        this.pojBagaz = pojBagaz;
        this.liczbaKol = liczbaKol;
        this.pojazd = new Object[] {this.getRodzaj().toString(), this.getNadwozie(), this.getMarka().toString(),
                this.getModel(), this.getKolor().toString(), this.getPojSilnika(), this.getMocSilnika(),
                this.getWaga(), this.getRokProd(), this.getPrzebieg(), this.getCena(), this.getMaxPredkosc(),
                this.getLiczbaMiejsc(), this.getLiczbaDrzwi(), this.getPojBagaz(), this.getLiczbaKol()};
    }

    @Override
    public Object[] zwrocPojazd() { return pojazd; }

    @Override
    public String toString()
    {
        return "Rodzaj." + getRodzaj() + ";NadwozieAutobus." + getNadwozie() + ";Marka." + getMarka() + ";" +
                getModel() + ";Kolor." + getKolor() + ";" + getPojSilnika() + ";" + getMocSilnika() + ";" +
                getMaxPredkosc() + ";" + getWaga() + ";" + getRokProd() + ";" + getPrzebieg() + ";" + getCena() + ";" +
                getLiczbaMiejsc() + ";" + getLiczbaDrzwi() + ";" + getPojBagaz() + ";" + getLiczbaKol() + "\n";
    }

    @Override
    public String getNadwozie() { return nadwozie.name(); }
    public void setNadwozie(NadwozieAutobus nadwozie) { this.nadwozie = nadwozie; }
    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public int getPojBagaz() { return pojBagaz; }
    public void setPojBagaz(int pojBagaz) { this.pojBagaz = pojBagaz; }
    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        Autobus autobus = (Autobus) obj;
        return Objects.equals(getRodzaj(), autobus.getRodzaj()) &&
                Objects.equals(getNadwozie(), autobus.getNadwozie()) &&
                Objects.equals(getMarka(), autobus.getMarka()) &&
                Objects.equals(getModel(), autobus.getModel()) &&
                Objects.equals(getKolor(), autobus.getKolor()) &&
                Double.compare(getPojSilnika(), autobus.getPojSilnika()) == 0 &&
                getMocSilnika() == autobus.getMocSilnika() &&
                Double.compare(getWaga(), autobus.getWaga()) == 0 &&
                getRokProd() == autobus.getRokProd() &&
                getPrzebieg() == autobus.getPrzebieg() &&
                getCena() == autobus.getCena() &&
                getMaxPredkosc() == autobus.getMaxPredkosc() &&
                getLiczbaMiejsc() == autobus.getLiczbaMiejsc() &&
                getLiczbaDrzwi() == autobus.getLiczbaDrzwi() &&
                getPojBagaz() == autobus.getPojBagaz() &&
                getLiczbaKol() == autobus.getLiczbaKol();
    }
    @Override
    public int hashCode() { return Objects.hash(getRodzaj(), getNadwozie(), getMarka(), getModel(), getKolor(),
            getPojSilnika(), getMocSilnika(), getWaga(), getRokProd(), getPrzebieg(), getCena(), getMaxPredkosc(),
            getLiczbaMiejsc(), getLiczbaDrzwi(), getPojBagaz(), getLiczbaKol()); }
}
