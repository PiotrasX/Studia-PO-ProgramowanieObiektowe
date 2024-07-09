package Lab7.Zad4;

// Zad. 4 Utwórz dowolną klasę, a potem zainicjalizowaną tablicę obiektów tej klasy. Zawartością tablicy wypełnij
//        listę List. Wyłuskaj z niej fragment listy metodą subList(), a następnie usuń tę podlistę z oryginalnej listy.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadanie4
{
    public static void main(String[] args)
    {
        Samochod[] tab = new Samochod[10];
        tab[0] = new Samochod("Honda", "Accord", 2005);
        tab[1] = new Samochod("Ford", "Fokus", 2007);
        tab[2] = new Samochod("Fiat", "Uno", 2007);
        tab[3] = new Samochod("Renault", "Master", 2023);
        tab[4] = new Samochod("Fiat", "Panda", 1999);
        tab[5] = new Samochod("Nissan", "Nuke", 2004);
        tab[6] = new Samochod("Honda", "Civic", 2009);
        tab[7] = new Samochod("Hyundai", "i30", 2016);
        tab[8] = new Samochod("Toyota", "Corolla", 2012);
        tab[9] = new Samochod("Isuzu", "Ducato", 1995);
        List<Samochod> samochodList = new ArrayList<>(Arrays.asList(tab));

        System.out.println("Oryginalna lista:");
        for (Samochod samochod : samochodList)
        {
            samochod.opis();
        }
        samochodList.subList(2,8).clear();
        System.out.println();
        System.out.println("Zredukowana lista:");
        for (Samochod samochod : samochodList)
        {
            samochod.opis();
        }
    }
}
