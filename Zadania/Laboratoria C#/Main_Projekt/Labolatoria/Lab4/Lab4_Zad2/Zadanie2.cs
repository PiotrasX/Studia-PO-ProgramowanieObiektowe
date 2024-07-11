namespace Lab4_Zad2
{
    internal class Zadanie2
    {
        static void Main(string[] args)
        {
            Uczen uczen1 = new Uczen("Jan", "Śliwa", "06230644537", "Szkoła podstawowa numer 9 im. Andrzeja Dudy w Warszawie", false);
            Uczen uczen2 = new Uczen("Łukasz", "Powidlok", "99050393734", "Liceum sióstr kapucynek w Brzostku", true);
            Uczen uczen3 = new Uczen("Michalina", "Kiepska", "09261942667", "Szkoła podstawowa numer 9 im. Andrzeja Dudy w Warszawie", false);
            Uczen uczen4 = new Uczen("Stefan", "Czerstwy", "02323012458", "Liceum sióstr kapucynek w Brzostku", true);
            Uczen uczen5 = new Uczen("Justyna", "Mandarynkowa", "06272527264", "Liceum sióstr kapucynek w Brzostku", false);

            Nauczyciel nauczyciel1 = new Nauczyciel("Mariusz", "Niewski", "81081614135", "Szkoła podstawowa numer 9 im. Andrzeja Dudy w Warszawie", true, TytulNaukowy.magister_inzynier);
            nauczyciel1.PodwladniUczniowie.Add(uczen1);
            nauczyciel1.PodwladniUczniowie.Add(uczen3);
            Nauczyciel nauczyciel2 = new Nauczyciel("Małgorzata", "Węglowska", "79052764529", "Liceum sióstr kapucynek w Brzostku", true, TytulNaukowy.magister);
            nauczyciel2.PodwladniUczniowie.Add(uczen2);
            nauczyciel2.PodwladniUczniowie.Add(uczen4);
            nauczyciel2.PodwladniUczniowie.Add(uczen5);

            Console.WriteLine($"Uczeń 1 -> {uczen1.GetImieINazwisko()}, {uczen1.GetWiek()} lat, płeć: {uczen1.GetPlec()}");
            Console.WriteLine($"Uczeń 2 -> {uczen2.GetImieINazwisko()}, {uczen2.GetWiek()} lat, płeć: {uczen2.GetPlec()}");
            Console.WriteLine($"Uczeń 3 -> {uczen3.GetImieINazwisko()}, {uczen3.GetWiek()} lat, płeć: {uczen3.GetPlec()}");
            Console.WriteLine($"Uczeń 4 -> {uczen4.GetImieINazwisko()}, {uczen4.GetWiek()} lat, płeć: {uczen4.GetPlec()}");
            Console.WriteLine($"Uczeń 5 -> {uczen5.GetImieINazwisko()}, {uczen5.GetWiek()} lat, płeć: {uczen5.GetPlec()}");
            Console.WriteLine();

            Console.WriteLine($"Nauczyciel 1 -> {nauczyciel1.GetImieINazwisko()}, {nauczyciel1.GetWiek()} lat, płeć: {nauczyciel1.GetPlec()}");
            Console.WriteLine($"Nauczyciel 2 -> {nauczyciel2.GetImieINazwisko()}, {nauczyciel2.GetWiek()} lat, płeć: {nauczyciel2.GetPlec()}");
            Console.WriteLine("\n\n");

            Console.WriteLine($"Nauczyciel 1 -> {nauczyciel1.GetImieINazwisko()}, {nauczyciel1.GetWiek()} lat, płeć: {nauczyciel1.GetPlec()}");
            Console.WriteLine("\nPodwładni uczniowie:");
            foreach (var uczen in nauczyciel1.PodwladniUczniowie)
                Console.WriteLine($"Uczeń -> {uczen.GetImieINazwisko()}, {uczen.GetWiek()} lat, płeć: {uczen.GetPlec()}");
            Console.WriteLine("\nKtórzy uczniowie mogą iść do domu:");
            nauczyciel1.KtorzyUczniowieMogaIscDoDomu();
            Console.WriteLine("\n\n");

            Console.WriteLine($"Nauczyciel 2 -> {nauczyciel2.GetImieINazwisko()}, {nauczyciel2.GetWiek()} lat, płeć: {nauczyciel2.GetPlec()}");
            Console.WriteLine("\nPodwładni uczniowie:");
            foreach (var uczen in nauczyciel2.PodwladniUczniowie)
                Console.WriteLine($"Uczeń -> {uczen.GetImieINazwisko()}, {uczen.GetWiek()} lat, płeć: {uczen.GetPlec()}");
            Console.WriteLine("\nKtórzy uczniowie mogą iść do domu:");
            nauczyciel2.KtorzyUczniowieMogaIscDoDomu();
        }
    }

    internal abstract class Osoba
    {
        private string imie, nazwisko, pesel;

        public string Imie
        {
            get { return imie; }
            set { imie = value; }
        }
        public string Nazwisko
        {
            get { return nazwisko; }
            set { nazwisko = value; }
        }
        public string Pesel
        {
            get { return pesel; }
            set { pesel = value; }
        }

        public void SetImie(string imie)
        {
            this.imie = imie;
        }
        public void SetNazwisko(string nazwisko)
        {
            this.nazwisko = nazwisko;
        }
        public void SetPesel(string pesel)
        {
            this.pesel = pesel;
        }

        public int GetWiek()
        {
            int rok, miesiac, wiek;
            int.TryParse(pesel.Substring(0, 2), out rok);
            int.TryParse(pesel.Substring(2, 1), out miesiac);
            if (miesiac == 8 || miesiac == 9) rok += 1800;
            else if (miesiac == 0 || miesiac == 1) rok += 1900;
            else if (miesiac == 2 || miesiac == 3) rok += 2000;
            else if (miesiac == 4 || miesiac == 5) rok += 2100;
            else rok += 2200;
            DateTime thisDay = DateTime.Today;
            wiek = thisDay.Year;
            wiek -= rok;
            return wiek;
        }

        public char GetPlec()
        {
            char plec;
            int plecLiczba;
            int.TryParse(pesel.Substring(9, 1), out plecLiczba);
            if (plecLiczba % 2 == 0) plec = 'K';
            else plec = 'M';
            return plec;
        }

        public Osoba(string imie, string nazwisko, string pesel)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Pesel = pesel;
        }

        public abstract string GetInformacjaOEdukacji();
        public abstract string GetImieINazwisko();
        public abstract bool CzyMozeIscDoDomu();
    }

    internal class Uczen : Osoba
    {
        private string szkola;
        private bool mozeSamWracacDoDomu;

        public string Szkola { get => szkola; set => szkola = value; }
        public bool MozeSamWracacDoDomu { get => mozeSamWracacDoDomu; set => mozeSamWracacDoDomu = value; }

        public void SetSzkola(string szkola)
        {
            this.szkola = szkola;
        }
        public void ZmianaSzkoly(string szkola)
        {
            Szkola = szkola;
        }
        public void SetMozeSamWracacDoDomu(bool mozeSamWracacDoDomu)
        {
            this.mozeSamWracacDoDomu = mozeSamWracacDoDomu;
        }

        public Uczen(string imie, string nazwisko, string pesel, string szkola, bool mozeSamWracacDoDomu) : base(imie, nazwisko, pesel) 
        { 
            Szkola = szkola;
            MozeSamWracacDoDomu = mozeSamWracacDoDomu;
        }

        public override bool CzyMozeIscDoDomu()
        {
            return MozeSamWracacDoDomu;
        }
        public override string GetImieINazwisko()
        {
            return Imie + " " + Nazwisko;
        }
        public override string GetInformacjaOEdukacji()
        {
            return Szkola;
        }
    }

    public enum TytulNaukowy
    {
        inzynier, licencjat, magister, magister_inzynier, doktor, doktor_inzynier, profesor
    }

    internal class Nauczyciel : Uczen
    {
        private TytulNaukowy tytulNaukowy;
        private List<Uczen> podwladniUczniowie;

        public TytulNaukowy TytulNaukowy { get => tytulNaukowy; set => tytulNaukowy = value; }
        public List<Uczen> PodwladniUczniowie { get => podwladniUczniowie; set => podwladniUczniowie = value; }

        public Nauczyciel(string imie, string nazwisko, string pesel, string szkola, bool mozeSamWracacDoDomu, TytulNaukowy tytulNaukowy) : base(imie, nazwisko, pesel, szkola, mozeSamWracacDoDomu) 
        {
            TytulNaukowy = tytulNaukowy;
            PodwladniUczniowie = new List<Uczen> { };
        }

        public void KtorzyUczniowieMogaIscDoDomu()
        {
            foreach (var uczen in PodwladniUczniowie)
            {
                if (uczen.MozeSamWracacDoDomu == true)
                    Console.WriteLine($"Uczeń {uczen.GetImieINazwisko()} może iść do domu sam");
                else Console.WriteLine($"Uczeń {uczen.GetImieINazwisko()} nie może iść do domu sam");
            }
        }
    }
}
