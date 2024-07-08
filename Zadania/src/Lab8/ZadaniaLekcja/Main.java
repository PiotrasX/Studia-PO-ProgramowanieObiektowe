package Lab8.ZadaniaLekcja;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /* MAPY */
        // Mapy przechowują pary klucz - wartość w postaci obiektów o nazwie entry. Zwyczajowo mówimy zatem,
        // że mapa jest kolekcją entries, gdzie każde entry składa się z pary: Klucz - Wartość (Key - Value).



        /* CECHY MAP */
        //  • Nie są dozwolone duplikaty kluczy.
        //  • Wartości mogą się duplikować.
        //  • Mogą być sortowalne lub nie - zależy od konkretnej implementacji interfejsu.
        //  • Klucze mogą być null-ami lub nie - zależy od konkretnej implementacji interfejsu
        //    (TreeMapy nie pozwalają na null-e).



        /* IMPLEMENTACJE MAP */
        //  • HashMap z pakietu java.util - Bardzo często stosowana implementacja. Elementy są nieposortowane.
        //    Ich kolejność nie odpowiada również kolejności wkładania do zbioru. Może przechowywać jednego null-a
        //    wśród kluczy.
        //  • LinkedHashMap z pakietu java.util - Implementacja przechowująca elementy w kolejności ich dodawania.
        //    Rozszerza klasę HashMap. Zatem może być przydatna jeśli zależy nam zarówno na unikalności kluczy jak
        //    i na tworzeniu historii unikalnych wpisów. Może przechowywać jednego null-a wśród kluczy.
        //  • TreeMap z pakietu java.util - Nie pozwala na przechowywanie nulla w miejscu klucza. Elementy są
        //    przechowywane pod postacią drzewa. Elementy są poukładane według kluczy w sposób posortowany (rosnąco).
        //    Przydaje się gdy chcemy zapewnić unikalność elementów oraz podstawowe sortowanie.



        /* TWORZENIE MAPY */
        Map<Object, Object> mapOfAnything1 = new HashMap<Object, Object>();
        Map<Integer, String> linkedWordsWithIds1 = new LinkedHashMap<Integer, String>();
        Map<Integer, String> sortedWordsWithIds1 = new TreeMap<Integer, String>();



        /* PODSTAWOWE OPERACJE NA MAPACH */
        // Podstawowymi operacjami jakie możemy wykonywać na mapach jest dodawanie, pobieranie oraz usuwanie elementów.
        // Operacje te są realizowane przez następujące metody:

        //  • put(<obiekt>, <obiekt>) Umożliwia ona dodanie elementu do mapy. Co ważne - wymagane jest dodanie
        //    elementów tych samych typów (lub podtypów) co parametry typów zadeklarowanych przez mapę. Metoda ta
        //    umożliwia również aktualizację obiektu w mapie. Wprowadzając do mapy parę o tym samym kluczu,
        //    ale innej wartości, podmieniamy de facto tę wartość.
        Map<Integer, String> movies = new HashMap<Integer, String>();
        movies.put(1, "Joker");
        movies.put(2, "Jurassic World");
        movies.put(3, "Psy 3");

        //  • get(<obiekt>) - Metoda pobiera element z mapy poprzez podanie wybranego obiektu klucza.
        //    Poniższy zapis zwróci obiekt z tekstem "Joker".
        movies.get(1);

        //  • remove(<obiekt>) - Metoda usuwa element z mapy poprzez podanie wybranego obiektu klucza.
        //    Poniższy zapis usunie film "Psy 3", który wyżej dodaliśmy z kluczem 3
        movies.remove(3);



        /* PRZEGLĄDANIE ZAWARTOŚCI MAPY */
        // Mapy nie implementują interfejsu Iterable, ale i tak można je w łatwy sposób przeglądać za pomocą iteratora.
        // Pobranie bieżącego elementu i przejście do następnego wykonywane jest za pomocą metody next.
        // W przypadku map - aby użyć iteratora - najpierw pobieramy z mapy zbiór entries. Wszystkie entries tworzą
        // zbiór (czyli znany Wam już Set), a jak wiemy zbiory możemy iterować i właśnie tak można przeglądać mapy.
        Set<Map.Entry<Integer, String>> entries = movies.entrySet();
        for (Map.Entry<Integer, String> entry : entries)
        {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
    }
}
