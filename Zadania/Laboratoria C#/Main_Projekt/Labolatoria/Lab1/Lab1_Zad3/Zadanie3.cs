using System.ComponentModel.Design;

namespace Lab1_Zad3
{
    internal class Zadanie3
    {
        static int[] tab;
        static bool czyKoniec = false;

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
                Console.WriteLine("1. Wyświetlanie tablicy od pierwszego do ostatniego indeksu");
                Console.WriteLine("2. Wyświetlanie tablicy od ostatniego do pierwszego indeksu");
                Console.WriteLine("3. Wyświetlanie elementów o nieparzystych indeksach");
                Console.WriteLine("4. Wyświetlanie elementów o parzystych indeksach");
                Console.WriteLine("5. Zakończ program");

                Console.ForegroundColor = ConsoleColor.Yellow;
                int opcja;
                Console.Write("\nWybierz opcje: ");
                int.TryParse(Console.ReadLine(), out opcja);
                Console.ForegroundColor = ConsoleColor.Red;
                switch (opcja) 
                {
                    case 1:
                        WypiszPrzod();
                        break;
                    case 2:
                        WypiszTyl();
                        break;
                    case 3:
                        WypiszParzyste();
                        break;
                    case 4:
                        WypiszNieparzyste();
                        break;
                    case 5:
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

        static void WypiszPrzod()
        {
            Console.Write("Tablica od przodu do tyłu: ");
            for (int i = 0; i < tab.Length; i++)
                Console.Write(tab[i] + " ");
            Console.WriteLine();
        }

        static void WypiszTyl()
        {
            Console.Write("Tablica od tyłu do przodu: ");
            for (int i = tab.Length - 1; i >= 0; i--)
                Console.Write(tab[i] + " ");
            Console.WriteLine();
        }

        static void WypiszParzyste()
        {
            Console.Write("Tablica parzyste (od indeksu 0) od przodu do tyłu: ");
            for (int i = 0; i < tab.Length; i+=2)
                Console.Write(tab[i] + " ");
            Console.WriteLine();
        }

        static void WypiszNieparzyste()
        {
            Console.Write("Tablica nieparzyste (od indeksu 0) od przodu do tyłu: ");
            for (int i = 1; i < tab.Length; i+=2)
                Console.Write(tab[i] + " ");
            Console.WriteLine();
        }
    }
}
