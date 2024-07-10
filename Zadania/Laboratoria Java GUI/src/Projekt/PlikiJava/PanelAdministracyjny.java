package Projekt.PlikiJava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class PanelAdministracyjny extends BazoweFrame
{
    private JPanel JMainPanel;
    private JLabel labelLogin;
    private JTextField textFieldLogin;
    private JLabel labelHaslo;
    private JPasswordField passwordFieldHaslo;
    private JButton buttonZaloguj;
    private JButton buttonPowrot;
    private JLabel labelLogowanieDlaAdministracji;
    private JLabel labelBazaDanychSamochodow;
    private JLabel labelPIN;
    private JPasswordField passwordFieldPIN;
    private static final ImageIcon loginBackgroundImage = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\login_background_image.png")));
    private static final ImageIcon car = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\car.png")));

    public PanelAdministracyjny()
    {
        super("Panel administracyjny", loginBackgroundImage, car, 1200, 800);
        JLayeredPane layeredPane = BazoweFrame.returnLayeredPane();
        JMainPanel.setBounds(0, 0, 1200, 800);
        layeredPane.add(JMainPanel, Integer.valueOf(0));
        passwordFieldPIN.setHorizontalAlignment(JTextField.CENTER);
        actionListener();
        keyListener();
    }

    private void keyListener()
    {
        passwordFieldPIN.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (!Character.isDigit(e.getKeyChar()) || (passwordFieldPIN.getPassword().length >= 7 && passwordFieldPIN.getSelectionStart() == passwordFieldPIN.getSelectionEnd()))
                    e.consume();
            }
        });
    }

    private void actionListener()
    {
        buttonZaloguj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String login = textFieldLogin.getText();
                String haslo = new String(passwordFieldHaslo.getPassword());
                String pin = new String(passwordFieldPIN.getPassword());
                if (login.isEmpty() && haslo.isEmpty() && pin.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pola \"Login\", \"Hasło\" oraz \"PIN\"", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE);
                else if (login.isEmpty() && haslo.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pola \"Login\" oraz \"Hasło\"", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE);
                else if (login.isEmpty() && pin.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pola \"Login\" oraz \"PIN\"", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE);
                else if (haslo.isEmpty() && pin.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pola \"Hasło\" oraz \"PIN\"", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE);
                else if (login.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pole \"Login\"", "Uzupełnij pole", JOptionPane.ERROR_MESSAGE);
                else if (haslo.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pole \"Hasło\"", "Uzupełnij pole", JOptionPane.ERROR_MESSAGE);
                else if (pin.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pole \"PIN\"", "Uzupełnij pole", JOptionPane.ERROR_MESSAGE);
                else
                {
                    for (String[] profil : profile)
                    {
                        if (profil[0].equals("administrator") && profil[1].equals(login) && profil[3].equals(haslo) && profil[4].equals(pin))
                        {
                            JOptionPane.showMessageDialog(null, "Zalogowano do systemu jako administrator", "Poprawne dane", JOptionPane.INFORMATION_MESSAGE);
                            PanelBazaSamochodow panelBazaSamochodowGUI = new PanelBazaSamochodow(true, login);
                            panelBazaSamochodowGUI.setVisible(true);
                            dispose();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Błędny login, hasło lub kod PIN", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPowrot.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Login loginGUI = new Login();
                loginGUI.setVisible(true);
                dispose();
            }
        });
    }
}
