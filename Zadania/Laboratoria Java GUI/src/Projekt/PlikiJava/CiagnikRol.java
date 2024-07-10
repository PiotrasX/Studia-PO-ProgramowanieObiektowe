package Projekt.PlikiJava;

import java.util.Objects;

public class CiagnikRol extends Pojazd
{
    private NadwozieCiagnikRol nadwozie;
    private int liczbaDrzwi;
    private int maxMasaCiagniecia;

    public CiagnikRol(Rodzaj rodzaj, NadwozieCiagnikRol nadwozie, Marka marka, String model, Kolor kolor, double pojSilnika,
                      int mocSilnika, int maxPredkosc, double waga, int rokProd, int przebieg, int cena, int liczbaMiejsc,
                      int liczbaDrzwi, int maxMasaCiagniecia)
    {
        super(rodzaj, marka, model, kolor, pojSilnika, mocSilnika, maxPredkosc, waga, rokProd, przebieg, cena, liczbaMiejsc);
        this.nadwozie = nadwozie;
        this.liczbaDrzwi = liczbaDrzwi;
        this.maxMasaCiagniecia = maxMasaCiagniecia;
        this.pojazd = new Object[] {this.getRodzaj().toString(), this.getNadwozie(), this.getMarka().toString(),
                this.getModel(), this.getKolor().toString(), this.getPojSilnika(), this.getMocSilnika(),
                this.getWaga(), this.getRokProd(), this.getPrzebieg(), this.getCena(), this.getMaxPredkosc(),
                this.getLiczbaMiejsc(), this.getLiczbaDrzwi(), this.getMaxMasaCiagniecia()};
    }

    @Override
    public Object[] zwrocPojazd() { return pojazd; }

    @Override
    public String toString()
    {
        return "Rodzaj." + getRodzaj() + ";NadwozieCiagnikRol." + getNadwozie() + ";Marka." + getMarka() + ";" +
                getModel() + ";Kolor." + getKolor() + ";" + getPojSilnika() + ";" + getMocSilnika() + ";" +
                getMaxPredkosc() + ";" + getWaga() + ";" + getRokProd() + ";" + getPrzebieg() + ";" + getCena() + ";" +
                getLiczbaMiejsc() + ";" + getLiczbaDrzwi() + ";" + getMaxMasaCiagniecia() + "\n";
    }

    @Override
    public String getNadwozie() { return nadwozie.name(); }
    public void setNadwozie(NadwozieCiagnikRol nadwozie) { this.nadwozie = nadwozie; }
    public int getLiczbaDrzwi() { return liczbaDrzwi; }
    public void setLiczbaDrzwi(int liczbaDrzwi) { this.liczbaDrzwi = liczbaDrzwi; }
    public int getMaxMasaCiagniecia() { return maxMasaCiagniecia; }
    public void setMaxMasaCiagniecia(int maxMasaCiagniecia) { this.maxMasaCiagniecia = maxMasaCiagniecia; }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        CiagnikRol ciagnikRol = (CiagnikRol) obj;
        return Objects.equals(getRodzaj(), ciagnikRol.getRodzaj()) &&
                Objects.equals(getNadwozie(), ciagnikRol.getNadwozie()) &&
                Objects.equals(getMarka(), ciagnikRol.getMarka()) &&
                Objects.equals(getModel(), ciagnikRol.getModel()) &&
                Objects.equals(getKolor(), ciagnikRol.getKolor()) &&
                Double.compare(getPojSilnika(), ciagnikRol.getPojSilnika()) == 0 &&
                getMocSilnika() == ciagnikRol.getMocSilnika() &&
                Double.compare(getWaga(), ciagnikRol.getWaga()) == 0 &&
                getRokProd() == ciagnikRol.getRokProd() &&
                getPrzebieg() == ciagnikRol.getPrzebieg() &&
                getCena() == ciagnikRol.getCena() &&
                getMaxPredkosc() == ciagnikRol.getMaxPredkosc() &&
                getLiczbaMiejsc() == ciagnikRol.getLiczbaMiejsc() &&
                getLiczbaDrzwi() == ciagnikRol.getLiczbaDrzwi() &&
                getMaxMasaCiagniecia() == ciagnikRol.getMaxMasaCiagniecia();
    }
    @Override
    public int hashCode() { return Objects.hash(getRodzaj(), getNadwozie(), getMarka(), getModel(), getKolor(),
            getPojSilnika(), getMocSilnika(), getWaga(), getRokProd(), getPrzebieg(), getCena(), getMaxPredkosc(),
            getLiczbaMiejsc(), getLiczbaDrzwi(), getMaxMasaCiagniecia()); }
}
