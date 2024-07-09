package Lab8.Zad4;

// Zad. 4 Napisz prostą symulację pójścia na zakupy:
//         • utwórz tablicę String zawierającą 10 nazw produktów dostępnych w sklepie,
//         • po wejściu do sklepu zapełnij kosz (będący stosem - użyj klasy z poprzedniego zadania) losową ilością
//           losowych towarów (koszyk pomieści maksymalnie 15 przedmiotów),
//         • umieść siebie w kolejce (Queue) na losową pozycję (maksymalna ilość osób w kolejce wynosi 10),
//         • gdy dojdziesz do kasy wypisz produkty znajdujące się w koszyku,

import Lab8.Zad3.Stos;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Zadanie4
{
    public static void main(String[] args)
    {
        String[] produkty = {"mleko", "ser biały", "ser żółty", "szynka", "parówki", "płatki kukurydzane", "chleb",
                 "papryka", "kukurydza w puszcze", "mandarynka"};
        Stos koszyk = new Stos();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(15) + 1; i++)
        {
            koszyk.push(produkty[random.nextInt(10)]);
        }
        Queue<Integer> kolejka = new ArrayDeque<>();
        int ktora = random.nextInt(10) + 1;
        int i = 1;
        while (i < ktora)
        {
            if ((ktora - i == 9) ||(ktora - i == 8) || (ktora - i == 7) || (ktora - i == 6) || (ktora - i == 5))
            {
                System.out.println("Przed tobą jeszcze " + (ktora - i) + " osób w kolejce");
            }
            else if ((ktora - i == 4) || (ktora - i == 3) || (ktora - i == 2))
            {
                System.out.println("Przed tobą jeszcze " + (ktora - i) + " osoby w kolejce");
            }
            else if ((ktora - i == 1))
            {
                System.out.println("Przed tobą jeszcze " + (ktora - i) + " osoba w kolejce");
            }
            i++;
        }
        System.out.print("Twoja kolej, produkty w twoim koszyku: ");
        System.out.println(koszyk.toString());
    }
}
