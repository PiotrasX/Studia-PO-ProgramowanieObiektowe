namespace Lab3_ZadaniaLekcja_Przyklady
{
    internal class Przyklady
    {
        static void Main(string[] args)
        {
            Person person1 = new Person("N/A", "N/A");
            person1.FirstName = "Jan";
            person1.LastName = "Kowalski";
            Console.WriteLine("person1: " + person1.FirstName + " " + person1.LastName);
            Console.WriteLine(person1.ToString());

            Console.WriteLine();
            Person person2 = new Student("Jan", "Nowak", "125159");
            Console.WriteLine("person2: " + person2.FirstName + " " + person2.LastName);
            Console.WriteLine(person2.ToString());
        }
    }

    internal class Person
    {
        /* Enkapsulacja (hermetyzacja) - ukrywanie pól i metod */
        // Plusy stosowania enkapsulacji:
        // • Lepsza kontrola nad elementami klasy (zmniejszenie możliwości zepsucia kodu przez siebie (lub innych)).
        // • Pola mogą być tylko do odczytu (jeśli używasz tylko metody get) lub tylko do zapisu (jeśli używasz tylko metody set).
        // • Elastyczność: programista może zmienić jedną część kodu bez wpływu na inne części.
        // • Zwiększone bezpieczeństwo danych.

        private string firstName; // Pole
        private string lastName;

        public string FirstName // Właściwość
        {
            get { return firstName; } // get method
            set { firstName = value; } // set method
        }
        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public Person(string imie, string nazwisko)
        {
            FirstName = imie;
            LastName = nazwisko;
        }

        public override string ToString()
        {
            return "Imię i nazwisko: " + FirstName + " " + LastName;
        }
    }



    /* Dziedziczenie (klasa bazowa i klasa pochodna) */
    // W języku C# możliwe jest dziedziczenie pól i metod z jednej klasy do drugiej. Koncepcję dziedziczenia dzielimy na dwie kategorie:
    // • Klasa pochodna (dziecko) - klasa, która dziedziczy z innej klasy.
    // • Klasa bazowa (rodzic) - klasa, z której się dziedziczy.

    internal class Student : Person
    {
        private string nrAlbum;

        public string NrAlbum
        {
            get { return nrAlbum; }
            set { nrAlbum = value; }
        }

        public Student(string imie, string nazwisko, string nrAlbumu) : base(imie, nazwisko)
        {
            NrAlbum = nrAlbumu;
        }

        public override string ToString()
        {
            return "Imię i nazwisko, nr albumu: " + FirstName + " " + LastName + ", " + NrAlbum;
        }
    }
}
