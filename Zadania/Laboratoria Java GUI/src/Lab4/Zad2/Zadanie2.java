package Lab4.Zad2;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie2 extends JFrame
{
    private JPanel JMainPanel;
    private JButton buttonB;
    private JButton buttonI;
    private JButton buttonZ;
    private JButton buttonP;
    private JEditorPane editorPane;
    private JComboBox comboBox;
    private JTextPane textPane;
    private JLabel kolorLabel;
    private JLabel edytorLabel;
    private JScrollPane scrollPane;
    private JButton buttonN;
    private JButton buttonBI;
    private JLabel czcionkaLabel;
    private JLabel rozmiarCzcionkaLabel;
    private JLabel kolorCzcionkaLabel;

    StyledDocument doc = textPane.getStyledDocument();
    Style style = textPane.addStyle("", textPane.getStyle(""));
    int sizeFont = 20;

    public static void main(String[] args)
    {
        Zadanie2 zadanie2GUI = new Zadanie2();
        zadanie2GUI.setVisible(true);
    }

    public Zadanie2()
    {
        super("Zadanie 2");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        ActionListener listener2 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object jakiPrzycisk = e.getSource();
                generujDocStyle();
                if(jakiPrzycisk == buttonP && sizeFont < 96) { ++sizeFont; }
                else if(jakiPrzycisk == buttonZ && sizeFont > 4) { --sizeFont; }
                StyleConstants.setFontSize(style, sizeFont);
                rozmiarCzcionkaLabel.setText("Rozmiar czcionki: " + sizeFont);
                wypiszDocStyle();
            }
        };
        buttonP.addActionListener(listener2);
        buttonZ.addActionListener(listener2);

        ActionListener listener1 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object jakiPrzycisk = e.getSource();
                generujDocStyle();
                StyleConstants.setBold(style, false);
                StyleConstants.setItalic(style, false);
                czcionkaLabel.setText("Czcionka: normal");
                if(jakiPrzycisk == buttonB) { StyleConstants.setBold(style, true); czcionkaLabel.setText("Czcionka: bold");}
                else if(jakiPrzycisk == buttonI) { StyleConstants.setItalic(style, true); czcionkaLabel.setText("Czcionka: italic"); }
                else if(jakiPrzycisk == buttonBI) { StyleConstants.setItalic(style, true); StyleConstants.setBold(style, true); czcionkaLabel.setText("Czcionka: bold italic"); }
                wypiszDocStyle();
            }
        };
        buttonB.addActionListener(listener1);
        buttonI.addActionListener(listener1);
        buttonN.addActionListener(listener1);
        buttonBI.addActionListener(listener1);

        comboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                generujDocStyle();
                String kolor = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
                switch (kolor)
                {
                    case "Czarny" -> { StyleConstants.setForeground(style, Color.black); kolorCzcionkaLabel.setText("Kolor czcionki: czarny"); }
                    case "Czerwony" -> { StyleConstants.setForeground(style, Color.red); kolorCzcionkaLabel.setText("Kolor czcionki: czerwony"); }
                    case "Zielony" -> { StyleConstants.setForeground(style, Color.green); kolorCzcionkaLabel.setText("Kolor czcionki: zielony"); }
                    case "Niebieski" -> { StyleConstants.setForeground(style, Color.blue); kolorCzcionkaLabel.setText("Kolor czcionki: niebieski"); }
                    case "Żółty" -> { StyleConstants.setForeground(style, Color.yellow); kolorCzcionkaLabel.setText("Kolor czcionki: żółty"); }
                    case "Szary" -> { StyleConstants.setForeground(style, new Color(177,183,186)); kolorCzcionkaLabel.setText("Kolor czcionki: szary"); }
                    case "Fioletowy" -> { StyleConstants.setForeground(style, new Color(184,32,233)); kolorCzcionkaLabel.setText("Kolor czcionki: fioletowy"); }
                }
                wypiszDocStyle();
            }
        });
    }

    public void generujDocStyle()
    {
        doc = textPane.getStyledDocument();
        style = textPane.addStyle("", textPane.getStyle(""));
    }

    public void wypiszDocStyle()
    {
        try { doc.insertString(doc.getLength(), String.valueOf((char) 127), style); }
        catch (BadLocationException ex) { throw new RuntimeException(ex); }
    }
}
