package LabOOP.Lab3.Interface;

// Klasa Prostokąt musi zaimplementować wszystkie metody interfejsu FiguraGeometryczna, ale nic nie stoi na przeszkodzie,
// aby posiadała dodatkowe metody wewnątrz własnej klasy np.: wzór na przekątną.

public class Prostokat implements FiguraGeometryczna
{
    private double a; // Długość
    private double b; // Wysokość

    public Prostokat()
    {
        this.a = 0;
        this.b = 0;
    }
    public Prostokat(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public double pole()  { return a*b; }
    public double obwod() { return 2*a + 2*b; }
}
