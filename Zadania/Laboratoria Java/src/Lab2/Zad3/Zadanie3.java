package Lab2.Zad3;

// Zad. 3 Dany jest ciąg n liczb (n>0), napisz program pozwalający
//        na obliczenie sumy wszystkich liczb parzystych w danym ciągu.

import java.util.Arrays;
import java.util.Scanner;

public class Zadanie3
{
    public static void main(String[] args)
    {
        int ileLiczb = WprowadzLiczbe();
        int[] liczby = WczytywanieDoTabeli(ileLiczb);
        System.out.println("Wprowadzona tabela liczb: " + Arrays.toString(liczby));
        SumaParzystych(liczby);
    }

    public static int WprowadzLiczbe()
    {
        System.out.print("Podaj, ile chcesz wprowadzić liczb: ");
        int liczba = InputInt();
        while (liczba <= 0)
        {
            System.out.println("Tablica musi zawierać przynajmniej jeden element!");
            System.out.print("Podaj, ile chcesz wprowadzić liczb: ");
            liczba = InputInt();
        }
        System.out.println();
        return liczba;
    }

    public static void SumaParzystych(int[] tab)
    {
        int sumaParz = 0;
        for(int x : tab)
        {
            if ((x % 2) == 0) { sumaParz += x; }
        }
        System.out.println("Suma wszystkich liczb parzystych wynosi: " + sumaParz);
    }

    public static int[] WczytywanieDoTabeli(int i)
    {
        int[] tab = new int[i];
        int x = 0;
        while (x < i)
        {
            System.out.print("Podaj liczbe całkowitą dla " + (x + 1) + " pozycji: ");
            tab[x] = InputInt();
            x += 1;
        }
        System.out.println();
        return tab;
    }

    public static int InputInt()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
