using System.Data.SqlClient;
using static System.Console;

namespace Lab6_Zad2
{
    internal class Zadanie2
    {
        static void Main(string[] args)
        {
            string connectionString = "Data Source=LAPTOP-PIOTRASX;Initial Catalog=CSLab6Zadanie2;Integrated Security=True";
            string createTableQuery = @"
            CREATE TABLE Osoby
            (
                Id INT PRIMARY KEY IDENTITY(1,1),
                Imie NVARCHAR(50),
                Nazwisko NVARCHAR(50),
                Ulica NVARCHAR(100),
                Numer NVARCHAR(15),
                KodPocztowy NVARCHAR(6) CHECK (KodPocztowy LIKE '[0-9][0-9]-[0-9][0-9][0-9]'),
                Miejscowosc NVARCHAR(100),
                Pesel CHAR(11) CHECK (LEN(Pesel) = 11 AND Pesel NOT LIKE '%[^0-9]%'),
                Email NVARCHAR(100)
            )";

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();

                // Tworzenie tabeli jeśli nie istnieje
                using (SqlCommand createTableCommand = new SqlCommand(createTableQuery, connection))
                {
                    try { createTableCommand.ExecuteNonQuery(); }
                    catch (Exception ex) { }
                }

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

                    if (opcja == 1) { WyswietlOsobe(connectionString, connection); }
                    else if (opcja == 2) { DodajOsobe(connectionString, connection); }
                    else if (opcja == 3) { ModyfikujOsobe(connectionString, connection); }
                    else if (opcja == 4) { UsunOsobe(connectionString, connection); }
                    else if (opcja == 5) { ForegroundColor = ConsoleColor.DarkGreen; Write("\nZakończono działanie programu!\n\n\n"); ResetColor(); break; }
                    else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\nBrak takiej opcji, spróbuj ponownie"); }
                    ResetColor();
                    Write("\n\n\n");
                }
            }
        }

        static void WyswietlOsobe(string connectionString, SqlConnection connection)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                string countQuery = "SELECT COUNT(*) FROM Osoby";
                using (SqlCommand countCommand = new SqlCommand(countQuery, connection))
                {
                    liczbaRekordow = (int)countCommand.ExecuteScalar();
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
                        WyswietlOsobeZZakresu(connection, liczbaRekordow);
                        break;
                    }
                    else if (opcja == 2)
                    {
                        WyswietlOsobeZZakresu(connection);
                        break;
                    }
                    else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\n\tBrak takiej opcji, spróbuj ponownie"); }
                }
            }
        }

        private static void WyswietlOsobeZZakresu(SqlConnection connection, int liczbaRekordow)
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

            string query = $"SELECT * FROM Osoby ORDER BY Id OFFSET {opcjaZakres - 1} ROWS FETCH NEXT 1 ROWS ONLY";
            using (SqlCommand command = new SqlCommand(query, connection))
            {
                using (SqlDataReader reader = command.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        Osoba osoba = new Osoba(reader);
                        ForegroundColor = ConsoleColor.White;
                        WriteLine($"\nWyniki wyszukiwania dla {opcjaZakres} rekordu:");
                        ResetColor();
                        WriteLine(osoba);
                    }
                }
            }
        }

        private static void WyswietlOsobeZZakresu(SqlConnection connection)
        {
            ForegroundColor = ConsoleColor.Cyan;
            Write("\n\t\tPodaj teskt do wyszukania: ");
            string opcjaWyszukaj = ReadLine();
            ResetColor();

            string query = $"SELECT * FROM Osoby WHERE Imie LIKE '%{opcjaWyszukaj}%' OR Nazwisko LIKE '%{opcjaWyszukaj}%' OR Ulica LIKE '%{opcjaWyszukaj}%' OR Numer LIKE '%{opcjaWyszukaj}%' OR KodPocztowy LIKE '%{opcjaWyszukaj}%' OR Miejscowosc LIKE '%{opcjaWyszukaj}%' OR Pesel LIKE '%{opcjaWyszukaj}%' OR Email LIKE '%{opcjaWyszukaj}%'";

            using (SqlCommand command = new SqlCommand(query, connection))
            {
                using (SqlDataReader reader = command.ExecuteReader())
                {
                    ForegroundColor = ConsoleColor.White;
                    WriteLine($"\nWyniki wyszukiwania dla '{opcjaWyszukaj}':");
                    ResetColor();
                    while (reader.Read())
                    {
                        Osoba osoba = new Osoba(reader);
                        WriteLine(osoba.ToString());
                    }
                }
            }
        }

        static void DodajOsobe(string connectionString, SqlConnection connection)
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

            string insertQuery = @"
            INSERT INTO Osoby (Imie, Nazwisko, Ulica, Numer, KodPocztowy, Miejscowosc, Pesel, Email) 
            VALUES (@Imie, @Nazwisko, @Ulica, @Numer, @KodPocztowy, @Miejscowosc, @Pesel, @Email)";

            using (SqlCommand command = new SqlCommand(insertQuery, connection))
            {
                command.Parameters.AddWithValue("@Imie", osoba.Imie);
                command.Parameters.AddWithValue("@Nazwisko", osoba.Nazwisko);
                command.Parameters.AddWithValue("@Ulica", osoba.Adres.Ulica);
                command.Parameters.AddWithValue("@Numer", osoba.Adres.Numer);
                command.Parameters.AddWithValue("@KodPocztowy", osoba.Adres.KodPocztowy);
                command.Parameters.AddWithValue("@Miejscowosc", osoba.Adres.Miejscowosc);
                command.Parameters.AddWithValue("@Pesel", osoba.Pesel);
                command.Parameters.AddWithValue("@Email", osoba.Email);

                try { command.ExecuteNonQuery(); }
                catch (Exception ex) { }
            }
        }

        static void ModyfikujOsobe(string connectionString, SqlConnection connection)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                string countQuery = "SELECT COUNT(*) FROM Osoby";
                using (SqlCommand countCommand = new SqlCommand(countQuery, connection))
                {
                    liczbaRekordow = (int)countCommand.ExecuteScalar();
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

                    string selectQuery = "SELECT * FROM Osoby WHERE Id = @Id";
                    Osoba osoba = new Osoba();
                    using (SqlCommand selectCommand = new SqlCommand(selectQuery, connection))
                    {
                        selectCommand.Parameters.AddWithValue("@Id", opcjaZakres);
                        int opcjaModyfikacji;
                        string poleDoZmiany = "";
                        object wartoscDoZmiany = null;
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
                            if (osoba.Adres == null) osoba.Adres = new Adres();
                            if (opcjaModyfikacji == 1) { osoba.PodajImie(); poleDoZmiany = "Imie"; wartoscDoZmiany = osoba.Imie; }
                            else if (opcjaModyfikacji == 2) { osoba.PodajNazwisko(); poleDoZmiany = "Nazwisko"; wartoscDoZmiany = osoba.Nazwisko; }
                            else if (opcjaModyfikacji == 3) { osoba.Adres.PodajUlice(); poleDoZmiany = "Ulica"; wartoscDoZmiany = osoba.Adres.Ulica; }
                            else if (opcjaModyfikacji == 4) { osoba.Adres.PodajNumer(); poleDoZmiany = "Numer"; wartoscDoZmiany = osoba.Adres.Numer; }
                            else if (opcjaModyfikacji == 5) { osoba.Adres.PodajKodPocztowy(); poleDoZmiany = "KodPocztowy"; wartoscDoZmiany = osoba.Adres.KodPocztowy; }
                            else if (opcjaModyfikacji == 6) { osoba.Adres.PodajMiejscowosc(); poleDoZmiany = "Miejscowosc"; wartoscDoZmiany = osoba.Adres.Miejscowosc; }
                            else if (opcjaModyfikacji == 7) { osoba.PodajPesel(); poleDoZmiany = "Pesel"; wartoscDoZmiany = osoba.Pesel; }
                            else if (opcjaModyfikacji == 8) { osoba.PodajEmail(); poleDoZmiany = "Email"; wartoscDoZmiany = osoba.Email; }
                            else { ForegroundColor = ConsoleColor.DarkRed; WriteLine("\t\tBrak takiej opcji, spróbuj ponownie"); }
                            if (opcjaModyfikacji > 0 && opcjaModyfikacji <= 8) break;
                        }

                        if (!string.IsNullOrEmpty(poleDoZmiany))
                        {
                            string updateQuery = $"UPDATE Osoby SET {poleDoZmiany} = @{poleDoZmiany} WHERE Id = @Id";

                            using (SqlCommand updateCommand = new SqlCommand(updateQuery, connection))
                            {
                                updateCommand.Parameters.AddWithValue($"@{poleDoZmiany}", wartoscDoZmiany);
                                updateCommand.Parameters.AddWithValue("@Id", opcjaZakres);
                                int rowsAffected = updateCommand.ExecuteNonQuery();
                                ForegroundColor = ConsoleColor.White;
                                WriteLine($"\nZmodyfikowano {opcjaZakres} rekord z pliku");
                                ResetColor();
                            }
                        }
                    }
                    break;
                }
            }
        }

        static void UsunOsobe(string connectionString, SqlConnection connection)
        {
            while (true)
            {
                int liczbaRekordow = 0;
                string countQuery = "SELECT COUNT(*) FROM Osoby";
                using (SqlCommand countCommand = new SqlCommand(countQuery, connection))
                {
                    liczbaRekordow = (int)countCommand.ExecuteScalar();
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

                    string deleteQuery = "DELETE FROM Osoby WHERE Id = @Id";
                    Osoba osoba = new Osoba();
                    using (SqlCommand deleteCommand = new SqlCommand(deleteQuery, connection))
                    {
                        deleteCommand.Parameters.AddWithValue("@Id", opcjaZakres);
                        int rowsAffected = deleteCommand.ExecuteNonQuery();
                        ForegroundColor = ConsoleColor.White;
                        WriteLine($"\nUsunięto {opcjaZakres} rekord z pliku");
                        ResetColor();
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
        public Osoba(SqlDataReader reader)
        {
            Imie = (string) reader["Imie"];
            Nazwisko = (string) reader["Nazwisko"];
            Adres = new Adres
            {
                Ulica = (string) reader["Ulica"],
                Numer = (string) reader["Numer"],
                KodPocztowy = (string) reader["KodPocztowy"],
                Miejscowosc = (string) reader["Miejscowosc"]
            };
            Pesel = (string)reader["Pesel"];
            Email = (string)reader["Email"];
        }

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
