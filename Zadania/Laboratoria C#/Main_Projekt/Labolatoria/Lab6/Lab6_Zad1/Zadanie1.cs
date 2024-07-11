using CsvHelper;
using System;
using System.Formats.Asn1;
using System.Globalization;
using static System.Console;

namespace Lab6_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            string sciezkaCSV = "osoby.csv";

            while (true)
            {
                BackgroundColor = ConsoleColor.Gray;
                ForegroundColor = ConsoleColor.DarkBlue;
                Write(" =====   MENU   ===== ");
                ResetColor();
                WriteLine();
                ForegroundColor = ConsoleColor.Cyan;
                WriteLine("1. Wyświetl osobę");
                WriteLine("2. Dodaj osobę");
                WriteLine("3. Modyfikuj osobę");
                WriteLine("4. Usuń osobę");
                WriteLine("5. Wyjście z programu");
                ForegroundColor = ConsoleColor.DarkCyan;
                Write("Wybierz opcję: ");
                int opcja;
                int.TryParse(ReadLine(), out opcja);
                ResetColor();

                if (opcja == 1) { WyswietlOsobe(sciezkaCSV); }
                else if (opcja == 2) { DodajOsobe(sciezkaCSV); }
                else if (opcja == 3) { ModyfikujOsobe(sciezkaCSV); }
                else if (opcja == 4) { UsunOsobe(sciezkaCSV); }
                else if (opcja == 5) { ForegroundColor = ConsoleColor.DarkGreen; Write("\nZakończono działanie programu!\n\n\n"); ResetColor(); break; }
                else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\nBrak takiej opcji, spróbuj ponownie"); }
                ResetColor();
                Write("\n\n\n");
            }
        }

        static void WyswietlOsobe(string sciezkaCSV)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                using (var czytnik = new StreamReader(sciezkaCSV))
                using (var csv = new CsvReader(czytnik, CultureInfo.InvariantCulture))
                {
                    liczbaRekordow = csv.GetRecords<dynamic>().Count();
                }

                if (liczbaRekordow < 1)
                {
                    ForegroundColor = ConsoleColor.DarkRed;
                    WriteLine("\nBrak danych w pliku");
                    ResetColor();
                    break;
                }
                else
                {
                    ForegroundColor = ConsoleColor.Magenta;
                    WriteLine("\n\tJaki sposób wyświetlania wybierasz:");
                    ForegroundColor = ConsoleColor.Yellow;
                    WriteLine("\t1. Wyświetl osobę z zakresu");
                    WriteLine("\t2. Wyświetl osobę na podstawie wyszukiwania");
                    ForegroundColor = ConsoleColor.DarkYellow;
                    Write("\tWybierz opcję: ");
                    int opcja;
                    int.TryParse(ReadLine(), out opcja);
                    ResetColor();

                    if (opcja == 1)
                    {
                        int opcjaZakres;
                        while (true)
                        {
                            ForegroundColor = ConsoleColor.Cyan;
                            Write($"\n\t\tPodaj liczbę z zakresu od 1 do {liczbaRekordow}: ");
                            int.TryParse(ReadLine(), out opcjaZakres);
                            if (opcjaZakres > 0 && opcjaZakres <= liczbaRekordow) break;
                            else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\t\tBrak takiej opcji, spróbuj ponownie"); }
                        }

                        using (var odczytaj = new StreamReader(sciezkaCSV))
                        using (var csv = new CsvReader(odczytaj, CultureInfo.InvariantCulture))
                        {
                            var rekordy = csv.GetRecords<Osoba>();
                            var osoba = rekordy.ElementAt(opcjaZakres - 1);
                            ForegroundColor = ConsoleColor.White;
                            WriteLine($"\nWyniki wyszukiwania dla {opcjaZakres} rekordu:");
                            ResetColor();
                            WriteLine(osoba);
                        }
                        break;
                    }
                    else if (opcja == 2)
                    {
                        using (var odczytaj = new StreamReader(sciezkaCSV))
                        using (var csv = new CsvReader(odczytaj, CultureInfo.InvariantCulture))
                        {
                            ForegroundColor = ConsoleColor.Cyan;
                            Write("\n\t\tPodaj teskt do wyszukania: ");
                            string opcjaWyszukaj = ReadLine();
                            ResetColor();

                            var rekordy = csv.GetRecords<Osoba>().Where(p => p.Imie.Contains(opcjaWyszukaj) || p.Nazwisko.Contains(opcjaWyszukaj) || p.Email.Contains(opcjaWyszukaj) || p.Pesel.Contains(opcjaWyszukaj) || p.Adres.Ulica.Contains(opcjaWyszukaj) || p.Adres.Numer.Contains(opcjaWyszukaj) || p.Adres.KodPocztowy.Contains(opcjaWyszukaj) || p.Adres.Miejscowosc.Contains(opcjaWyszukaj)).ToList();

                            ForegroundColor = ConsoleColor.White;
                            WriteLine($"\nWyniki wyszukiwania dla '{opcjaWyszukaj}':");
                            ResetColor();
                            foreach (var osoba in rekordy) { WriteLine(osoba); }
                            break;
                        }
                    }
                    else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\n\tBrak takiej opcji, spróbuj ponownie"); }
                }
            }
        }

        static void DodajOsobe(string sciezkaCSV)
        {
            Osoba osoba = new Osoba();
            osoba.PodajImie();
            osoba.PodajNazwisko();
            osoba.PodajAdres();
            osoba.PodajPesel();
            osoba.PodajEmail();
            ForegroundColor = ConsoleColor.White;
            WriteLine("\nWprowadzone dane:");
            ResetColor();
            WriteLine(osoba);

            using (var zapisz = new StreamWriter(sciezkaCSV, true))
            using (var csv = new CsvWriter(zapisz, CultureInfo.InvariantCulture)) { csv.WriteRecord(osoba); csv.Flush(); }
        }

        static void ModyfikujOsobe(string sciezkaCSV)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                using (var czytnik = new StreamReader(sciezkaCSV))
                using (var csv = new CsvReader(czytnik, CultureInfo.InvariantCulture))
                {
                    liczbaRekordow = csv.GetRecords<dynamic>().Count();
                }

                if (liczbaRekordow < 1)
                {
                    ForegroundColor = ConsoleColor.DarkRed;
                    WriteLine("\nBrak danych w pliku");
                    ResetColor();
                    break;
                }
                else
                {
                    int opcjaZakres;
                    while (true)
                    {
                        ForegroundColor = ConsoleColor.Magenta;
                        WriteLine("\n\tJaką chcesz modyfikować osobę?");
                        ForegroundColor = ConsoleColor.Cyan;
                        Write($"\tPodaj liczbę z zakresu od 1 do {liczbaRekordow}: ");
                        int.TryParse(ReadLine(), out opcjaZakres);
                        if (opcjaZakres > 0 && opcjaZakres <= liczbaRekordow) break;
                        else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\tBrak takiej opcji, spróbuj ponownie"); }
                    }

                    List<Osoba> rekordyList;
                    using (var odczytaj = new StreamReader(sciezkaCSV))
                    using (var csv = new CsvReader(odczytaj, CultureInfo.InvariantCulture))
                    {
                        rekordyList = csv.GetRecords<Osoba>().ToList();
                    }

                    Osoba osoba = rekordyList.ElementAt(opcjaZakres - 1);
                    int opcjaModyfikacji;
                    while (true)
                    {
                        ForegroundColor = ConsoleColor.Magenta;
                        WriteLine("\n\t\tJaką chcesz zmodyfikować wartość?");
                        ForegroundColor = ConsoleColor.Yellow;
                        WriteLine("\t\t1. Imię");
                        WriteLine("\t\t2. Nazwisko");
                        WriteLine("\t\t3. Ulica");
                        WriteLine("\t\t4. Numer domu/mieszkania");
                        WriteLine("\t\t5. Kod pocztowy");
                        WriteLine("\t\t6. Miejscowość");
                        WriteLine("\t\t7. PESEL");
                        WriteLine("\t\t8. Email");
                        ForegroundColor = ConsoleColor.Cyan;
                        Write($"\t\tPodaj liczbę z zakresu od 1 do 8: ");
                        int.TryParse(ReadLine(), out opcjaModyfikacji);
                        if (opcjaModyfikacji == 1) osoba.PodajImie();
                        else if (opcjaModyfikacji == 2) osoba.PodajNazwisko();
                        else if (opcjaModyfikacji == 3) osoba.Adres.PodajUlice();
                        else if (opcjaModyfikacji == 4) osoba.Adres.PodajNumer();
                        else if (opcjaModyfikacji == 5) osoba.Adres.PodajKodPocztowy();
                        else if (opcjaModyfikacji == 6) osoba.Adres.PodajMiejscowosc();
                        else if (opcjaModyfikacji == 7) osoba.PodajPesel();
                        else if (opcjaModyfikacji == 8) osoba.PodajEmail();
                        else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\t\tBrak takiej opcji, spróbuj ponownie"); }
                        if (opcjaModyfikacji > 0 && opcjaModyfikacji <= 8) break;
                    }

                    using (var zapisz = new StreamWriter(sciezkaCSV))
                    using (var csv = new CsvWriter(zapisz, CultureInfo.InvariantCulture))
                    {
                        csv.WriteRecords(rekordyList);
                        ForegroundColor = ConsoleColor.White;
                        WriteLine($"\nZmodyfikowano {opcjaZakres} rekord z pliku");
                        ResetColor();
                    }
                    break;
                }
            }
        }

        static void UsunOsobe(string sciezkaCSV)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                using (var czytnik = new StreamReader(sciezkaCSV))
                using (var csv = new CsvReader(czytnik, CultureInfo.InvariantCulture))
                {
                    liczbaRekordow = csv.GetRecords<dynamic>().Count();
                }

                if (liczbaRekordow < 1)
                {
                    ForegroundColor = ConsoleColor.DarkRed;
                    WriteLine("\nBrak danych w pliku");
                    ResetColor();
                    break;
                }
                else
                {
                    int opcjaZakres;
                    while (true)
                    {
                        ForegroundColor = ConsoleColor.Magenta;
                        WriteLine("\n\tJaką chcesz usunąć osobę?");
                        ForegroundColor = ConsoleColor.Cyan;
                        Write($"\tPodaj liczbę z zakresu od 1 do {liczbaRekordow}: ");
                        int.TryParse(ReadLine(), out opcjaZakres);
                        if (opcjaZakres > 0 && opcjaZakres <= liczbaRekordow) break;
                        else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\tBrak takiej opcji, spróbuj ponownie"); }
                    }

                    List<Osoba> rekordyList;
                    using (var odczytaj = new StreamReader(sciezkaCSV))
                    using (var csv = new CsvReader(odczytaj, CultureInfo.InvariantCulture))
                    {
                        rekordyList = csv.GetRecords<Osoba>().ToList();
                        rekordyList.RemoveAt(opcjaZakres - 1);
                        ForegroundColor = ConsoleColor.White;
                        WriteLine($"\nUsunięto {opcjaZakres} rekord z pliku");
                        ResetColor();
                    }
                    using (var zapisz = new StreamWriter(sciezkaCSV))
                    using (var csv = new CsvWriter(zapisz, CultureInfo.InvariantCulture))
                    {
                        csv.WriteRecords(rekordyList);
                    }
                    break;
                }
            }
        }
    }

    internal class Osoba
    {
        private string imie;
        private string nazwisko;
        private Adres adres;
        private string pesel;
        private string email;

        public string Imie { get => imie; set => imie = value; }
        public string Nazwisko { get => nazwisko; set => nazwisko = value; }
        public Adres Adres { get => adres; set => adres = value; }
        public string Pesel { get => pesel; set => pesel = value; }
        public string Email { get => email; set => email = value; }

        public Osoba(string imie, string nazwisko, Adres adres, string pesel, string email)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Adres = adres;
            Pesel = pesel;
            Email = email;
        }
        public Osoba() { }

        private string PrawidlowyString(string tekst, bool zamien)
        {
            if (zamien) tekst = char.ToUpper(tekst[0]) + tekst.Substring(1).ToLower();
            ForegroundColor = ConsoleColor.DarkGreen;
            WriteLine("\tPodano prawidłowe dane");
            ResetColor();
            return tekst;
        }

        public void PodajImie()
        {
            while (true) 
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\tPodaj imię: ");
                Imie = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Imie) || string.IsNullOrWhiteSpace(Imie) || !Imie.All(char.IsLetter))
                    { WriteLine("\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Imie = PrawidlowyString(Imie, true); break; }
            }
        }
        public void PodajNazwisko()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\tPodaj nazwisko: ");
                Nazwisko = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Nazwisko) || string.IsNullOrWhiteSpace(Nazwisko) || !Nazwisko.All(char.IsLetter))
                    { WriteLine("\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Nazwisko = PrawidlowyString(Nazwisko, true); break; }
            }
        }
        public void PodajAdres()
        {
            ForegroundColor = ConsoleColor.White;
            WriteLine("\n\tPodaj Adres: ");
            Adres adres = new Adres();
            adres.PodajUlice();
            adres.PodajNumer();
            adres.PodajKodPocztowy();
            adres.PodajMiejscowosc();
            Adres = adres;
        }
        public void PodajPesel()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\tPodaj PESEL: ");
                Pesel = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Pesel) || string.IsNullOrWhiteSpace(Pesel) || !Pesel.All(char.IsNumber) || Pesel.Length != 11)
                    { WriteLine("\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Pesel = PrawidlowyString(Pesel, false); break; }
            }
        }
        public void PodajEmail()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\tPodaj email: ");
                Email = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Email) || string.IsNullOrWhiteSpace(Email) || !Email.Contains("@"))
                    { WriteLine("\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Email = PrawidlowyString(Email, false); break; }
            }
        }

        public override string ToString()
        {
            return $"\nImię: {Imie}\nNazwisko: {Nazwisko}\n{Adres}PESEL: {Pesel}\nEmail: {Email}";
        }
    }

    internal class Adres
    {
        private string ulica;
        private string numer;
        private string kodPocztowy;
        private string miejscowosc;

        public string Ulica { get => ulica; set => ulica = value; }
        public string Numer { get => numer; set => numer = value; }
        public string KodPocztowy { get => kodPocztowy; set => kodPocztowy = value; }
        public string Miejscowosc { get => miejscowosc; set => miejscowosc = value; }

        public Adres(string ulica, string numer, string kodPocztowy, string miejscowosc)
        {
            Ulica = ulica;
            Numer = numer;
            KodPocztowy = kodPocztowy;
            Miejscowosc = miejscowosc;
        }
        public Adres() { }

        private string PrawidlowyString(string tekst, bool zamien)
        {
            if (zamien) tekst = char.ToUpper(tekst[0]) + tekst.Substring(1).ToLower();
            ForegroundColor = ConsoleColor.DarkGreen;
            WriteLine("\t\tPodano prawidłowe dane");
            ResetColor();
            return tekst;
        }

        public void PodajUlice()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\t\tPodaj ulicę: ");
                Ulica = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Ulica) || string.IsNullOrWhiteSpace(Ulica))
                { WriteLine("\t\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Ulica = PrawidlowyString(Ulica, true); break; }
            }
        }
        public void PodajNumer()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\t\tPodaj numer mieszkania/domu: ");
                Numer = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Numer) || string.IsNullOrWhiteSpace(Numer))
                { WriteLine("\t\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Numer = PrawidlowyString(Numer, false); break; }
            }
        }
        public void PodajKodPocztowy()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\t\tPodaj kod pocztowy: ");
                KodPocztowy = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(KodPocztowy) || string.IsNullOrWhiteSpace(KodPocztowy) || KodPocztowy.Length != 6)
                { WriteLine("\t\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else if (!KodPocztowy.Where((c, i) => i != 2).All(char.IsDigit) || KodPocztowy.Substring(2, 1) != "-") { WriteLine("\t\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { KodPocztowy = PrawidlowyString(KodPocztowy, false); break; }
            }
        }
        public void PodajMiejscowosc()
        {
            while (true)
            {
                ForegroundColor = ConsoleColor.White;
                Write("\n\t\tPodaj miejscowość: ");
                Miejscowosc = ReadLine();

                ForegroundColor = ConsoleColor.DarkRed;
                if (string.IsNullOrEmpty(Miejscowosc) || string.IsNullOrWhiteSpace(Miejscowosc) || !Miejscowosc.All(char.IsLetter))
                { WriteLine("\t\tPodano niepoprawne informacje, spróbuj ponownie"); }
                else { Miejscowosc = PrawidlowyString(Miejscowosc, true); break; }
            }
        }

        public override string ToString()
        {
            return $"Adres:\n\tUlica: {Ulica}\n\tNumer domu/mieszkania: {Numer}\n\tKod pocztowy: {KodPocztowy}\n\tMiejscowość: {Miejscowosc}\n";
        }
    }
}
