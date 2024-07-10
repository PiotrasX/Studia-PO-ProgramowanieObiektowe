package Projekt.PlikiJava;

import java.util.Objects;

public class Motocykl extends Pojazd
{
    private NadwozieMotocykl nadwozie;
    private int liczbaKol;

    public Motocykl(Rodzaj rodzaj, NadwozieMotocykl nadwozie, Marka marka, String model, Kolor kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaKol)
    {
        super(rodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.nadwozie = nadwozie;
        this.liczbaKol = liczbaKol;
        this.pojazd = new Object[] {this.getRodzaj().toString(), this.getNadwozie(), this.getMarka().toString(),
                this.getModel(), this.getKolor().toString(), this.getPojSilnika(), this.getMocSilnika(),
                this.getWaga(), this.getRokProd(), this.getPrzebieg(), this.getCena(), this.getMaxPredkosc(),
                this.getLiczbaMiejsc(), this.getLiczbaKol()};
    }

    @Override
    public Object[] zwrocPojazd() { return pojazd; }

    @Override
    public String toString()
    {
        return "Rodzaj." + getRodzaj() + ";NadwozieMotocykl." + getNadwozie() + ";Marka." + getMarka() + ";" +
                getModel() + ";Kolor." + getKolor() + ";" + getPojSilnika() + ";" + getMocSilnika() + ";" +
                getMaxPredkosc() + ";" + getWaga() + ";" + getRokProd() + ";" + getPrzebieg() + ";" + getCena() + ";" +
                getLiczbaMiejsc() + ";" + getLiczbaKol() + "\n";
    }

    @Override
    public String getNadwozie() { return nadwozie.name(); }
    public void setNadwozie(NadwozieMotocykl nadwozie) { this.nadwozie = nadwozie; }
    public int getLiczbaKol() { return liczbaKol; }
    public void setLiczbaKol(int liczbaKol) { this.liczbaKol = liczbaKol; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        Motocykl motocykl = (Motocykl) obj;
        return Objects.equals(getRodzaj(), motocykl.getRodzaj()) &&
                Objects.equals(getNadwozie(), motocykl.getNadwozie()) &&
                Objects.equals(getMarka(), motocykl.getMarka()) &&
                Objects.equals(getModel(), motocykl.getModel()) &&
                Objects.equals(getKolor(), motocykl.getKolor()) &&
                Double.compare(getPojSilnika(), motocykl.getPojSilnika()) == 0 &&
                getMocSilnika() == motocykl.getMocSilnika() &&
                Double.compare(getWaga(), motocykl.getWaga()) == 0 &&
                getRokProd() == motocykl.getRokProd() &&
                getPrzebieg() == motocykl.getPrzebieg() &&
                getCena() == motocykl.getCena() &&
                getMaxPredkosc() == motocykl.getMaxPredkosc() &&
                getLiczbaMiejsc() == motocykl.getLiczbaMiejsc() &&
                getLiczbaKol() == motocykl.getLiczbaKol();
    }
    @Override
    public int hashCode() { return Objects.hash(getRodzaj(), getNadwozie(), getMarka(), getModel(), getKolor(),
            getPojSilnika(), getMocSilnika(), getWaga(), getRokProd(), getPrzebieg(), getCena(), getMaxPredkosc(),
            getLiczbaMiejsc(), getLiczbaKol()); }
}
