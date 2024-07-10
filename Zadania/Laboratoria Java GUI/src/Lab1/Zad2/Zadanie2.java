package Lab1.Zad2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Zadanie2 extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanelFull;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JPanel JPanel5;
    private JPanel JPanel6;
    private JPanel JPanel7;
    private JPanel JPanel8;
    private JPanel JPanel9;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a5Button;
    private JButton a3Button;
    private JLabel a2Label;
    private JLabel a3Label;
    private JLabel a4Label;
    private JLabel a5Label;
    private JLabel a1Label;
    private JLabel tajemnicaLabel;
    private JLabel a6Label;
    private JButton wlaczButton;
    private JCheckBox check3CheckBox;
    private JCheckBox check1CheckBox;
    private JCheckBox check2CheckBox;
    private JRadioButton cheok4RadioButton;
    private JLabel tajemnica2Label;
    private JButton okButton;
    private JLabel dataLabel;
    private JLabel tekstPoZmianieLabel;
    private JTextPane tutajZacznijPisacTextPane;
    private JButton wcisnij1Button;
    private JButton wcisnij3Button;
    private JButton wcisnij2Button;

    public static void main(String[] args)
    {
        Zadanie2 zadanie2GUI = new Zadanie2();
        zadanie2GUI.setVisible(true);
    }

    public Zadanie2()
    {
        super("Aplikacja wykorzystująca poznane komponenty");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1015,1040);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        a6Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tajemnicaLabel.setText("");
                tajemnica2Label.setText("!!!!!");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        a4Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                a2Label.setText("2");
                a5Label.setText("");
                tajemnicaLabel.setText("");
                tajemnica2Label.setText("");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        a2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                a5Label.setText("5");
                a6Label.setText("");
                tajemnicaLabel.setText("");
                tajemnica2Label.setText("");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        a1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                a3Label.setText("3");
                a2Label.setText("");
                tajemnicaLabel.setText("");
                tajemnica2Label.setText("");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        a5Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                a6Label.setText("6");
                a3Label.setText("");
                tajemnicaLabel.setText("");
                tajemnica2Label.setText("");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        a3Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tajemnicaLabel.setText("UKRYTA WIADOMOŚĆ");
                tajemnica2Label.setText("");
                tutajZacznijPisacTextPane.setEnabled(false);
            }
        });
        wlaczButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        cheok4RadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (cheok4RadioButton.isSelected())
                {
                    tutajZacznijPisacTextPane.setEnabled(true);
                    check1CheckBox.setEnabled(true);
                    check2CheckBox.setEnabled(false);
                    check3CheckBox.setEnabled(true);
                    cheok4RadioButton.setEnabled(true);
                }
                else
                {
                    tutajZacznijPisacTextPane.setEnabled(false);
                    check1CheckBox.setEnabled(true);
                    check2CheckBox.setEnabled(true);
                    check3CheckBox.setEnabled(false);
                    cheok4RadioButton.setEnabled(true);
                }
            }
        });
        check1CheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tutajZacznijPisacTextPane.setEnabled(false);
                check1CheckBox.setEnabled(false);
                check2CheckBox.setEnabled(false);
                check3CheckBox.setEnabled(true);
                cheok4RadioButton.setEnabled(true);
            }
        });
        check3CheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tutajZacznijPisacTextPane.setEnabled(true);
                check1CheckBox.setEnabled(true);
                check2CheckBox.setEnabled(true);
                check3CheckBox.setEnabled(false);
                cheok4RadioButton.setEnabled(true);
            }
        });
        check2CheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tutajZacznijPisacTextPane.setEnabled(false);
                check1CheckBox.setEnabled(true);
                check2CheckBox.setEnabled(true);
                check3CheckBox.setEnabled(false);
                cheok4RadioButton.setEnabled(false);
            }
        });
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tutajZacznijPisacTextPane.setEnabled(false);
                tekstPoZmianieLabel.setText("To jest tekst po wciśnięciu OK     ");
                LocalDateTime mojaDataCzas = LocalDateTime.now();
                DateTimeFormatter dataCzasFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String mojaDataCzasFormatowana = mojaDataCzas.format(dataCzasFormat);
                dataLabel.setText(mojaDataCzasFormatowana);
            }
        });
        wcisnij1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tutajZacznijPisacTextPane.setText("Twój tekst właśnie przestał istnieć :)");
            }
        });
        wcisnij2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { dataLabel.setText("Dzisiejsza data przestałą istnieć"); }
        });
        wcisnij3Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                  String text = JOptionPane.showInputDialog(null, "Przedstaw się: ", "Jesteś pewny, że to nie wirus?", JOptionPane.QUESTION_MESSAGE);
                  JOptionPane.showMessageDialog(null,"Nie znam cię " + text, "Brakowało mi cię", JOptionPane.INFORMATION_MESSAGE);
                  JOptionPane.showConfirmDialog(null, "Chcesz już mnie opuścić? ", "Smutno mi jest :(", JOptionPane.YES_NO_OPTION);
                  if (text.length() <= 35) tekstPoZmianieLabel.setText(text + "     ");
                  else tekstPoZmianieLabel.setText(text.substring(0,35) + "     ");
            }
        });
    }
}
