package Lab7.Zad3;

// Zad. 3 Napisz klasę przechowującą informacje o uczestnikach wydarzenia (ID, imię oraz jego wiek).
//        Zaimplementować metodę toString(), aby wyświetlać informację o uczestniku oraz metody equals() i hashCode()
//        (metody do porównywania obiektów). Do przechowywania uczestników należy użyć listy.
//        Ponadto zaproponować metodę pozwalającą na filtrowanie osób niepełnoletnich.
//        Zaproponować rozwiązanie z użyciem LinkedList oraz ArrayList.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zadanie3
{
    public static void main(String[] args)
    {
        List<Uczestnik> uczestnikList = new ArrayList<>();
        Uczestnik uczestnik1 = new Uczestnik(1, 15, "Piotr");
        uczestnikList.add(uczestnik1);
        Uczestnik uczestnik2 = new Uczestnik(2, 18, "Marcin");
        uczestnikList.add(uczestnik2);
        Uczestnik uczestnik3 = new Uczestnik(3, 17, "Monika");
        uczestnikList.add(uczestnik3);
        Uczestnik uczestnik4 = new Uczestnik(4, 23, "Paulina");
        uczestnikList.add(uczestnik4);
        Uczestnik uczestnik5 = new Uczestnik(5, 27, "Katarzyna");
        uczestnikList.add(uczestnik5);
        Uczestnik uczestnik6 = new Uczestnik(6, 35, "Michał");
        uczestnikList.add(uczestnik6);
        Uczestnik uczestnik7 = new Uczestnik(7, 42, "Małgorzata");
        uczestnikList.add(uczestnik7);
        Uczestnik uczestnik8 = new Uczestnik(8, 54, "Alina");
        uczestnikList.add(uczestnik8);
        Uczestnik uczestnik9 = new Uczestnik(9, 13, "Paulina");
        uczestnikList.add(uczestnik9);
        Uczestnik uczestnik10 = new Uczestnik(10, 20, "Maurycy");
        uczestnikList.add(uczestnik10);

        System.out.println("Lista uczestników: ");
        for (Uczestnik uczestnik : uczestnikList)
        {
            System.out.println(uczestnik.toString());
        }

        System.out.println();
        LinkedList<Uczestnik> uczestnikNiepelnoletniList = new LinkedList<>();
        for (Uczestnik uczestnik : uczestnikList)
        {
            if (uczestnik.getWiek() < 18)
            {
                uczestnikNiepelnoletniList.add(uczestnik);
            }
        }
        System.out.println("Lista uczestników niepełnoletnich: ");
        for (Uczestnik uczestnik : uczestnikNiepelnoletniList)
        {
            System.out.println(uczestnik.toString());
        }
    }
}
