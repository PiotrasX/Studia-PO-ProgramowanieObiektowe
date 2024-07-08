package Lab9.ZadaniaLekcja;

import java.io.*;

public class BinaryFile
{
    // Pliki binarne zapis
    public static void SaveBinary() throws IOException
    {
        String filePath = "\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\binary.txt";
        int number = 1234567;
        DataOutputStream outputStream = null;

        // Tworzenie instancji klasy i przekazanie jej do konstruktora, FileOutputStream pozwala na zapis danych
        // bajt po bajcie, DataOutputStream wykonuje zapis binarny z wykorzystaniem metody writeInt
        try
        {
            outputStream = new DataOutputStream(new FileOutputStream(filePath));
            outputStream.writeInt(number);
        }
        finally
        {
            if (outputStream != null)
            {
                outputStream.close();
            }
        }
    }

    public static int ReadBinray() throws IOException
    {
        String filePath = "\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab9\\ZadaniaLekcja\\PlikiTekstowe\\binary.txt";
        int number = 0;
        DataInputStream inputStream = null;
        // DataInputStream pozwala na czytanie większych kawałków pliku zapisanego binarnie,
        // dzięki tej klasie możemy przeczytać liczbę typu int zapisaną wcześniej w pliku

        try
        {
            inputStream = new DataInputStream(new FileInputStream(filePath));
            number = inputStream.readInt();
        }
        finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
        return number;
    }
}
