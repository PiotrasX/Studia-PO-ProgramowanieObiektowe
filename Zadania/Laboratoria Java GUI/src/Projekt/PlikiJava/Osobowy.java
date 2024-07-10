package Projekt.PlikiJava;

import java.util.Objects;

public class Osobowy extends Pojazd
{
    private NadwozieOsobowy nadwozie;
    private int liczbaDrzwi;
    private int pojBagaz;

    public Osobowy(Rodzaj rodzaj, NadwozieOsobowy nadwozie, Marka marka, String model, Kolor kolor, double pojSilnika,
                   int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                   int liczbaDrzwi, int pojBagaz)
    {
        super(rodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.nadwozie = nadwozie;
        this.liczbaDrzwi = liczbaDrzwi;
        this.pojBagaz = pojBagaz;
        this.pojazd = new Object[] {this.getRodzaj().toString(), this.getNadwozie(), this.getMarka().toString(),
                this.getModel(), this.getKolor().toString(), this.getPojSilnika(), this.getMocSilnika(),
                this.getWaga(), this.getRokProd(), this.getPrzebieg(), this.getCena(), this.getMaxPredkosc(),
                this.getLiczbaMiejsc(), this.getLiczbaDrzwi(), this.getPojBagaz()};
    }

    @Override
    public Object[] zwrocPojazd() { return pojazd; }

    @Override
    public String toString()
    {
        return "Rodzaj." + getRodzaj() + ";NadwozieOsobowy." + getNadwozie() + ";Marka." + getMarka() + ";" +
                getModel() + ";Kolor." + getKolor() + ";" + getPojSilnika() + ";" + getMocSilnika() + ";" +
                getMaxPredkosc() + ";" + getWaga() + ";" + getRokProd() + ";" + getPrzebieg() + ";" + getCena() + ";" +
                getLiczbaMiejsc() + ";" + getLiczbaDrzwi() + ";" + getPojBagaz() + "\n";
    }

    @Override
    public String getNadwozie() { return nadwozie.name(); }
    public void setNadwozie(NadwozieOsobowy nadwozie) { this.nadwozie = nadwozie; }
    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public int getPojBagaz() { return pojBagaz; }
    public void setPojBagaz(int pojBagaz) { this.pojBagaz = pojBagaz; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        Osobowy osobowy = (Osobowy) obj;
        return Objects.equals(getRodzaj(), osobowy.getRodzaj()) &&
                Objects.equals(getNadwozie(), osobowy.getNadwozie()) &&
                Objects.equals(getMarka(), osobowy.getMarka()) &&
                Objects.equals(getModel(), osobowy.getModel()) &&
                Objects.equals(getKolor(), osobowy.getKolor()) &&
                Double.compare(getPojSilnika(), osobowy.getPojSilnika()) == 0 &&
                getMocSilnika() == osobowy.getMocSilnika() &&
                Double.compare(getWaga(), osobowy.getWaga()) == 0 &&
                getRokProd() == osobowy.getRokProd() &&
                getPrzebieg() == osobowy.getPrzebieg() &&
                getCena() == osobowy.getCena() &&
                getMaxPredkosc() == osobowy.getMaxPredkosc() &&
                getLiczbaMiejsc() == osobowy.getLiczbaMiejsc() &&
                getLiczbaDrzwi() == osobowy.getLiczbaDrzwi() &&
                getPojBagaz() == osobowy.getPojBagaz();
    }
    @Override
    public int hashCode() { return Objects.hash(getRodzaj(), getNadwozie(), getMarka(), getModel(), getKolor(),
            getPojSilnika(), getMocSilnika(), getWaga(), getRokProd(), getPrzebieg(), getCena(), getMaxPredkosc(),
            getLiczbaMiejsc(), getLiczbaDrzwi(), getPojBagaz()); }
}
