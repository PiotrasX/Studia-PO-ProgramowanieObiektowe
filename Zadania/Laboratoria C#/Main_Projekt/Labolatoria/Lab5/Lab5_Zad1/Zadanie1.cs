namespace Lab5_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            string napis = "";
            while (true) 
            {
                Console.Write("Podaj napis (wpisz 'koniec' aby zamknąć program): ");
                napis = Console.ReadLine();
                if (napis.Equals("koniec")) break;
                WypiszNapis(napis);
            }

            WypiszNapis(null);
            Console.WriteLine("\nZakończono działanie programu");
        }

        static void WypiszNapis(string napis)
        {
            try
            {
                Console.WriteLine("Długość napisu: " + napis.Length + "\n");
            }
            catch (NullReferenceException e)
            {
                Console.WriteLine(e.StackTrace);
                try
                {
                    throw new NullReferenceException();
                }
                catch (NullReferenceException ex)
                {
                    Console.WriteLine("Drugi wyjątek z rzędu");
                }
            }
        }
    }
}
