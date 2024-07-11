namespace Lab1_Zad2
{
    internal class Zadanie2
    {
        static bool wyjscie = false;

        static void Main(string[] args)
        {
            Kalkulator();
        }

        static void Kalkulator()
        {
            while (!wyjscie)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("\n\n\n---------- Menu ----------");
                Console.WriteLine("1. Suma");
                Console.WriteLine("2. Różnica");
                Console.WriteLine("3. Iloczyn");
                Console.WriteLine("4. Iloraz");
                Console.WriteLine("5. Potęgowanie");
                Console.WriteLine("6. Pierwiastkowanie");
                Console.WriteLine("7. Wartości trygonometryczne");
                Console.WriteLine("8. Wyjście");

                Console.ForegroundColor = ConsoleColor.Yellow;
                int wybor;
                decimal a = 0, b = 0, wynik;
                Console.Write("\nWybierz opcje: ");
                int.TryParse(Console.ReadLine(), out wybor);

                Console.ForegroundColor = ConsoleColor.Red;
                switch (wybor)
                {
                    case 1:
                        CzytajAB(ref a, ref b);
                        wynik = a + b;
                        Console.WriteLine($"{a} + {b} = " + wynik);
                        break;

                    case 2:
                        CzytajAB(ref a, ref b);
                        wynik = a - b;
                        Console.WriteLine($"{a} - {b} = " + wynik);
                        break;

                    case 3:
                        CzytajAB(ref a, ref b);
                        wynik = a * b;
                        Console.WriteLine($"{a} * {b} = " + wynik);
                        break;

                    case 4:
                        CzytajAB(ref a, ref b);
                        if (b == 0)
                            wynik = 0;
                        else
                            wynik = a / b;
                        Console.WriteLine($"{a} / {b} = " + wynik);
                        break;

                    case 5:
                        CzytajAB(ref a, ref b);
                        wynik = (decimal)Math.Pow((double)a, (double)b);
                        Console.WriteLine($"{a} ^ {b} = " + wynik);
                        break;

                    case 6:
                        CzytajA(ref a);
                        wynik = (decimal)Math.Sqrt((double)a);
                        Console.WriteLine($"V( {a} ) = " + wynik);
                        break;

                    case 7:
                        Console.Write("Podaj stopnie: ");
                        CzytajA(ref a);
                        decimal rad = (a / 180) * (decimal)Math.PI;
                        decimal wynikSin, wynikCos;
                        double wynikTan, wynikCtg;
                        wynikSin = (decimal)Math.Sin((double)rad);
                        wynikCos = (decimal)Math.Cos((double)rad);
                        if (a % 360 == 0)
                        {
                            wynikSin = 0;
                            wynikCos = 1;
                            wynikTan = 0;
                            wynikCtg = Double.PositiveInfinity;
                        }
                        else if (a % 360 == 90)
                        {
                            wynikSin = 1;
                            wynikCos = 0;
                            wynikTan = Double.PositiveInfinity;
                            wynikCtg = 0;
                        }
                        else if (a % 360 == 180)
                        {
                            wynikSin = 0;
                            wynikCos = -1;
                            wynikTan = 0;
                            wynikCtg = Double.PositiveInfinity;
                        }
                        else if (a % 360 == 270)
                        {
                            wynikSin = -1;
                            wynikCos = 0;
                            wynikTan = Double.PositiveInfinity;
                            wynikCtg = 0;
                        }
                        else
                        {
                            wynikTan = Math.Tan((double)rad);
                            wynikCtg = 1 / wynikTan;
                        }
                        Console.WriteLine($"Sinus( {a} ) = " + wynikSin);
                        Console.WriteLine($"Cosinus( {a} ) = " + wynikCos);
                        Console.WriteLine($"Tangens( {a} ) = " + wynikTan);
                        Console.WriteLine($"Cotangens( {a} ) = " + wynikCtg);
                        break;

                    case 8:
                        Console.WriteLine("Zakończono działanie programu");
                        Console.ResetColor();
                        wyjscie = true;
                        break;

                    default:
                        Console.WriteLine("Nie ma takiej opcji wyboru");
                        break;

                }
            }
        }

        static void CzytajAB(ref decimal a, ref decimal b)
        {
            Console.Write("Podaj a: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out a);
            Console.Write("Podaj b: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out b);
            Console.ForegroundColor = ConsoleColor.Magenta;
        }

        static void CzytajA(ref decimal a)
        {
            Console.Write("Podaj a: ");
            decimal.TryParse(Console.ReadLine().Replace(".", ","), out a);
            Console.ForegroundColor = ConsoleColor.Magenta;
        }
    }
}
