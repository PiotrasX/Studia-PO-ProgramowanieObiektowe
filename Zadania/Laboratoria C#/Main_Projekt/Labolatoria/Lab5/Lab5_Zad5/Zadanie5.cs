namespace Lab5_Zad5
{
    internal class Zadanie5
    {
        static void Main(string[] args)
        {
            Klasa1 objekt1 = new Klasa1("Szynka", 11, true);
            Klasa1 objekt2 = new Klasa1();
            Console.WriteLine("objekt1 - " + objekt1.ToString());
            Console.WriteLine("objekt2 - " + objekt2.ToString());

            Console.WriteLine("\nKopiowanie obiektu");
            KopiujObiekt(objekt1, objekt2);
            Console.WriteLine("objekt1 - " + objekt1.ToString());
            Console.WriteLine("objekt2 - " + objekt2.ToString());

            Console.WriteLine("\nZmiana wartości obiektu1");
            objekt1.Pole1 = "Ser";
            objekt1.Pole2 = 9;
            objekt1.Pole3 = false;
            Console.WriteLine("objekt1 - " + objekt1.ToString());
            Console.WriteLine("objekt2 - " + objekt2.ToString());
            Console.WriteLine("\n\n");



            Klasa1 test1 = new Klasa1();
            Klasa1 test2 = new Klasa1("WSAD", 1337, false);
            KopiujObiekt(test1, test2);
        }

        static void KopiujObiekt(object objPocz, object objKon)
        {
            var typePocz = objPocz.GetType();
            var typeKon = objKon.GetType();

            if (typePocz == typeKon && objPocz is ICloneable klonowalny)
            {
                try
                {
                    var kopia = klonowalny.Clone();
                    var pola = typePocz.GetProperties();

                    foreach (var pole in pola) 
                    {
                        if (pole.CanWrite)
                        {
                            var wartosc = pole.GetValue(kopia);
                            pole.SetValue(objKon, wartosc);
                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Wyjątek: " + ex.Message);
                }
            }
        }
    }

    internal class Klasa1 : ICloneable
    {
        private string pole1;
        private int pole2;
        private bool pole3;

        public Klasa1()
        {

        }
        public Klasa1(string pole1, int pole2, bool pole3)
        {
            Pole1 = pole1;
            Pole2 = pole2;
            Pole3 = pole3;
        }

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Pole1 { get => pole1; set => pole1 = value; }
        public int Pole2 { get => pole2; set => pole2 = value; }
        public bool Pole3 { get => pole3; set => pole3 = value; }

        public override string ToString()
        {
            return $"Pole1: {Pole1}, Pole2: {Pole2}, Pole3: {Pole3}";
        }
    }
}
