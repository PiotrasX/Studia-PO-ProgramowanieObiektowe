package Projekt.PlikiJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static Projekt.PlikiJava.Pojazd.pojazdyList;

public class BazoweFrame extends JFrame
{
    private static JLayeredPane layeredPane;
    public static final ArrayList<String[]> profile = new ArrayList<>();

    public BazoweFrame(String title, ImageIcon backgroundImage, ImageIcon icon, int layeredWidth, int layeredHeight)
    {
        super(title);

        resourceLoading();
        loadPojazdy();
        newLayeredPane();
        layeredPane.setPreferredSize(new Dimension(layeredWidth, layeredHeight));

        JLabel backgroundLabel = new JLabel(ResizeImageIcon.resize(backgroundImage, layeredWidth, layeredHeight));
        backgroundLabel.setBounds(0, 0, layeredWidth, layeredHeight);
        layeredPane.add(backgroundLabel, Integer.valueOf(-1));

        this.pack();
        Insets insets = this.getInsets();
        int width = layeredWidth + insets.left + insets.right;
        int height = layeredHeight + insets.top + insets.bottom;
        this.setSize(width, height);

        this.setContentPane(layeredPane);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(ResizeImageIcon.resize(icon,64,64).getImage());

        UIManager.put("OptionPane.messageFont", new Font("Fira Code", Font.PLAIN, 22));
        UIManager.put("OptionPane.messageForeground", new Color(35, 15, 35));
        UIManager.put("OptionPane.background", new Color(213, 183, 180));
        UIManager.put("Panel.background", new Color(213, 183, 180));
        UIManager.put("Button.background", new Color(31, 36, 65));
        UIManager.put("Button.foreground", new Color(255, 255, 255));
        UIManager.put("Button.font", new Font("Fira Code", Font.PLAIN, 28));
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int result = JOptionPane.showConfirmDialog(BazoweFrame.this, "Czy na pewno chcesz wyjść z programu?", "Potwierdzenie wyjścia", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        FileWriter fileWriter = new FileWriter("src\\Projekt\\PlikiJava\\PlikiDoProjektu\\baza.txt");
                        for (Pojazd pojazd : pojazdyList)
                        {
                            String tekst = pojazd.toString();
                            fileWriter.write(tekst);
                        }
                        fileWriter.close();
                    }
                    catch (IOException ex) { System.out.println("Error"); }
                    BazoweFrame.this.dispose();
                }
            }
        });
    }

    private void loadPojazdy()
    {
        if (pojazdyList.isEmpty())
        {
            try
            {
                FileReader fileReader = new FileReader("src\\Projekt\\PlikiJava\\PlikiDoProjektu\\baza.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    String[] pojazdData = line.split(";");
                    Pojazd pojazd = null;
                    Rodzaj rodzaj = Rodzaj.valueOf(pojazdData[0].replace("Rodzaj.", ""));
                    Marka marka = Marka.valueOf(pojazdData[2].replace("Marka.", ""));
                    Kolor kolor = Kolor.valueOf(pojazdData[4].replace("Kolor.", ""));

                    if (rodzaj == Rodzaj.Samochod_Osobowy)
                    {
                        NadwozieOsobowy nadwozie = NadwozieOsobowy.valueOf(pojazdData[1].replace("NadwozieOsobowy.", ""));
                        pojazd = new Osobowy(rodzaj, nadwozie, marka, pojazdData[3], kolor,
                                Double.parseDouble(pojazdData[5]), Integer.parseInt(pojazdData[6]),
                                Integer.parseInt(pojazdData[7]), Double.parseDouble(pojazdData[8]),
                                Integer.parseInt(pojazdData[9]), Integer.parseInt(pojazdData[10]),
                                Integer.parseInt(pojazdData[11]), Integer.parseInt(pojazdData[12]),
                                Integer.parseInt(pojazdData[13]), Integer.parseInt(pojazdData[14]));
                    }

                    if (rodzaj == Rodzaj.Samochod_Ciezarowy)
                    {
                        NadwozieCiezarowy nadwozie = NadwozieCiezarowy.valueOf(pojazdData[1].replace("NadwozieCiezarowy.", ""));
                        pojazd = new Ciezarowy(rodzaj, nadwozie, marka, pojazdData[3], kolor,
                                Double.parseDouble(pojazdData[5]), Integer.parseInt(pojazdData[6]),
                                Integer.parseInt(pojazdData[7]), Double.parseDouble(pojazdData[8]),
                                Integer.parseInt(pojazdData[9]), Integer.parseInt(pojazdData[10]),
                                Integer.parseInt(pojazdData[11]), Integer.parseInt(pojazdData[12]),
                                Integer.parseInt(pojazdData[13]), Integer.parseInt(pojazdData[14]),
                                Integer.parseInt(pojazdData[15]));
                    }

                    if (rodzaj == Rodzaj.Ciagnik_Rolniczy)
                    {
                        NadwozieCiagnikRol nadwozie = NadwozieCiagnikRol.valueOf(pojazdData[1].replace("NadwozieCiagnikRol.", ""));
                        pojazd = new CiagnikRol(rodzaj, nadwozie, marka, pojazdData[3], kolor,
                                Double.parseDouble(pojazdData[5]), Integer.parseInt(pojazdData[6]),
                                Integer.parseInt(pojazdData[7]), Double.parseDouble(pojazdData[8]),
                                Integer.parseInt(pojazdData[9]), Integer.parseInt(pojazdData[10]),
                                Integer.parseInt(pojazdData[11]), Integer.parseInt(pojazdData[12]),
                                Integer.parseInt(pojazdData[13]), Integer.parseInt(pojazdData[14]));
                    }

                    if (rodzaj == Rodzaj.Autobus)
                    {
                        NadwozieAutobus nadwozie = NadwozieAutobus.valueOf(pojazdData[1].replace("NadwozieAutobus.", ""));
                        pojazd = new Autobus(rodzaj, nadwozie, marka, pojazdData[3], kolor,
                                Double.parseDouble(pojazdData[5]), Integer.parseInt(pojazdData[6]),
                                Integer.parseInt(pojazdData[7]), Double.parseDouble(pojazdData[8]),
                                Integer.parseInt(pojazdData[9]), Integer.parseInt(pojazdData[10]),
                                Integer.parseInt(pojazdData[11]), Integer.parseInt(pojazdData[12]),
                                Integer.parseInt(pojazdData[13]), Integer.parseInt(pojazdData[14]),
                                Integer.parseInt(pojazdData[15]));
                    }

                    if (rodzaj == Rodzaj.Motocykl)
                    {
                        NadwozieMotocykl nadwozie = NadwozieMotocykl.valueOf(pojazdData[1].replace("NadwozieMotocykl.", ""));
                        pojazd = new Motocykl(rodzaj, nadwozie, marka, pojazdData[3], kolor,
                                Double.parseDouble(pojazdData[5]), Integer.parseInt(pojazdData[6]),
                                Integer.parseInt(pojazdData[7]), Double.parseDouble(pojazdData[8]),
                                Integer.parseInt(pojazdData[9]), Integer.parseInt(pojazdData[10]),
                                Integer.parseInt(pojazdData[11]), Integer.parseInt(pojazdData[12]),
                                Integer.parseInt(pojazdData[13]));
                    }

                    pojazdyList.add(pojazd);
                }
                bufferedReader.close();
            }
            catch (IOException e) { System.out.println("Error"); }
        }
    }

    private void resourceLoading()
    {
        if (profile.isEmpty())
        {
            try
            {
                FileReader fileReader = new FileReader("src\\Projekt\\PlikiJava\\PlikiDoProjektu\\uzytkownicy.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    String[] userData = line.split(";");
                    profile.add(userData);
                }
                bufferedReader.close();
            }
            catch (IOException e) { System.out.println("Error"); }
        }
    }

    public static JLayeredPane returnLayeredPane() { return layeredPane; }
    public static void newLayeredPane() { layeredPane = new JLayeredPane(); }
}
