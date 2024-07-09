package Lab8.Zad3;

// Zad. 3 W poniższym zadaniu napiszemy własną klasę odnośnie stosu, czyli co zostanie włożone na stos jako ostatnie
//        jest pierwszym elementem, który można z niego zdjąć (LIFO).
//            1. Utwórz klasę Stos<T> zawierającą:
//               • zainicjowane prywatne pole LinkedList<T> stos,
//               • publiczne metody:
//                   • void push(T v) - wkłada element na stos,
//                   • T peek() - zwraca pierwszy element stosu, ale go nie usuwa,
//                   • T pop() - zwraca pierwszy element stosu i usuwa go,
//                   • boolean empty() - sprawdza, czy stos jest pusty,
//                   • String toString() - wypisuje elementy naszego stosu,
//            2. Stosy są często używane do obliczania wyrażeń w językach programowania. Za pomocą utworzonej klasy Stos
//               oblicz poniższe wyrażenie, w którym '+' oznacza "umieszczenie następnej litery na stosie",
//               a '-' "zdjęcie szczytowego elementu stosu i wypisanie go na wyjściu".
//        Wyrażenie do wyliczenia: "+ł+a+B---+a+g+a---+n-+w-+t+i+l---+e-+k+r--+h+c+a---".

import java.util.Scanner;

public class Zadanie3
{
    public static void main(String[] args)
    {
        Stos stos = new Stos();
        System.out.print("Podaj wyrażenie do obliczenia: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int i = 0;
        while (i < text.length())
        {
            if (text.charAt(i) == '+')
            {
                stos.push(String.valueOf(text.charAt(i+1)));
                i += 2;
            }
            if (text.charAt(i) == '-')
            {
                System.out.print(stos.pop());
                i += 1;
            }
        }
    }
}
