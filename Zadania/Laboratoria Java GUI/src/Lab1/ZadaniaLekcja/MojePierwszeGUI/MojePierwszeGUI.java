package Lab1.ZadaniaLekcja.MojePierwszeGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MojePierwszeGUI extends JFrame
{
    private JPanel JMainPanel;
    private JButton OKButton;
    private JButton witajButton;
    private JPanel JPanelLabel;
    private JTextPane jestTekstTextPane;
    private JPanel JPanelE;
    private JPanel JPanelW;
    private JPanel JPanelN;
    private JButton przyciskWButton;
    private JButton przyciskZButton;
    private JLabel miedzyPrzyciskowyText;
    private JButton zamknijButton;

    public static void main(String[] args)
    {
        MojePierwszeGUI mojePierwszeGUI = new MojePierwszeGUI(); // Inicjalizacja konstruktora klasy
        mojePierwszeGUI.setVisible(true); // Metoda wyświetlająca okno GUI
    }

    public MojePierwszeGUI()
    {
        super("Moje pierwsze GUI"); // Dziedziczenie z JFrame — napis na pasku
        this.setContentPane(this.JMainPanel); // Metoda wyświetlająca GUI na ekranie
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Metoda pozwalająca na zamknięcie okna
        // this.pack(); — Metoda, która upakowuje okno GUI zgodnie z preferowanymi rozmiarami komponentów,
        //                które są zawarte w Frame, rozmiar okna będzie dopasowywał się do rozmiarów komponentów
        int width = 500, height = 700; // Szerokość, wysokość
        this.setSize(width,height); // Metoda ustawiająca szerokość i wysokość okna GUI
        witajButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = JOptionPane.showInputDialog(null, "Podaj imię: ", "Imię wpisywanie", JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(null,"Witaj " + text, "Imię wyświetlanie", JOptionPane.INFORMATION_MESSAGE);
                int a = JOptionPane.showConfirmDialog(null, "Wpisano dane: " + text, "Moje okno pytające", JOptionPane.YES_NO_OPTION);
            }
        });
        zamknijButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); /* Metoda zamykania okna GUI */ }
        });
        OKButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jestTekstTextPane.setText("To jest tekst po zmianie");
                LocalDateTime mojaDataCzas = LocalDateTime.now();
                DateTimeFormatter dataCzasFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String mojaDataCzasFormatowana = mojaDataCzas.format(dataCzasFormat);
                miedzyPrzyciskowyText.setText(mojaDataCzasFormatowana);
            }
        });
    }
}
