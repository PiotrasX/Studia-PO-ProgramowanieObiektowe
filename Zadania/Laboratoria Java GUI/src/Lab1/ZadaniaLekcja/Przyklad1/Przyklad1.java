package Lab1.ZadaniaLekcja.Przyklad1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Przyklad1 extends JFrame
{
    private JPanel JMainPanel;
    private JButton zamknijButton;
    private JButton wyswietlButton;
    private JButton dataCzasButton;
    private JLabel poleTXT;

    public static void main(String[] args)
    {
        Przyklad1 przyklad1GUI = new Przyklad1();
        przyklad1GUI.setVisible(true);
    }

    public Przyklad1()
    {
        super("Przykład 1");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        zamknijButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        wyswietlButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String imie = JOptionPane.showInputDialog(null, "Podaj imię: ", "Wpisywanie - imię", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"Witaj " + imie, "Wyświetlanie - imię", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showConfirmDialog(null, "Wpisano imię: " + imie, "Potwierdzenie - imię", JOptionPane.YES_NO_OPTION);
                poleTXT.setText("Witaj użytkowniku " + imie);
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
                poleTXT.setText(mojaDTFormatowana);
            }
        });
    }
}
