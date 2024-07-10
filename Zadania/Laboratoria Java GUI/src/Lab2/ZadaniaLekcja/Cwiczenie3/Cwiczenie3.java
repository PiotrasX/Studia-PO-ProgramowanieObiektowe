package Lab2.ZadaniaLekcja.Cwiczenie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cwiczenie3 extends JFrame
{
    private JPanel JMainPanel;
    private JButton okButton;
    private JPanel JPanelDown;
    private JPanel JPanelUP;
    private JPanel JPanel3;
    private JPanel JPanel1;
    private JPanel JPanel4;
    private JPanel JPanel2;
    private JLabel kursLabel;
    private JCheckBox javaCheckBox;
    private JCheckBox cShCheckBox;
    private JCheckBox cPlusCheckBox;
    private JCheckBox pythonCheckBox;

    public static void main(String[] args)
    {
        Cwiczenie3 cwiczenie3GUI = new Cwiczenie3();
        cwiczenie3GUI.setVisible(true);
    }

    public Cwiczenie3()
    {
        super("Wybór kursów programowania");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int cena = 0;
                String wiadomosc = "";
                if (javaCheckBox.isSelected()) { cena+=3500; wiadomosc+="Java - cena 3500 PLN\n"; }
                if (cPlusCheckBox.isSelected()) { cena+=4000; wiadomosc+="C++ - cena 4000 PLN\n"; }
                if (cShCheckBox.isSelected()) { cena+=3000; wiadomosc+="C# - cena 3000 PLN\n"; }
                if (pythonCheckBox.isSelected()) { cena+=5000; wiadomosc+="Python - cena 5000 PLN\n"; }
                if (cena==0) { wiadomosc+="Nie wybrano żadnego kursu"; }
                else { wiadomosc+="---------------------------------\nRazem: " + cena + " PLN"; }
                UIManager.put("OptionPane.messageForeground", new Color(11,22,33));
                UIManager.put("OptionPane.background", new Color(143,85,254));
                UIManager.put("Panel.background", new Color(143,85,254));
                UIManager.put("Button.background", new Color(229,132,69));
                UIManager.put("Button.foreground", new Color(11,22,33));
                UIManager.put("Button.font", new Font("Leelawadee UI", Font.BOLD, 16));
                JOptionPane.showMessageDialog(null, wiadomosc, "Wybrane kursy", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
