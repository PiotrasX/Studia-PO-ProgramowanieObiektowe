package Lab9.Zad4;

// Zad. 4 Napisz program, który pobierze od użytkownika ścieżkę do pliku binarnego z datą urodzenia,
//        a następnie wyświetli ją na ekran.

import java.io.*;

public class Zadanie4
{
    public static void main(String[] args)
    {
        StringBuilder calyTekst = new StringBuilder();
        try
        {
            System.out.print("Twoja data urodzin: ");
            DataInputStream zapis = new DataInputStream(new FileInputStream("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\Zad3\\dataUrodzin.txt"));
            int tekst = 0;
            int linia = 1;
            while (true)
            {
                tekst = zapis.readInt();
                if (tekst == 0) break;
                if (linia == 2 && tekst < 10)
                {
                    calyTekst.append("0").append(tekst).append(".");
                    continue;
                }
                calyTekst.append(tekst).append(".");
                linia++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nie odnaleziono ścieżki do pliku");
        }
        catch (IOException ignored) {}
        calyTekst = new StringBuilder(calyTekst.substring(0, calyTekst.length() - 1));
        System.out.println(calyTekst);
    }
}
