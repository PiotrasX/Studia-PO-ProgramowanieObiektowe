package Lab8.Zad2;

// Zad. 2 Napisz klasę o nazwie Command, która zawiera ciąg znaków String i metodę operation(), która go wypisuje.
//        Napisz drugą klasę, z metodą wypełniającą kolejkę Queue obiektami klasy Command i zwracającą wypełniony
//        kontener. Przekaż kontener do metody z trzeciej klasy: metoda ma konsumować obiekty z kolejki Queue,
//        wywołując dla każdego z nich metodę operation().

import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Zadanie2
{
    public static void main(String[] args)
    {
        Fill napisy = new Fill();
        while (true)
        {
            menu();
            String wybor = inputString();
            if (Objects.equals(wybor, "1"))
            {
                napisy.wypelnij();
            }
            else if (Objects.equals(wybor, "2"))
            {
                System.out.println("\nElementy w kolejce:");
                Queue<Command> kolejka = napisy.zwroc();
                for (Command item : kolejka)
                {
                    item.operation();
                }
                break;
            }
            else
            {
                System.out.println("Nie istnieje taka opcja wyboru");
            }
        }
    }

    public static void menu()
    {
        System.out.println();
        System.out.println("Jaką chcesz wykonać operację?");
        System.out.println("1. Dodaj obiekt do kolejki");
        System.out.println("2. Zwróć i wypisz elementy kolejki");
        System.out.print("Podaj odpowiednią operację: ");
    }

    public static String inputString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
