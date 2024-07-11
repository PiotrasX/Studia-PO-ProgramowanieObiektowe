using System;

namespace Lab2_ZadaniaLekcja_Przyklady
{
    internal class Przyklady
    {
        static void Main(string[] args)
        {
            // Programowanie obiektowe – OOP Object-Oriented Programming

            // Programowanie proceduralne polega na pisaniu procedur lub metod, które wykonują operacje na danych, podczas gdy programowanie obiektowe polega na tworzeniu obiektów, które zawierają zarówno dane, jak i metody.
            // Programowanie obiektowe ma kilka zalet w porównaniu z programowaniem proceduralnym:
            // • OOP jest szybsze i łatwiejsze do wykonania
            // • OOP zapewnia przejrzystą strukturę dla programów
            // • OOP pomaga utrzymać kod C# DRY "Don't Repeat Yourself" i sprawia, że kod jest łatwiejszy w utrzymaniu, modyfikacji i debugowaniu
            // • OOP umożliwia tworzenie pełnych aplikacji wielokrotnego użytku z mniejszą ilością kodu i krótszym czasem programowania



            // Tworzenie obiektu klasy
            Car car1 = new Car();
            Car car2 = new Car(Color.Pomarańczowy, 2003);   
            Car car3 = new Car(Color.Zielony, 2015);

            // Wywołanie metody na obiekcie klasy
            Console.WriteLine(car1.ToString());
            Console.WriteLine(car2.ToString());
            Console.WriteLine(car3.ToString());

            // Zmiana parametrów obiektu klasy
            car1.Kolor = Color.Czarny;
            car1.Rok = 2020;
            car1.Podglad();
            Console.WriteLine();

            // Tworzenie tablicy obiektów i ich wyświetlanie - I sposoób
            Car[] arrayCar1 = new Car[5];
            arrayCar1[0] = new Car(Color.Czerwony, 2023);
            arrayCar1[1] = new Car(Color.Niebieski, 2021);
            arrayCar1[2] = new Car(Color.Zielony, 1999);
            arrayCar1[3] = new Car(Color.Czarny, 2015);
            arrayCar1[4] = new Car(Color.Niebieski, 2019);
            foreach (Car item in arrayCar1)
                item.Podglad();
            Console.WriteLine();

            // Tworzenie tablicy obiektów i ich wyświetlanie - II sposób
            Car[] arrayCar2 = new Car[] 
              { new Car(Color.Czerwony, 2023),
                new Car(Color.Niebieski, 2021),
                new Car(Color.Zielony, 1999),
                new Car(Color.Czarny, 2015),
                new Car(Color.Niebieski, 2019) };
            foreach (Car item in arrayCar2)
                item.Podglad();
            Console.WriteLine();

            // Tworzenie tablicy obiektów i ich wyświetlanie - III sposob
            Car[] arrayCar3 = new Car[5];
            Color[] color = { Color.Czerwony, Color.Niebieski, Color.Zielony, Color.Czarny, Color.Niebieski };
            int[] rok = { 2023, 2021, 1999, 2015, 2019 };
            for (int i = 0; i < arrayCar3.Length; i++)
                arrayCar3[i] = new Car(color[i], rok[i]);
            foreach (Car item in arrayCar3)
                item.Podglad();
            Console.WriteLine();

            // Modyfikatory dostępu
            // • public – Kod jest dostępny dla wszystkich klas;
            // • private - Kod jest dostępny tylko w obrębie tej samej klasy;
            // • protected - Kod jest dostępny w tej samej klasie lub w klasie, która dziedziczy z tej klasy;
            // • internal - Kod jest dostępny tylko w obrębie własnego zespołu, ale nie z innego zespołu;
        }
    }

    internal enum Color
    {
        Czerwony, Niebieski, Zielony, Biały, Czarny, Fioletowy, Żółty, Różowy, Szary, Pomarańczowy
    }

    internal class Car
    {
        // Pola klasy
        private Color kolor = Color.Biały;
        private int rok = 2023;

        // Właściwości klasy
        public Color Kolor
        {
            get { return kolor; }
            set { kolor = value; }
        }
        public int Rok
        {
            get { return rok; }
            set { rok = value; }
        }

        // Konstruktory klasy
        public Car()
        {
            
        }
        public Car(Color kolor, int rok)
        {
            Kolor = kolor;
            Rok = rok;
        }

        // Metody klasy
        public void Podglad()
        {
            Console.WriteLine($"Kolor samochodu: {Kolor}, Rok produkcji: {Rok}");
        }
        public override string ToString()
        {
            return $"Kolor samochodu: {Kolor}, Rok produkcji: {Rok}";
        }
    }
}
