package Lab1.Zad3;

// Zad. 3 Napisz metodę, która jako argument przyjmuje liczbę i zwraca true, jeśli liczba jest parzysta.

import java.util.Scanner;

public class Zadanie3
{
    public static void main(String[] args)
    {
        int x = InputInt();
        System.out.println("Czy liczba " + x + " jest parzysta? - " + CzyParzysta(x));
    }

    public static boolean CzyParzysta(int x)
    {
        return ((x % 2) == 0);
    }

    public static int InputInt()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbe całkowitą: ");
        return input.nextInt();
    }
}
