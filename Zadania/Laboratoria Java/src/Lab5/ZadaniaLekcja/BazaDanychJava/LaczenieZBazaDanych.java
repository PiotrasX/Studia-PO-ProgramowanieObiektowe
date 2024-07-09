package Lab5.ZadaniaLekcja.BazaDanychJava;

import java.sql.*;

public class LaczenieZBazaDanych
{
    public static void main(String[] args)
    {
        Connection c = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite://C:\\Users\\piotr\\Desktop\\Studia\\Semestr 2\\PO\\Zadania\\Labolatoria\\src\\Lab5\\ZadaniaLekcja\\BazaDanychJava\\Test.db");
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
