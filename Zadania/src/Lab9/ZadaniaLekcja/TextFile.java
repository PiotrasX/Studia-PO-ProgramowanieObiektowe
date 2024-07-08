package Lab9.ZadaniaLekcja;

import java.io.*;
import java.util.Scanner;

public class TextFile
{
    // Odczyt File
    // Odczyt danych z pliku
    // Scanner odczyt = new Scanner(new File("nazwa_pliku.txt"));
    public static void ReadFile() throws IOException
    {
        // Tworzenie obiektu do przechowywania danych w pliku
        // Dostęp do pliku znak po znaku
        File plik = new File("\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\ala.txt");
        Scanner in = new Scanner(plik);

        String zdanie = in.nextLine();
        System.out.println(zdanie);
    }

    // Zapis File
    // Zapis danych do pliku
    // PrintWriter zapis = new PrintWriter("nazwa_pliku.txt");
    public static void SaveFile() throws IOException
    {
        PrintWriter zapis = new PrintWriter("\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\ala.txt");
        zapis.println("Ala ma kota, a kot ma Alę");
        zapis.close(); // Zamkniecie strumienia
    }

    // Zapis FileWriter
    public static void SaveFileWriter() throws IOException
    {
        // Inicjalizacja zmiennych
        String filePath = "\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\file.txt";
        int number = 123;
        FileWriter fileWriter = null; // Klasa odpowiedzialna za zapis do pliku tekstowego

        try
        {
            fileWriter = new FileWriter(filePath); // Tworzenie instancji oraz przekazanie ścieżki do pliku
            fileWriter.write(Integer.toString(number)); // Zapis do pliku wartości tekstowej liczby number
        }
        finally // Blok sprawdza czy nasz filewriter został zainicjalizowany
        {
            if (fileWriter != null)
            {
                fileWriter.close();
            }
        }
    }

    // Odczyt BufferedReader
    // Dostęp do pliku linijka po linijce
    // BufferedReader odczyt = new BufferedReader(new FileReader("ala.txt"));
    public static int ReadBufferFile() throws IOException
    {
        // Inicjalizacja zmiennych
        String filePath = "\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\file.txt";
        int number = 0;
        BufferedReader fileReader = null;

        try
        {
            fileReader = new BufferedReader(new FileReader(filePath)); // Tworzenie instancji klasy
            // Czytanie z pliku linijka po linijce, parsowanie łańcucha znaków i zapisanie go jako liczby typu int
            // Metoda readLine zwróci null, jeśli w pliku nie znajduje się już więcej danych
            String numberAsString = fileReader.readLine();
            number = Integer.parseInt(numberAsString);
        }
        finally
        {
            if (fileReader != null)
            {
                fileReader.close();
            }
        }
        return number;
    }
}
