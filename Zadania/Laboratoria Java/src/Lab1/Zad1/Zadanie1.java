package Lab1.Zad1;

// Zad. 1 Napisz metodę, która zwróci twoje imię oraz aktualny wiek.

public class Zadanie1
{
    public static void main(String[] args)
    {
        System.out.println(Imie());
        System.out.println(Wiek());
    }

    public static String Imie() { return "Piotr"; }

    public static int Wiek() { return 20; }
}
