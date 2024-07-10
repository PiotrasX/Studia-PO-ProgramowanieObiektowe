package Lab2.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Sklep extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanelDown;
    private JPanel JPanelUP;
    private JLabel nazwaLabel;
    private JButton kupButton;
    private JButton powrotButton;
    private JPanel JPanel1;
    private JLabel doZakupuLabel;
    private JLabel imageLabel1;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JCheckBox cPlusCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox cCheckBox;
    private JCheckBox kotlinCheckBox;
    private JCheckBox pascalCheckBox;
    private JLabel imageLabel2;
    private JLabel imageLabel3;
    private JLabel imageLabel4;
    private JLabel imageLabel5;
    private JLabel imageLabel6;
    private JLabel imageLabel7;
    private JLabel kwotaLabel;
    private final ImageIcon iconJava = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\javaLogo.png")));
    private final ImageIcon iconPython = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\pythonLogo.png")));
    private final ImageIcon iconCPlus = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\cppLogo.png")));
    private final ImageIcon iconCSharp = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\csharpLogo.png")));
    private final ImageIcon iconC = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\cLogo.png")));
    private final ImageIcon iconKotlin = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\kotlinLogo.png")));
    private final ImageIcon iconPascal = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\pascalLogo.png")));
    private final ImageIcon puste = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\puste.png")));

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight)
    {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args)
    {
        Sklep sklepGUI = new Sklep("admin", "6000", "");
        sklepGUI.setVisible(true);
    }

    public Sklep(String nazwa, String pieniadze, String kursy)
    {
        super("Sklep kursów programowania");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1500,900));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        int wymiar = 55;
        kwotaLabel.setText("Portfel: " + pieniadze + " PLN               ");
        if (!Objects.equals(kursy,""))
        {
            String[] kursyTab = new String[7];
            int ileKursow=0;
            int j=0;
            for (int i=0; i<kursy.length(); i++)
            {
                if (kursy.charAt(i)==';')
                {
                    kursyTab[ileKursow] = kursy.substring(j,i);
                    j = i + 1;
                    ileKursow++;
                }
            }
            for (String kurs : kursyTab)
            {
                if (kurs==null) { continue; }
                if (Objects.equals(kurs,"Java")) { javaCheckBox.setEnabled(false); javaCheckBox.setText("Java   -   kurs zakupiony"); imageLabel1.setIcon(resize(iconJava,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"Python")) { pythonCheckBox.setEnabled(false); pythonCheckBox.setText("Python   -   kurs zakupiony"); imageLabel2.setIcon(resize(iconPython,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"C++")) { cPlusCheckBox.setEnabled(false); cPlusCheckBox.setText("C++   -   kurs zakupiony"); imageLabel3.setIcon(resize(iconCPlus,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"C#")) { cSharpCheckBox.setEnabled(false); cSharpCheckBox.setText("C#   -   kurs zakupiony"); imageLabel4.setIcon(resize(iconCSharp,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"C")) { cCheckBox.setEnabled(false); cCheckBox.setText("C   -   kurs zakupiony"); imageLabel5.setIcon(resize(iconC,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"Kotlin")) { kotlinCheckBox.setEnabled(false); kotlinCheckBox.setText("Kotlin   -   kurs zakupiony"); imageLabel6.setIcon(resize(iconKotlin,wymiar,wymiar)); continue; }
                if (Objects.equals(kurs,"Pascal")) { pascalCheckBox.setEnabled(false); pascalCheckBox.setText("Pascal   -   kurs zakupiony"); imageLabel7.setIcon(resize(iconPascal,wymiar,wymiar)); }
            }
        }

        kupButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int srodki = Integer.parseInt(pieniadze);
                String kursyZakup = kursy;
                int cena = 0;
                String wiadomosc = "";
                if (javaCheckBox.isSelected()) { cena+=650; wiadomosc+="Java   -   cena 650 PLN\n"; kursyZakup+="Java;"; }
                if (pythonCheckBox.isSelected()) { cena+=480; wiadomosc+="Python   -   cena 480 PLN\n"; kursyZakup+="Python;"; }
                if (cPlusCheckBox.isSelected()) { cena+=920; wiadomosc+="C++   -   cena 920 PLN\n"; kursyZakup+="C++;"; }
                if (cSharpCheckBox.isSelected()) { cena+=770; wiadomosc+="C#   -   cena 770 PLN\n"; kursyZakup+="C#;"; }
                if (cCheckBox.isSelected()) { cena+=1235; wiadomosc+="C   -   cena 1235 PLN\n"; kursyZakup+="C;"; }
                if (kotlinCheckBox.isSelected()) { cena+=1420; wiadomosc+="Kotlin   -   cena 1420 PLN\n"; kursyZakup+="Kotlin;"; }
                if (pascalCheckBox.isSelected()) { cena+=840; wiadomosc+="Pascal   -   cena 840 PLN\n"; kursyZakup+="Pascal;"; }
                wiadomosc+="---------------------------------\nRazem: " + cena + " PLN\n\nCzy chcesz zakupić podane kursy?";
                if (cena==0)
                {
                    JOptionPane.showMessageDialog(null, "Nie wybrano żadnego kursu", "Zakup kursów", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int i = JOptionPane.showConfirmDialog(null, wiadomosc, "Zakup kursów", JOptionPane.YES_NO_OPTION);
                    if (i==0)
                    {
                        if (srodki<cena) { JOptionPane.showMessageDialog(null, "Brak wystarczającej ilości środków", "Brak środków", JOptionPane.WARNING_MESSAGE); }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Pomyślnie zakupiono podane kursy", "Zakup udany", JOptionPane.INFORMATION_MESSAGE);
                            srodki-=cena;
                            PanelKlienta panelKlientaGUI = new PanelKlienta(nazwa, String.valueOf(srodki), kursyZakup);
                            panelKlientaGUI.setVisible(true);
                            dispose();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Zakup został anulowany", "Zakup anulowany", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        powrotButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PanelKlienta panelKlientaGUI = new PanelKlienta(nazwa, pieniadze, kursy);
                panelKlientaGUI.setVisible(true);
                dispose();
            }
        });

        javaCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (javaCheckBox.isSelected()) { imageLabel1.setIcon(resize(iconJava,wymiar,wymiar)); }
                if (!javaCheckBox.isSelected()) { imageLabel1.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        pythonCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (pythonCheckBox.isSelected()) { imageLabel2.setIcon(resize(iconPython,wymiar,wymiar)); }
                if (!pythonCheckBox.isSelected()) { imageLabel2.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        cPlusCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (cPlusCheckBox.isSelected()) { imageLabel3.setIcon(resize(iconCPlus,wymiar,wymiar)); }
                if (!cPlusCheckBox.isSelected()) { imageLabel3.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        cSharpCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (cSharpCheckBox.isSelected()) { imageLabel4.setIcon(resize(iconCSharp,wymiar,wymiar)); }
                if (!cSharpCheckBox.isSelected()) { imageLabel4.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        cCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (cCheckBox.isSelected()) { imageLabel5.setIcon(resize(iconC,wymiar,wymiar)); }
                if (!cCheckBox.isSelected()) { imageLabel5.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        kotlinCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (kotlinCheckBox.isSelected()) { imageLabel6.setIcon(resize(iconKotlin,wymiar,wymiar)); }
                if (!kotlinCheckBox.isSelected()) { imageLabel6.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
        pascalCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (pascalCheckBox.isSelected()) { imageLabel7.setIcon(resize(iconPascal,wymiar,wymiar)); }
                if (!pascalCheckBox.isSelected()) { imageLabel7.setIcon(resize(puste,wymiar,wymiar)); }
            }
        });
    }
}
