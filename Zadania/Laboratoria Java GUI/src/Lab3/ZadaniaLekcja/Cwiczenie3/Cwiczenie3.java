package Lab3.ZadaniaLekcja.Cwiczenie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cwiczenie3 extends JFrame
{
    private JPanel JMainPanel;
    private JButton pokazButton;
    private JList jezykProgramowaniaList;
    private JList srodowiskoProgramowaniaList;
    private JLabel srodowiskoLabel;
    private JLabel jezykLabel;

    public static void main(String[] args)
    {
        Cwiczenie3 cwiczenie3GUI = new Cwiczenie3();
        cwiczenie3GUI.setVisible(true);
    }

    public Cwiczenie3()
    {
        super("List Ćwiczenie3");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1000, 760));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        UIManager.put("OptionPane.messageFont", new Font("JetBrains Mono", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(37,187,0));
        UIManager.put("OptionPane.background", new Color(239,210,233));
        UIManager.put("Panel.background", new Color(239,210,233));
        UIManager.put("Button.background", new Color(0,39,65));
        UIManager.put("Button.foreground", new Color(37,187,0));
        UIManager.put("Button.font", new Font("JetBrains Mono", Font.PLAIN, 18));

        pokazButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String jezyk = jezykGetText(), srodowisko = srodowiskoGetText();
                JOptionPane.showMessageDialog(null, "Wybrany język: " + jezyk + "\nWybrane środowisko: " + srodowisko, "Język i środowisko", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        MouseAdapter listener = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String jezyk = jezykGetText(), srodowisko = srodowiskoGetText();
                jezykLabel.setText("Wybrany język: " + jezyk);
                srodowiskoLabel.setText("Wybrane środowisko: " + srodowisko);
            }
        };
        jezykProgramowaniaList.addMouseListener(listener);
        srodowiskoProgramowaniaList.addMouseListener(listener);
    }

    private String jezykGetText()
    {
        String jezyk;
        if (jezykProgramowaniaList.getSelectedValue()==null) { jezyk = "nie wybrano"; }
        else { jezyk = (String) jezykProgramowaniaList.getSelectedValue(); }
        return jezyk;
    }
    private String srodowiskoGetText()
    {
        String srodowisko;
        if (srodowiskoProgramowaniaList.getSelectedValue()==null) { srodowisko = "nie wybrano"; }
        else { srodowisko = (String) srodowiskoProgramowaniaList.getSelectedValue(); }
        return srodowisko;
    }
}
