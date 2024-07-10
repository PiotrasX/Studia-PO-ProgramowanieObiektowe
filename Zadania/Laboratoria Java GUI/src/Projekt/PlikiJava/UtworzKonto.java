package Projekt.PlikiJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;
import java.util.regex.Pattern;

public class UtworzKonto extends BazoweFrame
{
    private JPanel JMainPanel;
    private JLabel labelLogin;
    private JTextField textFieldLogin;
    private JLabel labelEmail;
    private JButton buttonUtworzKonto;
    private JButton buttonPowrot;
    private JLabel labelBazaDanychSamochodow;
    private JLabel labelUtworzKonto;
    private JLabel labelPowtorzHaslo;
    private JTextField textFieldEmail;
    private JLabel labelHaslo;
    private JPasswordField passwordFieldHaslo;
    private JPasswordField passwordFieldPowtorzHaslo;
    private JLabel labelLoginPodpowiedz;
    private JLabel labelEmailPodpowiedz;
    private JLabel labelHasloPodpowiedz;
    private static final ImageIcon loginBackgroundImage = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\login_background_image.png")));
    private static final ImageIcon car = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\car.png")));
    private static final ImageIcon question_mark = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\question_mark.png")));

    public UtworzKonto()
    {
        super("Panel tworzenia konta", loginBackgroundImage, car, 1200, 800);
        JLayeredPane layeredPane = BazoweFrame.returnLayeredPane();
        JMainPanel.setBounds(0, 0, 1200, 800);
        layeredPane.add(JMainPanel, Integer.valueOf(0));
        toolTipTextComponent();
        actionListener();
    }

    private void toolTipTextComponent()
    {
        labelLoginPodpowiedz.setIcon(ResizeImageIcon.resize(question_mark, labelLogin.getHeight() - 10, labelLogin.getHeight() - 10));
        labelEmailPodpowiedz.setIcon(ResizeImageIcon.resize(question_mark, labelEmail.getHeight() - 10, labelEmail.getHeight() - 10));
        labelHasloPodpowiedz.setIcon(ResizeImageIcon.resize(question_mark, labelHaslo.getHeight() - 10, labelHaslo.getHeight() - 10));
        labelLoginPodpowiedz.setToolTipText("<html><body style='font-size:16px; font-family:Fira Code;'>Login musi zawierać:<br>- od 4 do 20 znaków;<br>- znaki z zakresu: [a-z], [A-Z], [0-9] lub '_';</html>");
        labelEmailPodpowiedz.setToolTipText("<html><body style='font-size:16px; font-family:Fira Code;'>Email musi zawierać:<br>- od 6 znaków;<br>- znaki z zakresu: [a-z], [A-Z], [0-9], '.', '-' lub '_';</html>");
        labelHasloPodpowiedz.setToolTipText("<html><body style='font-size:16px; font-family:Fira Code;'>Hasło musi zawierać:<br>- od 8 do 30 znaków;<br>- znaki z zakresu: [a-z], [A-Z], [0-9] lub [!?@#$%^&*=+-_&lt&gt];<br>- co najmniej jeden znak:<br>&emsp - dużej litery;<br>&emsp - małej litery;<br>&emsp - numeryczny;<br>&emsp - specjalny z zakresu [!?@#$%^&*=+-_&lt&gt];</html>");
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
        UIManager.put("ToolTip.background", new Color(213, 183, 180));
        UIManager.put("ToolTip.foreground", new Color(35, 15, 35));
        UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.BLACK));
    }

    private void actionListener()
    {
        buttonUtworzKonto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String login = textFieldLogin.getText();
                String email = textFieldEmail.getText();
                String haslo = new String(passwordFieldHaslo.getPassword());
                String powtorzHaslo = new String(passwordFieldPowtorzHaslo.getPassword());

                if (login.isEmpty() || email.isEmpty() || haslo.isEmpty() || powtorzHaslo.isEmpty())
                    { JOptionPane.showMessageDialog(null, "Uzupełnij puste pola w formularzu", "Uzupełnij pola", JOptionPane.ERROR_MESSAGE); return; }
                else if (login.length() < 4 || login.length() > 20)
                    { JOptionPane.showMessageDialog(null, "Login musi zawierać od 4 do 20 znaków", "Niepoprawny login", JOptionPane.ERROR_MESSAGE); return; }
                else if (!Pattern.matches("^\\w{4,20}$", login))
                    { JOptionPane.showMessageDialog(null, "Login zawiera znaki niedozwolone do użycia", "Niepoprawny login", JOptionPane.ERROR_MESSAGE); return; }
                else if (email.length() < 6)
                    { JOptionPane.showMessageDialog(null, "Email musi zawierać od 6 znaków", "Niepoprawny email", JOptionPane.ERROR_MESSAGE); return; }
                else if (!Pattern.matches("^[\\w.-]+@[\\w-]+\\.[\\w-.]{2,}$", email))
                    { JOptionPane.showMessageDialog(null, "Email jest niepoprawny lub zawiera znaki niedozwolone do użycia", "Niepoprawny email", JOptionPane.ERROR_MESSAGE); return; }
                else
                {
                    for (String[] profil : profile)
                    {
                        if (profil[1].equals(login))
                            { JOptionPane.showMessageDialog(null, "Podany login jest zajęty", "Zajęty login", JOptionPane.ERROR_MESSAGE); return; }
                        if (profil[2].equals(email))
                            { JOptionPane.showMessageDialog(null, "Podany email jest zajęty", "Zajęty email", JOptionPane.ERROR_MESSAGE); return; }
                    }
                }
                if (haslo.length() < 8 || haslo.length() > 30)
                    JOptionPane.showMessageDialog(null, "Hasło musi zawierać od 8 do 30 znaków", "Niepoprawny login", JOptionPane.ERROR_MESSAGE);
                else if (!haslo.equals(powtorzHaslo))
                    JOptionPane.showMessageDialog(null, "Hasło w obu polach musi być identyczne", "Niepoprawne hasło", JOptionPane.ERROR_MESSAGE);
                else if (!Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*+=\\-_<>?])[A-Za-z\\d!@#$%^&*+=\\-_<>?]{8,30}$", haslo))
                    JOptionPane.showMessageDialog(null, "Hasło jest niepoprawne lub zawiera niedozwolone znaki", "Niepoprawne hasło", JOptionPane.ERROR_MESSAGE);
                else
                {
                    try
                    {
                        FileWriter fileWriter = new FileWriter("src\\Projekt\\PlikiJava\\PlikiDoProjektu\\uzytkownicy.txt", true);
                        String line = "uzytkownik;" + login + ";" + email + ";" + haslo;
                        fileWriter.write(line + "\n");
                        String[] userData = line.split(";");
                        profile.add(userData);
                        fileWriter.close();
                    }
                    catch (IOException ex) { System.out.println("Error"); }
                    JOptionPane.showMessageDialog(null, "Poprawnie utworzono konto w systemie", "Poprawne dane", JOptionPane.INFORMATION_MESSAGE);
                    openLoginGUI();
                }
            }
        });

        buttonPowrot.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { openLoginGUI(); }
        });
    }

    private void openLoginGUI()
    {
        Login loginGUI = new Login();
        loginGUI.setVisible(true);
        dispose();
    }
}
