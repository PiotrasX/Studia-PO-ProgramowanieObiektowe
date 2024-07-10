package Lab2.ZadaniaLekcja.Przyklad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Przyklad1 extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JButton boldButton;
    private JButton regularButton;
    private JButton italicBoldButton;
    private JButton italicButton;
    private JLabel Label1;
    private JLabel Label2;
    private JTextArea textArea1;
    private JButton policzButton;

    public static void main(String[] args)
    {
        Przyklad1 przyklad1GUI = new Przyklad1();
        przyklad1GUI.setVisible(true);
    }

    public Przyklad1()
    {
        super("Przykład 1");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600,450));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String polecenie = e.getActionCommand();
                switch (polecenie)
                {
                    case "Policz" ->
                    {
                        Label2.setText(textArea1.getText().length() + " znaków");
                        Label1.setText(textArea1.getLineCount() + " lini tekstu");
                    }
                    case "Regular" ->
                    {
                        Font f = new Font("Serif", Font.PLAIN, 16);
                        textArea1.setFont(f);
                    }
                    case "Bold" ->
                    {
                        Font f = new Font("Serif", Font.BOLD, 16);
                        textArea1.setFont(f);
                    }
                    case "Italic" ->
                    {
                        Font f = new Font("Serif", Font.ITALIC, 16);
                        textArea1.setFont(f);
                    }
                    case "Italic Bold" ->
                    {
                        Font f = new Font("Serif", Font.BOLD | Font.ITALIC, 16);
                        textArea1.setFont(f);
                    }
                }
            }
        };
        boldButton.addActionListener(listener);
        regularButton.addActionListener(listener);
        italicBoldButton.addActionListener(listener);
        italicButton.addActionListener(listener);
        policzButton.addActionListener(listener);
    }
}
