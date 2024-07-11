namespace Lab2_Zad2
{
    internal class Zadanie2
    {
        static void Main(string[] args)
        {
            Sumator sumator = new Sumator();
            Console.WriteLine("\nSuma elementów tablicy: " + sumator.Suma());
            Console.WriteLine("\nSuma elementów tablicy podzielona przez 2: " + sumator.SumaPodziel2());
            Console.WriteLine("\nIle elementów jest w tablicy: " + sumator.IleElementow());
            sumator.Wypisz();
            if (sumator.IleElementow() >= 5)
                sumator.WypiszIndeksami(-1, 1);
                sumator.WypiszIndeksami(0, 2);
                sumator.WypiszIndeksami(1, 3);
                sumator.WypiszIndeksami(2, 4);
                sumator.WypiszIndeksami(3, 5);
        }
    }

    internal class Sumator
    {
        private int[] liczby;

        public Sumator()
        {
            int ileLiczb = 1;
            do
            {
                if (ileLiczb <= 0) Console.WriteLine("\nPodana wartość musi być większa od zera");
                Console.Write("Ile chcesz wprowadzić liczb do tablicy?: ");
                int.TryParse(Console.ReadLine(), out ileLiczb);
            } while (ileLiczb <= 0);

            Console.WriteLine();
            liczby = new int[ileLiczb];
            for (int i = 0; i < liczby.Length; i++) 
            {
                int liczba;
                Console.Write("Podaj " + i + " element tablicy: ");
                int.TryParse(Console.ReadLine(), out liczba);
                liczby[i] = liczba;
            }
        }

        public int Suma()
        {
            int suma = 0;
            foreach (int i in liczby) 
                suma += i;
            return suma;
        }
        public decimal SumaPodziel2()
        {
            return (decimal)Suma() / 2;
        }
        public int IleElementow()
        {
            return liczby.Length;
        }
        public void Wypisz()
        {
            Console.Write("Elementy w tablicy: ");
            Array.ForEach(liczby, i => Console.Write(i + " "));
            Console.WriteLine();
        }
        public void WypiszIndeksami(int lowIndex, int hightIndex)
        {
            Console.Write($"Elementy w tablicy od indeksu {lowIndex} do indeksu {hightIndex}: ");
            if (lowIndex < 0) lowIndex = 0;
            if (hightIndex >= IleElementow()) hightIndex = IleElementow() - 1;
            for (int i = lowIndex; i <= hightIndex; i++)
                Console.Write(liczby[i] + " ");
            Console.WriteLine();
        }
    }
}
