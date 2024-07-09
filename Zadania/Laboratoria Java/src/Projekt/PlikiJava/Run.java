package Projekt.PlikiJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run
{
    private static final Informacje informacje = new Informacje("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Projekt\\PlikiJava\\PlikiDoProjektu\\informacje.txt");

    public void run()
    {
        inicjalizacja();
        while (true)
        {
            int opcja = -1;
            menu();
            try { opcja = inputInt(); }
            catch (InputMismatchException ignore) { System.out.print(""); }
            switch (opcja)
            {
                case 1 -> opis();
                case 2 -> opisWszystkie();
                case 3 -> dodaj();
                case 4 -> usun();
                case 5 -> zapis();
                case 6 -> odczyt();
                case 7 -> end();
                default -> defaultChoice();
            }
        }
    }

    public void wypisz(int wartosc)
    {
        int wybor = -1;
        do
        {
            System.out.println("\nJaki wybierasz pojazd?");
            System.out.println("1. Osobowy");
            System.out.println("2. Autobus");
            System.out.println("3. Motocykl");
            System.out.println("4. Ciężarowy");
            System.out.println("5. Ciągnik rolniczy");
            System.out.println("------------------------------");
            System.out.print("Wybierz odpowiednią operacje: ");
            try
            {
                wybor = inputInt();
                if (wybor <= 0 || wybor > 5) { System.out.println("Nie istnieje taka opcja do wyboru"); }
            }
            catch (InputMismatchException ignore) { System.out.println("Nie istnieje taka opcja do wyboru"); }
        } while (wybor <= 0 || wybor > 5);
        pojazd(wartosc, wybor);
    }

    public void opis()
    {
        int wartosc = 1;
        wypisz(wartosc);
    }

    public void opisWszystkie()
    {
        int wartosc = 2;
        wypisz(wartosc);
    }

    public void dodaj()
    {
        int wartosc = 3;
        wypisz(wartosc);
    }

    public void usun()
    {
        int wartosc = 4;
        wypisz(wartosc);
    }

    public void zapis()
    {
        try
        {
            FileWriter plik = new FileWriter("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Projekt\\PlikiJava\\PlikiDoProjektu\\baza.txt", true);
            BufferedWriter zapis = new BufferedWriter(plik);
            int wybor = 1;
            while(wybor <= 5)
            {
                for (Pojazd pojazd : tabPojazd[wybor - 1])
                {
                    try { if (pojazd.getMarka() == null) break; }
                    catch (NullPointerException ignored) { break; }
                    switch (wybor)
                    {
                        case 1 -> zapis.write("Osobowy;" + pojazd.getPodrodzaj() + ";" + pojazd.getMarka() +
                                    ";" + pojazd.getModel() + ";" + pojazd.getKolor() + ";" + pojazd.getPojSilnika() +
                                    ";" + pojazd.getMocSilnika() + ";" + pojazd.getMaxPredkosc() +
                                    ";" + pojazd.getWaga() + ";" + pojazd.getRokProd() + ";" + pojazd.getPrzebieg() +
                                    ";" + pojazd.getCena() + ";" + pojazd.getLiczbaMiejsc() +
                                    ";" + ((Osobowy) pojazd).getLiczbaDrzwi() + ";" + ((Osobowy) pojazd).getPojBagaz() + "\n");
                        case 2 -> zapis.write("Autobus;" + pojazd.getPodrodzaj() + ";" + pojazd.getMarka() +
                                ";" + pojazd.getModel() + ";" + pojazd.getKolor() + ";" + pojazd.getPojSilnika() +
                                ";" + pojazd.getMocSilnika() + ";" + pojazd.getMaxPredkosc() +
                                ";" + pojazd.getWaga() + ";" + pojazd.getRokProd() + ";" + pojazd.getPrzebieg() +
                                ";" + pojazd.getCena() + ";" + pojazd.getLiczbaMiejsc() +
                                ";" + ((Autobus) pojazd).getLiczbaDrzwi() + ";" + ((Autobus) pojazd).getPojBagaz() +
                                ";" + ((Autobus) pojazd).getLiczbaKol() + "\n");
                        case 3 -> zapis.write("Motocykl;" + pojazd.getPodrodzaj() + ";" + pojazd.getMarka() +
                                ";" + pojazd.getModel() + ";" + pojazd.getKolor() + ";" + pojazd.getPojSilnika() +
                                ";" + pojazd.getMocSilnika() + ";" + pojazd.getMaxPredkosc() +
                                ";" + pojazd.getWaga() + ";" + pojazd.getRokProd() + ";" + pojazd.getPrzebieg() +
                                ";" + pojazd.getCena() + ";" + pojazd.getLiczbaMiejsc() +
                                ";" + ((Motocykl) pojazd).getLiczbaKol() + "\n");
                        case 4 -> zapis.write("Ciezarowy;" + pojazd.getPodrodzaj() + ";" + pojazd.getMarka() +
                                ";" + pojazd.getModel() + ";" + pojazd.getKolor() + ";" + pojazd.getPojSilnika() +
                                ";" + pojazd.getMocSilnika() + ";" + pojazd.getMaxPredkosc() +
                                ";" + pojazd.getWaga() + ";" + pojazd.getRokProd() + ";" + pojazd.getPrzebieg() +
                                ";" + pojazd.getCena() + ";" + pojazd.getLiczbaMiejsc() +
                                ";" + ((Ciezarowy) pojazd).getLiczbaDrzwi() + ";" + ((Ciezarowy) pojazd).getLadownosc() +
                                ";" + ((Ciezarowy) pojazd).getLiczbaKol() + "\n");
                        case 5 -> zapis.write("CiagnikRol;" + pojazd.getPodrodzaj() + ";" + pojazd.getMarka() +
                                ";" + pojazd.getModel() + ";" + pojazd.getKolor() + ";" + pojazd.getPojSilnika() +
                                ";" + pojazd.getMocSilnika() + ";" + pojazd.getMaxPredkosc() +
                                ";" + pojazd.getWaga() + ";" + pojazd.getRokProd() + ";" + pojazd.getPrzebieg() +
                                ";" + pojazd.getCena() + ";" + pojazd.getLiczbaMiejsc() +
                                ";" + ((CiagnikRol) pojazd).getLiczbaDrzwi() +
                                ";" + ((CiagnikRol) pojazd).getMaxMasaCiagniecia() + "\n");
                    }
                }
                wybor++;
            }
            zapis.close();
            System.out.println("\nPomyślnie zapisano pojazdy w pliku tekstowym");
        }
        catch (IOException e)
        {
            System.out.println("Błąd podczas zapisu pliku: " + e.getMessage());
        }
    }

    public void odczyt()
    {
        File plikBaza = new File("C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Projekt\\PlikiJava\\PlikiDoProjektu\\baza.txt");
        try
        {
            Scanner odczytBaza = new Scanner(plikBaza);
            while (odczytBaza.hasNextLine())
            {
                int ilePojazdOsobowy = ilePojazdow(1);
                int ilePojazdAutobus = ilePojazdow(2);
                int ilePojazdMotocykl = ilePojazdow(3);
                int ilePojazdCiezarowy = ilePojazdow(4);
                int ilePojazdCiagnikRol = ilePojazdow(5);
                String line = odczytBaza.nextLine();
                String[] rozdziel = line.split(";");
                switch (rozdziel[0])
                {
                    case "Osobowy" ->
                    {
                        if (ilePojazdOsobowy < tabPojazd[0].length)
                        {
                            tabPojazd[0][ilePojazdOsobowy] = new Osobowy("Osobowy",
                                    rozdziel[1], rozdziel[2], rozdziel[3], rozdziel[4],
                                    Double.parseDouble(rozdziel[5]), Integer.parseInt(rozdziel[6]),
                                    Integer.parseInt(rozdziel[7]), Double.parseDouble(rozdziel[8]),
                                    Integer.parseInt(rozdziel[9]), Integer.parseInt(rozdziel[10]),
                                    Integer.parseInt(rozdziel[11]), Integer.parseInt(rozdziel[12]),
                                    Integer.parseInt(rozdziel[13]), Double.parseDouble(rozdziel[14]));
                        }
                        else
                        {
                            System.out.println("Nie można dodać więcej pojazdów rodzaju \"Osobowy\" - brak miejsca w tablicy");
                        }
                    }
                    case "Autobus" ->
                    {
                        if (ilePojazdAutobus < tabPojazd[1].length)
                        {
                            tabPojazd[1][ilePojazdAutobus] = new Autobus("Autobus",
                                    rozdziel[1], rozdziel[2], rozdziel[3], rozdziel[4],
                                    Double.parseDouble(rozdziel[5]), Integer.parseInt(rozdziel[6]),
                                    Integer.parseInt(rozdziel[7]), Double.parseDouble(rozdziel[8]),
                                    Integer.parseInt(rozdziel[9]), Integer.parseInt(rozdziel[10]),
                                    Integer.parseInt(rozdziel[11]), Integer.parseInt(rozdziel[12]),
                                    Integer.parseInt(rozdziel[13]), Double.parseDouble(rozdziel[14]),
                                    Integer.parseInt(rozdziel[15]));
                        }
                        else
                        {
                            System.out.println("Nie można dodać więcej pojazdów rodzaju \"Autobus\" - brak miejsca w tablicy");
                        }
                    }
                    case "Motocykl" ->
                    {
                        if (ilePojazdMotocykl < tabPojazd[2].length)
                        {
                            tabPojazd[2][ilePojazdMotocykl] = new Motocykl("Motocykl",
                                    rozdziel[1], rozdziel[2], rozdziel[3], rozdziel[4],
                                    Double.parseDouble(rozdziel[5]), Integer.parseInt(rozdziel[6]),
                                    Integer.parseInt(rozdziel[7]), Double.parseDouble(rozdziel[8]),
                                    Integer.parseInt(rozdziel[9]), Integer.parseInt(rozdziel[10]),
                                    Integer.parseInt(rozdziel[11]), Integer.parseInt(rozdziel[12]),
                                    Integer.parseInt(rozdziel[13]));
                        }
                        else
                        {
                            System.out.println("Nie można dodać więcej pojazdów rodzaju \"Motocykl\" - brak miejsca w tablicy");
                        }
                    }
                    case "Ciezarowy" ->
                    {
                        if (ilePojazdCiezarowy < tabPojazd[3].length)
                        {
                            tabPojazd[3][ilePojazdCiezarowy] = new Ciezarowy("Ciezarowy",
                                    rozdziel[1], rozdziel[2], rozdziel[3], rozdziel[4],
                                    Double.parseDouble(rozdziel[5]), Integer.parseInt(rozdziel[6]),
                                    Integer.parseInt(rozdziel[7]), Double.parseDouble(rozdziel[8]),
                                    Integer.parseInt(rozdziel[9]), Integer.parseInt(rozdziel[10]),
                                    Integer.parseInt(rozdziel[11]), Integer.parseInt(rozdziel[12]),
                                    Integer.parseInt(rozdziel[13]), Double.parseDouble(rozdziel[14]),
                                    Integer.parseInt(rozdziel[13]));
                        }
                        else
                        {
                            System.out.println("Nie można dodać więcej pojazdów rodzaju \"Ciezarowy\" - brak miejsca w tablicy");
                        }
                    }
                    case "CiagnikRol" ->
                    {
                        if (ilePojazdCiagnikRol < tabPojazd[4].length)
                        {
                            tabPojazd[4][ilePojazdCiagnikRol] = new CiagnikRol("CiagnikRol",
                                    rozdziel[1], rozdziel[2], rozdziel[3], rozdziel[4],
                                    Double.parseDouble(rozdziel[5]), Integer.parseInt(rozdziel[6]),
                                    Integer.parseInt(rozdziel[7]), Double.parseDouble(rozdziel[8]),
                                    Integer.parseInt(rozdziel[9]), Integer.parseInt(rozdziel[10]),
                                    Integer.parseInt(rozdziel[11]), Integer.parseInt(rozdziel[12]),
                                    Integer.parseInt(rozdziel[13]), Double.parseDouble(rozdziel[14]));
                        }
                        else
                        {
                            System.out.println("Nie można dodać więcej pojazdów rodzaju \"CiagnikRol\" - brak miejsca w tablicy");
                        }
                    }
                }
            }
            System.out.println("\nPomyślnie odczytano pojazdy z pliku tekstowego");
        }
        catch (IOException e)
        {
            System.out.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    public int ilePojazdow(int wybor)
    {
        int ilePoj = 0;
        while (ilePoj < tabPojazd[wybor - 1].length)
        {
            try
            {
                if (tabPojazd[wybor - 1][ilePoj].getMarka() == null) break;
                ilePoj += 1;
            }
            catch (NullPointerException ignored) { break; }
        }
        return ilePoj;
    }

    public void wprowadzPojazd(Pojazd pojazd)
    {
        System.out.println("\nWprowadź dane pojazdu");
        System.out.print("Podrodzaj: ");
        pojazd.setPodrodzaj(inputString());
        System.out.print("Marka: ");
        pojazd.setMarka(inputString());
        System.out.print("Model: ");
        pojazd.setModel(inputString());
        System.out.print("Kolor: ");
        pojazd.setKolor(inputString());
        System.out.print("Pojemność silnika (dm^3): ");
        try { pojazd.setPojSilnika(inputDouble()); }
        catch (InputMismatchException ignore) { pojazd.setPojSilnika(0); }
        System.out.print("Moc silnika (KM): ");
        try { pojazd.setMocSilnika(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setMocSilnika(0); }
        System.out.print("Maksymalna prędkość (km/h): ");
        try { pojazd.setMaxPredkosc(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setMaxPredkosc(0); }
        System.out.print("Waga (kg): ");
        try { pojazd.setWaga(inputDouble()); }
        catch (InputMismatchException ignore) { pojazd.setWaga(0); }
        System.out.print("Rok produkcji: ");
        try { pojazd.setRokProd(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setRokProd(0); }
        System.out.print("Przebieg (km): ");
        try { pojazd.setPrzebieg(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setPrzebieg(0); }
        System.out.print("Cena (PLN): ");
        try { pojazd.setCena(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setCena(0); }
        System.out.print("Liczba miejsc: ");
        try { pojazd.setLiczbaMiejsc(inputInt()); }
        catch (InputMismatchException ignore) { pojazd.setLiczbaMiejsc(0); }
    }

    public void pojazd(int wartosc, int wybor)
    {
        int ilePoj = ilePojazdow(wybor);
        if (wartosc == 1 || wartosc == 2 || wartosc == 4)
        {
            if (ilePoj == 0)
            {
                if (wartosc == 4) { System.out.println("Nie można usunąć więcej pojazdów tego rodzaju - brak pojazdów w tablicy"); }
                else { System.out.println("Nie można wyświetlić informacji o pojazdach tego rodzaju - brak pojazdów w tablicy"); }

            }
            else
            {
                if (wartosc == 1 || wartosc == 4)
                {
                    int ktory = -1;
                    do
                    {
                        System.out.print("Który wybierasz pojazd z listy? Podaj liczbę z zakresu od " + 1 + " do " + ilePoj + ": ");
                        try
                        {
                            ktory = inputInt();
                            if (ktory <= 0 || ktory > ilePoj) { System.out.println("Nie istnieje taki pojazd do wyboru"); }
                        }
                        catch (InputMismatchException ignore) { System.out.println("Nie istnieje taki pojazd do wyboru"); }
                    } while (ktory <= 0 || ktory > ilePoj);
                    if (wartosc == 1) // Wyświetlanie opisu jednego pojazdu danej kategorii
                    {
                        System.out.print(tabPojazd[wybor - 1][ktory - 1].opis());
                    }
                    else // Usuwanie pojazdu danej kategorii
                    {
                        informacje.pisz("- Usunięto pojazd: " + tabPojazd[wybor - 1][ktory - 1]);
                        System.out.println("\nPomyślnie usunięto pojazd");
                        for (int i = (ktory - 1); i < (ilePoj - 1); i++)
                        {
                            tabPojazd[wybor - 1][i] = tabPojazd[wybor - 1][i + 1];
                        }
                        tabPojazd[wybor - 1][ilePoj - 1] = null;
                    }
                }
                else // Wyświetlanie opisu wszystkich pojazdów danej kategorii
                {
                    for(int v = 0; v < ilePoj; v++)
                    {
                        System.out.print(tabPojazd[wybor - 1][v].opis());
                    }
                }
            }
        }
        else if (wartosc == 3) // Dodawanie pojazdu danej kategorii
        {
            if (ilePoj < tabPojazd[wybor - 1].length)
            {
                if (wybor == 1) // Osobowy
                {
                    Osobowy pojazd = new Osobowy();
                    wprowadzPojazd(pojazd);
                    System.out.print("Liczba drzwi: ");
                    try { pojazd.setLiczbaDrzwi(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaDrzwi(0); }
                    System.out.print("Pojemność bagażnika (dm^3): ");
                    try { pojazd.setPojBagaz(inputDouble()); }
                    catch (InputMismatchException ignore) { pojazd.setPojBagaz(0); }
                    tabPojazd[wybor - 1][ilePoj] = pojazd;
                }
                else if (wybor == 2) // Autobus
                {
                    Autobus pojazd = new Autobus();
                    wprowadzPojazd(pojazd);
                    System.out.print("Liczba drzwi: ");
                    try { pojazd.setLiczbaDrzwi(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaDrzwi(0); }
                    System.out.print("Pojemność bagażnika (dm^3): ");
                    try { pojazd.setPojBagaz(inputDouble()); }
                    catch (InputMismatchException ignore) { pojazd.setPojBagaz(0); }
                    System.out.print("Liczba kół: ");
                    try { pojazd.setLiczbaKol(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaKol(0); }
                    tabPojazd[wybor - 1][ilePoj] = pojazd;
                }
                else if (wybor == 3) // Motocykl
                {
                    Motocykl pojazd = new Motocykl();
                    wprowadzPojazd(pojazd);
                    System.out.print("Liczba kół: ");
                    try { pojazd.setLiczbaKol(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaKol(0); }
                    tabPojazd[wybor - 1][ilePoj] = pojazd;
                }
                else if (wybor == 4) // Ciężarowy
                {
                    Ciezarowy pojazd = new Ciezarowy();
                    wprowadzPojazd(pojazd);
                    System.out.print("Liczba drzwi: ");
                    try { pojazd.setLiczbaDrzwi(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaDrzwi(0); }
                    System.out.print("Ładowność (kg): ");
                    try { pojazd.setLadownosc(inputDouble()); }
                    catch (InputMismatchException ignore) { pojazd.setLadownosc(0); }
                    System.out.print("Liczba kół: ");
                    try { pojazd.setLiczbaKol(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaKol(0); }
                    tabPojazd[wybor - 1][ilePoj] = pojazd;
                }
                else if (wybor == 5) // Ciągnik Rolniczy
                {
                    CiagnikRol pojazd = new CiagnikRol();
                    wprowadzPojazd(pojazd);
                    System.out.print("Liczba drzwi: ");
                    try { pojazd.setLiczbaDrzwi(inputInt()); }
                    catch (InputMismatchException ignore) { pojazd.setLiczbaDrzwi(0); }
                    System.out.print("Maksymalny ciężar do ciągnięcia (kg): ");
                    try { pojazd.setMaxMasaCiagniecia(inputDouble()); }
                    catch (InputMismatchException ignore) { pojazd.setMaxMasaCiagniecia(0); }
                    tabPojazd[wybor - 1][ilePoj] = pojazd;
                }
                informacje.pisz("- Dodano pojazd: " + tabPojazd[wybor - 1][ilePoj]);
                System.out.println("\nPomyślnie dodano pojazd");
            }
            else
            {
                System.out.println("Nie można dodać więcej pojazdów tego rodzaju - brak miejsca w tablicy");
            }
        }
    }

    Pojazd[][] tabPojazd = new Pojazd[5][25];
    public void inicjalizacja()
    {
        tabPojazd[0][0] = new Osobowy("Osobowy", "Sedan", "Honda", "Accord", "Zielony",
                1.9, 114, 217, 1995, 2003, 234150, 12000,
                5, 5, 987);
        tabPojazd[0][1] = new Osobowy("Osobowy", "Couple", "Hyundai", "Couple Sport", "Czarny",
                2.6, 167, 246, 1458, 2007, 132098, 18500,
                4, 3, 318);
        tabPojazd[0][2] = new Osobowy("Osobowy", "Kombi", "Toyota", "Corolla", "Srebrny",
                1.8, 159, 202, 1676, 2014, 46092, 45699,
                5, 5, 1345);
        tabPojazd[1][0] = new Autobus("Autobus", "Miejski", "Mercedes-Benz", "O 550", "Biały",
                12.3, 350, 112, 19000, 2002, 876590, 43580,
                56, 3, 0, 6);
        tabPojazd[1][1] = new Autobus("Autobus", "Turystyczny", "BOVA", "Magiq 112", "Biały",
                11.9, 408, 125, 17580, 2009, 575940, 135400,
                53, 2, 13000, 4);
        tabPojazd[1][2] = new Autobus("Autobus", "Szkolny", "IRIZAR", "i6s INTEGRAL", "Pomarańczowy",
                10.4, 320, 110, 16980, 2006, 765024, 75890,
                52, 2, 10500, 4);
        tabPojazd[2][0] = new Motocykl("Motocykl", "Osobowy", "Yamaha", "XVS", "Czarny",
                1.3, 73, 147, 237, 2014, 15590, 43900,
                1, 2);
        tabPojazd[2][1] = new Motocykl("Motocykl", "Enduro", "Cross", "BS-125", "Czarny",
                0.125, 11, 75, 67, 2022, 0, 24690,
                1, 2);
        tabPojazd[2][2] = new Motocykl("Motocykl", "Osobowy", "Kawasaki", "Ninja", "Czarny",
                0.6, 130, 192, 235, 2005, 69341, 16900,
                1, 2);
        tabPojazd[3][0] = new Ciezarowy("Ciezarowy", "Wielozadaniowy", "Iveco", "Daily", "Biały",
                3, 150, 160, 2673, 2015, 413946, 59800,
                3, 3, 880, 4);
        tabPojazd[3][1] = new Ciezarowy("Ciezarowy", "Skrzynia", "Isuzu", "M 21 TH", "Biały",
                3, 150, 160, 2673, 2015, 413946, 59800,
                3, 3, 880, 4);;
        tabPojazd[3][2] = new Ciezarowy("Ciezarowy", "Ciągnik siodłowy (z naczepą)", "Iveco", "Eurocargo 120E", "Czerwony",
                3, 167, 184, 2307, 2023, 0, 203934,
                3, 2, 1193, 6);;
        tabPojazd[4][0] = new CiagnikRol("CiagnikRol", "Kołowy", "John", "Deere 7530", "Zielono-żółty",
                5.4, 205, 43, 3707, 2010, 12790, 280740,
                1, 2, 8090);
        tabPojazd[4][1] = new CiagnikRol("CiagnikRol", "Kołowy", "Case", "IH", "Czerwony",
                6.4, 266, 49, 2380, 2011, 34561, 168100,
                1, 2, 1245);
        tabPojazd[4][2] = new CiagnikRol("CiagnikRol", "Gąsienicowy", "Same", "Diamond 270", "Zielony",
                5.8, 375, 43, 3160, 2019, 24500, 735800,
                1, 1, 13999);
    }

    public void menu()
    {
        System.out.println("\n\n\n==============================");
        System.out.println("=======   MENU OPCJI   =======");
        System.out.println("==============================");
        System.out.println("1. Wyświetl dane pojazdu danej kategorii");
        System.out.println("2. Wyświetl dane wszystkich pojazdów danej kategorii");
        System.out.println("3. Wprowadz pojazd");
        System.out.println("4. Usuń pojazd");
        System.out.println("5. Zapisz bazę danych do pliku");
        System.out.println("6. Odczytaj bazę danych z pliku");
        System.out.println("7. Wyjście");
        System.out.println("----------------------------------");
        System.out.print("Wybierz odpowiednią operacje: ");
    }

    public void end()
    {
        System.out.print("Czy na pewno chcesz wyjść z programu? ( T | t | TAK | tak ): ");
        String znak = inputString();
        if  (znak.equals("T") || znak.equals("t") || znak.equals("TAK") || znak.equals("tak"))
        {
            System.out.println("Program zakończył działanie");
            System.exit(0);
        }
        else
        {
            System.out.println("Anulowano wyjście z programu");
        }
    }

    public void defaultChoice() { System.out.println("Nie istnieje taka opcja do wyboru"); }

    public int inputInt()
    {
        Scanner input = new Scanner(System.in);
        int number;
        number = input.nextInt();
        return number;
    }

    public double inputDouble()
    {
        Scanner input = new Scanner(System.in);
        double number;
        number = input.nextDouble();
        return number;
    }

    public String inputString()
    {
        Scanner input = new Scanner(System.in);
        String word;
        word = input.nextLine();
        return word;
    }
}
