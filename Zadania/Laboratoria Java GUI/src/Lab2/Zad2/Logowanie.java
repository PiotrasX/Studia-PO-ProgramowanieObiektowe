package Lab2.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Lab2.Zad2.Zadanie2.getDane;

public class Logowanie extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JButton zalogujButton;
    private JTextField loginField;
    private JPasswordField hasloField;
    private JLabel loginLabel;
    private JLabel hasloLabel;
    private JLabel nazwaLabel;
    private JButton utworzButton;
    private JButton zmienButton;
    private JLabel nieKontoLabel;
    private JLabel nieHasloLabel;
    private JLabel czyZalogowanoLabel;

    public static void main(String[] args)
    {
        Logowanie logowanieGUI = new Logowanie();
        logowanieGUI.setVisible(true);
    }

    public Logowanie()
    {
        super("Logowanie do panelu klienta");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1500,900));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageForeground", new Color(255,255,255));
        UIManager.put("OptionPane.background", new Color(45,15,115));
        UIManager.put("Panel.background", new Color(45,15,115));
        UIManager.put("Button.background", new Color(45,15,15));
        UIManager.put("Button.foreground", new Color(255,255,255));
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 16));

        zalogujButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Map<String, List<String>> dane = getDane();
                boolean czyZalogowano=false;
                for (Map.Entry<String, List<String>> przegladajDane : dane.entrySet())
                {
                    if (Objects.equals(przegladajDane.getKey(), loginField.getText()) && Objects.equals((przegladajDane.getValue()).get(0), new String(hasloField.getPassword())))
                    {
                        JOptionPane.showMessageDialog(null, "Pomyślnie zalogowano", "Zalogowano do aplikacji", JOptionPane.INFORMATION_MESSAGE);
                        czyZalogowano=true;
                        PanelKlienta panelKlientaGUI = new PanelKlienta(loginField.getText(), przegladajDane.getValue().get(2), przegladajDane.getValue().get(3));
                        panelKlientaGUI.setVisible(true);
                        dispose();
                        break;
                    }
                }
                hasloField.setText("");
                if (!czyZalogowano) { JOptionPane.showMessageDialog(null, "Niepoprawny login lub hasło", "Niepoprawne dane", JOptionPane.WARNING_MESSAGE); }
            }
        });

        utworzButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UtworzKonto utworzKontoGUI = new UtworzKonto();
                utworzKontoGUI.setVisible(true);
                dispose();
            }
        });

        zmienButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ResetowanieHasla resetowanieHaslaGUI = new ResetowanieHasla();
                resetowanieHaslaGUI.setVisible(true);
                dispose();
            }
        });
    }
}
