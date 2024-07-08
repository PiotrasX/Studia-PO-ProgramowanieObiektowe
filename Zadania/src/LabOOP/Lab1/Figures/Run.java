package LabOOP.Lab1.Figures;

import java.util.Scanner;

public class Run
{
    public void runs()
    {
        while (true)
        {
            menu();
            int choice = inputInt();
            switch (choice)
            {
                case 1 -> circleF();
                case 2 -> squareF();
                case 3 -> rectangleF();
                case 4 -> cubeF();
                case 5 -> cuboidF();
                case 6 -> sphereF();
                case 7 -> coneF();
                case 8 -> end();
                default -> defaultOptions();
            }
        }
    }

    public void menu()
    {
        System.out.println("\n\t======================");
        System.out.println("\t===   MENU OPCJI   ===");
        System.out.println("\t======================");
        System.out.println("\t1. Koło");
        System.out.println("\t2. Kwadrat");
        System.out.println("\t3. Prostokąt");
        System.out.println("\t4. Sześcian");
        System.out.println("\t5. Prostopadłościan");
        System.out.println("\t6. Kula");
        System.out.println("\t7. Stożek");
        System.out.println("\t8. Wyjście");
        System.out.println("\t----------------------");
        System.out.print("\tWybierz odpowiednią operacje: ");
    }

    public void circleF()
    {
        System.out.print("\tPodaj nazwę dla koła: ");
        String name = inputString();
        System.out.print("\tPodaj długość promienia: ");
        double r = inputDouble();
        Circle circle = new Circle(r, name);
        circle.print();
    }

    public void squareF()
    {
        System.out.print("\tPodaj nazwę dla kwadratu: ");
        String name = inputString();
        System.out.print("\tPodaj długość boku: ");
        double a = inputDouble();
        Square square = new Square(a, name);
        square.print();
    }

    public void rectangleF()
    {
        System.out.print("\tPodaj nazwę dla prostokąta: ");
        String name = inputString();
        System.out.print("\tPodaj długość boku 1: ");
        double a = inputDouble();
        System.out.print("\tPodaj długość boku 2: ");
        double b = inputDouble();
        Rectangle rectangle = new Rectangle(a, b, name);
        rectangle.print();
    }

    public void cubeF()
    {
        System.out.print("\tPodaj nazwę dla sześcianu: ");
        String name = inputString();
        System.out.print("\tPodaj długość krawędzi: ");
        double a = inputDouble();
        Cube cube = new Cube(a, name);
        cube.print();
    }

    public void cuboidF()
    {
        System.out.print("\tPodaj nazwę dla prostopadłościanu: ");
        String name = inputString();
        System.out.print("\tPodaj długość krawędzi 1: ");
        double a = inputDouble();
        System.out.print("\tPodaj długość krawędzi 2: ");
        double b = inputDouble();
        System.out.print("\tPodaj długość krawędzi 3: ");
        double c = inputDouble();
        Cuboid cuboid = new Cuboid(a, b, c, name);
        cuboid.print();
    }

    public void sphereF()
    {
        System.out.print("\tPodaj nazwę dla kuli: ");
        String name = inputString();
        System.out.print("\tPodaj długość promienia: ");
        double r = inputDouble();
        Sphere sphere = new Sphere(r, name);
        sphere.print();
    }

    public void coneF()
    {
        System.out.print("\tPodaj nazwę dla stożka: ");
        String name = inputString();
        System.out.print("\tPodaj długość promienia: ");
        double r = inputDouble();
        System.out.print("\tPodaj długość wysokości: ");
        double h = inputDouble();
        Cone cone = new Cone(r, h, name);
        cone.print();
    }

    public void end()
    {
        System.out.print("\tCzy na pewno chcesz wyjść z programu? ( t | T | tak | Tak | TAK ): ");
        String znak = inputString();
        if (znak.equals("t") || znak.equals("T") || znak.equals("tak") || znak.equals("Tak") || znak.equals("TAK"))
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

    public double inputDouble()
    {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public String inputString()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
