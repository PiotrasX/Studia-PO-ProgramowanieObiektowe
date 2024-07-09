package LabOOP.Lab1.Building;

import java.util.Scanner;

public class Run
{
    public void runs()
    {
        initialization();
        while (true)
        {
            menu();
            int choice = inputInt();
            switch (choice)
            {
                case 1 -> info();
                case 2 -> howOld();
                case 3 -> end();
                default -> defaultOptions();
            }
        }
    }

    Building[] buildingsTab = new Building[5];
    public void initialization()
    {
        buildingsTab[0] = new Building("Uniwersytet Rzeszowski - budynek A0", 2010,3);
        buildingsTab[1] = new Building("Uniwersytet Rzeszowski - budynek A1", 2005,2);
        buildingsTab[2] = new Building("Uniwersytet Rzeszowski - budynek A2", 2007,3);
        buildingsTab[3] = new Building("Uniwersytet Rzeszowski - budynek A3", 2001,5);
        buildingsTab[4] = new Building("Galeria Milenium Hall", 2011,2);
    }

    public void info()
    {
        int x;
        do
        {
            System.out.print("\tKtóry wybierasz budynek? Podaj liczbę z zakresu od " + 1 + " do " + buildingsTab.length + ": ");
            x = inputInt();
        } while (x <= 0 || x > buildingsTab.length);
        buildingsTab[x - 1].print();
    }

    public void howOld()
    {
        int x;
        do
        {
            System.out.print("\tKtóry wybierasz budynek? Podaj liczbę z zakresu od " + 1 + " do " + buildingsTab.length + ": ");
            x = inputInt();
        } while (x <= 0 || x > buildingsTab.length);
        buildingsTab[x - 1].howOld();
    }

    public void menu()
    {
        System.out.println("\n\t======================");
        System.out.println("\t===   MENU OPCJI   ===");
        System.out.println("\t======================");
        System.out.println("\t1. Wyświetlanie informacji o budynkach");
        System.out.println("\t2. Policzenie, ile lat ma budynek");
        System.out.println("\t3. Wyjście");
        System.out.println("\t----------------------");
        System.out.print("\tWybierz odpowiednią operacje: ");
    }

    public void end()
    {
        System.out.print("\tCzy na pewno chcesz wyjść z programu? ( t | T | tak | Tak | TAK ): ");
        String znak = inputString();
        if  (znak.equals("t") || znak.equals("T") || znak.equals("tak") || znak.equals("Tak") || znak.equals("TAK"))
        {
            System.out.println("\tKoniec programu");
            System.exit(0);
        }
        else
        {
            System.out.println("\tAnulowano wyjście");
        }
    }

    public void defaultOptions()
    {
        System.out.println("\tBłędne dane, koniec programu");
        System.exit(0);
    }

    public int inputInt()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String inputString()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
