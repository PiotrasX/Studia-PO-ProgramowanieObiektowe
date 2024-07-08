package Lab7.Zad1;

// Zad. 1 Napisz program, który będzie pobierał od użytkownika imiona. Program powinien pozwolić użytkownikowi
//        na wprowadzenie dowolnej liczby imion (wprowadzenie „-” jako imienia przerwie wprowadzanie).
//        Na zakończenie wypisz liczbę unikalnych imion.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zadanie1
{
    public static void main(String[] args)
    {
        Set<String> imiona = new HashSet<>();
        String imie = "";
        Scanner skaner = new Scanner(System.in);
        while (!imie.equals("-"))
        {
            System.out.print("Podaj imię: ");
            imie = skaner.nextLine();
            imiona.add(imie);
        }
        imiona.remove("-");
        System.out.println("\nUnikalne imiona:");
        for (String wartosc : imiona)
        {
            System.out.println(wartosc);
        }
    }
}
