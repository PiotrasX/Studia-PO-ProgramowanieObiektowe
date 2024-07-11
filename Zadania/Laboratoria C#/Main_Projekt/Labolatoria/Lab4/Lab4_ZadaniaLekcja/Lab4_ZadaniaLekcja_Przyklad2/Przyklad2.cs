namespace Lab4_ZadaniaLekcja_Przyklad2
{
    internal class Przyklad2
    {
        static void Main(string[] args)
        {
            /* Polimorfizm statyczny - przeciążanie metod */

            Wyswietl(59);
            Wyswietl(3.14);
            Wyswietl('?');
            Wyswietl("ABC");
        }

        // Przeciążanie metod
        public static void Wyswietl(int i)
        {
            Console.WriteLine("Wyswietlana liczba: {0}", i);
        }
        public static void Wyswietl(double d)
        {
            Console.WriteLine("Wyswietlana liczna: {0}", d);
        }
        public static void Wyswietl(char c)
        {
            Console.WriteLine("Wyswietlany znak: {0}", c);
        }
        public static void Wyswietl(string s)
        {
            Console.WriteLine("Wyswietlany tekst: {0}", s);
        }
    }
}
