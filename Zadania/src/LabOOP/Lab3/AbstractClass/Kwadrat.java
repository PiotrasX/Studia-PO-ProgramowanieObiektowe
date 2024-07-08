package LabOOP.Lab3.AbstractClass;

// Przykład klasy potomnej implementującą klasę abstrakcyjną Figura.

public class Kwadrat extends Figura
{
    public double a;

    public Kwadrat() { this.a = 0; }
    public Kwadrat(double a) { this.a = a; }

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double pole() { return a*a; }
    public double obwod() { return 4*a; }
}
