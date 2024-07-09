package Lab7.ZadaniaLekcja;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /* LISTY */
        // Listy są dostarczane w ramach kolekcji za pośrednictwem interfejsu List z pakietu java.util.
        // Listę możemy zasadniczo zdefiniować jako bardziej elastyczną wersję tablicy. Jest to jednak pewne
        // uproszczenie, dlatego też przyjrzyjmy się teraz dokładnie jakie są cechy charakterystyczne list:
        //      • Elementy listy mają określoną kolejność.
        //      • Dozwolone są duplikaty elementów.
        //      • Elementy można umieścić na liście w określonej pozycji.
        //      • Element znajdujący się w określonej pozycji można prosto pobrać z listy.
        //      • Element w określonej pozycji możemy łatwo podmienić na inny.
        //      • Listy możemy łatwo sortować.
        //      • Nie musimy deklarować na początku rozmiaru listy (choć ogólnie warto to robić, jeśli jesteśmy
        //        w stanie przewidzieć jej rozmiar).



        /* TWORZENIE LISTY */
        // Dobrą praktyką jest zadeklarowanie instancji listy z parametrem typu, na przykład:
        List<Object> listAnything1 = new ArrayList<Object>();
        List<Integer> listNumbers1 = new ArrayList<Integer>();
        List<String> linkedWords1 = new LinkedList<String>();
        // Od Javy 7 możemy usunąć parametr typu po prawej stronie, co upraszcza zapis do następującej postaci:
        List<Integer> listNumbers2 = new ArrayList<>();
        // Od Javy 9 możemy utworzyć kolekcję z ustalonego zestawu elementów:
        List<Integer> listNumbers3 = List.of(1, 2, 3, 4, 5, 6);
        // Od Javy 10 można jeszcze bardziej skrócić tworzenie kolekcji, używając słowa var:
        var listNumbers4 = new ArrayList<Integer>();



        /* PODSTAWOWE OPERACJE NA LISTACH */
        // Podstawowymi operacjami, jakie możemy wykonywać na listach, jest dodawanie, pobieranie, aktualizowanie
        // oraz usuwanie elementów. Operacje te są realizowane przez następujące metody:

        // • add(<obiekt>) - umożliwia ona dodanie elementu do listy. Co ważne - wymagane jest dodanie elementów
        //   tego samego typu (lub podtypu) co parametr typu zadeklarowanego przez listę.
        List<String> listStrings1 = new ArrayList<String>();
        // Poniższe elementy zostaną dodane do listy - wszystkie są typu String:
        listStrings1.add("One");
        listStrings1.add("Two");
        listStrings1.add("Three");
        // Poniższy element nie zostanie dodany do listy - kompilator zgłosi błąd:
        // listStrings1.add(123);
        //
        // Dodawanie elementów podtypów zadeklarowanego typu:
        List<Number> linkedNumbers1 = new LinkedList<>();
        linkedNumbers1.add(123);
        linkedNumbers1.add(3.1415);
        linkedNumbers1.add(299.988);
        linkedNumbers1.add(67000);

        // Pozycje w liście - podobnie jak w przypadku tablic - są numerowane od zera. Dodawanie następnego
        // elementu powoduje umieszczenie go w kolejnym wolnym indeksie (0, 1, 2, 3, ..., itd.).
        // • get(<indeks>) - umożliwia ona pobranie elementu z listy poprzez podanie indeksu, na którym znajduje się
        //   ten element.
        Number number = linkedNumbers1.get(3);

        // • set(<indeks>,<obiekt>) - metoda aktualizuje element w danej pozycji listy, a dokładniej mówiąc,
        //   zastępuje ten element.
        linkedNumbers1.set(3, 12345);

        // • remove(<indeks>) - metoda usuwa element w danej pozycji listy. Innymi słowy, element znajdujący się
        //   na danym indeksie jest całkowicie usuwany z listy.
        linkedNumbers1.remove(3);



        /* PRZEGLĄDANIE ZAWARTOŚCI LISTY */
        // Listy implementują interfejs Iterable, co umożliwia przeglądanie ich element po elemencie. W tym celu
        // wykorzystać można interfejs Iterator. Jego działanie polega na przeglądaniu listy, dopóki po danym
        // elemencie występuje kolejny element. Pobranie bieżącego elementu i przejście do następnego wykonywane jest
        // za pomocą metody next.
        Iterator<Number> someNumbersIterator1 = linkedNumbers1.iterator();
        while (someNumbersIterator1.hasNext())
        {
            System.out.println(someNumbersIterator1.next());
        }
        System.out.println();
        for (Number value : linkedNumbers1)
        {
            System.out.println(value);
        }
        System.out.println();



        /* SETY */
        // Kolejną kolekcją w Javie są Sety, inaczej mówiąc zbiory. Dostarczane są one za pośrednictwem interfejsu Set
        // z pakietu java.util. Sety wyglądają z wierzchu trochę podobnie do list, jednak ich implementacja i podejście
        // do danych jest zupełnie inne. Przyjrzyjmy się teraz najważniejszym cechom zbiorów:
        //      • Nie są dozwolone duplikaty elementów.
        //      • Do elementów w secie nie odwołujemy się po pozycji, gdyż nie wiadomo na jakiej pozycji znajduje się
        //        dany element.
        //      • Mogą być sortowalne lub nie - zależy od konkretnej implementacji interfejsu.
        // Na początku można zadać sobie pytanie dotyczące użyteczności setów, których konstrukcja wydaje się być
        // bardziej zagmatwana od list i do tego ma swoje ograniczenia. Mimo tego sety są bardzo często używane
        // i nie można ich pominąć w trakcie nauki. Dzieje się tak ze względu na ich specjalną właściwość:
        //      • Unikalność elementów.
        //      • W secie nie mogą istnieć dokładnie dwa takie same obiekty. Zawsze będzie przechowywany tylko jeden.
        //        Zatem jeśli mamy ciąg liczb: 7, 2, 9, 1, 5, 7, 6, 3, 9 i taki ciąg wpiszemy do seta, to odczytując
        //        wszystkie elementy zbioru otrzymamy tylko pojedyncze wartości: 7, 2, 9, 1, 5, 6, 3. W ten sposób
        //        można w łatwy sposób odfiltrować duplikaty. Wystarczy wprowadzić je do seta. Wyciągniemy z niego
        //        jedynie niezduplikowane elementy.



        /* TWORZENIE ZBIORU */
        // Dobrą praktyką jest zadeklarowanie instancji zbioru z parametrem typu, na przykład:
        Set<Object> listAnything2 = new HashSet<Object>();
        Set<Integer> listNumbers5 = new HashSet<Integer>();
        Set<String> linkedWords2 = new LinkedHashSet<String>();
        Set<String> sortedWords1 = new TreeSet<String>();



        /* PODSTAWOWE OPERACJE NA ZBIORACH */

        // • add(<obiekt>) - umożliwia ona dodanie elementu do seta. Co ważne - wymagane jest dodanie elementów
        // tego samego typu (lub podtypu) co parametr typu zadeklarowanego przez seta.
        Set<String> setStrings1 = new HashSet<String>();
        // Poniższe elementy zostaną dodane do seta - wszystkie są typu String:
        setStrings1.add("One");
        setStrings1.add("Two");
        setStrings1.add("Three");
        // Poniższy element nie zostanie dodany do seta - kompilator zgłosi błąd:
        // setStrings1.add(123);
        //
        // Dodawanie elementów podtypów zadeklarowanego typu:
        Set<Number> linkedNumbers2 = new LinkedHashSet<>();
        linkedNumbers2.add(123);
        linkedNumbers2.add(3.1415);
        linkedNumbers2.add(299.988);
        linkedNumbers2.add(67000);

        // Pamiętajmy, że w przypadku setów nie możemy mówić o indeksie elementu. W przypadku LinkedHashSet
        // mamy jedynie zapewnioną kolejność, czyli podczas przeglądania zbioru otrzymamy elementy zgodne
        // z kolejnością ich dodawania.
        // • remove(<obiekt>) - metoda usuwa element ze zbioru.
        setStrings1.remove("Two");



        /* PRZEGLĄDANIE ZAWARTOŚCI SETA */
        // Zbiory implementują interfejs Iterable, co umożliwia przeglądanie ich element po elemencie. W tym celu
        // wykorzystujemy interfejs Iterator. Jego działanie polega na przeglądaniu kolekcji dopóki po danym elemencie
        // występuje kolejny element. Pobranie bieżącego elementu i przejście do następnego wykonywane jest za pomocą
        // metody next.
        Iterator<Number> someNumbersIterator2 = linkedNumbers2.iterator();
        while (someNumbersIterator2.hasNext())
        {
            System.out.println(someNumbersIterator2.next());
        }
        System.out.println();
        for (Number value : linkedNumbers2)
        {
            System.out.println(value);
        }
        System.out.println();



        /* MODYFIKOWANIE OBIEKTÓW W SETACH */
        // Omawiając listy wspomnieliśmy o metodzie set, która pozwalała nam na aktualizację obiektu na danej pozycji.
        // W przypadku setów nie mamy indeksów i nie mamy metody set. Co nam zatem pozostaje? Otóż możemy iterować
        // po kolejnych obiektach seta i porównywać je po wybranym polu w celu znalezienia właściwego obiektu,
        // a gdy już to zrobimy możemy wtedy zaktualizować jego dane. Inną opcją jest usunięcie obiektu z seta
        // metodą remove i dodanie go na nowo w zaktualizowanej wersji za pomocą metody add.
    }
}
