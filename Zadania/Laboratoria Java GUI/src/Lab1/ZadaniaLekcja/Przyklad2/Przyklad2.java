package Lab1.ZadaniaLekcja.Przyklad2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Przyklad2 extends JFrame
{
    private JPanel JMainPanel;
    private JButton zamknijButton;
    private JButton witajButton;
    private JButton dataCzasButton;
    private JLabel zamknijLabel;
    private JLabel witajLabel;
    private JLabel kalendarzLabel;

    public static void main(String[] args)
    {
        Przyklad2 przyklad2GUI = new Przyklad2();
        przyklad2GUI.setVisible(true);
    }

    public Przyklad2()
    {
        super("Przykład 2");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        zamknijButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        witajButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String imie = JOptionPane.showInputDialog(null, "Podaj imię: ", "Wpisywanie - imię", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"Witaj " + imie, "Wyświetlanie - imię", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showConfirmDialog(null, "Wpisano imię: '" + imie + "', potwierdzasz prawdziwość informacji?", "Potwierdzenie - imię", JOptionPane.YES_NO_OPTION);
                witajLabel.setText("Witaj użytkowniku " + imie);
            }
        });
        dataCzasButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                LocalDateTime mojaDT = LocalDateTime.now();
                DateTimeFormatter motaDTFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String mojaDTFormatowana = mojaDT.format(motaDTFormat);
                kalendarzLabel.setText("Twoja data i czas: " + mojaDTFormatowana);
            }
        });
    }
}
