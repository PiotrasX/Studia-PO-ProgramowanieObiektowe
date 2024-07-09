package Lab4.Zad7;

// Zad. 7 Napisz program, w którym zdefiniujesz dwie tablice przechowujące wartości typu String.
//        Zainicjalizuj obie tablice takimi samymi wartościami, w takiej samej kolejności.
//        Napisz kod, który porówna obie tablice i odpowie na pytanie, czy są one takie same.

import java.util.Arrays;
import java.util.Scanner;

public class Zadanie7
{
    public static void main(String[] args)
    {
        int ileSlow = WprowadzLiczbe();
        System.out.println("\t\t\tWprowadź wyrazy dla tablicy1: ");
        String[] tabSlowa1 = WprowadzDoTabeli(ileSlow);
        // String[] tabSlowa2 = Arrays.copyOf(tabSlowa1, tabSlowa1.length);
        System.out.println("\t\t\tWprowadź wyrazy dla tablicy2: ");
        String[] tabSlowa2 = WprowadzDoTabeli(ileSlow);
        Porownywanie(tabSlowa1, tabSlowa2);
    }

    public static int WprowadzLiczbe()
    {
        System.out.print("\t\t\tPodaj, ile chcesz wprowadzić słów: ");
        int ileSlow = InputInt();
        while (ileSlow <= 0)
        {
            System.out.println("\t\t\tTablica musi zawierać przynajmniej jeden element!");
            System.out.print("\t\t\tPodaj, ile chcesz wprowadzić słów: ");
            ileSlow = InputInt();
        }
        return ileSlow;
    }

    public static String[] WprowadzDoTabeli(int ileSlow)
    {
        String[] tab = new String[ileSlow];
        for (int x = 0; x < ileSlow; x++)
        {
            System.out.print("\t\t\tPodaj " + (x+1) + " wyraz: ");
            tab[x] = InputString();
        }
        return tab;
    }

    public static void Porownywanie(String[] tab1, String[] tab2)
    {
        System.out.println("\t\t\tCzy podane tablice są równe?: " + Arrays.equals(tab1, tab2));
    }

    public static int InputInt()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String InputString()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
