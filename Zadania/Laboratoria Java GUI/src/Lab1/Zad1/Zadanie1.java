package Lab1.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Zadanie1 extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanel1;
    private JPanel JPanel5;
    private JPanel JPanel3;
    private JPanel JPanel2;
    private JPanel JPanel4;
    private JLabel konwersjaLabel;
    private JTextField wpiszField;
    private JButton przeliczButton;
    private JButton zamknijButton;
    private JLabel celsjuszLabel;
    private JLabel farenheitLabel;
    private JLabel errorLabel;

    public static void main(String[] args)
    {
        Zadanie1 zadanie1GUI = new Zadanie1();
        zadanie1GUI.setVisible(true);
    }

    public Zadanie1()
    {
        super("Konwersja temperatury");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,450);
        this.setMinimumSize(new Dimension(600,450));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        przeliczButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tempS = wpiszField.getText();
                try
                {
                    for (int i = 0; i < tempS.length(); i++)
                    {
                        if (tempS.charAt(i) == '.' || tempS.charAt(i) == ',')
                        {
                            tempS = "0" + tempS.substring(0,i) + "." + tempS.substring(i+1);
                            break;
                        }
                    }
                    float temp = Float.parseFloat(tempS);
                    if (temp>999) throw new ArithmeticException();
                    float tempF = (((float) 9/5) * temp) + 32;
                    float tempC = ((temp - 32) * ((float) 5/9));
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(1);
                    errorLabel.setText("");
                    farenheitLabel.setText(df.format(temp) + "C = " + df.format(tempF) + "F");
                    celsjuszLabel.setText(df.format(temp) + "F = " + df.format(tempC) + "C");
                }
                catch (ArithmeticException | NumberFormatException f)
                {
                    errorLabel.setText("Niepoprawne dane");
                    farenheitLabel.setText("");
                    celsjuszLabel.setText("");
                }
            }
        });
        zamknijButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }
}
