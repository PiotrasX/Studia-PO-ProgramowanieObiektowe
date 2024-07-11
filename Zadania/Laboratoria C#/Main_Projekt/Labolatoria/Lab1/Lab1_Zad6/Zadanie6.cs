namespace Lab1_Zad6
{
    internal class Zadanie6
    {
        static void Main(string[] args)
        {
            int a;
            while (true) 
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.Write("Podaj liczbę: ");
                int.TryParse(Console.ReadLine(), out a);
                Console.ForegroundColor = ConsoleColor.Red;

                if (a < 0)
                {
                    Console.WriteLine("Wprowadzono liczbę mniejszą od zera - koniec pętli");
                    Console.ResetColor();
                    break;
                }

                Console.WriteLine("Twoja liczba: " + a + "\n");
            }
        }
    }
}
