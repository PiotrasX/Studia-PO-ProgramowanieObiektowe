package Lab5.ZadaniaLekcja.Przyklad3;

import javax.swing.*;
import java.awt.*;

public class Przyklad3 extends JFrame
{
    private JPanel JMainPanel;
    private JProgressBar progressBar;

    public static void main(String[] args)
    {
        Przyklad3 przyklad3GUI = new Przyklad3();
        przyklad3GUI.setVisible(true);
        przyklad3GUI.iterate();
    }

    public Przyklad3()
    {
        super("JProgressBar");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar
    }

    public void iterate()
    {
        int i = 0;
        while (i <= 10000)
        {
            progressBar.setValue(i);
            i += 10;
            try { Thread.sleep(10); }
            catch(Exception ignored) { }
        }
    }

}
