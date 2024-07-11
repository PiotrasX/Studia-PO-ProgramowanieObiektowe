namespace Lab4_Zad3
{
    internal class Zadanie3
    {
        static void Main(string[] args)
        {
            Osoba.listaOsob.Add(new Osoba("Jan", "Kowalski"));
            Osoba.listaOsob.Add(new Osoba("Krzysztof", "Węglowski"));
            Osoba.listaOsob.Add(new Osoba("Mariusz", "Podzanawski"));
            Osoba.listaOsob.Add(new Osoba("Justyna", "Pomarańczowa"));
            Osoba.listaOsob.Add(new Osoba("Martyna", "Plizga"));
            Osoba.listaOsob.Add(new Osoba("Marcysia", "Plizga"));

            Osoba.WypiszOsoby();
            Console.WriteLine();

            Osoba.PosortujOsobyPoNazwisku();
            Osoba.WypiszOsoby();
            Console.WriteLine();

            Student.listaStudentow.Add(new Student("Michał", "Słaby", "WSIiZ", "Informatyka", 1, 1));
            Student.listaStudentow.Add(new Student(new Osoba("Magdalena", "Kowalska"), "WSIiZ", "Ekonometria", 1, 2));
            Student.listaStudentow.Add(new Student(Osoba.listaOsob[5], "UR", "Informatyka", 2, 3));
            Student.listaStudentow.Add(new Student(Osoba.listaOsob[1], "UR", "Położnictwo", 3, 6));
            Student.listaStudentow.Add(new Student(Osoba.listaOsob[2], "UR", "Ratownictwo medyczne", 5, 9));

            Student.WypiszPelnaNazweIUczelnie();
            Console.WriteLine();

            Student.PosortujStudentowPoNazwisku();
            Student.WypiszPelnaNazweIUczelnie();
            Console.WriteLine();

            Student.listaStudentow.Add(new StudentWSIiZ("Patryk", "Grabowy", "WSIiZ", "Rolnictwo", 1, 1));
            Student.listaStudentow.Add(new StudentWSIiZ(new Osoba("Julia", "Grabowy"), "WSIiZ", "Ekonometria", 1, 2));
            Student.listaStudentow.Add(new StudentWSIiZ(Osoba.listaOsob[0], "WSIiZ", "Rolnictwo", 2, 4));

            Student.WypiszPelnaNazweIUczelnie();
            Console.WriteLine();

            Student.PosortujStudentowPoNazwisku();
            Student.WypiszPelnaNazweIUczelnie();
            Console.WriteLine();
        }
    }

    internal interface IOsoba
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }

        public string ZwrocPelnaNazwe();
    }

    internal interface IStudent : IOsoba
    {
        public string Uczelnia { get; set; }
        public string Kierunek { get; set; }
        public int Rok { get; set; }
        public int Semestr { get; set; }
    }

    internal class Osoba : IOsoba, IComparable<Osoba>
    {
        private string imie, nazwisko;
        public static List<Osoba> listaOsob = new List<Osoba> { };

        public Osoba(string imie, string nazwisko)
        {
            Imie = imie;
            Nazwisko = nazwisko;
        }

        public string Imie 
        { 
            get => imie;
            set => imie = value;
        }
        public string Nazwisko 
        {
            get => nazwisko;
            set => nazwisko = value;
        }

        public string ZwrocPelnaNazwe()
        {
            return imie + " " + nazwisko;
        }

        public static void WypiszOsoby()
        {
            foreach (Osoba o in listaOsob)
                Console.WriteLine("Imię i nazwisko: {0}", o.ZwrocPelnaNazwe());
        }

        public static void PosortujOsobyPoNazwisku()
        {
            listaOsob.Sort();
        }

        public int CompareTo(Osoba? other)
        {
            return 10 * Nazwisko.CompareTo(other.Nazwisko) + Imie.CompareTo(other.Imie);
        }
    }

    internal class Student : IStudent, IComparable<Student>
    {
        private string imie, nazwisko, uczelnia, kierunek;
        private int rok, semestr;
        public static List<Student> listaStudentow = new List<Student> { };

        public Student(string imie, string nazwisko, string uczelnia, string kierunek, int rok, int semestr)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Uczelnia = uczelnia;
            Kierunek = kierunek;
            Rok = rok;
            Semestr = semestr;
        }
        public Student(Osoba osoba, string uczelnia, string kierunek, int rok, int semestr)
        {
            Imie = osoba.Imie;
            Nazwisko = osoba.Nazwisko;
            Uczelnia = uczelnia;
            Kierunek = kierunek;
            Rok = rok;
            Semestr = semestr;
        }

        public string Uczelnia 
        { 
            get => uczelnia; 
            set => uczelnia = value; 
        }
        public string Kierunek 
        {
            get => kierunek;
            set => kierunek = value;
        }
        public int Rok 
        {
            get => rok;
            set => rok = value;
        }
        public int Semestr 
        {
            get => semestr;
            set => semestr = value;
        }
        public string Imie 
        {
            get => imie;
            set => imie = value;
        }
        public string Nazwisko 
        {
            get => nazwisko;
            set => nazwisko = value;
        }

        public string ZwrocPelnaNazwe()
        {
            return imie + " " + nazwisko;
        }

        public static void WypiszStudentow()
        {
            foreach (Student s in listaStudentow)
                Console.WriteLine("Imię i nazwisko studenta: {0}", s.ZwrocPelnaNazwe());
        }

        public static void WypiszPelnaNazweIUczelnie()
        {
            foreach (Student s in listaStudentow)
                Console.WriteLine($"Imię i nazwisko studenta: {s.ZwrocPelnaNazwe()} - Rok: {s.Rok}, Semestr: {s.Semestr}, Kierunek: {s.Kierunek}, Uczelnia: {s.Uczelnia}");
        }

        public static void PosortujStudentowPoNazwisku()
        {
            listaStudentow.Sort();
        }

        public int CompareTo(Student? other)
        {
            return 10 * Nazwisko.CompareTo(other.Nazwisko) + Imie.CompareTo(other.Imie);
        }
    }

    internal class StudentWSIiZ : Student
    {
        public StudentWSIiZ(Osoba osoba, string uczelnia, string kierunek, int rok, int semestr) : base(osoba, "WSIiZ", kierunek, rok, semestr) { }

        public StudentWSIiZ(string imie, string nazwisko, string uczelnia, string kierunek, int rok, int semestr) : base(imie, nazwisko, "WSIiZ", kierunek, rok, semestr) { }

        public new static void WypiszPelnaNazweIUczelnie()
        {
            foreach (Student s in listaStudentow)
                Console.WriteLine($"Imię i nazwisko studenta: {s.ZwrocPelnaNazwe()} - Rok: {s.Rok}, Semestr: {s.Semestr}, Kierunek: {s.Kierunek}, Uczelnia: <3 WSiIZ");
        }
    }
}
