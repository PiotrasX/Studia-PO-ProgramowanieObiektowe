package Lab7.Zad5;

// Zad. 5 Utwórz i zapełnij listę List<Integer>. Utwórz drugą listę List<Integer>. Użyj ListIterator do przejrzenia
//        elementów pierwszej listy i wstawienia ich do listy drugiej, ale w odwrotnej kolejności.

import java.util.*;

public class Zadanie5
{
    public static void main(String[] args)
    {
        List<Integer> liczby1 = new ArrayList<>();
        liczby1.add(9);
        liczby1.add(6);
        liczby1.add(5);
        List<Integer> liczby2 = new ArrayList<>(List.of(1, 2, 3));

        ListIterator<Integer> iteracjaListyLiczby1 = liczby1.listIterator(liczby1.size());
        while (iteracjaListyLiczby1.hasPrevious())
        {
            int liczba = iteracjaListyLiczby1.previous();
            liczby2.add(liczba);
        }
        System.out.println(liczby2);
    }
}
