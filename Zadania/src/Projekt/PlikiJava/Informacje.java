package Projekt.PlikiJava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Informacje
{
    private final String plik;

    public Informacje(String plik) { this.plik = plik; }

    public void pisz(String informacja)
    {
        try (BufferedWriter pisz = new BufferedWriter(new FileWriter(plik, true)))
        {
            Date data = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
            pisz.write(dateFormat.format(data) + " " + informacja + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
