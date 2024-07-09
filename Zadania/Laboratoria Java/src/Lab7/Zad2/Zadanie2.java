package Lab7.Zad2;

// Zad. 2 Napisz program, który będzie pobierał od użytkownika imiona par, dopóki nie wprowadzi imienia „-”,
//        następnie poproś użytkownika o podanie jednego z wcześniej wprowadzonych imion i wyświetl imię
//        odpowiadającego mu partnera.

import java.util.*;

public class Zadanie2
{
    public static void main(String[] args)
    {
        Set<ParyImion> imiona = new HashSet<>();
        Scanner skaner = new Scanner(System.in);
        while (true)
        {
            ParyImion para = new ParyImion();
            System.out.print("Podaj imię 1: ");
            para.setImie1(skaner.nextLine());
            if (Objects.equals(para.getImie1(), "-")) { break; }
            System.out.print("Podaj imię 2: ");
            para.setImie2(skaner.nextLine());
            if (Objects.equals(para.getImie2(), "-")) { break; }
            imiona.add(para);
            System.out.println();
        }
        System.out.println();
        System.out.print("Podaj imie do sprawdzenia: ");
        String sprawdzImie = skaner.nextLine();
        int czyJest = 0;
        for (ParyImion para : imiona)
        {
            if (sprawdzImie.equals(para.getImie1())) { System.out.println("Imię drugiej połówki: " + para.getImie2()); czyJest = 1; break; }
            else if (sprawdzImie.equals(para.getImie2())) { System.out.println("Imię drugiej połówki: " + para.getImie1()); czyJest = 1; break; }
        }
        if (czyJest == 0) { System.out.println("Brak imienia drugiej połówki dla podanego imienia do sprawdzenia"); }
    }
}
