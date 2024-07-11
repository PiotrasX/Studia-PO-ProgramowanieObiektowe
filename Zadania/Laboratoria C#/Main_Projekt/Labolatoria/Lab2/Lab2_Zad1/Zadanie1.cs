namespace Lab2_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            Licz licz1 = new Licz();
            licz1.Dodaj(5);
            licz1.Dodaj(2);
            licz1.Odejmij(1);
            Console.WriteLine("Wartość licz1: " + licz1.Value);

            Licz licz2 = new Licz();
            licz2.Dodaj(13);
            licz2.Odejmij(1);
            licz2.Odejmij(3);
            Console.WriteLine("Wartość licz2: " + licz2.Value);

            Licz licz3 = new Licz();
            licz3.Odejmij(2);
            licz3.Dodaj(5);
            licz3.Odejmij(1);
            Console.WriteLine("Wartość licz3: " + licz3.Value);

            Licz licz4 = new Licz(7);
            licz4.Dodaj(13);
            licz4.Odejmij(5);
            Console.WriteLine("Wartość licz4: " + licz4.WartoscValue());

            Licz licz5 = new Licz(2);
            licz5.Odejmij(9);
            licz5.Dodaj(1);
            Console.WriteLine("Wartość licz5: " + licz5.WartoscValue());
        }
    }

    internal class Licz
    {
        private int value = 0;

        public int Value
        {
            get { return value; }
            set { this.value = value; }
        }

        public Licz()
        {
            
        }
        public Licz(int x)
        {
            value = x;
        }

        public void Dodaj(int x)
        {
            value += x;
        }
        public void Odejmij(int x)
        {
            value -= x;
        }
        public int WartoscValue()
        {
            return value;
        }
    }
}
