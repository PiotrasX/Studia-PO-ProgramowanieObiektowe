package Lab2.ZadaniaLekcja.Cwiczenie1;

import Lab2.ZadaniaLekcja.Cwiczenie2.Cwiczenie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Cwiczenie1 extends JFrame
{
    private JPanel JMainPanel;
    private JTextField usernameTextField;
    private JPanel JUserPanel;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPanel JInfroPanel;
    private JLabel infoLabel;
    private JButton loginButton;
    private JLabel loginLabel;
    private JPanel JloginLabel;
    private JPasswordField passwordField;
    String username = "admin", password = "admin";

    public static void main(String[] args)
    {
        Cwiczenie1 cwiczenie1GUI = new Cwiczenie1();
        cwiczenie1GUI.setVisible(true);
    }

    public Cwiczenie1()
    {
        super("Logowanie");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,430));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String usernameInput = usernameTextField.getText();
                String passwordInput = new String (passwordField.getPassword());
                if (Objects.equals(usernameInput, username) && passwordInput.equals(password))
                {
                    loginLabel.setText("Zalogowano poprawnie");
                    // dispose(); /* - zamknięcie obecnie otwartego okna GUI */
                    // Cwiczenie2 cwiczenie2 = new Cwiczenie2(); /* - otwarcie nowego okna GUI */
                }
                else
                {
                    usernameTextField.setText("");
                    passwordField.setText("");
                    loginLabel.setText("Błąd logowania - niepoprawne dane");
                }
            }
        });
    }
}
