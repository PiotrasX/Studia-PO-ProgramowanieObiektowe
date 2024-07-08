package Lab8.Zad2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Fill
{
    Queue<Command> napisy;

    public Fill() { this.napisy = new ArrayDeque<>(); }

    public void wypelnij()
    {
        System.out.print("Podaj ciąg znaków: ");
        Scanner scanner = new Scanner(System.in);
        String napis = scanner.nextLine();
        Command ciagZnakow = new Command(napis);
        napisy.add(ciagZnakow);
    }

    public Queue<Command> zwroc() { return napisy; }
}
