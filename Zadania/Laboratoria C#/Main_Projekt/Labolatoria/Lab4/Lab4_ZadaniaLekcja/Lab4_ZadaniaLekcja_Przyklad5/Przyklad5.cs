namespace Lab4_ZadaniaLekcja_Przyklad5
{
    internal class Przyklad5
    {
        static void Main(string[] args)
        {
            Transakcje t1 = new Transakcje("01", "25/11/2023", 331);
            t1.WyswietlDane();

            Transakcje t2 = new Transakcje("02", "26/11/2023", 1337);
            t2.WyswietlDane();
        }
    }

    // Interfejs
    public interface ITransakcje
    {
        // Składowe interfejsu
        public void WyswietlDane();
        public int PoliczIlosc();
    }

    internal class Transakcje : ITransakcje
    {
        private string kod;
        private string data;
        private int ilosc;

        public Transakcje()
        {
            kod = "";
            data = "";
            ilosc = 0;
        }
        public Transakcje(string kod, string data, int ilosc)
        {
            this.kod = kod;
            this.data = data;
            this.ilosc = ilosc;
        }

        public int PoliczIlosc()
        {
            return ilosc;
        }

        public void WyswietlDane()
        {
            Console.WriteLine("Kod: {0}", kod);
            Console.WriteLine("Data: {0}", data);
            Console.WriteLine("Ilość: {0}", ilosc);
            Console.WriteLine();
        }
    }
}
