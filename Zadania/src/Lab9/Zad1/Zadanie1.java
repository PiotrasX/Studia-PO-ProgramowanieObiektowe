package Lab9.Zad1;

// Zad. 1 Napisz program, który pobierze od użytkownika ścieżkę do pliku tekstowego oraz kilka linijek tekstu
//        (dopóki użytkownik nie wprowadzi „-” jako linijki) i zapisze je do pliku tekstowego. Do wykonania
//        tego zadania może Ci się przydać metoda System.lineSeparator() zwracająca znak nowej linii
//        (jeśli chciałbyś oddzielić linie wprowadzone przez użytkownika).

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class Zadanie1
{
    public static void main(String[] args)
    {
        try
        {
            PrintWriter zapis = new PrintWriter("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\Zad1\\tekstowo.txt");
            Scanner scanner = new Scanner(System.in);
            String tekst = ";";
            while (!Objects.equals(tekst, "-"))
            {
                System.out.print("Podaj tekst, jaki chcesz wprowadzić do pliku: ");
                tekst = scanner.nextLine();
                if (Objects.equals(tekst, "-")) break;
                zapis.println(tekst);
            }
            zapis.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nie odnaleziono ścieżki do pliku");
        }
    }
}
