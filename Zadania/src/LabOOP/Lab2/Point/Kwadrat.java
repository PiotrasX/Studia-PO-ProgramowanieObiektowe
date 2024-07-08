package LabOOP.Lab2.Point;

public class Kwadrat extends Prostokat
{
    public Kwadrat() {}
    public Kwadrat(double szer) { super(szer); }
    public Kwadrat(double szer, String kolor) { super(szer, kolor); }
    public Kwadrat(double szer, String kolor, Punkt punkt) { super(szer, kolor, punkt); }

    public double getSzer() { return super.getSzer(); }
    public void setSzer(double szer) { super.setSzer(szer); }

    public double getPowierzchnia() { return (szer * szer); }
    public void przesun(double x, double y) { super.przesun(x, y); }
    public void opis()
    {
        System.out.printf("Klasa kwadrat. Środek kwadratu: [%f, %f]. Kolor: %s. Szerokość: %f\n", punkt.x, punkt.y, kolor, szer);
    }
}
