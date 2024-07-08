package Lab3.Zad4;

// Zad. 4 Napisz program umożliwiający wprowadzanie 10-ciu liczb.
//        Dla wprowadzonych liczb wykonaj odpowiednie algorytmy:
//          • oblicz sumę elementów tablicy.
//          • oblicz iloczyn elementów tablicy.
//          • wyznacz wartość średnią.
//          • wyznacz wartość minimalną.
//          • wyznacz wartość maksymalną.
//        Wyniki działania algorytmów wyświetlaj na konsoli. Utwórz odpowiednie menu.

import java.util.Scanner;

public class Zadanie4
{
    public static void main(String[] args) { Run(); }

    public static void Run()
    {
        int ileLiczb = WprowadzLiczbe();
        double[] tab = WprowadzDoTabeli(ileLiczb);
        while (true)
        {
            Menu();
            int wybor = InputInt();
            switch (wybor)
            {
                case 1 -> Suma(tab);
                case 2 -> Iloczyn(tab);
                case 3 -> Srednia(tab);
                case 4 -> Min(tab);
                case 5 -> Maks(tab);
                case 6 -> Zakoncz();
                default -> Default();
            }
        }
    }

    public static int WprowadzLiczbe()
    {
        System.out.print("\t\t\tPodaj, ile chcesz wprowadzić liczb: ");
        int ileLiczb = InputInt();
        while (ileLiczb <= 0)
        {
            System.out.println("\t\t\tTablica musi zawierać przynajmniej jeden element!");
            System.out.print("\t\t\tPodaj, ile chcesz wprowadzić liczb: ");
            ileLiczb = InputInt();
        }
        return ileLiczb;
    }

    public static double[] WprowadzDoTabeli(int ileLiczb)
    {
        double[] tab = new double[ileLiczb];
        int x = 0;
        while (x < ileLiczb)
        {
            System.out.print("\t\t\tPodaj liczbe rzeczywistą dla " + x + " indeksu: ");
            tab[x] = InputDouble();
            x += 1;
        }
        return tab;
    }

    public static void Menu()
    {
        System.out.println("\n\t\t\t==============================");
        System.out.println("\t\t\t=======   MENU OPCJI   =======");
        System.out.println("\t\t\t==============================");
        System.out.println("\t\t\t1. Suma elementów");
        System.out.println("\t\t\t2. Iloczyn elementów");
        System.out.println("\t\t\t3. Wartość średnia");
        System.out.println("\t\t\t4. Wartość minimalna");
        System.out.println("\t\t\t5. Wartość maksymalna");
        System.out.println("\t\t\t6. Wyjście z programu");
        System.out.println("\t\t\t------------------------------");
        System.out.print("\t\t\tWybierz operacje: ");
    }

    public static void Suma(double[] tab)
    {
        double suma = 0;
        for(double i : tab)
        {
            suma += i;
        }
        System.out.println("\t\t\tSuma elementów tablicy wynosi: " + suma);
    }

    public static void Iloczyn(double[] tab)
    {
        double iloczyn = 1;
        for(double i : tab)
        {
            iloczyn *= i;
        }
        System.out.println("\t\t\tIloczyn elementów tablicy wynosi: " + iloczyn);
    }

    public static void Srednia(double[] tab)
    {
        double srednia = 0;
        for(double i : tab)
        {
            srednia += i;
        }
        srednia /= tab.length;
        System.out.println("\t\t\tWartość średnia w tablicy wynosi: " + srednia);
    }

    public static void Min(double[] tab)
    {
        double min = tab[0];
        for(double i : tab)
        {
            if (i < min) { min = i; }
        }
        System.out.println("\t\t\tWartość minimalna w tablicy wynosi: " + min);
    }

    public static void Maks(double[] tab)
    {
        double maks = tab[0];
        for(double i : tab)
        {
            if (i > maks) { maks = i; }
        }
        System.out.println("\t\t\tWartość maksymalna w tablicy wynosi: " + maks);
    }

    public static void Zakoncz()
    {
        System.out.print("\t\t\tCzy na pewno chcesz wyjść z programu? ( t | T | tak | Tak | TAK ): ");
        String znak = InputString();
        if (znak.equals("t") || znak.equals("T") || znak.equals("tak") || znak.equals("Tak") || znak.equals("TAK"))
        {
            System.out.println("\t\t\tKoniec programu");
            System.exit(0);
        }
        else
        {
            System.out.println("\t\t\tAnulowano wyjście");
        }
    }

    public static void Default()
    {
        System.out.println("\t\t\tBłędne dane, koniec programu");
        System.exit(0);
    }

    public static double InputDouble()
    {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
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
