package Lab2.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Lab2.Zad2.Zadanie2.getDane;
import static Lab2.Zad2.Zadanie2.setDane;

public class UtworzKonto extends JFrame
{
    private JPanel JMainPanel;
    private JButton utworzButton;
    private JButton powrotButton;
    private JLabel resetLabel;
    private JLabel nazwaLabel;
    private JTextField nazwaField;
    private JPasswordField hasloField;
    private JLabel hasloLabel;
    private JLabel hasloPowtorzLabel;
    private JPasswordField hasloPowtorzField;
    private JLabel emailLabel;
    private JTextField emailField;

    public static void main(String[] args)
    {
        UtworzKonto utworzKontoGUI = new UtworzKonto();
        utworzKontoGUI.setVisible(true);
    }

    public UtworzKonto()
    {
        super("Tworzenie nowego konta");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1500,900));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        utworzButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Map<String, java.util.List<String>> dane = getDane();
                for (Map.Entry<String, List<String>> przegladajDane : dane.entrySet())
                {
                    if (Objects.equals(przegladajDane.getKey(), nazwaField.getText()) || Objects.equals(przegladajDane.getValue().get(1), emailField.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Podana nazwa użytkownika lub email są zajęte", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    else if (nazwaField.getText().length()<5)
                    {
                        JOptionPane.showMessageDialog(null, "Nazwa użytkownika musi składać się z minimum 5 znaków", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    else
                    {
                        if (emailField.getText().length()<5)
                        {
                            JOptionPane.showMessageDialog(null, "Adres email musi składać się z minimum 5 znaków", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        boolean poprawnyEmail = false;
                        for (int i=0; i<emailField.getText().length(); i++)
                        {
                            char znak = emailField.getText().charAt(i);
                            if (znak=='@') { poprawnyEmail=true; }
                        }
                        if (!poprawnyEmail)
                        {
                            JOptionPane.showMessageDialog(null, "Niepoprawny adres email", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        if (Objects.equals(new String(hasloField.getPassword()),new String(hasloPowtorzField.getPassword())))
                        {
                            String haslo = new String(hasloField.getPassword());
                            if (haslo.length()<8)
                            {
                                JOptionPane.showMessageDialog(null, "Hasło jest za krótkie", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            else if (haslo.length()>20)
                            {
                                JOptionPane.showMessageDialog(null, "Hasło jest za długie", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            else
                            {
                                // Poprawność hasła:
                                // Zawiera co najmniej 8 znaków i maksymalnie 20 znaków.
                                // Zawiera co najmniej jedną cyfrę.
                                // Zawiera co najmniej jeden wielki alfabet.
                                // Zawiera co najmniej jeden mały alfabet.
                                // Zawiera co najmniej jeden znak specjalny, który obejmuje !@#$%&*()-+=^.
                                // Nie zawiera żadnych białych znaków.

                                boolean poprawnosc = false;
                                int cyfry=0, duze=0, male=0, specjalne=0;
                                for (int i=0; i<haslo.length(); i++)
                                {
                                    int ascii = (int) haslo.charAt(i);
                                    if (ascii==33 || (ascii>=35 && ascii<=38) || (ascii>=40 && ascii<=43) || ascii==45 || ascii==61 || ascii==64 || ascii==94) specjalne++;
                                    else if (ascii>=48 && ascii<=57) cyfry++;
                                    else if (ascii>=65 && ascii<=90) duze++;
                                    else if (ascii>=97 && ascii<=122) male++;
                                    else break;
                                }
                                if (cyfry>=1 && duze>=1 && male>=1 && specjalne>=1) poprawnosc=true;
                                if (!poprawnosc)
                                {
                                    JOptionPane.showMessageDialog(null, "Hasło jest niezgodne z \"codejava\"", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                                }
                                if (poprawnosc)
                                {
                                    JOptionPane.showMessageDialog(null, "Konto zostało pomyślnie utworzone\nPotwierdź utworzenie konta na swojej poczcie email", "Poprawne dane", JOptionPane.INFORMATION_MESSAGE);
                                    setDane(nazwaField.getText(), Arrays.asList(haslo, emailField.getText(), "3500", ""));
                                    Logowanie logowanieGUI = new Logowanie();
                                    logowanieGUI.setVisible(true);
                                    dispose();
                                }
                                break;
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Hasło nie jest jednakowe w obu polach", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                }
                hasloField.setText("");
                hasloPowtorzField.setText("");
            }
        });

        powrotButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Logowanie logowanieGUI = new Logowanie();
                logowanieGUI.setVisible(true);
                dispose();
            }
        });
    }
}
