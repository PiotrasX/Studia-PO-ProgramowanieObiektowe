package Lab7.Zad4;

public class Samochod
{
    public String nazwa, rodzaj;
    public int rokProd;

    public Samochod(String nazwa, String rodzaj, int rokProd)
    {
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.rokProd = rokProd;
    }

    public void opis()
    {
        System.out.println("Nazwa i rodzaj: " + nazwa + " " + rodzaj + ", rok produkcji: " + rokProd);
    }
}
