namespace Lab2_Zad3
{
    internal class Zadanie3
    {
        static void Main(string[] args)
        {
            Data data1 = new Data();
            data1.WypiszDate();

            Data data2 = new Data(30, 12, 2023);
            data2.WypiszDate();
        }
    }

    internal class Data
    {
        private DateOnly dataTwoja;

        public DateOnly DataTwoja
        {
            get { return dataTwoja; }
            set { dataTwoja = value; }
        }

        public Data()
        {
            dataTwoja = DateOnly.FromDateTime(DateTime.Now);
        }
        public Data(int dzien, int miesiac, int rok)
        {
            dataTwoja = new DateOnly(rok, miesiac, dzien);
        }

        public void WypiszDate()
        {
            Console.WriteLine("Twoja data: " + dataTwoja);
            Console.WriteLine("Twoja data tydzień do przodu: " + dataTwoja.AddDays(7));
            Console.WriteLine("Twoja data tydzień do tyłu: " + dataTwoja.AddDays(-7));
            Console.WriteLine();
        }
    }
}
