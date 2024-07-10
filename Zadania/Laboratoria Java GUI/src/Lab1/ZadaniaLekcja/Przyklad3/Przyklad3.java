package Lab1.ZadaniaLekcja.Przyklad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Przyklad3 extends JFrame
{
    private JPanel JMainPanel;
    private JTextField bTextField;
    private JTextField aTextField;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel wynikLabel;
    private JLabel wynikCyfraLabel;
    private JButton wyjscieButton;
    private JButton dodawanieButton;
    private JButton odejmowanieButton;

    public static void main(String[] args)
    {
        Przyklad3 przyklad3GUI = new Przyklad3();
        przyklad3GUI.setVisible(true);
    }

    public Przyklad3()
    {
        super("Przykład 3");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
        wyjscieButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        dodawanieButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BigDecimal a = number(aTextField.getText());
                BigDecimal b = number(bTextField.getText());
                try
                {
                    BigDecimal wynik = a.add(b);
                    wynikCyfraLabel.setText(String.valueOf(wynik));
                }
                catch (NullPointerException f)
                {
                    wynikCyfraLabel.setText("Niepoprawne dane wejściowe");
                }
                aTextField.setText("");
                bTextField.setText("");
            }
        });
        odejmowanieButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BigDecimal a = number(aTextField.getText());
                BigDecimal b = number(bTextField.getText());
                try
                {
                    BigDecimal wynik = a.subtract(b);
                    wynikCyfraLabel.setText(String.valueOf(wynik));
                }
                catch (NullPointerException f)
                {
                    wynikCyfraLabel.setText("Niepoprawne dane wejściowe");
                }
                aTextField.setText("");
                bTextField.setText("");
            }
        });
    }

    public BigDecimal number(String number)
    {
        try
        {
            for (int i = 0; i < number.length(); i++)
            {
                if (number.charAt(i) == '.' || number.charAt(i) == ',')
                {
                    number = "0" + number.substring(0,i) + "." + number.substring(i+1);
                    break;
                }
            }
            return new BigDecimal(number);
        }
        catch (ArithmeticException | NumberFormatException f)
        {
            wynikCyfraLabel.setText("Niepoprawne dane wejściowe");
            return null;
        }
    }
}
