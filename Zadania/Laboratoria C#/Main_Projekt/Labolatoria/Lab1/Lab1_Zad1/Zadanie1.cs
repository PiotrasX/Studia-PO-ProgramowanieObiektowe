namespace Lab1_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            Delta();
        }

        static void Delta() 
        {
            decimal a, b, c;
            Console.Write("Podaj a: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out a);
            Console.Write("Podaj b: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out b);
            Console.Write("Podaj c: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out c);

            Console.WriteLine($"\nTwoje równanie: {a} * x^2 + {b} * x + {c}");
            decimal delta = (b * b) - (4 * a * c);
            if (delta > 0) 
            {
                decimal x1 = (-b - (decimal)Math.Sqrt((double)delta)) / (2 * a), x2 = (-b + (decimal)Math.Sqrt((double)delta)) / (2 * a);
                Console.WriteLine("Dwa rozwiązania w zbiorze liczb rzeczywistych");
                Console.WriteLine("x1 = " + x1);
                Console.WriteLine("x2 = " + x2);
            }
            else if (delta < 0)
            {
                Console.WriteLine("Brak rozwiązań w zbiorze liczb rzeczywistych");
            } 
            else 
            {
                decimal x1 = -b / (2 * a);
                Console.WriteLine("Jedno rozwiązanie w zbiorze liczb rzeczywistcyh");
                Console.WriteLine("x1 = " + x1);
            }
        }
    }
}
