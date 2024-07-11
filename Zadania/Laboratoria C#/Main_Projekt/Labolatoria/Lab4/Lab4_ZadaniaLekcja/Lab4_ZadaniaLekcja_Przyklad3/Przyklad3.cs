namespace Lab4_ZadaniaLekcja_Przyklad3
{
    internal class Przyklad3
    {
        static void Main(string[] args)
        {
            /* Polimorfizm statyczny - przeciążanie operatorów */

            double objetosc = 0;
            Pudelko p1 = new Pudelko();
            Pudelko p2 = new Pudelko();
            Pudelko p3 = new Pudelko();
            Pudelko p4 = new Pudelko();
            Pudelko p5 = new Pudelko();

            // Specyfikacja 1
            p1.Dlugosc = 3.5;
            p1.Szerokosc = 4.0;
            p1.Wysokosc = 5.5;
            // Specyfikacja 2
            p2.Dlugosc = 2.5;
            p2.Szerokosc = 5.0;
            p2.Wysokosc = 4.5;
            // Specyfikacja 3
            p3.Dlugosc = 12.5;   
            p3.Szerokosc = 15.0;
            p3.Wysokosc = 14.5;

            // Wyświetlenie danych wewnątrz kolejnych obiektów
            Console.WriteLine("Pudełko 1: {0}", p1.ToString());
            Console.WriteLine("Pudełko 2: {0}", p2.ToString());
            Console.WriteLine("Pudełko 3: {0}", p3.ToString());
            Console.WriteLine();

            // Objętość 1
            objetosc = p1.ObliczObjetosc();
            Console.WriteLine($"Objetosc pudełka 1: {objetosc}");
            // Objętość 2
            objetosc = p2.ObliczObjetosc();
            Console.WriteLine($"Objetosc pudełka 2: {objetosc}");
            // Objętość 3
            objetosc = p3.ObliczObjetosc();
            Console.WriteLine($"Objetosc pudełka 3: {objetosc}");
            
            Console.WriteLine();

            // Dodanie dwóch obiektów
            p4 = p3 + p2;
            Console.WriteLine("Pudełko 4: {0}", p4.ToString());
            objetosc = p4.ObliczObjetosc();
            Console.WriteLine($"Objetosc pudełka 4: {objetosc}");

            // Odejmowanie dwóch obiektów
            p5 = p4 - p1;
            Console.WriteLine("Pudełko 5: {0}", p5.ToString());
            objetosc = p5.ObliczObjetosc();
            Console.WriteLine($"Objetosc pudełka 5: {objetosc}");

            Console.WriteLine();

            // Porównanie obiektów
            if (p1 == p2) Console.WriteLine("Pudełka p1 oraz p2 są identyczne");
            if (p1 != p2) Console.WriteLine("Pudełka p1 oraz p2 są różne");
        }
    }

    internal class Pudelko
    {
        private double dlugosc;
        private double szerokosc;
        private double wysokosc;
        private double objetosc;

        public double Dlugosc { get => dlugosc; set => dlugosc = value; }
        public double Szerokosc { get => szerokosc; set => szerokosc = value; }
        public double Wysokosc { get => wysokosc; set => wysokosc = value; }

        public double ObliczObjetosc()
        {
            objetosc = Dlugosc * Szerokosc * Wysokosc;
            return objetosc;
        }

        // Przeciążenie operatora +
        public static Pudelko operator +(Pudelko a, Pudelko b)
        {
            Pudelko c = new Pudelko();
            c.Dlugosc = a.Dlugosc + b.Dlugosc;
            c.Szerokosc = a.Szerokosc + b.Szerokosc;
            c.Wysokosc = a.Wysokosc + b.Wysokosc;
            return c;
        }

        // Przeciążenie operatora -
        public static Pudelko operator -(Pudelko a, Pudelko b)
        {
            Pudelko c = new Pudelko();
            c.Dlugosc = a.Dlugosc - b.Dlugosc;
            if (c.Dlugosc < 1) c.Dlugosc = 1;
            c.Szerokosc = a.Szerokosc - b.Szerokosc;
            if (c.Szerokosc < 1) c.Szerokosc = 1;
            c.Wysokosc = a.Wysokosc - b.Wysokosc;
            if (c.Wysokosc < 1) c.Wysokosc = 1;
            return c;
        }

        // Przeciążenie operatora ==
        public static bool operator ==(Pudelko a, Pudelko b)
        {
            bool status = false;
            if (a.Dlugosc == b.Dlugosc && a.Szerokosc == b.Szerokosc && a.Wysokosc == b.Wysokosc) status = true;
            return status;
        }

        // Przeciążenie operatora !=
        public static bool operator !=(Pudelko a, Pudelko b)
        {
            bool status = false;
            if (a.Dlugosc != b.Dlugosc || a.Szerokosc != b.Szerokosc || a.Wysokosc != b.Wysokosc) status = true;
            return status;
        }

        public override string ToString()
        {
            return String.Format("Wymiary pudełka: ({0} x {1} x {2})", Dlugosc, Szerokosc, Wysokosc);
        }
    }
}
