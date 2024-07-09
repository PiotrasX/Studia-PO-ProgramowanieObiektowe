package Lab8.Zad1;

// Zad. 1 Wykonaj poniższe polecenia:
//        1. Utwórz nową klasę Kangur ze składową int nrKangura, inicjalizowaną z poziomu konstruktora. Wyposaż klasę
//           w metodę skok(), wypisującą wartość tej składowej i sygnalizującej wykonywanie podskoków. Utwórz kontener
//           ArrayList i wstaw do niego obiekty Kangur (minimum 10). Teraz skorzystaj z metody get() kontenera w celu
//           przejrzenia jego zawartości i wywołania metody skok() dla każdego umieszczonego w nim kangura.
//        2. Zmodyfikuj uzyskany kod tak, aby przeglądało listę (i wywoływało metodę skok()) za pomocą
//           iteratora.
//        3. Weź klasę Kangur z podpunktu 1 i umieść jej elementy w kontenerze HashMap, kojarząc każdy egzemplarz
//           Kangur (wartość) z nazwą ("Jacek", "Marta" itd.) w postaci obiektu String (klucz). Pozyskaj iterator
//           zbioru zwracanego przez keySet() i wykorzystaj go do przejrzenia kontenera HashMap. Wypisz w konsoli
//           imiona kangurów oraz odpowiadające im numery, zwracane poprzez metodę skok().
//        4. Wyodrębnij z kontenera HashMap (utworzonego w poprzednim podpunkcie) pary, posortuj je według kluczy
//           i umieść całość w kontenerze LinkedHashMap.

import java.util.*;

public class Zadanie1
{
    public static void main(String[] args)
    {
        List<Kangur> kangurzaLista = new ArrayList<>();
        kangurzaLista.add(new Kangur(1));
        kangurzaLista.add(new Kangur(2));
        kangurzaLista.add(new Kangur(3));
        kangurzaLista.add(new Kangur(4));
        kangurzaLista.add(new Kangur(5));
        kangurzaLista.add(new Kangur(6));
        kangurzaLista.add(new Kangur(7));
        kangurzaLista.add(new Kangur(8));
        kangurzaLista.add(new Kangur(9));
        kangurzaLista.add(new Kangur(10));
        for (Kangur kangur : kangurzaLista)
        {
            kangur.skok();
        }
        System.out.println();

        Map<String, Kangur> kangurzeImiona = new HashMap<>();
        kangurzeImiona.put("Jacek", kangurzaLista.get(0));
        kangurzeImiona.put("Marta", kangurzaLista.get(1));
        kangurzeImiona.put("Monika", kangurzaLista.get(2));
        kangurzeImiona.put("Bronisław", kangurzaLista.get(3));
        kangurzeImiona.put("Dorota", kangurzaLista.get(4));
        kangurzeImiona.put("Marcel", kangurzaLista.get(5));
        kangurzeImiona.put("Jarosław", kangurzaLista.get(6));
        kangurzeImiona.put("Bożena", kangurzaLista.get(7));
        kangurzeImiona.put("Maksymilian", kangurzaLista.get(8));
        kangurzeImiona.put("Dawid", kangurzaLista.get(9));
        for (Map.Entry<String, Kangur> kangurek : kangurzeImiona.entrySet())
        {
            System.out.print(kangurek.getKey() + " jest to ");
            kangurek.getValue().skok();
        }
        System.out.println();

        Map<String, Kangur> kangurzeImionaPosortowane = new TreeMap<>(kangurzeImiona);
        Map<String, Kangur> kangurzeImionaPosortowaneLinked = new LinkedHashMap<>(kangurzeImionaPosortowane);
        for (Map.Entry<String, Kangur> kangurek : kangurzeImionaPosortowaneLinked.entrySet())
        {
            System.out.print(kangurek.getKey() + " jest to ");
            kangurek.getValue().skok();
        }
    }
}
