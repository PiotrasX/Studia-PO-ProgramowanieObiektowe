package Lab9.Zad2;

// Zad. 2 Napisz program, który pobierze od użytkownika ścieżkę do pliku i wyświetli zawartość pliku na ekranie
//        wraz z informacją ile linii znajduje się w pliku.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Zadanie2
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader odczyt = new BufferedReader(new FileReader("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\Zad1\\tekstowo.txt"));
            String tekst = ";";
            int linijek = 0;
            while (true)
            {
                tekst = odczyt.readLine();
                if (Objects.equals(tekst, null)) break;
                linijek++;
                System.out.println(tekst);
            }
            System.out.println("Linijek tekstu: " + linijek);
            odczyt.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nie odnaleziono ścieżki do pliku");
        }
        catch (IOException e)
        {
            System.out.println("Błąd odczytu pliku");
        }
    }
}
