package Lab5.ZadaniaLekcja.Przyklad2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Przyklad2 extends JFrame
{
    private JPanel JMainPanel;
    private JLabel label1;
    private JSlider slider1;
    private JSlider slider2;
    private JLabel label2;

    public static void main(String[] args)
    {
        Przyklad2 przyklad2GUI = new Przyklad2();
        przyklad2GUI.setVisible(true);
    }

    public Przyklad2()
    {
        super("JSlider");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        slider1.setMinorTickSpacing(2);
        slider1.setMajorTickSpacing(10);
        slider1.setPaintTicks(true); // Widoczne odstępy w formie lin
        slider1.setPaintLabels(true); // Widoczne odstępy w formie cyfr
        label1.setText("Wartość: " + slider1.getValue());

        slider2.setMinorTickSpacing(5);
        slider2.setMajorTickSpacing(20);
        slider2.setPaintTicks(true); // Widoczne odstępy w formie lin
        slider2.setPaintLabels(true); // Widoczne odstępy w formie cyfr
        label2.setText("Wartość: " + slider2.getValue());

        slider1.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e) { label1.setText("Wartość: " + slider1.getValue()); }
        });

        slider2.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e) { label2.setText("Wartość: " + slider2.getValue()); }
        });
    }
}
