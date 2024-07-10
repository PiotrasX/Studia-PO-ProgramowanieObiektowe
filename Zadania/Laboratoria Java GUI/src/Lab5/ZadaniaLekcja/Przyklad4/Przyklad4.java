package Lab5.ZadaniaLekcja.Przyklad4;

import javax.swing.*;
import java.awt.*;

public class Przyklad4 extends JFrame
{
    private JPanel JMainPanel;
    protected JMenu menu, subMenu;
    protected JMenuBar menuBar;
    protected JMenuItem i1, i2, i3, i4, i5;

    public static void main(String[] args)
    {
        Przyklad4 przyklad4GUI = new Przyklad4();
        przyklad4GUI.setVisible(true);
    }

    public Przyklad4()
    {
        super("JMenuBar, JMenu, JMenuItem");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        menu = new JMenu("Menu");
        subMenu = new JMenu("Sub Menu");
        i1 = new JMenuItem("Item 1");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 3.1");
        i5 = new JMenuItem("Item 3.2");
        menuBar = new JMenuBar();
        menuBar.add(menu);
        menu.add(i1); menu.add(i2); menu.add(i3);
        menu.add(subMenu);
        subMenu.add(i4); subMenu.add(i5);
        this.setJMenuBar(menuBar);
        this.setLayout(null);
    }
}
