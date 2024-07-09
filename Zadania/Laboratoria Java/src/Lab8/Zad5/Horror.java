package Lab8.Zad5;

public class Horror extends Film
{
    private final String typ;

    public Horror(String typ, int czasTrwania, String tytul, boolean czyObejrzany)
    {
        super(czasTrwania, tytul, czyObejrzany);
        this.typ = typ;
    }

    public String getTyp() { return typ; }

    public void wypisz()
    {
        System.out.println("Typ filmu: " + getTyp() + ", Tytuł: " + getTytul() + ", Czas trwania: " + getCzasTrwania() +
                " minut, Czy został obejrzany: " + isCzyObejrzany());
    }
}
