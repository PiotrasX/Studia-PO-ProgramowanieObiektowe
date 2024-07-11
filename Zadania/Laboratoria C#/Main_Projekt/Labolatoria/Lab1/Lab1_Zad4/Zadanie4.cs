namespace Lab1_Zad4
{
    internal class Zadanie4
    {
        static int[] tab;
        static bool czyKoniec = false;
        static decimal wynik;

        static void Main(string[] args)
        {
            Wprowadz();
            Menu();
        }

        static void Menu()
        {
            while (!czyKoniec)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("\n\n\n--------- MENU ---------");
                Console.WriteLine("1. Suma elementów tablicy");
                Console.WriteLine("2. Iloczyn elementów tablicy");
                Console.WriteLine("3. Średnia elementów tablicy");
                Console.WriteLine("4. Minimum z tablicy ");
                Console.WriteLine("5. Maksymum z tablicy");
                Console.WriteLine("6. Zakończ program");

                Console.ForegroundColor = ConsoleColor.Yellow;
                int opcja;
                Console.Write("\nWybierz opcje: ");
                int.TryParse(Console.ReadLine(), out opcja);
                Console.ForegroundColor = ConsoleColor.Red;
                switch (opcja)
                {
                    case 1:
                        Suma();
                        break;
                    case 2:
                        Iloczyn();
                        break;
                    case 3:
                        Srednia();
                        break;
                    case 4:
                        Min();
                        break;
                    case 5:
                        Maks();
                        break;
                    case 6:
                        Console.WriteLine("Zakończono działanie programu!");
                        Console.ResetColor();
                        czyKoniec = true;
                        break;
                    default:
                        Console.WriteLine("Brak podanej opcji wyboru");
                        break;
                }
            }
        }

        static void Wprowadz()
        {
            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("Tablica typów 'int'");
            tab = new int[10];
            for (int i = 0; i < tab.Length; i++)
            {
                Console.Write($"Podaj {i} element tablicy: ");
                int.TryParse(Console.ReadLine(), out tab[i]);
            }
        }

        static void Suma()
        {
            wynik = 0;
            foreach (var i in tab)
                wynik += i;
            Console.WriteLine("Suma elementów tablicy wynosi: " + wynik);
        }

        static void Iloczyn()
        {
            wynik = 1;
            foreach (var i in tab)
                wynik *= i;
            Console.WriteLine("Iloczyn elementów tablicy wynosi: " + wynik);
        }

        static void Srednia()
        {
            wynik = 0;
            foreach (var i in tab)
                wynik += i;
            wynik /= 10;
            Console.WriteLine("Średnia elementów tablicy wynosi: " + wynik);
        }

        static void Min()
        {
            wynik = tab.Min();
            Console.WriteLine("Minimum z tablicy wynosi: " + wynik);
        }

        static void Maks()
        {
            wynik = tab.Max();
            Console.WriteLine("Maksimum z tablicy wynosi: " + wynik);
        }
    }
}
