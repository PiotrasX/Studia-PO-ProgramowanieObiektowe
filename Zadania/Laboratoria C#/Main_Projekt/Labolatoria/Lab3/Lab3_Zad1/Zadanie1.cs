namespace Lab3_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            Osoba osoba1 = new Osoba("Wojciech", "Kozioł", 52);
            Osoba osoba2 = new Osoba("Henryk", "Sienkiewicz", 48);
            Osoba osoba3 = new Osoba("Mirosława", "Zięba", 39);
            Osoba osoba4 = new Osoba("Jan", "Kowalski", 19);
            Osoba osoba5 = new Osoba("Stanisław", "Nowak", 24);
            Osoba osoba6 = new Osoba("Adam", "Zawadzki", 14);
            Osoba osoba7 = new Osoba("Martyna", "Mydło", 31);
            Osoba osoba8 = new Osoba("Alina", "Parch", 54);
            Osoba osoba9 = new Osoba("Józef", "Linsta", 60);
            Osoba osoba10 = new Osoba("Michał", "Słaby", 29);

            Ksiazka ksiazka1 = new Ksiazka("C# w praktyce", osoba1, new DateOnly(2007, 5, 12));
            Ksiazka ksiazka2 = new Ksiazka("Java w praktyce", osoba1, new DateOnly(2011, 2, 23));
            Ksiazka ksiazka3 = new Ksiazka("W pustyni i w puszczy", osoba2, new DateOnly(1997, 9, 2));
            Ksiazka ksiazka4 = new Ksiazka("Kain i Abel", osoba2, new DateOnly(2004, 9, 3));
            Ksiazka ksiazka5 = new Ksiazka("Metody numeryczne a informatyka", osoba3, new DateOnly(2014, 7, 17));
            Ksiazka ksiazka6 = new Ksiazka("Wykorzystanie metod numerycznych w praktyce", osoba3, new DateOnly(2020, 11, 30));

            Czytelnik czytelnik1 = new Czytelnik(osoba4.Imie, osoba4.Nazwisko, osoba4.Wiek);
            Czytelnik czytelnik2 = new Czytelnik(osoba5);
            Osoba czytelnik3 = new Czytelnik(osoba6);

            czytelnik1.PrzeczytaneKsiazki.Add(ksiazka1);
            czytelnik1.PrzeczytaneKsiazki.Add(ksiazka2);
            czytelnik1.PrzeczytaneKsiazki.Add(ksiazka5);
            czytelnik2.PrzeczytaneKsiazki.Add(ksiazka3);
            czytelnik2.PrzeczytaneKsiazki.Add(ksiazka6);

            List<Osoba> listaCzytelnikow = new List<Osoba> { czytelnik1, czytelnik2, czytelnik3 };
            foreach (Osoba czytelnik in listaCzytelnikow)
                czytelnik.Podglad();



            Console.WriteLine("\n\n\n");
            Recenzent czytelnik4 = new Recenzent(osoba7.Imie, osoba7.Nazwisko, osoba7.Wiek);
            Czytelnik czytelnik5 = new Recenzent(osoba8);
            Osoba czytelnik6 = new Recenzent(osoba9);

            czytelnik4.PrzeczytaneKsiazki.Add(ksiazka2);
            czytelnik4.PrzeczytaneKsiazki.Add(ksiazka4);
            czytelnik5.PrzeczytaneKsiazki.Add(ksiazka3);

            listaCzytelnikow.Add(czytelnik4);
            listaCzytelnikow.Add(czytelnik5);
            listaCzytelnikow.Add(czytelnik6);
            foreach (Osoba osoba in listaCzytelnikow)
                osoba.Podglad();



            Console.WriteLine("\n\n\n");
            Ksiazka ksiazka7 = new KsiazkaPrzygodowa("Przygody w Panamie", osoba2, new DateOnly(2010, 5, 19), "Panama");
            Ksiazka ksiazka8 = new KsiazkaPrzygodowa("Leśna wyprawa", osoba2, new DateOnly(2014, 4, 16), "Las syberyjski");
            Ksiazka ksiazka9 = new KsiazkaDokumentarna("Stefan Żeromski - historia prawdziwa", osoba10, new DateOnly(2018, 12, 26), "Stefan Żeromski");
            Ksiazka ksiazka10 = new KsiazkaDokumentarna("Magni - syn Thora", osoba10, new DateOnly(2017, 8, 20), "Magni Odynson");

            czytelnik1.PrzeczytaneKsiazki.Add(ksiazka7);
            czytelnik4.PrzeczytaneKsiazki.Add(ksiazka8);
            czytelnik5.PrzeczytaneKsiazki.Add(ksiazka9);
            czytelnik2.PrzeczytaneKsiazki.Add(ksiazka10);

            foreach (Osoba osoba in listaCzytelnikow)
                osoba.Podglad();
        }
    }

    internal class Osoba
    {
        private string imie, nazwisko;
        private int wiek;

        public Osoba(string imie, string nazwisko, int wiek)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.wiek = wiek;
        }

        public string Imie
        {
            get => imie;
            set { if (value.Length >= 3) imie = value; }
        }
        public string Nazwisko
        {
            get => nazwisko;
            set { if (value.Length >= 3) nazwisko = value; }
        }
        public int Wiek
        {
            get => wiek;
            set { if (value >= 0) wiek = value; }
        }

        public virtual void Podglad()
        {
            Console.WriteLine($"Imie i nazwisko: {Imie} {Nazwisko}; wiek {Wiek} lat\n");
        }
    }

    internal class Ksiazka
    {
        private string tytul;
        private Osoba autor;
        private DateOnly dataWydania;

        public Ksiazka(string tytul, Osoba autor, DateOnly dataWydania)
        {
            this.tytul = tytul;
            this.autor = autor;
            this.dataWydania = dataWydania;
        }

        public string Tytul 
        { 
            get => tytul;
            set { if (value.Length >= 3) tytul = value; }
        }
        public Osoba Autor
        {
            get => autor;
            set
            {
                Autor.Imie = value.Imie;
                Autor.Nazwisko = value.Nazwisko;
                Autor.Wiek = value.Wiek;
            }
        }
        public DateOnly DataWydania
        {
            get => dataWydania;
            set { dataWydania = value; }
        }

        public void Podglad()
        {
            Console.WriteLine($"Imie i nazwisko autora: {Autor.Imie} {Autor.Nazwisko}; wiek {Autor.Wiek} lat; ");
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}\n");
        }
        public void InfoKsiazka()
        {
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}");
        }
        public virtual void InfoKsiazkaAutor()
        {
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; autor: {Autor.Imie} {Autor.Nazwisko}");
        }
        public virtual void InfoKsiazkaAutorOcena()
        {
            Random random = new Random();
            int ocena = random.Next(5) + 1;
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; autor: {Autor.Imie} {Autor.Nazwisko}; Ocena książki: {ocena}/5");
        }
    }

    internal class Czytelnik : Osoba
    {
        private List<Ksiazka> przeczytaneKsiazki = new List<Ksiazka>();

        public Czytelnik(Osoba osoba) : base(osoba.Imie, osoba.Nazwisko, osoba.Wiek) { }
        public Czytelnik(string imie, string nazwisko, int wiek) : base(imie, nazwisko, wiek) { }

        public List<Ksiazka> PrzeczytaneKsiazki 
        { 
            get => przeczytaneKsiazki;
            set { przeczytaneKsiazki = value; }
        }

        public virtual void InfoPrzeczytaneKsiazki()
        {
            Console.WriteLine("Przeczytane książki:");
            if (przeczytaneKsiazki.Count > 0)
            {
                foreach (Ksiazka ksiazka in przeczytaneKsiazki)
                    ksiazka.InfoKsiazkaAutor();
                Console.WriteLine("");
            }
            else Console.WriteLine("brak przeczytanych książek\n");
        }
        public override void Podglad()
        {
            Console.WriteLine($"Imie i nazwisko czytelnika: {Imie} {Nazwisko}; wiek {Wiek} lat");
            InfoPrzeczytaneKsiazki();
        }
    }

    internal class Recenzent : Czytelnik
    {
        public Recenzent(Osoba osoba) : base(osoba) { }
        public Recenzent(string imie, string nazwisko, int wiek) : base(imie, nazwisko, wiek) { }

        public override void InfoPrzeczytaneKsiazki()
        {
            Console.WriteLine("Przeczytane książki:");
            if (PrzeczytaneKsiazki.Count > 0)
            {
                foreach (Ksiazka ksiazka in PrzeczytaneKsiazki)
                    ksiazka.InfoKsiazkaAutorOcena();
                Console.WriteLine("");
            }
            else Console.WriteLine("brak przeczytanych książek\n");
        }
        public override void Podglad()
        {
            Console.WriteLine($"Imie i nazwisko recenzenta: {Imie} {Nazwisko}; wiek {Wiek} lat");
            InfoPrzeczytaneKsiazki();
        }
    }

    internal class KsiazkaPrzygodowa : Ksiazka
    {
        private string miejsceAkcji;

        public KsiazkaPrzygodowa(string tytul, Osoba autor, DateOnly dataWydania, string miejsceAkcji) : base(tytul, autor, dataWydania) 
        { 
            this.miejsceAkcji = miejsceAkcji;
        }

        public string MiejsceAkcji 
        { 
            get => miejsceAkcji; 
            set => miejsceAkcji = value; 
        }

        public override void InfoKsiazkaAutor()
        {
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; typ książki: przygodowa; miejsce akcji: {MiejsceAkcji}; autor: {Autor.Imie} {Autor.Nazwisko}");
        }
        public override void InfoKsiazkaAutorOcena()
        {
            Random random = new Random();
            int ocena = random.Next(5) + 1;
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; typ książki: przygodowa; miejsce akcji: {MiejsceAkcji}; autor: {Autor.Imie} {Autor.Nazwisko}; Ocena książki: {ocena}/5");
        }
    }

    internal class KsiazkaDokumentarna : Ksiazka
    {
        private string bohaterDokumentu;

        public KsiazkaDokumentarna(string tytul, Osoba autor, DateOnly dataWydania, string bohaterDokumentu) : base(tytul, autor, dataWydania)
        { 
            this.bohaterDokumentu = bohaterDokumentu;
        }

        public string BohaterDokumentu 
        { 
            get => bohaterDokumentu; 
            set => bohaterDokumentu = value; 
        }

        public override void InfoKsiazkaAutor()
        {
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; typ książki: dokumentalna; bohater dokumentu: {BohaterDokumentu}; autor: {Autor.Imie} {Autor.Nazwisko}");
        }
        public override void InfoKsiazkaAutorOcena()
        {
            Random random = new Random();
            int ocena = random.Next(5) + 1;
            Console.WriteLine($"Tytuł książki: {Tytul}; data wydania książki: {DataWydania}; typ książki: dokumentalna; bohater dokumentu: {BohaterDokumentu}; autor: {Autor.Imie} {Autor.Nazwisko}; Ocena książki: {ocena}/5");
        }
    }
}
