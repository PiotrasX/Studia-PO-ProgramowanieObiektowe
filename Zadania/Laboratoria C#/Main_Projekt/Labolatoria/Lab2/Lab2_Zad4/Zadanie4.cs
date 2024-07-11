namespace Lab2_Zad4
{
    internal class Zadanie4
    {
        static void Main(string[] args)
        {
            Liczba tablicaLiczb = new Liczba();
            tablicaLiczb.WypiszElementy();
            Console.WriteLine("Element o indeksie 2: " + tablicaLiczb.GetCyfra(2));
            Console.WriteLine("Zmiana wartości elementu o indeksie 3 na '9.2'");
            tablicaLiczb.SetCyfra(3, 9.2);
            Console.WriteLine("Pomnożenie wartości elementu o indeksie 4 razy 3");
            tablicaLiczb.PomnozCyfre(4, 3);
            tablicaLiczb.WypiszElementy();
            Console.WriteLine("\nObliczanie silni dla elementu tablicy o indeksie 1");
            tablicaLiczb.PoliczSilnie(1);
        }
    }

    internal class Liczba
    {
        private double[] cyfry;

        public Liczba()
        {
            int ileLiczb = 5;
            do
            {
                if (ileLiczb <= 4) Console.WriteLine("\nPodana wartość musi być większa lub równa pięciu");
                Console.Write("Ile chcesz wprowadzić liczb do tablicy?: ");
                int.TryParse(Console.ReadLine(), out ileLiczb);
            } while (ileLiczb <= 4);

            Console.WriteLine();
            cyfry = new double[ileLiczb];
            for (int i = 0; i < cyfry.Length; i++)
            {
                double liczba;
                Console.Write("Podaj " + i + " element tablicy: ");
                double.TryParse(Console.ReadLine().Replace(".", ","), out liczba);
                cyfry[i] = liczba;
            }
            Console.WriteLine();
        }

        public double GetCyfra(int index) 
        {
            if (index >= 0 && index < cyfry.Length)
                return cyfry[index];
            else return -1;
        }
        public void SetCyfra(int index, double wartosc)
        {
            if (index >= 0 && index < cyfry.Length)
                cyfry[index] = wartosc;
        }
        public void PomnozCyfre(int index, int ile)
        {
            if (index >= 0 && index < cyfry.Length)
                cyfry[index] *= ile;
        }
        public void WypiszElementy()
        {
            Console.Write("Elementy tablicy: ");
            Array.ForEach(cyfry, i => Console.Write(i + " --- "));
            Console.WriteLine();
        }
        public void PoliczSilnie(int index)
        {
            int liczba = (int)cyfry[index];
            if (liczba < 0) Console.WriteLine("Nie można obliczyć silni liczby ujemnej!");
            else if (liczba == 0 || liczba == 1) Console.WriteLine($"Silnia z {liczba} wynosi: 1");
            else
            {
                int[] tablicaSilni = new int[liczba + 1];
                tablicaSilni[0] = 1;
                tablicaSilni[1] = 1;
                for (int i = 2; i <= liczba; i++)
                    tablicaSilni[i] = i * tablicaSilni[i - 1];
                Console.WriteLine($"Silnia z {liczba} wynosi: {tablicaSilni[liczba]}");
            }
        }
    }
}
