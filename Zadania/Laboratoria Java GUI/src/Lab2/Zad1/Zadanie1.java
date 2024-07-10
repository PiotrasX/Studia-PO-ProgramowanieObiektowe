package Lab2.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie1 extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel passwordLabel1;
    private JLabel passwordLabel2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton OKButton;
    private JPanel JPanel3;

    public static void main(String[] args)
    {
        Zadanie1 zadanie1GUI = new Zadanie1();
        zadanie1GUI.setVisible(true);
    }

    public Zadanie1()
    {
        super("Utwórz hasło");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600,300));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        OKButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UIManager.put("OptionPane.messageForeground", new Color(21,17,60));
                UIManager.put("OptionPane.background", new Color(255,199,175));
                UIManager.put("Panel.background", new Color(255,199,175));
                UIManager.put("Button.background", new Color(25,52,20));
                UIManager.put("Button.foreground", new Color(246,169,229));
                UIManager.put("Button.font", new Font("Arial Nova", Font.BOLD, 22));

                String enterPass = new String(passwordField1.getPassword());
                String confirmPass = new String(passwordField2.getPassword());
                if (!enterPass.equals(confirmPass))
                {
                    JOptionPane.showMessageDialog(null, "Hasła nie są takie same", "Poprawność haseł", JOptionPane.WARNING_MESSAGE);
                }
                else if (enterPass.length()<8)
                {
                    JOptionPane.showMessageDialog(null, "Hasło jest za krótkie", "Poprawność haseł", JOptionPane.WARNING_MESSAGE);
                }
                else if (enterPass.length()>20)
                {
                    JOptionPane.showMessageDialog(null, "Hasło jest za długie", "Poprawność haseł", JOptionPane.WARNING_MESSAGE);
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
                    for (int i = 0; i < enterPass.length(); i++)
                    {
                        int ascii = (int) enterPass.charAt(i);
                        if (ascii==33 || (ascii>=35 && ascii<=38) || (ascii>=40 && ascii<=43) || ascii==45 || ascii==61 || ascii==64 || ascii==94) specjalne++;
                        else if (ascii>=48 && ascii<=57) cyfry++;
                        else if (ascii>=65 && ascii<=90) duze++;
                        else if (ascii>=97 && ascii<=122) male++;
                        else break;
                    }
                    if (cyfry>=1 && duze>=1 && male>=1 && specjalne>=1) poprawnosc=true;
                    if (!poprawnosc)
                    {
                        JOptionPane.showMessageDialog(null, "Hasło niezgodne z \"codejava\"", "Poprawność haseł", JOptionPane.WARNING_MESSAGE);
                    }
                    if (poprawnosc)
                    {
                        JOptionPane.showMessageDialog(null, "Hasło zostało pomyślnie utworzone", "Poprawność haseł", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                passwordField1.setText("");
                passwordField2.setText("");
            }
        });
    }
}
