namespace Lab1_Zad7
{
    internal class Zadanie7
    {
        static int[] tab;
        static int ileLiczb = 1;

        static void Main(string[] args)
        {
            Wprowadz();
            Sortowanie();
        }

        static void Wprowadz()
        {
            Console.ForegroundColor = ConsoleColor.Blue;
            do
            {
                if (ileLiczb <= 0)
                    Console.WriteLine("\nPodana liczba musi być większa od 0");
                Console.Write("Ile chcesz wprowadzić liczb do tablicy?: ");
                int.TryParse(Console.ReadLine(), out ileLiczb);
            } 
            while (ileLiczb <= 0);

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("\nTablica typów 'int'");
            tab = new int[ileLiczb];
            for (int i = 0; i < ileLiczb; i++)
            {
                Console.Write($"Podaj {i} element tablicy: ");
                int.TryParse(Console.ReadLine(), out tab[i]);
            }
        }

        static void Sortowanie()
        {
            for (int i = 1; i < ileLiczb; i++)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("\nSortowanie kolej " + i);
                Console.Write("Tablica: ");
                Array.ForEach(tab, i => Console.Write(i + " "));
                Console.WriteLine();
                Console.ForegroundColor = ConsoleColor.Magenta;

                for (int j = 1; j < ileLiczb - i + 1; j++)
                {
                    Console.Write("Porównywanie " + tab[j - 1] + " i " + tab[j] + " - ");
                    if (tab[j] > tab[j - 1])
                        Console.WriteLine("Prawidłowa kolejność - brak zmiany");
                    else 
                    {
                        Console.WriteLine("Brak prawidłowej kolejności - następuje zmiana");
                        int pomoc = tab[j - 1];
                        tab[j - 1] = tab[j];
                        tab[j] = pomoc;
                    }
                }
            }

            Console.ForegroundColor = ConsoleColor.Red;
            Console.Write("\nPosortowana tablica: ");
            Array.ForEach(tab, i => Console.Write(i + " "));
            Console.WriteLine();
            Console.ResetColor();
        }
    }
}
