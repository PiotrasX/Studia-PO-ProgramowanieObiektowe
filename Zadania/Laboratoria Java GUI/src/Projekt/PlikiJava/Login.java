package Projekt.PlikiJava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends BazoweFrame
{
    private JPanel JMainPanel;
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldHaslo;
    private JButton buttonZaloguj;
    private JButton buttonUtworzKonto;
    private JButton buttonAdministracja;
    private JLabel labelLogin;
    private JLabel labelHaslo;
    private JLabel labelBazaDanychSamochodow;
    private JLabel labelLogowanie;
    private static final ImageIcon loginBackgroundImage = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\login_background_image.png")));
    private static final ImageIcon car = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\car.png")));

    public Login()
    {
        super("Panel logowania", loginBackgroundImage, car,1200,800);
        JLayeredPane layeredPane = BazoweFrame.returnLayeredPane();
        JMainPanel.setBounds(0, 0, 1200, 800);
        layeredPane.add(JMainPanel, Integer.valueOf(0));
        actionListener();
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
                if (login.isEmpty() && haslo.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pola \"Login\" oraz \"Hasło\"", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE);
                else if (login.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pole \"Login\"", "Uzupełnij pole", JOptionPane.ERROR_MESSAGE);
                else if (haslo.isEmpty())
                    JOptionPane.showMessageDialog(null, "Uzupełnij puste pole \"Hasło\"", "Uzupełnij pole", JOptionPane.ERROR_MESSAGE);
                else
                {
                    for (String[] profil : profile)
                    {
                        if (profil[0].equals("uzytkownik") && profil[1].equals(login) && profil[3].equals(haslo))
                        {
                            JOptionPane.showMessageDialog(null, "Zalogowano do systemu", "Poprawne dane", JOptionPane.INFORMATION_MESSAGE);
                            PanelBazaSamochodow panelBazaSamochodowGUI = new PanelBazaSamochodow(false, login);
                            panelBazaSamochodowGUI.setVisible(true);
                            dispose();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Błędny login lub hasło", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonUtworzKonto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UtworzKonto utworzKontoGUI = new UtworzKonto();
                utworzKontoGUI.setVisible(true);
                dispose();
            }
        });

        buttonAdministracja.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PanelAdministracyjny panelAdministracyjnyGUI = new PanelAdministracyjny();
                panelAdministracyjnyGUI.setVisible(true);
                dispose();
            }
        });
    }
}
