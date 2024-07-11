namespace Lab4_ZadaniaLekcja_Przyklad4
{
    internal class Przyklad4
    {
        static void Main(string[] args)
        {
            Square square = new Square();
            square.View();

            Rectangle rectangle = new Rectangle();
            rectangle.View();
        }
    }

    /* Klasy abstrakcyjne */

    internal abstract class Figure
    {
        // Abstrakcyjne metody
        public abstract double Area();
        public abstract double Circumference();

        // Regularne metody
        public void view()
        {
            Console.WriteLine("Figura: ");
        }
    }

    internal class Square : Figure
    {
        private double a = 4;

        public override double Area()
        {
            return a * a;
        }

        public override double Circumference()
        {
            return 4 * a;
        }

        public void View()
        {
            Console.WriteLine("Kwadrat, pole: " + Area() + ", obwód: " + Circumference());
        }
    }

    internal class Rectangle : Figure
    {
        private double a = 5, b = 2;

        public override double Area()
        {
            return a * b;
        }

        public override double Circumference()
        {
            return 2 * a + 2 * b;
        }

        public void View()
        {
            Console.WriteLine("Prostokąt, pole: " + Area() + ", obwód: " + Circumference());
        }
    }
}
