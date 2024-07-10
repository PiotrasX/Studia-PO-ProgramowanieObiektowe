package Lab3.ZadaniaLekcja.Cwiczenie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cwiczenie1 extends JFrame
{
    private JComboBox wybierzComboBox;
    private JLabel tekstLabel;
    private JPanel JMainPanel;
    private JButton pokazButton;

    public static void main(String[] args)
    {
        Cwiczenie1 cwiczenie1GUI = new Cwiczenie1();
        cwiczenie1GUI.setVisible(true);
    }

    public Cwiczenie1()
    {
        super("ComboBox Ćwiczenie1");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 400));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        wybierzComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tekst = "Wybrano język " + wybierzComboBox.getItemAt(wybierzComboBox.getSelectedIndex());
                tekstLabel.setText(tekst);
            }
        });
        pokazButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UIManager.put("OptionPane.messageFont", new Font("Arial Black", Font.BOLD, 22));
                UIManager.put("OptionPane.messageForeground", new Color(0,52,187));
                UIManager.put("OptionPane.background", new Color(255,235,195));
                UIManager.put("Panel.background", new Color(255,235,195));
                UIManager.put("Button.background", new Color(178,255,167));
                UIManager.put("Button.foreground", new Color(0,52,187));
                UIManager.put("Button.font", new Font("Arial Black", Font.BOLD, 22));

                String tekst = (String) wybierzComboBox.getItemAt(wybierzComboBox.getSelectedIndex());
                JOptionPane.showMessageDialog(null,"Wybrałeś " + tekst + " jako swój język programowania","Wybrany język",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
