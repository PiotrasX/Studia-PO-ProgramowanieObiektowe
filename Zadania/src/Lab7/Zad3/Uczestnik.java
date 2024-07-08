package Lab7.Zad3;

import java.util.Objects;

public class Uczestnik
{
    private int ID, wiek;
    private String imie;

    public Uczestnik(int ID, int wiek, String imie)
    {
        this.ID = ID;
        this.wiek = wiek;
        this.imie = imie;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public int getWiek() { return wiek; }
    public void setWiek(int wiek) { this.wiek = wiek; }
    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }

    @Override
    public String toString()
    {
        return "ID=" + ID +
                ", wiek=" + wiek +
                ", imie='" + imie + '\'';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return ID == uczestnik.ID && wiek == uczestnik.wiek && Objects.equals(imie, uczestnik.imie);
    }

    @Override
    public int hashCode() { return Objects.hash(ID, wiek, imie); }
}
