package Lab9.Zad3;

// Zad. 3 Napisz program, który poprosi od użytkownika o nazwę pliku wyjściowego oraz o podanie swojej daty urodzenia
//        (osobno dzień, miesiąc i rok), a następnie zapisze te dane jako trzy osobne liczby binarnie.

import java.io.*;
import java.util.Scanner;

public class Zadanie3
{
    public static void main(String[] args)
    {
        try
        {
            DataOutputStream zapis = new DataOutputStream(new FileOutputStream("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\Zad3\\dataUrodzin.txt"));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj swoją datę urodzenia\nPodaj dzień: ");
            int tekst = scanner.nextInt();
            zapis.writeInt(tekst);
            System.out.print("Podaj miesiąc: ");
            tekst = scanner.nextInt();
            zapis.writeInt(tekst);
            System.out.print("Podaj rok: ");
            tekst = scanner.nextInt();
            zapis.writeInt(tekst);
            zapis.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nie odnaleziono ścieżki do pliku");
        }
        catch (IOException e)
        {
            System.out.println("Błąd zapisu pliku");
        }
    }
}
