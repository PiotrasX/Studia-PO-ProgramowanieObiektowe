package Lab6.Zad1;

// Zad. 1 Napisz program, który pobierze od użytkownika liczbę i wyświetli jej pierwiastek.
//        Do obliczenia pierwiastka możesz użyć istniejącej metody java.lang.Math.sqrt().
//        Jeśli użytkownik poda liczbę ujemną rzuć wyjątek java.lang.IllegalArgumentException.
//        Obsłuż sytuację, w której użytkownik poda ciąg znaków, który nie jest liczbą.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie1
{
    public static void main(String[] args)
    {
        System.out.print("Podaj liczbę nieujemną: ");
        double liczba;
        try
        {
            liczba = inputInt();
            if (liczba < 0)
            {
                throw new IllegalArgumentException("Liczba musi być nieujemna: " + liczba);
            }
        }
        catch (InputMismatchException e)
        {
            liczba = 0;
        }
        double pierwiastek = Math.sqrt(liczba);
        System.out.println("Pierwiastek z liczby " + liczba + " to " + pierwiastek);
    }

    public static int inputInt()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
