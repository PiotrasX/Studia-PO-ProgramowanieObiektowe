package Projekt.PlikiJava;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static Projekt.PlikiJava.PanelBazaSamochodow.*;
import static Projekt.PlikiJava.Pojazd.pojazdyList;
import static Projekt.PlikiJava.Pojazd.pojazdyListWyswietlTabela;

public class PojazdDodajEdycja extends BazoweFrame
{
    private JPanel JMainPanel;
    private JLabel labelTytul;
    private JButton buttonPowrot;
    private JButton buttonZapisz;
    private JTextField textFieldCena;
    private JLabel labelDodatkoweInformacje;
    private JLabel labelDodatkowa1;
    private JLabel labelDodatkowa2;
    private JLabel labelDodatkowa3;
    private JSpinner spinnerDodatkowa1;
    private JSpinner spinnerDodatkowa2;
    private JSpinner spinnerDodatkowa3;
    private JLabel labelRodzaj;
    private JLabel labelNadwozie;
    private JLabel labelMarka;
    private JLabel labelModel;
    private JLabel labelKolor;
    private JLabel labelCena;
    private JLabel labelMocSil;
    private JLabel labelWaga;
    private JLabel labelRokProdkucji;
    private JLabel labelMaksPredkosc;
    private JLabel labelPojSil;
    private JLabel labelLiczbaMiejsc;
    private JSpinner spinnerPojSil;
    private JSpinner spinnerMocSil;
    private JSpinner spinnerWaga;
    private JSpinner spinnerRokProdukcji;
    private JSpinner spinnerMaksPredkosc;
    private JSpinner spinnerLiczbaMiejsc;
    private JComboBox comboBoxRodzaj;
    private JComboBox comboBoxMarka;
    private JComboBox comboBoxNadwozie;
    private JComboBox comboBoxKolor;
    private JTextField textFieldModel;
    private JLabel labelPrzebieg;
    private JTextField textFieldPrzebieg;
    private String jakaCzynnosc;
    private String nazwaUzytkownika;
    private boolean admin;
    private Object[] staryObiekt;
    private static final ImageIcon loginBackgroundImage = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\login_background_image.png")));
    private static final ImageIcon car = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\car.png")));

    private final ArrayList<JSpinner> jSpinnerList = new ArrayList<>(Arrays.asList(
            spinnerPojSil, spinnerMocSil, spinnerWaga, spinnerRokProdukcji, spinnerMaksPredkosc, spinnerLiczbaMiejsc));

    public PojazdDodajEdycja(String title, String jakaCzynnosc, boolean admin, String nazwaUzytkownika, Object[] pojazd)
    {
        super(title, loginBackgroundImage, car, 1200, 800);
        JLayeredPane layeredPane = BazoweFrame.returnLayeredPane();
        JMainPanel.setBounds(0, 0, 1200, 800);
        layeredPane.add(JMainPanel, Integer.valueOf(0));
        actionComponent(jakaCzynnosc, admin, nazwaUzytkownika, pojazd);
        actionListener();
    }

    private void zamknijOkno()
    {
        PanelBazaSamochodow panelBazaSamochodowGUI = new PanelBazaSamochodow(admin, nazwaUzytkownika);
        panelBazaSamochodowGUI.setVisible(true);
        dispose();
    }

    private void actionListener()
    {
        buttonPowrot.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tekst = "Czy na pewno chcesz zakończyć";
                if (jakaCzynnosc.equals("dodawanie")) tekst += " dodawanie nowego pojazdu?";
                else tekst += " edycję pojazdu?";
                int result = JOptionPane.showConfirmDialog(null, tekst, "Potwierdzenie wyjścia", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) zamknijOkno();
            }
        });

        buttonZapisz.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object[] niepelnyObiekt = stworzObject();
                Object[] nowyObject = getObject(niepelnyObiekt);

                if (jakaCzynnosc.equals("dodawanie"))
                {
                    for (Object[] pojazd : pojazdyListWyswietlTabela)
                    {
                        boolean bool = porownajPojazdPojazd(pojazd, nowyObject);
                        if (bool)
                        {
                            JOptionPane.showMessageDialog(null, "Taki pojazd już istnieje w bazie danych", "Błąd danych", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    Pojazd pojazdDoDodania = stworzPojazd(nowyObject);
                    pojazdyList.add(pojazdDoDodania);
                    pojazdyListWyswietlTabela.add(nowyObject);

                    JOptionPane.showMessageDialog(null, "Poprawnie dodano pojazd do bazy danych", "Dodano pojazd", JOptionPane.INFORMATION_MESSAGE);
                    zamknijOkno();
                }
                else
                {
                    for (Object[] pojazd : pojazdyListWyswietlTabela)
                    {
                        boolean bool = porownajPojazdPojazd(pojazd, staryObiekt);
                        if (bool)
                        {
                            Pojazd staryPojazd = stworzPojazd(pojazd);
                            Pojazd nowyPojazd = stworzPojazd(nowyObject);
                            pojazdyList.set(pojazdyList.indexOf(staryPojazd), nowyPojazd);
                            pojazdyListWyswietlTabela.set(pojazdyListWyswietlTabela.indexOf(pojazd), nowyObject);

                            JOptionPane.showMessageDialog(null, "Poprawnie edytowano pojazd w bazie danych", "Edytowano pojazd", JOptionPane.INFORMATION_MESSAGE);
                            zamknijOkno();
                        }
                    }
                }
            }

            private Object[] getObject(Object[] staryObject)
            {
                Object[] nowyObject = new Object[0];
                if (staryObject[0].equals("Samochod_Osobowy") || staryObject[0].equals("Ciagnik_Rolniczy"))
                    nowyObject = new Object[]{staryObject[0], staryObject[1], staryObject[2], staryObject[3],
                            staryObject[4], staryObject[5], staryObject[6], staryObject[7], staryObject[8],
                            staryObject[9], staryObject[10], staryObject[11], staryObject[12],
                            ((Number) spinnerDodatkowa1.getValue()).intValue(),
                            ((Number) spinnerDodatkowa2.getValue()).intValue()};
                else if (staryObject[0].equals("Samochod_Ciezarowy") || staryObject[0].equals("Autobus"))
                    nowyObject = new Object[]{staryObject[0], staryObject[1], staryObject[2], staryObject[3],
                            staryObject[4], staryObject[5], staryObject[6], staryObject[7], staryObject[8],
                            staryObject[9], staryObject[10], staryObject[11], staryObject[12],
                            ((Number) spinnerDodatkowa1.getValue()).intValue(),
                            ((Number) spinnerDodatkowa2.getValue()).intValue(),
                            ((Number) spinnerDodatkowa3.getValue()).intValue()};
                else if (staryObject[0].equals("Motocykl"))
                    nowyObject = new Object[]{staryObject[0], staryObject[1], staryObject[2], staryObject[3],
                            staryObject[4], staryObject[5], staryObject[6], staryObject[7], staryObject[8],
                            staryObject[9], staryObject[10], staryObject[11], staryObject[12],
                            ((Number) spinnerDodatkowa1.getValue()).intValue()};
                return nowyObject;
            }
        });

        comboBoxRodzaj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String) comboBoxRodzaj.getSelectedItem();
                assert selectedItem != null;
                switch (selectedItem)
                {
                    case "Samochód osobowy" -> pojazdSamochodOsobowy();
                    case "Samochód ciężarowy" -> pojazdSamochodCiezarowy();
                    case "Ciągnik rolniczy" -> pojazdCiagnikRol();
                    case "Autobus" -> pojazdAutobus();
                    case "Motocykl" -> pojazdMotocykl();
                }
                JMainPanel.revalidate();
                JMainPanel.repaint();
            }
        });
    }

    private Object[] stworzObject()
    {
        Object[] objects = new Object[13];
        objects[0] = renameRodzajBaza((String) Objects.requireNonNull(comboBoxRodzaj.getSelectedItem()));
        objects[1] = renameNadwozieBaza((String) Objects.requireNonNull(comboBoxNadwozie.getSelectedItem()));
        objects[2] = comboBoxMarka.getSelectedItem();
        objects[3] = textFieldModel.getText();
        objects[4] = renameKolorBaza((String) Objects.requireNonNull(comboBoxKolor.getSelectedItem()));
        objects[5] = ((Number) spinnerPojSil.getValue()).doubleValue();
        objects[6] = ((Number) spinnerMocSil.getValue()).intValue();
        objects[7] = ((Number) spinnerWaga.getValue()).doubleValue();
        objects[8] = ((Number) spinnerRokProdukcji.getValue()).intValue();
        objects[9] = Integer.parseInt(textFieldPrzebieg.getText());
        objects[10] = Integer.parseInt(textFieldCena.getText());
        objects[11] = ((Number) spinnerMaksPredkosc.getValue()).intValue();
        objects[12] = ((Number) spinnerLiczbaMiejsc.getValue()).intValue();
        return objects;
    }

    private void actionComponent(String jakaCzynnosc, boolean admin, String nazwaUzytkownika, Object[] pojazd)
    {
        this.jakaCzynnosc = jakaCzynnosc;
        this.admin = admin;
        this.nazwaUzytkownika = nazwaUzytkownika;

        ArrayList<JComboBox> jComboBoxList = new ArrayList<>(Arrays.asList(comboBoxNadwozie, comboBoxMarka, comboBoxRodzaj, comboBoxKolor));
        spinnerComboBoxCreateComponent(comboBoxKolor, comboBoxMarka, comboBoxNadwozie, jComboBoxList, jSpinnerList);

        textFieldInicjalizacja();
        wartosciDanychInicjalizacja(pojazd);
        staryObiekt = stworzObject();
    }

    private void textFieldInicjalizacja()
    {
        textFieldModel.setText("?");
        textFieldModel.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) { validateTextFieldModel(textFieldModel); }
        });
        textFieldModel.setMargin(new Insets(3, 10, 3, 0));
        ArrayList<JTextField> jTextFieldList = new ArrayList<>(Arrays.asList(textFieldCena, textFieldPrzebieg));
        for (JTextField textField : jTextFieldList)
            textFieldCreateComponent(textField);

        textFieldPrzebieg.setText("100000");
        textFieldPrzebieg.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) { validateTextFieldValue(textFieldPrzebieg, 0, 999900); }
        });
        textFieldCena.setText("15000");
        textFieldCena.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) { validateTextFieldValue(textFieldCena, 1000, 1999990); }
        });
    }

    private void wartosciDanychInicjalizacja(Object[] pojazd)
    {
        pojazdSamochodOsobowy();
        if (jakaCzynnosc.equals("dodawanie")) labelTytul.setText("Dodawanie nowego pojazdu");
        else
        {
            labelTytul.setText("Edycja pojazdu");

            String rodzaj = renameRodzajPolski((String) pojazd[0]);
            comboBoxRodzaj.setSelectedItem(rodzaj);
            comboBoxMarka.setSelectedItem(pojazd[2]);
            textFieldModel.setText((String) pojazd[3]);
            comboBoxKolor.setSelectedItem(renameKolorPolski((String) pojazd[4]));
            textFieldPrzebieg.setText(String.valueOf(pojazd[9]));
            textFieldCena.setText(String.valueOf(pojazd[10]));
            spinnerPojSil.setValue(pojazd[5]);
            spinnerMocSil.setValue(pojazd[6]);
            spinnerWaga.setValue(pojazd[7]);
            spinnerRokProdukcji.setValue(pojazd[8]);
            spinnerMaksPredkosc.setValue(pojazd[11]);
            spinnerLiczbaMiejsc.setValue(pojazd[12]);

            switch (rodzaj)
            {
                case "Samochód osobowy" ->
                {
                    pojazdSamochodOsobowy();
                    spinnerDodatkowa2.setValue(pojazd[14]);
                }
                case "Samochód ciężarowy" ->
                {
                    pojazdSamochodCiezarowy();
                    spinnerDodatkowa2.setValue(pojazd[14]);
                    spinnerDodatkowa3.setValue(pojazd[15]);
                }
                case "Ciągnik rolniczy" ->
                {
                    pojazdCiagnikRol();
                    spinnerDodatkowa2.setValue(pojazd[14]);
                }
                case "Autobus" ->
                {
                    pojazdAutobus();
                    spinnerDodatkowa2.setValue(pojazd[14]);
                    spinnerDodatkowa3.setValue(pojazd[15]);
                }
                case "Motocykl" -> pojazdMotocykl();
            }
            comboBoxNadwozie.setSelectedItem(renameNadwoziePolski((String) pojazd[1]));
            spinnerDodatkowa1.setValue(pojazd[13]);

            comboBoxRodzaj.setEnabled(false);
            comboBoxRodzaj.setBackground(Color.gray);
            UIManager.put("ComboBox.disabledBackground", Color.gray);
            UIManager.put("ComboBox.disabledForeground", new Color(110, 5, 0));

            JMainPanel.revalidate();
            JMainPanel.repaint();
        }
    }

    private void pojazdSamochodOsobowy()
    {
        comboBoxNadwozie.removeAllItems();
        for (NadwozieOsobowy nadwozie : NadwozieOsobowy.values())
            comboBoxNadwozie.addItem(nadwozie.name());

        labelDodatkowa1.setText("Liczba drzwi: ");
        customizeSpinner(spinnerDodatkowa1, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa1.getName());
        labelDodatkowa2.setText("Pojemność bagażnika (l): ");
        customizeSpinner(spinnerDodatkowa2, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa2.getName());
        labelDodatkowa3.setText("");
        customizeSpinner(spinnerDodatkowa3, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa3.getName());
    }

    private void pojazdSamochodCiezarowy()
    {
        comboBoxNadwozie.removeAllItems();
        for (NadwozieCiezarowy nadwozie : NadwozieCiezarowy.values())
        {
            if (nadwozie.name().equals("LekkaCiezarowka")) { comboBoxNadwozie.addItem("Lekka ciężarówka"); continue; }
            if (nadwozie.name().equals("CiezkaCiezarowka")) { comboBoxNadwozie.addItem("Ciężka ciężarówka"); continue; }
            comboBoxNadwozie.addItem(nadwozie.name());
        }

        labelDodatkowa1.setText("Liczba drzwi: ");
        customizeSpinner(spinnerDodatkowa1, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa1.getName());
        labelDodatkowa2.setText("Ładowność (l): ");
        customizeSpinner(spinnerDodatkowa2, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa2.getName());
        labelDodatkowa3.setText("Liczba kół: ");
        customizeSpinner(spinnerDodatkowa3, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa3.getName());
    }

    private void pojazdAutobus()
    {
        comboBoxNadwozie.removeAllItems();
        for (NadwozieAutobus nadwozie : NadwozieAutobus.values())
        {
            if (nadwozie.name().equals("Pietrowe")) { comboBoxNadwozie.addItem("Piętrowe"); continue; }
            comboBoxNadwozie.addItem(nadwozie.name());
        }

        labelDodatkowa1.setText("Liczba drzwi: ");
        customizeSpinner(spinnerDodatkowa1, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa1.getName());
        labelDodatkowa2.setText("Pojemność bagażnika (l): ");
        customizeSpinner(spinnerDodatkowa2, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa2.getName());
        labelDodatkowa3.setText("Liczba kół: ");
        customizeSpinner(spinnerDodatkowa3, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa3.getName());
    }

    private void pojazdCiagnikRol()
    {
        comboBoxNadwozie.removeAllItems();
        for (NadwozieCiagnikRol nadwozie : NadwozieCiagnikRol.values())
        {
            if (nadwozie.name().equals("Kolowe")) { comboBoxNadwozie.addItem("Kołowe"); continue; }
            if (nadwozie.name().equals("Gasienicowe")) { comboBoxNadwozie.addItem("Gąsienicowe"); continue; }
            comboBoxNadwozie.addItem(nadwozie.name());
        }

        labelDodatkowa1.setText("Liczba drzwi: ");
        customizeSpinner(spinnerDodatkowa1, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa1.getName());
        labelDodatkowa2.setText("Maksymalna masa ciągnięcia (kg): ");
        customizeSpinner(spinnerDodatkowa2, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa2.getName());
        labelDodatkowa3.setText("");
        customizeSpinner(spinnerDodatkowa3, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa3.getName());
    }

    private void pojazdMotocykl()
    {
        comboBoxNadwozie.removeAllItems();
        for (NadwozieMotocykl nadwozie : NadwozieMotocykl.values())
            comboBoxNadwozie.addItem(nadwozie.name());

        labelDodatkowa1.setText("Liczba kół: ");
        customizeSpinner(spinnerDodatkowa1, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa1.getName());
        labelDodatkowa2.setText("");
        customizeSpinner(spinnerDodatkowa2, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa2.getName());
        labelDodatkowa3.setText("");
        customizeSpinner(spinnerDodatkowa3, new Color(31, 36, 65), new Color(255, 255, 255), spinnerDodatkowa3.getName());
    }

    private void spinnerComboBoxCreateComponent(JComboBox comboBoxKolor, JComboBox comboBoxMarka,
                                                JComboBox comboBoxNadwozie, ArrayList<JComboBox> jComboBoxList,
                                                ArrayList<JSpinner> jSpinnerList)
    {
        for (Kolor kolor : Kolor.values())
        {
            String kolorTekst = getKolorString(kolor);
            comboBoxKolor.addItem(kolorTekst);
        }

        for (Marka marka : Marka.values())
            comboBoxMarka.addItem(marka.name());

        for (NadwozieOsobowy nadwozie : NadwozieOsobowy.values())
            comboBoxNadwozie.addItem(nadwozie.name());

        for (JComboBox comboBox : jComboBoxList)
        {
            comboBox.setRenderer(new DefaultListCellRenderer()
            {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
                {
                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    label.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 0));
                    return label;
                }
            });
        }

        for (JSpinner spinner : jSpinnerList)
            customizeSpinner(spinner, new Color(31, 36, 65), new Color(255, 255, 255), spinner.getName());
    }

    private String getKolorString(Kolor kolor)
    {
        String kolorTekst = String.valueOf(kolor);
        switch (kolorTekst)
        {
            case "Bialy" -> kolorTekst = "Biały";
            case "Zolty" -> kolorTekst = "Żółty";
            case "Zloty" -> kolorTekst = "Złoty";
            case "Rozowy" -> kolorTekst = "Różowy";
            case "Bezowy" -> kolorTekst = "Beżowy";
            case "Brazowy" -> kolorTekst = "Brązowy";
            case "Pomaranczowy" -> kolorTekst = "Pomarańczowy";
        }
        return kolorTekst;
    }

    private void textFieldCreateComponent(JTextField textField)
    {
        textField.setMargin(new Insets(3, 10, 3, 0));

        DocumentFilter filter = new DocumentFilter()
        {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException
            {
                if (text.matches("[0-9]+"))
                    super.insertString(fb, offset, text, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
            {
                if (text.matches("[0-9]+"))
                    super.replace(fb, offset, length, text, attrs);
            }
        };
        ((PlainDocument) textField.getDocument()).setDocumentFilter(filter);
    }

    private void customizeSpinner(JSpinner spinner, Color backgroundColor, Color foregroundColor, String nazwaSpinner)
    {
        spinner.setUI(new BasicSpinnerUI()
        {
            protected Component createNextButton()
            {
                BasicArrowButton button = (BasicArrowButton) super.createNextButton();
                button.setBackground(backgroundColor);
                button.setForeground(foregroundColor);
                button.addActionListener(new ActionListener()
                    { public void actionPerformed(ActionEvent e) { validateSpinnerValue(spinner); } });
                return button;
            }

            protected Component createPreviousButton()
            {
                BasicArrowButton button = (BasicArrowButton) super.createPreviousButton();
                button.setBackground(backgroundColor);
                button.setForeground(foregroundColor);
                button.addActionListener(new ActionListener()
                    { public void actionPerformed(ActionEvent e) { validateSpinnerValue(spinner); } });
                return button;
            }
        });

        if (!nazwaSpinner.equals("spinnerDodatkowa1") && !nazwaSpinner.equals("spinnerDodatkowa2") && !nazwaSpinner.equals("spinnerDodatkowa3"))
            nazwySpinnerPojazdDodajEdycja(spinner, nazwaSpinner);
        else nazwySpinnerDodatkowa(spinner, nazwaSpinner);

        JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) spinner.getEditor();
        JTextField textField = defaultEditor.getTextField();
        textField.setBorder(new EmptyBorder(2, 6, 2, 6));
        textField.setBackground(backgroundColor);
        textField.setForeground(foregroundColor);
        textField.setFont(new Font("Fira Code", Font.PLAIN, 22));
        textField.addFocusListener(new FocusAdapter()
            { public void focusLost(FocusEvent e) { validateSpinnerValue(spinner); } });
    }

    private void nazwySpinnerPojazdDodajEdycja(JSpinner spinner, String nazwaSpinner)
    {
        // SpinnerModel value = new SpinnerNumberModel(Początkowa wartość, Minimalna wartość, Maksymalna wartość, Krok);
        switch (nazwaSpinner)
        {
            case "spinnerPojSil" ->
            {
                spinner.setModel(new SpinnerNumberModel(1.5, 0.5, 19.9, 0.1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.0"));
                spinner.setValue(1.5);
            }
            case "spinnerMocSil" ->
            {
                spinner.setModel(new SpinnerNumberModel(150, 50, 1500, 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(150);
            }
            case "spinnerWaga" ->
            {
                spinner.setModel(new SpinnerNumberModel(2.000, 0.100, 29.995, 0.005));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.000"));
                spinner.setValue(2.000);
            }
            case "spinnerRokProdukcji" ->
            {
                spinner.setModel(new SpinnerNumberModel(2015, 1970, LocalDate.now().getYear(), 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(2015);
            }
            case "spinnerMaksPredkosc" ->
            {
                spinner.setModel(new SpinnerNumberModel(150, 10, 499, 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(150);
            }
            case "spinnerLiczbaMiejsc" ->
            {
                spinner.setModel(new SpinnerNumberModel(5, 1, 99, 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(5);
            }
        }
    }

    private void nazwySpinnerDodatkowa(JSpinner spinner, String nazwaSpinner)
    {
        // SpinnerModel value = new SpinnerNumberModel(Początkowa wartość, Minimalna wartość, Maksymalna wartość, Krok);
        String selectedItem = (String) comboBoxRodzaj.getSelectedItem();
        assert selectedItem != null;
        switch (selectedItem) {
            case "Samochód osobowy" ->
            {
                switch (nazwaSpinner)
                {
                    case "spinnerDodatkowa1" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(5, 1, 7, 1));
                        spinner.setValue(5);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa2" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(350, 0, 9999, 1));
                        spinner.setValue(350);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa3" -> spinner.setVisible(false);
                }
            }
            case "Samochód ciężarowy" ->
            {
                switch (nazwaSpinner)
                {
                    case "spinnerDodatkowa1" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(2, 1, 9, 1));
                        spinner.setValue(2);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa2" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(1300, 0, 99999, 1));
                        spinner.setValue(1300);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa3" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(4, 2, 12, 2));
                        spinner.setValue(4);
                        setSpinnerEditorSizeVisible(spinner);
                        setSpinnerParzysteWartosci(spinner);
                    }
                }
            }
            case "Autobus" ->
            {
                switch (nazwaSpinner)
                {
                    case "spinnerDodatkowa1" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(3, 1, 9, 1));
                        spinner.setValue(3);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa2" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(1100, 0, 99999, 1));
                        spinner.setValue(1100);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa3" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(4, 2, 12, 2));
                        spinner.setValue(4);
                        setSpinnerEditorSizeVisible(spinner);
                        setSpinnerParzysteWartosci(spinner);
                    }
                }
            }
            case "Ciągnik rolniczy" ->
            {
                switch (nazwaSpinner)
                {
                    case "spinnerDodatkowa1" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(2, 1, 5, 1));
                        spinner.setValue(2);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa2" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(2500, 0, 49999, 1));
                        spinner.setValue(2500);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa3" -> spinner.setVisible(false);
                }
            }
            case "Motocykl" ->
            {
                switch (nazwaSpinner)
                {
                    case "spinnerDodatkowa1" ->
                    {
                        spinner.setModel(new SpinnerNumberModel(2, 2, 3, 1));
                        spinner.setValue(2);
                        setSpinnerEditorSizeVisible(spinner);
                    }
                    case "spinnerDodatkowa2", "spinnerDodatkowa3" -> spinner.setVisible(false);
                }
            }
        }
    }

    private void setSpinnerEditorSizeVisible(JSpinner spinner)
    {
        spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
        spinner.setSize(new Dimension(150, 39));
        spinner.setVisible(true);
    }

    private void setSpinnerParzysteWartosci(JSpinner spinner)
    {
        spinner.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                int value = (Integer) spinner.getValue();
                if (value % 2 != 0) spinner.setValue(value + 1);
            }
        });
    }

    private void validateTextFieldValue(JTextField textField, int minWartosc, int maxWartosc)
    {
        String textFieldWartosc = textField.getText();
        try
        {
            int wartosc = Integer.parseInt(textFieldWartosc);
            if (wartosc < minWartosc)
                textField.setText(String.valueOf(minWartosc));
            else if (wartosc > maxWartosc)
                textField.setText(String.valueOf(maxWartosc));
            else textField.setText(String.valueOf(wartosc));
        }
        catch (NumberFormatException e)
        {
            if (textFieldWartosc.isEmpty()) textField.setText(String.valueOf(minWartosc));
            else textField.setText(String.valueOf(maxWartosc));
        }
    }

    private void validateTextFieldModel(JTextField textField)
    {
        String textFieldWartosc = textField.getText();
        if (textFieldWartosc.isEmpty()) textField.setText("?");
        else if (textFieldWartosc.length() > 15) textField.setText(textFieldWartosc.substring(0, 15));
        else textField.setText(textFieldWartosc);
    }
}
