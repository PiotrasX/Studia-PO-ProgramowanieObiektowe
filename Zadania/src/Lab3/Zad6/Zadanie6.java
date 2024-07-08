package Lab3.Zad6;

// Zad. 6 Napisz program, który w nieskończoność pyta użytkownika o liczby całkowite.
//        Pętla nieskończona powinna się zakończyć, gdy użytkownik wprowadzi liczbę mniejszą od zera.
//        Do opuszczenia pętli nieskończonej użyj instrukcji break.

import java.util.Scanner;

public class Zadanie6
{
    public static void main(String[] args)
    {
        while (true)
        {
            int liczba = InputInt();
            if (liczba < 0)
            {
                System.out.println("Zakończono działanie nieskończonej pętli");
                break;
            }
        }
    }

    public static int InputInt()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą: ");
        return input.nextInt();
    }
}
