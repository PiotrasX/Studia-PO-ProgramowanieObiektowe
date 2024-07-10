package Lab2.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Lab2.Zad2.Zadanie2.getDane;
import static Lab2.Zad2.Zadanie2.setDane;

public class PanelKlienta extends JFrame
{
    private JPanel JMainPanel;
    private JLabel nazwaLabel;
    private JLabel kupioneLabel;
    private JButton wylogujButton;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JLabel kwotaLabel;
    private JLabel doZakupuLabel;
    private JLabel kupKursLabel;
    private JButton sklepButton;
    private JLabel rozpocznijKursLabel;
    private JButton startButton;
    private JLabel imageLabel1;
    private JLabel imageLabel2;
    private JLabel imageLabel3;
    private JLabel imageLabel4;
    private JLabel imageLabel5;
    private JLabel imageLabel6;
    private JLabel imageLabel7;
    private JRadioButton javaRadioButton;
    private JRadioButton pythonRadioButton;
    private JRadioButton cPlusRadioButton;
    private JRadioButton cSharpRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton kotlinRadioButton;
    private JRadioButton pascalRadioButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel image1Label;
    private JLabel image2Label;
    private JLabel image3Label;
    private JLabel image4Label;
    private JLabel image5Label;
    private JLabel image6Label;
    private JLabel image7Label;
    private final ImageIcon iconJava = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\javaLogo.png")));
    private final ImageIcon iconPython = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\pythonLogo.png")));
    private final ImageIcon iconCPlus = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\cppLogo.png")));
    private final ImageIcon iconCSharp = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\csharpLogo.png")));
    private final ImageIcon iconC = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\cLogo.png")));
    private final ImageIcon iconKotlin = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\kotlinLogo.png")));
    private final ImageIcon iconPascal = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\pascalLogo.png")));
    private final ImageIcon puste = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\puste.png")));

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight)
    {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args)
    {
        PanelKlienta panelKlientaGUI = new PanelKlienta("admin", "6000", "Java;Python;");
        panelKlientaGUI.setVisible(true);
    }

    public PanelKlienta(String nazwa, String pieniadze, String kursy)
    {
        super("Panel klienta");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1500,900));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        Map<String, java.util.List<String>> dane = getDane();
        for (Map.Entry<String, List<String>> przegladajDane : dane.entrySet())
        {
            if (Objects.equals(przegladajDane.getKey(),nazwa)) { setDane(nazwa, Arrays.asList(przegladajDane.getValue().get(0), przegladajDane.getValue().get(1), pieniadze, kursy)); break; }
        }

        int wymiar=55;
        image1Label.setIcon(resize(iconJava,wymiar,wymiar));
        image2Label.setIcon(resize(iconPython,wymiar,wymiar));
        image3Label.setIcon(resize(iconCPlus,wymiar,wymiar));
        image4Label.setIcon(resize(iconCSharp,wymiar,wymiar));
        image5Label.setIcon(resize(iconC,wymiar,wymiar));
        image6Label.setIcon(resize(iconKotlin,wymiar,wymiar));
        image7Label.setIcon(resize(iconPascal,wymiar,wymiar));
        kwotaLabel.setText("Portfel: " + pieniadze + " PLN");
        if (!Objects.equals(kursy, ""))
        {
            String[] kursyTab = new String[7];
            int ileKursow=0;
            int j=0;
            for (int i=0; i<kursy.length(); i++)
            {
                if (kursy.charAt(i)==';')
                {
                    kursyTab[ileKursow] = kursy.substring(j,i);
                    j=i+1;
                    ileKursow++;
                }
            }
            for (String kurs : kursyTab)
            {
                if (kurs==null) { continue; }
                if (kurs.equals("Java")) { javaRadioButton.setEnabled(true); imageLabel1.setIcon(resize(iconJava,wymiar,wymiar)); label1.setText(""); image1Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("Python")) { pythonRadioButton.setEnabled(true); imageLabel2.setIcon(resize(iconPython,wymiar,wymiar)); label2.setText(""); image2Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("C++")) { cPlusRadioButton.setEnabled(true); imageLabel3.setIcon(resize(iconCPlus,wymiar,wymiar)); label3.setText(""); image3Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("C#")) { cSharpRadioButton.setEnabled(true); imageLabel4.setIcon(resize(iconCSharp,wymiar,wymiar)); label4.setText(""); image4Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("C")) { cRadioButton.setEnabled(true); imageLabel5.setIcon(resize(iconC,wymiar,wymiar)); label5.setText(""); image5Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("Kotlin")) { kotlinRadioButton.setEnabled(true); imageLabel6.setIcon(resize(iconKotlin,wymiar,wymiar)); label6.setText(""); image6Label.setIcon(resize(puste,wymiar,wymiar)); continue; }
                if (kurs.equals("Pascal")) { pascalRadioButton.setEnabled(true); imageLabel7.setIcon(resize(iconPascal,wymiar,wymiar)); label7.setText(""); image7Label.setIcon(resize(puste,wymiar,wymiar)); }
            }
            if (Objects.equals(label6.getText(),""))
            {
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
            if (Objects.equals(label5.getText(),""))
            {
                image5Label.setIcon(image6Label.getIcon()); label5.setText(label6.getText());
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
            if (Objects.equals(label4.getText(),""))
            {
                image4Label.setIcon(image5Label.getIcon()); label4.setText(label5.getText());
                image5Label.setIcon(image6Label.getIcon()); label5.setText(label6.getText());
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
            if (Objects.equals(label3.getText(),""))
            {
                image3Label.setIcon(image4Label.getIcon()); label3.setText(label4.getText());
                image4Label.setIcon(image5Label.getIcon()); label4.setText(label5.getText());
                image5Label.setIcon(image6Label.getIcon()); label5.setText(label6.getText());
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
            if (Objects.equals(label2.getText(),""))
            {
                image2Label.setIcon(image3Label.getIcon()); label2.setText(label3.getText());
                image3Label.setIcon(image4Label.getIcon()); label3.setText(label4.getText());
                image4Label.setIcon(image5Label.getIcon()); label4.setText(label5.getText());
                image5Label.setIcon(image6Label.getIcon()); label5.setText(label6.getText());
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
            if (Objects.equals(label1.getText(),""))
            {
                image1Label.setIcon(image2Label.getIcon()); label1.setText(label2.getText());
                image2Label.setIcon(image3Label.getIcon()); label2.setText(label3.getText());
                image3Label.setIcon(image4Label.getIcon()); label3.setText(label4.getText());
                image4Label.setIcon(image5Label.getIcon()); label4.setText(label5.getText());
                image5Label.setIcon(image6Label.getIcon()); label5.setText(label6.getText());
                image6Label.setIcon(image7Label.getIcon()); label6.setText(label7.getText());
                image7Label.setIcon(resize(puste,wymiar,wymiar)); label7.setText("");
            }
        }

        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageForeground", new Color(45,15,15));
        UIManager.put("OptionPane.background", new Color(242,216,166));
        UIManager.put("Panel.background", new Color(242,216,166));
        UIManager.put("Button.background", new Color(45,10,45));
        UIManager.put("Button.foreground", new Color(255,255,255));
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 16));

        wylogujButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int i = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz się wylogować?", "Wylogować z aplikacji?", JOptionPane.YES_NO_OPTION);
                if (i==0)
                {
                    JOptionPane.showMessageDialog(null, "Pomyślnie wylogowano", "Wylogowano z aplikacji", JOptionPane.INFORMATION_MESSAGE);
                    Logowanie logowanieGUI = new Logowanie();
                    logowanieGUI.setVisible(true);
                    dispose();
                }
                else { JOptionPane.showMessageDialog(null, "Anulowano wylogowanie", "Anulowano wylogowanie", JOptionPane.INFORMATION_MESSAGE); }
            }
        });

        sklepButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Sklep sklepGUI = new Sklep(nazwa, pieniadze, kursy);
                sklepGUI.setVisible(true);
                dispose();
            }
        });


        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!javaRadioButton.isSelected() && !pythonRadioButton.isSelected() && !cPlusRadioButton.isSelected() && !cSharpRadioButton.isSelected() && !cRadioButton.isSelected() && !kotlinRadioButton.isSelected() && !pascalRadioButton.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Nie wybrano żadnego kursu", "Nie wybrano kursu", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int i = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz rozpocząć kurs?", "Rozpocząć kurs?", JOptionPane.YES_NO_OPTION);
                    if (i==0)
                    {
                        JOptionPane.showMessageDialog(null, "Kurs został rozpoczęty", "Rozpoczęto kurs", JOptionPane.INFORMATION_MESSAGE);
                        if (javaRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=Q_4XRJuJTBM&list=PL6aekdNhY7DCM1wGLQCE9eP3kPzu-P7E7";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (pythonRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=vek4MqPGvVU&list=PL6aekdNhY7DBGiMXnmBYjImq_vW32QftK";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (cPlusRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=cMtg4bpKI9w&list=PL6aekdNhY7DAkl9D3i55ppfwOpeSqIsh9";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (cSharpRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=qVMX17uoHbk&list=PL6aekdNhY7DAeU-2LEGBDXls60Yy-Ubbu&index=3";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (cRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=o9zn6XQKjgU&list=PL6aekdNhY7DBvSnK0HUUBb-OH4y41HoZw";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (kotlinRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=RfiY8RKhV3U&list=PL6aekdNhY7DB2lhRDfePL6owvAC9hfMv3";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                        if (pascalRadioButton.isSelected())
                        {
                            String url_open ="https://www.youtube.com/watch?v=9T-EVlCfOz8&list=PLF055CFFDFCD5194A";
                            try { Desktop.getDesktop().browse(java.net.URI.create(url_open)); }
                            catch (IOException ex) { throw new RuntimeException(ex); }
                            dispose();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Anulowano rozpoczęcie kursu", "Anulowano kurs", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }
}
