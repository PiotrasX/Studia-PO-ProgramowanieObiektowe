package Lab5.ZadaniaLekcja.Przyklad1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Przyklad1 extends JFrame
{
    private JPanel JMainPanel;
    private JLabel label;
    private JSpinner spinner;

    public static void main(String[] args)
    {
        Przyklad1 przyklad1GUI = new Przyklad1();
        przyklad1GUI.setVisible(true);
    }

    public Przyklad1()
    {
        super("JSpinner");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        SpinnerModel value = new SpinnerNumberModel(5, // Początkowa wartość
                                                          0, // Minimalna wartość
                                                          10, // Maksymalna wartość
                                                          1); // Krok
        spinner.setModel(value);
        label.setText("Wartość: " + spinner.getValue());

        spinner.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e) { label.setText("Wartość: " + spinner.getValue()); }
        });
    }
}
