package Lab4.ZadaniaLekcja.Przyklad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Przyklad1 extends JFrame
{
    private JPanel JMainPanel;
    private JTabbedPane tabbedPane;
    private JEditorPane editorPane;
    private JScrollBar scrollBar;
    private JPanel card1InTabbedPane;
    private JSplitPane splitPane;
    private JLabel valuesLabel;
    private JPanel card2InTabbedPane;
    private JLabel textInCard1Label;
    private JLabel text1InCard2Label;
    private JLabel text2InCard2Label;
    private JButton przycisk1Button;
    private JButton przycisk2Button;

    public static void main(String[] args)
    {
        Przyklad1 przyklad1GUI = new Przyklad1();
        przyklad1GUI.setVisible(true);
    }

    public Przyklad1()
    {
        this.setTitle("JTabbedPane, JSplitPane, JEditorPane, JScrollBar");
        this.setContentPane(JMainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(900, 400));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        scrollBar.addAdjustmentListener(new AdjustmentListener()
        {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e)
            {
                valuesLabel.setText("Vertical ScrollBar value is: " + scrollBar.getValue());
            }
        });

        przycisk1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { editorPane.setEnabled(false); }
        });

        przycisk2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { editorPane.setEnabled(true); }
        });
    }
}
