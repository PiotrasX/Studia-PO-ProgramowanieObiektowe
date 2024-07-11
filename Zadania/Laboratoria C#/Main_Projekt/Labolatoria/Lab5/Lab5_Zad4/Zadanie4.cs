using System.Reflection;

namespace Lab5_Zad4
{
    internal class Zadanie4
    {
        static void Main(string[] args)
        {
            Klasa1 klasa1Objekt1 = new Klasa1("Masło", 13, true);
            Klasa1 klasa1Objekt2 = new Klasa1();
            Console.WriteLine("klasa1Objekt1 - " + klasa1Objekt1.ToString());
            Console.WriteLine("klasa1Objekt2 - " + klasa1Objekt2.ToString());

            Console.WriteLine("\nKopiowanie obiektu");
            KopiujObiekt(klasa1Objekt1, klasa1Objekt2);
            Console.WriteLine("klasa1Objekt1 - " + klasa1Objekt1.ToString());
            Console.WriteLine("klasa1Objekt2 - " + klasa1Objekt2.ToString());

            Console.WriteLine("\nZmiana wartości obiektu1");
            klasa1Objekt1.Pole1 = "Ser";
            klasa1Objekt1.Pole2 = 17;
            klasa1Objekt1.Pole3 = false;
            Console.WriteLine("klasa1Objekt1 - " + klasa1Objekt1.ToString());
            Console.WriteLine("klasa1Objekt2 - " + klasa1Objekt2.ToString());
            Console.WriteLine("\n\n");



            Klasa2 klasa2Objekt1 = new Klasa2(3.14f, 3.69m, "Honda", "Accord", 'S');
            Klasa2 klasa2Objekt2 = new Klasa2();
            Console.WriteLine("klasa2Objekt1 - " + klasa2Objekt1.ToString());
            Console.WriteLine("klasa2Objekt2 - " + klasa2Objekt2.ToString());

            Console.WriteLine("\nKopiowanie obiektu");
            KopiujObiekt(klasa2Objekt1, klasa2Objekt2);
            Console.WriteLine("klasa2Objekt1 - " + klasa2Objekt1.ToString());
            Console.WriteLine("klasa2Objekt2 - " + klasa2Objekt2.ToString());

            Console.WriteLine("\nZmiana wartości obiektu1");
            klasa2Objekt1.Pole1 = 13.37f;
            klasa2Objekt1.Pole2 = 9.75m;
            klasa2Objekt1.Pole3 = "Uniwersytet";
            klasa2Objekt1.Pole4 = "Rzeszowski";
            klasa2Objekt1.Pole5 = 'X';
            Console.WriteLine("klasa2Objekt1 - " + klasa2Objekt1.ToString());
            Console.WriteLine("klasa2Objekt2 - " + klasa2Objekt2.ToString());
            Console.WriteLine("\n\n");



            Console.WriteLine("Zatem mamy różne klasy co zawierają różne pola, i wywołując tę samą metodę w głównym programie dla różnych obiektów róznych klas, dane obiekty są kopiowane jako wartości a nie jako referencje");
            Console.WriteLine("\n\n");


            Klasa1 test1 = new Klasa1();
            Klasa1 test2 = new Klasa1("WSAD", 1337, false);
            KopiujObiekt(test1, test2);
        }

        static void KopiujObiekt(object objPocz, object objKon)
        {
            var typePocz = objPocz.GetType();
            var typeKon = objKon.GetType();

            if (typePocz == typeKon && objKon is IKopiowanie kopiowalny)
            {
                try
                {
                    kopiowalny.KopiujObiekt(objPocz);
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Wyjątek: " + ex.Message);
                }
            }
        }
    }

    internal interface IKopiowanie
    {
        public abstract void KopiujObiekt(object objects);
    }

    internal class Klasa1 : IKopiowanie
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

        public void KopiujObiekt(object dobry)
        {
            Klasa1 dobryObiekt = (Klasa1)dobry;
            if (dobryObiekt.Pole1 is null) throw new Exception("Pole1 jest puste lub null");
            Pole1 = dobryObiekt.Pole1;
            Pole2 = dobryObiekt.Pole2;
            Pole3 = dobryObiekt.Pole3;
        }

        public string Pole1 { get => pole1; set => pole1 = value; }
        public int Pole2 { get => pole2; set => pole2 = value; }
        public bool Pole3 { get => pole3; set => pole3 = value; }

        public override string ToString()
        {
            return $"Pole1: {Pole1}, Pole2: {Pole2}, Pole3: {Pole3}";
        }
    }

    internal class Klasa2 : IKopiowanie
    {
        private float pole1;
        private decimal pole2;
        private string pole3, pole4;
        private char pole5;

        public Klasa2()
        {
            
        }
        public Klasa2(float pole1, decimal pole2, string pole3, string pole4, char pole5)
        {
            Pole1 = pole1;
            Pole2 = pole2;
            Pole3 = pole3;
            Pole4 = pole4;
            Pole5 = pole5;
        }

        public void KopiujObiekt(object dobry)
        {
            Klasa2 dobryObiekt = (Klasa2)dobry;
            if (dobryObiekt.Pole3 is null) throw new Exception("Pole3 jest puste lub null");
            if (dobryObiekt.Pole4 is null) throw new Exception("Pole4 jest puste lub null");
            if (dobryObiekt.Pole5.Equals('\0')) throw new Exception("Pole5 jest puste lub null");
            Pole1 = dobryObiekt.Pole1;
            Pole2 = dobryObiekt.Pole2;
            Pole3 = dobryObiekt.Pole3;
            Pole4 = dobryObiekt.Pole4;
            Pole5 = dobryObiekt.Pole5;
        }

        public float Pole1 { get => pole1; set => pole1 = value; }
        public decimal Pole2 { get => pole2; set => pole2 = value; }
        public string Pole3 { get => pole3; set => pole3 = value; }
        public string Pole4 { get => pole4; set => pole4 = value; }
        public char Pole5 { get => pole5; set => pole5 = value; }

        public override string ToString()
        {
            return $"Pole1: {Pole1}, Pole2: {Pole2}, Pole3: {Pole3}, Pole4: {Pole4}, Pole5: {Pole5}";
        }
    }
}
