package Lab8.Zad5;

// Zad. 5 Wykonaj poniższe polecenia:
//        1. Napisz klasę Film zawierającą prywatne pole czasTrwania, tytul oraz czyObejrzany (wartość true, gdy film
//           został obejrzany). Dodaj konstruktor i odpowiednie metody obsługujące pola.
//        2. Stwórz dwie klasy dziedziczące z klasy Film, np. Horror i Komedia. Każda z nich ma zawierać pole finalne
//           typ (wskazujące na typ filmu). Dodaj konstruktory i odpowiednie metody obsługujące pola. Dodaj metody
//           wypisujące wszystkie dane odnośnie filmu.
//        3. W głównej klasie stwórz mapę prywatnaKolekcja, gdzie kluczem będzie numer egzemplarza, a wartością
//           obiekt Film. Dodaj kilka elementów do utworzonej mapy.
//        4. Za pomocą iteratora wypisz posiadane filmy w kolekcji.
//
//        Przykład:
//        "Nr (nr w kolekcji), Tytul: (tytul filmu), Czas trwania: (czas), Obejrzany: (tak/nie), Typ: (gatunek filmu)".

import java.util.HashMap;
import java.util.Map;

public class Zadanie5
{
    public static void main(String[] args)
    {
        Map<Integer, Film> prywatnaKolekcja = new HashMap<>();
        prywatnaKolekcja.put(1, new Horror("horror", 126, "Piła 2", true));
        prywatnaKolekcja.put(2, new Horror("horror", 133, "Nie oddychaj", true));
        prywatnaKolekcja.put(3, new Komedia("komedia", 92, "Randka w ciemno", false));
        prywatnaKolekcja.put(4, new Horror("horror", 107, "Maska 4", false));
        prywatnaKolekcja.put(5, new Komedia("komedia", 89, "Baby yoga", true));
        prywatnaKolekcja.put(6, new Komedia("komedia", 111, "Miłość w rytmie disco", false));
        prywatnaKolekcja.put(7, new Horror("horror", 130, "Szklane odłamki", false));
        for (Map.Entry<Integer, Film> film : prywatnaKolekcja.entrySet())
        {
            System.out.print("Numer egzemplarza: " + film.getKey() + ", ");
            film.getValue().wypisz();
        }
    }
}
