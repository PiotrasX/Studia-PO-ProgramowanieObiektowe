namespace Lab5_Zad2
{
    internal class Zadanie2
    {
        static void Main(string[] args)
        {
            try
            {
                LosujWyjatek();
            }
            catch(WyjatekPierwszyException ex)
            {
                Console.WriteLine(ex.Message);
            }
            catch (WyjatekDrguiException ex)
            {
                Console.WriteLine(ex.Message);
            }
            catch (WyjatekTrzeciException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void LosujWyjatek()
        {
            Random random = new Random();
            int wyjatek = random.Next(1, 4);
            switch (wyjatek) 
            {
                case 1: throw new WyjatekPierwszyException();
                case 2: throw new WyjatekDrguiException();
                case 3: throw new WyjatekTrzeciException();
            }
        }
    }

    public class WyjatekPierwszyException : Exception
    {
        public WyjatekPierwszyException() : base("Jest to pierwszy wyjątek") { }
    }

    public class WyjatekDrguiException : Exception
    {
        public WyjatekDrguiException() : base("Jest to drugi wyjątek") { }
    }

    public class WyjatekTrzeciException : Exception
    {
        public WyjatekTrzeciException() : base("Jest to trzeci wyjątek") { }
    }
}
