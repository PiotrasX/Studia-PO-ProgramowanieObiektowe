package Lab3.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Objects;

public class Zadanie1 extends JFrame
{
    private JPanel JMainPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JLabel projektKontaktowyLabel;
    private JTextField imieINazwiskoTextField;
    private JTextField emailTextField;
    private JTextField numerTelefonuTextField;
    private JTextField adresZamieszkaniaTextField;
    private JTextField dataUrodzeniaTextField;
    private JButton zapiszNowyButton;
    private JButton zapiszIstniejacyButton;
    private JLabel imieINazwiskoLabel;
    private JLabel emailLabel;
    private JLabel numerTelefonuLabel;
    private JLabel adresZamieszkaniaLabel;
    private JLabel dataUrodzeniaLabel;
    private JLabel wiekField;
    private JLabel editWiekField;
    private JList osobyList;
    private Object[][] dane = new Object[][]
            {{"Piotr Rojek","pr125159@stud.ur.edu.pl","123456789","Nowa 3, 29-421 Rzeszów, Polska","15-06-2003"},
            {"Maksymilian Przypek","mp125155@stud.ur.edu.pl","564654234","Dębowa 95a, 54-345 Sędziszów Małopolski, Polska","14-07-2003"},
            {"Jan Nowak","jannowak@gmail.com","984736097","Rejtana 68, 96-341 Warszawa, Polska","02-12-1995"},
            {"Emilia Żołędziowa","emilia1337@gmail.com","109673458","Partyzantów 316b, 63-098 Dębica, Polska","27-02-1974"}};

    // Imię i nazwisko — wszystko tylko nie null
    // Adres email — wszystko tylko nie null
    // Numer telefonu — wszystko tylko nie null
    // Adres zamieszkania — wszystko tylko nie null
    // Data urodzenia — cyfry w formacie DD-MM-RRRR, data może być nie istniejąca

    public static void main(String[] args)
    {
        Zadanie1 zadanie1GUI = new Zadanie1();
        zadanie1GUI.setVisible(true);
    }

    public Zadanie1()
    {
        super("Projekt kontaktowy");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1025, 750));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        UIManager.put("OptionPane.messageFont", new Font("Fira Code", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(65,30,16));
        UIManager.put("OptionPane.background", new Color(187,230,245));
        UIManager.put("Panel.background", new Color(187,230,245));
        UIManager.put("Button.background", new Color(166,182,0));
        UIManager.put("Button.foreground", new Color(65,30,16));
        UIManager.put("Button.font", new Font("Fira Code", Font.PLAIN, 18));
        imieINazwiskoTextField.setEnabled(true);
        zapiszIstniejacyButton.setEnabled(false);
        zapiszNowyButton.setEnabled(true);
        stworzTabele();

        zapiszNowyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean poprawnosc = czyNiePuste();
                boolean poprawnoscDataUrodzenia = poprawnoscDataUrodzenia();

                if (poprawnosc && poprawnoscDataUrodzenia)
                {
                    String[] daneKontaktowe = uzupelnijDane();
                    dodajDane(daneKontaktowe);
                    JOptionPane.showMessageDialog(null, "Poprawnie dodano nowe dane", "Dodano nowe dane", JOptionPane.INFORMATION_MESSAGE);
                    stworzTabele();
                    setTextLabelNull();
                }
                else if (!poprawnosc) { JOptionPane.showMessageDialog(null, "Uzupełnij puste pola", "Brak wszystkich danych", JOptionPane.WARNING_MESSAGE); }
                else { JOptionPane.showMessageDialog(null, "Uzupełnij poprawnie datę urodzenia w formacie DD-MM-RRRR", "Data urodzenia jest niepoprawna", JOptionPane.WARNING_MESSAGE); }
            }
        });

        zapiszIstniejacyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean poprawnosc = czyNiePuste();
                boolean poprawnoscDataUrodzenia = poprawnoscDataUrodzenia();

                if (poprawnosc && poprawnoscDataUrodzenia)
                {
                    String[] daneKontaktoweNowe = uzupelnijDane();
                    zaktualizujDane(daneKontaktoweNowe);
                    JOptionPane.showMessageDialog(null, "Poprawnie zaktualizowano stare dane", "Zaktualizowano stare dane", JOptionPane.INFORMATION_MESSAGE);
                    stworzTabele();
                    setTextLabelNull();
                    imieINazwiskoTextField.setEnabled(true);
                    zapiszIstniejacyButton.setEnabled(false);
                    zapiszNowyButton.setEnabled(true);
                }
                else if (!poprawnosc) { JOptionPane.showMessageDialog(null, "Uzupełnij puste pola", "Brak wszystkich danych", JOptionPane.WARNING_MESSAGE); }
                else { JOptionPane.showMessageDialog(null, "Uzupełnij poprawnie datę urodzenia w formacie DD-MM-RRRR", "Data urodzenia jest niepoprawna", JOptionPane.WARNING_MESSAGE); }
            }
        });

        osobyList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String imieINazwisko = (String) osobyList.getSelectedValue();
                for (Object[] daneKontaktowe : dane)
                {
                    if (imieINazwisko==daneKontaktowe[0])
                    {
                        imieINazwiskoTextField.setText(imieINazwisko);
                        emailTextField.setText((String) daneKontaktowe[1]);
                        numerTelefonuTextField.setText((String) daneKontaktowe[2]);
                        adresZamieszkaniaTextField.setText((String) daneKontaktowe[3]);
                        dataUrodzeniaTextField.setText((String) daneKontaktowe[4]);

                        LocalDate dzisiejszaData = LocalDate.now();
                        int dzisiejszyRok = dzisiejszaData.getYear();
                        int dataUrodzenia = Integer.parseInt(((String) daneKontaktowe[4]).substring(6,10));
                        editWiekField.setText((dzisiejszyRok-dataUrodzenia) + " lat");
                        break;
                    }
                }

                imieINazwiskoTextField.setEnabled(false);
                zapiszIstniejacyButton.setEnabled(true);
                zapiszNowyButton.setEnabled(false);
            }
        });
    }

    public void setTextLabelNull()
    {
        imieINazwiskoTextField.setText("");
        emailTextField.setText("");
        numerTelefonuTextField.setText("");
        adresZamieszkaniaTextField.setText("");
        dataUrodzeniaTextField.setText("");
        editWiekField.setText("0 lat");
    }

    public boolean czyNiePuste()
    {
        boolean poprawnosc = !Objects.equals(imieINazwiskoTextField.getText(), "");
        if (Objects.equals(emailTextField.getText(),"")) { poprawnosc=false; }
        if (Objects.equals(numerTelefonuTextField.getText(),"")) { poprawnosc=false; }
        if (Objects.equals(adresZamieszkaniaTextField.getText(),"")) { poprawnosc=false; }
        if (Objects.equals(dataUrodzeniaTextField.getText(),"")) { poprawnosc=false; }
        return poprawnosc;
    }

    public boolean poprawnoscDataUrodzenia()
    {
        boolean poprawnosc = true;
        String dataUrodzenia = dataUrodzeniaTextField.getText();
        if (dataUrodzenia.length()!=10) { poprawnosc=false; }
        else
        {
            for (int i=0; i<10; i++)
            {
                if (i==2 || i==5) { if (dataUrodzenia.charAt(i)!='-') { poprawnosc=false; break; } }
                else { if ((int)dataUrodzenia.charAt(i)<48 || (int)dataUrodzenia.charAt(i)>57) { poprawnosc=false; break; } }
            }
        }
        return poprawnosc;
    }

    public String[] uzupelnijDane()
    {
        String[] daneKontaktoweNowe = new String[5];
        daneKontaktoweNowe[0] = imieINazwiskoTextField.getText();
        daneKontaktoweNowe[1] = emailTextField.getText();
        daneKontaktoweNowe[2] = numerTelefonuTextField.getText();
        daneKontaktoweNowe[3] = adresZamieszkaniaTextField.getText();
        daneKontaktoweNowe[4] = dataUrodzeniaTextField.getText();
        return daneKontaktoweNowe;
    }

    private void dodajDane(String[] daneKontaktowe)
    {
        Object[][] daneNowe = new Object[dane.length + 1][];
        System.arraycopy(dane, 0, daneNowe, 0, dane.length);
        daneNowe[dane.length] = daneKontaktowe;
        dane = daneNowe;
    }

    private void zaktualizujDane(String[] daneKontaktoweNowe)
    {
        for (int i=0; i<dane.length; i++)
        {
            if (Objects.equals(dane[i][0], daneKontaktoweNowe[0]))
            {
                dane[i][1] = daneKontaktoweNowe[1];
                dane[i][2] = daneKontaktoweNowe[2];
                dane[i][3] = daneKontaktoweNowe[3];
                dane[i][4] = daneKontaktoweNowe[4];
                break;
            }
        }
    }

    private void stworzTabele()
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Object[] objects : dane) { listModel.addElement((String) objects[0]); }
        osobyList.setModel(listModel);
    }
}
