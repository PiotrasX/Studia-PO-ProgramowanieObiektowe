package Lab4.ZadaniaLekcja.Cwiczenie1;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Cwiczenie1 extends JFrame
{
    private JPanel JMainPanel;
    private JLabel listaKursowLabel;
    private JTree kursyTree;
    private JTextField kursTextField;
    private JTextField cenaTextField;
    private JLabel kursLabel;
    private JLabel cenaLabel;
    private JButton wyjscieButton;
    private JButton oplacKursButton;

    public static void main(String[] args)
    {
        Cwiczenie1 cwiczenie1GUI = new Cwiczenie1();
        cwiczenie1GUI.setVisible(true);
    }

    public Cwiczenie1()
    {
        this.setTitle("JTree");
        this.setContentPane(JMainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 400));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        oplacKursButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String kurs = kursTextField.getText();
                String cenaSlownie = cenaTextField.getText();
                if (kurs.isEmpty() || cenaSlownie.isEmpty()) { JOptionPane.showMessageDialog(null, "Nie wybrano żadnego kursu", "Nic nie wybrano", JOptionPane.WARNING_MESSAGE); }
                else
                {
                    String wybor = JOptionPane.showInputDialog(null, "Podaj swoje imię i nazwisko:", "Wprowadź dane", JOptionPane.QUESTION_MESSAGE);
                    if (wybor != null && !wybor.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Zakupiono kurs: " + kursTextField.getText(), "Kurs zakupiony", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else if (wybor == null)
                        JOptionPane.showMessageDialog(null, "Anulowano zakup kursu", "Zakup anulowany", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Nie wprowadzono poprawnie danych", "Błąd danych", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        wyjscieButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });

        String[] niedozwolone = {"Moje kursy", "Programowanie", "Grafika komputerowa"};
        Map<String, Integer> ceny = new LinkedHashMap<>();
        ceny.put("C", 3500);
        ceny.put("C++", 2700);
        ceny.put("C#", 3950);
        ceny.put("Java", 4100);
        ceny.put("Python", 2450);
        ceny.put("Kotlin", 1990);
        ceny.put("Pascal", 2800);
        ceny.put("Adobe Photoshop", 4300);
        ceny.put("CorelDRAW", 3250);
        ceny.put("Adobe InDesign", 2990);
        ceny.put("Adobe Ilustrator", 4200);
        ceny.put("Gimp", 2320);

        kursyTree.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                DefaultMutableTreeNode selectedNone = (DefaultMutableTreeNode) Objects.requireNonNull(kursyTree.getSelectionPath()).getLastPathComponent();
                String kurs = String.valueOf(selectedNone);
                boolean czyMoznaNapisac = true;
                for (String element : niedozwolone)
                    { if (element.equals(kurs)) { czyMoznaNapisac = false; break; } }

                int cena = 0;
                for (Map.Entry<String, Integer> entry : ceny.entrySet())
                    { if (entry.getKey().equals(kurs)) { cena = entry.getValue(); break; } }
                if (kurs != null && czyMoznaNapisac)
                {
                    kursTextField.setText(kurs);
                    cenaTextField.setText(String.valueOf(cena));
                }
                else
                {
                    kursTextField.setText("");
                    cenaTextField.setText("");
                }
           }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultMutableTreeNode mojeKursy = new DefaultMutableTreeNode("Moje kursy");
        DefaultMutableTreeNode programowanie = new DefaultMutableTreeNode("Programowanie");
        mojeKursy.add(programowanie);
        programowanie.add(new DefaultMutableTreeNode("C"));
        programowanie.add(new DefaultMutableTreeNode("C++"));
        programowanie.add(new DefaultMutableTreeNode("C#"));
        programowanie.add(new DefaultMutableTreeNode("Java"));
        programowanie.add(new DefaultMutableTreeNode("Python"));
        programowanie.add(new DefaultMutableTreeNode("Kotlin"));
        programowanie.add(new DefaultMutableTreeNode("Pascal"));
        DefaultMutableTreeNode grafikaKomputerowa = new DefaultMutableTreeNode("Grafika komputerowa");
        mojeKursy.add(grafikaKomputerowa);
        grafikaKomputerowa.add(new DefaultMutableTreeNode("Adobe Photoshop"));
        grafikaKomputerowa.add(new DefaultMutableTreeNode("Adobe InDesign"));
        grafikaKomputerowa.add(new DefaultMutableTreeNode("Adobe Ilustrator"));
        grafikaKomputerowa.add(new DefaultMutableTreeNode("CorelDRAW"));
        grafikaKomputerowa.add(new DefaultMutableTreeNode("Gimp"));
        kursyTree = new JTree(mojeKursy);
    }
}
