package Projekt.PlikiJava;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

import static Projekt.PlikiJava.Pojazd.pojazdyList;
import static Projekt.PlikiJava.Pojazd.pojazdyListWyswietlTabela;

public class PanelBazaSamochodow extends BazoweFrame
{
    private JPanel JMainPanel;
    private JLabel labelUzytkownik;
    private JButton buttonWyloguj;
    private JButton labelUsunPojazd;
    private JButton labelEdytujPojazd;
    private JButton labelDodajPojazd;
    private JPanel adminPanel;
    private JComboBox comboBoxRodzaj;
    private JComboBox comboBoxMarka;
    private JComboBox comboBoxNadwozie;
    private JLabel labelRodzaj;
    private JLabel labelNadwozie;
    private JLabel labelMarka;
    private JLabel labelKolor;
    private JComboBox comboBoxKolor;
    private JCheckBox checkBoxRodzaj;
    private JCheckBox checkBoxNadwozie;
    private JCheckBox checkBoxMarka;
    private JCheckBox checkBoxKolor;
    private JLabel labelPojemnoscSilnika;
    private JSpinner spinnerPojSilMin;
    private JSpinner spinnerPojSilMax;
    private JCheckBox checkBoxPojSilMin;
    private JCheckBox checkBoxPojSilMax;
    private JLabel labelPojSIlMax;
    private JLabel labelPojSilMin;
    private JLabel labelMocSilnika;
    private JLabel labelMocSilMin;
    private JLabel labelMocSilMax;
    private JSpinner spinnerMocSilMin;
    private JSpinner spinnerMocSilMax;
    private JCheckBox checkBoxMocSilMin;
    private JCheckBox checkBoxMocSilMax;
    private JSlider sliderMaksPredkosc;
    private JCheckBox checkBoxMaksPredkosc;
    private JLabel labelMaksymalnaPredkosc;
    private JLabel labelWaga;
    private JLabel labelWagaMin;
    private JLabel labelWagaMax;
    private JSpinner spinnerWagaMin;
    private JSpinner spinnerWagaMax;
    private JCheckBox checkBoxWagaMin;
    private JCheckBox checkBoxWagaMax;
    private JLabel labelRokProdukcji;
    private JLabel labelRokProdukcjiMin;
    private JLabel labelRokProdukcjiMax;
    private JSpinner spinnerRokProdukcjiMin;
    private JSpinner spinnerRokProdukcjiMax;
    private JCheckBox checkBoxRokProdukcjiMin;
    private JCheckBox checkBoxRokProdukcjiMax;
    private JLabel labelPrzebieg;
    private JLabel labelPrzebiegMin;
    private JLabel labelPrzebiegMax;
    private JSpinner spinnerPrzebiegMin;
    private JSpinner spinnerPrzebiegMax;
    private JCheckBox checkBoxPrzebiegMin;
    private JCheckBox checkBoxPrzebiegMax;
    private JLabel labelCena;
    private JLabel labelCenaMin;
    private JLabel labelCenaMax;
    private JSpinner spinnerCenaMin;
    private JSpinner spinnerCenaMax;
    private JCheckBox checkBoxCenaMin;
    private JCheckBox checkBoxCenaMax;
    private JLabel labelFiltrowanie;
    private JButton buttonFiltruj;
    private JTable tablePojazdy;
    private JScrollPane scrollPane;
    private JButton buttonNull;
    private String nazwaUzytkownika;
    private boolean admin;
    private static final ImageIcon loginBackgroundImage = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\login_background_image.png")));
    private static final ImageIcon car = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\car.png")));
    private static final ImageIcon checkBoxIconSelected = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\check_box_selected.png")));
    private static final ImageIcon checkBoxIconNoSelected = new ImageIcon(Objects.requireNonNull(Login.class.getResource("PlikiDoProjektu\\check_box_no_selected.png")));
    public static final Map<Integer, Boolean> sortTableMap = new HashMap<>();
    private final ArrayList<JCheckBox> jCheckBoxList = new ArrayList<>(Arrays.asList(checkBoxRodzaj,
            checkBoxNadwozie, checkBoxMarka, checkBoxKolor, checkBoxPojSilMin, checkBoxPojSilMax, checkBoxMocSilMin,
            checkBoxMocSilMax, checkBoxWagaMin, checkBoxWagaMax, checkBoxRokProdukcjiMin, checkBoxRokProdukcjiMax,
            checkBoxPrzebiegMin, checkBoxPrzebiegMax, checkBoxCenaMin, checkBoxCenaMax, checkBoxMaksPredkosc));
    private final ArrayList<JSpinner> jSpinnerList = new ArrayList<>(Arrays.asList(
            spinnerPojSilMin, spinnerPojSilMax, spinnerMocSilMin, spinnerMocSilMax,
            spinnerWagaMin, spinnerWagaMax, spinnerRokProdukcjiMin, spinnerRokProdukcjiMax,
            spinnerPrzebiegMin, spinnerPrzebiegMax, spinnerCenaMin, spinnerCenaMax));
    private final ArrayList<Object[]> jCheckBoxWartosciList = new ArrayList<>(Arrays.asList(
            new Object[] {comboBoxRodzaj, checkBoxRodzaj}, new Object[] {comboBoxNadwozie, checkBoxNadwozie},
            new Object[] {comboBoxMarka, checkBoxMarka}, new Object[] {comboBoxKolor, checkBoxKolor},
            new Object[] {spinnerPojSilMin, checkBoxPojSilMin}, new Object[] {spinnerPojSilMax, checkBoxPojSilMax},
            new Object[] {spinnerMocSilMin, checkBoxMocSilMin}, new Object[] {spinnerMocSilMax, checkBoxMocSilMax},
            new Object[] {spinnerWagaMin, checkBoxWagaMin}, new Object[] {spinnerWagaMax, checkBoxWagaMax},
            new Object[] {spinnerRokProdukcjiMin, checkBoxRokProdukcjiMin}, new Object[] {spinnerRokProdukcjiMax, checkBoxRokProdukcjiMax},
            new Object[] {spinnerPrzebiegMin, checkBoxPrzebiegMin}, new Object[] {spinnerPrzebiegMax, checkBoxPrzebiegMax},
            new Object[] {spinnerCenaMin, checkBoxCenaMin}, new Object[] {spinnerCenaMax, checkBoxCenaMax},
            new Object[] {sliderMaksPredkosc, checkBoxMaksPredkosc}));
    private static final ArrayList<Object[]> jCheckBoxBoolList = new ArrayList<>();

    public PanelBazaSamochodow(boolean admin, String nazwaUzytkownika)
    {
        super("Baza danych samochodów", loginBackgroundImage, car, 1800, 1000);
        JLayeredPane layeredPane = BazoweFrame.returnLayeredPane();
        JMainPanel.setBounds(0, 0, 1800, 1000);
        layeredPane.add(JMainPanel, Integer.valueOf(0));
        createTable();
        actionListener();
        actionComponent(admin, nazwaUzytkownika);
    }

    private void actionListener()
    {
        buttonWyloguj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wylogować się z programu?", "Potwierdzenie wyjścia", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                {
                    Login loginGUI = new Login();
                    loginGUI.setVisible(true);
                    dispose();
                }
            }
        });

        buttonFiltruj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pojazdyListWyswietlTabela.clear();
                pojazdyList.forEach(pojazd -> pojazdyListWyswietlTabela.add(pojazd.zwrocPojazd()));

                if (checkBoxRodzaj.isSelected())
                {
                    String rodzaj = renameRodzajBaza((String) Objects.requireNonNull(comboBoxRodzaj.getSelectedItem()));
                    pojazdyListWyswietlTabela.removeIf(pojazd -> !pojazd[0].toString().equals(rodzaj));
                }
                if (checkBoxNadwozie.isSelected())
                {
                    String nadwozie = renameNadwozieBaza((String) Objects.requireNonNull(comboBoxNadwozie.getSelectedItem()));
                    pojazdyListWyswietlTabela.removeIf(pojazd -> !pojazd[1].toString().equals(nadwozie));
                }
                if (checkBoxMarka.isSelected())
                {
                    String marka = (String) comboBoxMarka.getSelectedItem();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> !pojazd[2].toString().equals(marka));
                }
                if (checkBoxKolor.isSelected())
                {
                    String kolor = renameKolorBaza((String) Objects.requireNonNull(comboBoxKolor.getSelectedItem()));
                    pojazdyListWyswietlTabela.removeIf(pojazd -> !pojazd[4].toString().equals(kolor));
                }
                if (checkBoxPojSilMin.isSelected())
                {
                    double pojSilMin = ((Number) spinnerPojSilMin.getValue()).doubleValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (double) pojazd[5] < pojSilMin);
                }
                if (checkBoxPojSilMax.isSelected())
                {
                    double pojSilMax = ((Number) spinnerPojSilMax.getValue()).doubleValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (double) pojazd[5] > pojSilMax);
                }
                if (checkBoxMocSilMin.isSelected())
                {
                    int mocSilMin = ((Number) spinnerMocSilMin.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[6] < mocSilMin);
                }
                if (checkBoxMocSilMax.isSelected())
                {
                    int mocSilMax = ((Number) spinnerMocSilMax.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[6] > mocSilMax);
                }
                if (checkBoxWagaMin.isSelected())
                {
                    double mocWagaMin = ((Number) spinnerWagaMin.getValue()).doubleValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (double) pojazd[7] < mocWagaMin);
                }
                if (checkBoxWagaMax.isSelected())
                {
                    double mocWagaMax = ((Number) spinnerWagaMax.getValue()).doubleValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (double) pojazd[7] > mocWagaMax);
                }
                if (checkBoxRokProdukcjiMin.isSelected())
                {
                    int rokProdukcjiMin = ((Number) spinnerRokProdukcjiMin.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[8] < rokProdukcjiMin);
                }
                if (checkBoxRokProdukcjiMax.isSelected())
                {
                    int rokProdukcjiMax = ((Number) spinnerRokProdukcjiMax.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[8] > rokProdukcjiMax);
                }
                if (checkBoxPrzebiegMin.isSelected())
                {
                    int przebiegMin = ((Number) spinnerPrzebiegMin.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[9] < przebiegMin);
                }
                if (checkBoxPrzebiegMax.isSelected())
                {
                    int przebiegMax = ((Number) spinnerPrzebiegMax.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[9] > przebiegMax);
                }
                if (checkBoxCenaMin.isSelected())
                {
                    int cenaMin = ((Number) spinnerCenaMin.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[10] < cenaMin);
                }
                if (checkBoxCenaMax.isSelected())
                {
                    int cenaMax = ((Number) spinnerCenaMax.getValue()).intValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[10] > cenaMax);
                }
                if (checkBoxMaksPredkosc.isSelected())
                {
                    int maksPredkosc = sliderMaksPredkosc.getValue();
                    pojazdyListWyswietlTabela.removeIf(pojazd -> (int) pojazd[11] > maksPredkosc);
                }

                setTableModel();
                setTableModel();
            }
        });

        labelDodajPojazd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                wartosciCheckBoxNapisz();
                PojazdDodajEdycja pojazdDodajEdycjaGUI = new PojazdDodajEdycja("Panel dodawania nowego pojazdu", "dodawanie", admin, nazwaUzytkownika, null);
                pojazdDodajEdycjaGUI.setVisible(true);
                dispose();
            }
        });

        labelEdytujPojazd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int[] wybraneWiersze = tablePojazdy.getSelectedRows();
                int wiersze = wybraneWiersze.length;
                if (wiersze == 0)
                    JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnych danych do edytowania\nZaznacz jeden wiersz tabeli", "Brak zaznaczonych danych", JOptionPane.WARNING_MESSAGE);
                else if (wiersze > 1)
                    JOptionPane.showMessageDialog(null, "Zaznaczono za dużo danych do edytowania\nZaznacz jeden wiersz tabeli", "Za dużo zaznaczonych danych", JOptionPane.WARNING_MESSAGE);
                else
                {
                    Object[] objects = stworzObjectTable(wybraneWiersze[0]);
                    for (Object[] pojazd : pojazdyListWyswietlTabela)
                    {
                        boolean bool = porownajPojazdPojazd(pojazd, objects);
                        if (bool)
                        {
                            wartosciCheckBoxNapisz();
                            PojazdDodajEdycja pojazdDodajEdycjaGUI = new PojazdDodajEdycja("Panel edytowania pojazdu", "edycja", admin, nazwaUzytkownika, pojazd);
                            pojazdDodajEdycjaGUI.setVisible(true);
                            dispose();
                            break;
                        }
                    }
                }
            }
        });

        labelUsunPojazd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int[] wybraneWiersze = tablePojazdy.getSelectedRows();
                int wiersze = wybraneWiersze.length;
                if (wiersze > 0)
                {
                    int result = JOptionPane.showConfirmDialog(null, "Zaznaczone wiersze: " + wiersze + "\nCzy na pewno chcesz usunąć zaznaczone dane?", "Potwierdzenie usunięcia danych", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                    {
                        pojazdyListWyswietlTabela.clear();
                        pojazdyList.forEach(pojazd -> pojazdyListWyswietlTabela.add(pojazd.zwrocPojazd()));

                        for (int i = wiersze - 1; i >= 0; i--)
                        {
                            int wiersz = wybraneWiersze[i];
                            Object[] objects = stworzObjectTable(wiersz);
                            for (Object[] pojazd : pojazdyListWyswietlTabela)
                            {
                                boolean bool = porownajPojazdPojazd(pojazd, objects);
                                if (bool)
                                {
                                    Pojazd pojazdDoUsuniecia = stworzPojazd(pojazd);
                                    pojazdyList.remove(pojazdDoUsuniecia);
                                    pojazdyListWyswietlTabela.remove(pojazd);
                                    break;
                                }
                            }
                        }

                        buttonFiltruj.doClick();
                    }
                }
                else JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnych danych do usunięcia", "Brak zaznaczonych danych", JOptionPane.WARNING_MESSAGE);
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
                    case "Samochód osobowy" ->
                    {
                        comboBoxNadwozie.removeAllItems();
                        for (NadwozieOsobowy nadwozie : NadwozieOsobowy.values())
                            comboBoxNadwozie.addItem(nadwozie.name());
                    }
                    case "Samochód ciężarowy" ->
                    {
                        comboBoxNadwozie.removeAllItems();
                        for (NadwozieCiezarowy nadwozie : NadwozieCiezarowy.values())
                        {
                            if (nadwozie.name().equals("LekkaCiezarowka")) { comboBoxNadwozie.addItem("Lekka ciężarówka"); continue; }
                            if (nadwozie.name().equals("CiezkaCiezarowka")) { comboBoxNadwozie.addItem("Ciężka ciężarówka"); continue; }
                            comboBoxNadwozie.addItem(nadwozie.name());
                        }
                    }
                    case "Ciągnik rolniczy" ->
                    {
                        comboBoxNadwozie.removeAllItems();
                        for (NadwozieCiagnikRol nadwozie : NadwozieCiagnikRol.values())
                        {
                            if (nadwozie.name().equals("Kolowe")) { comboBoxNadwozie.addItem("Kołowe"); continue; }
                            if (nadwozie.name().equals("Gasienicowe")) { comboBoxNadwozie.addItem("Gąsienicowe"); continue; }
                            comboBoxNadwozie.addItem(nadwozie.name());
                        }
                    }
                    case "Autobus" ->
                    {
                        comboBoxNadwozie.removeAllItems();
                        for (NadwozieAutobus nadwozie : NadwozieAutobus.values())
                        {
                            if (nadwozie.name().equals("Pietrowe")) { comboBoxNadwozie.addItem("Piętrowe"); continue; }
                            comboBoxNadwozie.addItem(nadwozie.name());
                        }
                    }
                    case "Motocykl" ->
                    {
                        comboBoxNadwozie.removeAllItems();
                        for (NadwozieMotocykl nadwozie : NadwozieMotocykl.values())
                            comboBoxNadwozie.addItem(nadwozie.name());
                    }
                }
            }
        });
    }

    private void wartosciCheckBoxNapisz()
    {
        jCheckBoxBoolList.clear();
        jCheckBoxBoolList.add(new Object[] { comboBoxRodzaj.getSelectedItem(), checkBoxRodzaj.isSelected() });
        jCheckBoxBoolList.add(new Object[] { comboBoxNadwozie.getSelectedItem(), checkBoxNadwozie.isSelected() });
        jCheckBoxBoolList.add(new Object[] { comboBoxMarka.getSelectedItem(), checkBoxMarka.isSelected() });
        jCheckBoxBoolList.add(new Object[] { comboBoxKolor.getSelectedItem(), checkBoxKolor.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerPojSilMin.getValue(), checkBoxPojSilMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerPojSilMax.getValue(), checkBoxPojSilMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerMocSilMin.getValue(), checkBoxMocSilMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerMocSilMax.getValue(), checkBoxMocSilMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerWagaMin.getValue(), checkBoxWagaMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerWagaMax.getValue(), checkBoxWagaMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerRokProdukcjiMin.getValue(), checkBoxRokProdukcjiMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerRokProdukcjiMax.getValue(), checkBoxRokProdukcjiMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerPrzebiegMin.getValue(), checkBoxPrzebiegMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerPrzebiegMax.getValue(), checkBoxPrzebiegMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerCenaMin.getValue(), checkBoxCenaMin.isSelected() });
        jCheckBoxBoolList.add(new Object[] { spinnerCenaMax.getValue(), checkBoxCenaMax.isSelected() });
        jCheckBoxBoolList.add(new Object[] { sliderMaksPredkosc.getValue(), checkBoxMaksPredkosc.isSelected() });
    }

    public static Pojazd stworzPojazd(Object[] pojazd)
    {
        Pojazd pojazdZwroc = null;
        switch (pojazd[0].toString())
        {
            case "Samochod_Osobowy" -> pojazdZwroc = new Osobowy(
                    Rodzaj.valueOf((String) pojazd[0]),
                    NadwozieOsobowy.valueOf((String) pojazd[1]),
                    Marka.valueOf((String) pojazd[2]), (String) pojazd[3],
                    Kolor.valueOf((String) pojazd[4]), (double) pojazd[5],
                    (int) pojazd[6], (int) pojazd[11], (double) pojazd[7],
                    (int) pojazd[8], (int) pojazd[9], (int) pojazd[10],
                    (int) pojazd[12], (int) pojazd[13], (int) pojazd[14]);
            case "Samochod_Ciezarowy" -> pojazdZwroc = new Ciezarowy(
                    Rodzaj.valueOf((String) pojazd[0]),
                    NadwozieCiezarowy.valueOf((String) pojazd[1]),
                    Marka.valueOf((String) pojazd[2]), (String) pojazd[3],
                    Kolor.valueOf((String) pojazd[4]), (double) pojazd[5],
                    (int) pojazd[6], (int) pojazd[11], (double) pojazd[7],
                    (int) pojazd[8], (int) pojazd[9], (int) pojazd[10],
                    (int) pojazd[12], (int) pojazd[13], (int) pojazd[14],
                    (int) pojazd[15]);
            case "Ciagnik_Rolniczy" -> pojazdZwroc = new CiagnikRol(
                    Rodzaj.valueOf((String) pojazd[0]),
                    NadwozieCiagnikRol.valueOf((String) pojazd[1]),
                    Marka.valueOf((String) pojazd[2]), (String) pojazd[3],
                    Kolor.valueOf((String) pojazd[4]), (double) pojazd[5],
                    (int) pojazd[6], (int) pojazd[11], (double) pojazd[7],
                    (int) pojazd[8], (int) pojazd[9], (int) pojazd[10],
                    (int) pojazd[12], (int) pojazd[13], (int) pojazd[14]);
            case "Autobus" -> pojazdZwroc = new Autobus(
                    Rodzaj.valueOf((String) pojazd[0]),
                    NadwozieAutobus.valueOf((String) pojazd[1]),
                    Marka.valueOf((String) pojazd[2]), (String) pojazd[3],
                    Kolor.valueOf((String) pojazd[4]), (double) pojazd[5],
                    (int) pojazd[6], (int) pojazd[11], (double) pojazd[7],
                    (int) pojazd[8], (int) pojazd[9], (int) pojazd[10],
                    (int) pojazd[12], (int) pojazd[13], (int) pojazd[14],
                    (int) pojazd[15]);
            case "Motocykl" -> pojazdZwroc = new Motocykl(
                    Rodzaj.valueOf((String) pojazd[0]),
                    NadwozieMotocykl.valueOf((String) pojazd[1]),
                    Marka.valueOf((String) pojazd[2]), (String) pojazd[3],
                    Kolor.valueOf((String) pojazd[4]), (double) pojazd[5],
                    (int) pojazd[6], (int) pojazd[11], (double) pojazd[7],
                    (int) pojazd[8], (int) pojazd[9], (int) pojazd[10],
                    (int) pojazd[12], (int) pojazd[13]);
        }
        return pojazdZwroc;
    }

    public static String renameRodzajBaza(String rodzaj)
    {
        switch (rodzaj)
        {
            case "Samochód osobowy" -> rodzaj = "Samochod_Osobowy";
            case "Samochód ciężarowy" -> rodzaj = "Samochod_Ciezarowy";
            case "Ciągnik rolniczy" -> rodzaj = "Ciagnik_Rolniczy";
        }
        return rodzaj;
    }
    public static String renameNadwozieBaza(String nadwozie)
    {
        switch (nadwozie)
        {
            case "Lekka ciężarówka" -> nadwozie = "LekkaCiezarowka";
            case "Ciężka ciężarówka" -> nadwozie = "CiezkaCiezarowka";
            case "Kołowe" -> nadwozie = "Kolowe";
            case "Gąsienicowe" -> nadwozie = "Gasienicowe";
            case "Piętrowe" -> nadwozie = "Pietrowe";
        }
        return nadwozie;
    }
    public static String renameKolorBaza(String kolor)
    {
        switch (kolor)
        {
            case "Biały" -> kolor = "Bialy";
            case "Żółty" -> kolor = "Zolty";
            case "Złoty" -> kolor = "Zloty";
            case "Różowy" -> kolor = "Rozowy";
            case "Beżowy" -> kolor = "Bezowy";
            case "Brązowy" -> kolor = "Brazowy";
            case "Pomarańczowy" -> kolor = "Pomaranczowy";
        }
        return kolor;
    }

    private void spinnerComboBoxCreateComponent(JComboBox comboBoxKolor, JComboBox comboBoxMarka,
                                                      JComboBox comboBoxNadwozie, ArrayList<JComboBox> jComboBoxList,
                                                      ArrayList<JSpinner> jSpinnerList)
    {
        for (Kolor kolor : Kolor.values())
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

    private void actionComponent(boolean admin, String nazwaUzytkownika)
    {
        this.admin = admin;
        this.nazwaUzytkownika = nazwaUzytkownika;
        labelUzytkownik.setText("Użytkownik: " + nazwaUzytkownika);
        adminPanel.setVisible(admin);
        buttonNull.setOpaque(false);

        ArrayList<JComboBox> jComboBoxList = new ArrayList<>(Arrays.asList(comboBoxNadwozie, comboBoxMarka, comboBoxRodzaj, comboBoxKolor));
        spinnerComboBoxCreateComponent(comboBoxKolor, comboBoxMarka, comboBoxNadwozie, jComboBoxList, jSpinnerList);

        for (JCheckBox checkBox : jCheckBoxList)
        {
            checkBox.setSelectedIcon(ResizeImageIcon.resize(checkBoxIconSelected, 30, 30));
            checkBox.setIcon(ResizeImageIcon.resize(checkBoxIconNoSelected, 30, 30));
        }
        customizeSlider(sliderMaksPredkosc, new Color(31, 36, 65));

        for (int i = 0; i < (long) jCheckBoxBoolList.size(); i++)
        {
            Object[] objects = jCheckBoxBoolList.get(i);
            Object pole = jCheckBoxWartosciList.get(i)[0];
            Object wartosc = objects[0];
            if (pole instanceof JSpinner spinner)
                spinner.setValue(wartosc);
            else if (pole instanceof JSlider slider)
                slider.setValue((Integer) wartosc);
            else if (pole instanceof JComboBox comboBox)
                comboBox.setSelectedItem(wartosc);
            boolean bool = (boolean) objects[1];
            if (bool) ((JCheckBox) jCheckBoxWartosciList.get(i)[1]).setSelected(true);
        }
        buttonFiltruj.doClick();
    }

    private void customizeSlider(JSlider slider, Color thumbColor)
    {
        slider.setUI(new BasicSliderUI(slider)
        {
            @Override
            public void paintThumb(Graphics g)
            {
                super.paintThumb(g);
                g.setColor(thumbColor);
            }
        });
        
        slider.setMinorTickSpacing(25);
        slider.setMajorTickSpacing(100);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
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

        nazwySpinnerPanelBaza(spinner, nazwaSpinner);
        JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) spinner.getEditor();
        JTextField textField = defaultEditor.getTextField();
        textField.setBorder(new EmptyBorder(2, 6, 2, 6));
        textField.setBackground(backgroundColor);
        textField.setForeground(foregroundColor);
        textField.setFont(new Font("Fira Code", Font.PLAIN, 22));
        textField.addFocusListener(new FocusAdapter() { public void focusLost(FocusEvent e) { validateSpinnerValue(spinner); } });
    }

    private void nazwySpinnerPanelBaza(JSpinner spinner, String nazwaSpinner)
    {
        // SpinnerModel value = new SpinnerNumberModel(Początkowa wartość, Minimalna wartość, Maksymalna wartość, Krok);
        switch (nazwaSpinner)
        {
            case "spinnerPojSilMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(1.0, 0.5, 19.9, 0.1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.0"));
                spinner.setValue(1.0);
            }
            case "spinnerPojSilMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(2.0, 0.5, 19.9, 0.1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.0"));
                spinner.setValue(2.0);
            }
            case "spinnerMocSilMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(100, 50, 1500, 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(100);
            }
            case "spinnerMocSilMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(200, 50, 1500, 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(200);
            }
            case "spinnerWagaMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(1.300, 0.100, 29.995, 0.005));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.000"));
                spinner.setValue(1.50);
            }
            case "spinnerWagaMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(2.500, 0.100, 29.995, 0.005));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0.000"));
                spinner.setValue(2.00);
            }
            case "spinnerRokProdukcjiMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(2000, 1970, LocalDate.now().getYear(), 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(2000);
            }
            case "spinnerRokProdukcjiMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(2020, 1970, LocalDate.now().getYear(), 1));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(2020);
            }
            case "spinnerPrzebiegMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(100000, 0, 999900, 100));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(100000);
            }
            case "spinnerPrzebiegMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(300000, 0, 999900, 100));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(300000);
            }
            case "spinnerCenaMin" ->
            {
                spinner.setModel(new SpinnerNumberModel(10000, 1000, 1999990, 10));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(10000);
            }
            case "spinnerCenaMax" ->
            {
                spinner.setModel(new SpinnerNumberModel(70000, 1000, 1999990, 10));
                spinner.setEditor(new JSpinner.NumberEditor(spinner, "#0"));
                spinner.setValue(70000);
            }
        }
    }

    private void createTable()
    {
        pojazdyListWyswietlTabela.clear();
        pojazdyList.forEach(pojazd -> pojazdyListWyswietlTabela.add(pojazd.zwrocPojazd()));
        setTableModel();
    }

    private SortedTableModel setTableWartosci()
    {
        SortedTableModel model = new SortedTableModel(new String[]{"Rodzaj<br><br>", "Nadwozie<br><br>",
                "Marka<br><br>", "Model<br><br>", "Kolor<br><br>", "Pojemność<br>silnika<br>(cm^3)",
                "Moc<br>silnika<br>(KM)", "Waga<br>(t)<br>", "Rok<br>produkcji<br>", "Przebieg<br>(km)<br>",
                "Cena<br>(PLN)<br>", "Maksymalna<br>prędkość<br>(km/h)", "Liczba<br>miejsc<br>"});
        for (Object[] objects : pojazdyListWyswietlTabela)
        {
            Object[] pojazd = new Object[] {objects[0], objects[1], objects[2], objects[3], objects[4], objects[5],
                              objects[6], objects[7], objects[8], objects[9], objects[10], objects[11], objects[12]};
            pojazd[0] = renameRodzajPolski((String) pojazd[0]);
            pojazd[1] = renameNadwoziePolski((String) pojazd[1]);
            pojazd[4] = renameKolorPolski((String) pojazd[4]);
            model.addRow(pojazd);
        }
        return model;
    }

    public static String renameRodzajPolski(String rodzaj)
    {
        switch (rodzaj)
        {
            case "Samochod_Osobowy" -> rodzaj = "Samochód osobowy";
            case "Samochod_Ciezarowy" -> rodzaj = "Samochód ciężarowy";
            case "Ciagnik_Rolniczy" -> rodzaj = "Ciągnik rolniczy";
        }
        return rodzaj;
    }
    public static String renameNadwoziePolski(String nadwozie)
    {
        switch (nadwozie)
        {
            case "LekkaCiezarowka" -> nadwozie = "Lekka ciężarówka";
            case "CiezkaCiezarowka" -> nadwozie = "Ciężka ciężarówka";
            case "Kolowe" -> nadwozie = "Kołowe";
            case "Gasienicowe" -> nadwozie = "Gąsienicowe";
            case "Pietrowe" -> nadwozie = "Piętrowe";
        }
        return nadwozie;
    }
    public static String renameKolorPolski(String kolor)
    {
        switch (kolor)
        {
            case "Bialy" -> kolor = "Biały";
            case "Zolty" -> kolor = "Żółty";
            case "Zloty" -> kolor = "Złoty";
            case "Rozowy" -> kolor = "Różowy";
            case "Bezowy" -> kolor = "Beżowy";
            case "Brazowy" -> kolor = "Brązowy";
            case "Pomaranczowy" -> kolor = "Pomarańczowy";
        }
        return kolor;
    }

    private void setTableModel()
    {
        SortedTableModel model = setTableWartosci();
        tablePojazdy.setModel(model);
        tablePojazdy.setEnabled(true);
        tablePojazdy.setDefaultEditor(Object.class, null);
        tablePojazdy.getTableHeader().setReorderingAllowed(false);
        tablePojazdy.setDefaultRenderer(Object.class, new KomorkaTabeli());
        tablePojazdy.setToolTipText("");
        tablePojazdy.addMouseMotionListener(new MouseMotionAdapter() { public void mouseMoved(MouseEvent e) { updateToolTipText(e); } });
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
        ListSelectionModel rowSelectionModel = tablePojazdy.getSelectionModel();
        rowSelectionModel.addListSelectionListener(e ->
        {
            if (!e.getValueIsAdjusting())
            {
                Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePosition, tablePojazdy);
                updateToolTipText(new MouseEvent(tablePojazdy, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, mousePosition.x, mousePosition.y, 0, false));
            }
        });

        for (int i = 0; i < tablePojazdy.getColumnCount(); i++)
        {
            Boolean ascending = sortTableMap.get(i);
            if (ascending != null) model.sortData(i, !ascending);
            else sortTableMap.put(i, null);
        }

        JTableHeader header = tablePojazdy.getTableHeader();
        header.setDefaultRenderer(new NaglowekTabeli());
        header.setPreferredSize(new Dimension(this.getWidth(), 70));
        header.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int indeksKolumny = header.columnAtPoint(e.getPoint());
                if (indeksKolumny != -1)
                {
                    Boolean ascending = sortTableMap.get(indeksKolumny);
                    if (ascending == null) ascending = true;
                    for (int i = 0; i < tablePojazdy.getColumnCount(); i++)
                        sortTableMap.put(i, null);
                    sortTableMap.put(indeksKolumny, !ascending);
                    model.sortData(indeksKolumny, ascending);
                    header.repaint();
                    model.fireTableDataChanged();
                }
            }
        });

        if (tablePojazdy.getColumnCount() == 13)
        {
            TableColumnModel columnModel = tablePojazdy.getColumnModel();
            for (int i = 0; i < 13; i++)
                columnModel.getColumn(i).setResizable(false);

            // 1038 - szerokość całej tabeli
            columnModel.getColumn(0).setMinWidth(125); // Rodzaj
            columnModel.getColumn(1).setMinWidth(110); // Nadwozie
            columnModel.getColumn(2).setMinWidth(93); // Marka
            columnModel.getColumn(3).setMinWidth(113); // Model
            columnModel.getColumn(4).setMinWidth(93); // Kolor
            columnModel.getColumn(5).setMinWidth(77); // Pojemność silnika (cm^3)
            columnModel.getColumn(6).setMinWidth(49); // Moc silnika (KM)
            columnModel.getColumn(7).setMinWidth(50); // Waga (t)
            columnModel.getColumn(8).setMinWidth(67); // Rok produkcji
            columnModel.getColumn(9).setMinWidth(63); // Przebieg (km)
            columnModel.getColumn(10).setMinWidth(60); // Cena (PLN)
            columnModel.getColumn(11).setMinWidth(85); // Maksymalna prędkość (km/h)
            columnModel.getColumn(12).setMinWidth(53); // Liczba miejsc

            columnModel.getColumn(5).setCellRenderer(new DefaultTableCellRenderer()
            {
                @Override
                protected void setValue(Object value)
                {
                    value = String.format("%.1f", ((Number) value).doubleValue());
                    super.setValue(value);
                }
            });
            columnModel.getColumn(7).setCellRenderer(new DefaultTableCellRenderer()
            {
                @Override
                protected void setValue(Object value)
                {
                    value = String.format("%.3f", ((Number) value).doubleValue());
                    super.setValue(value);
                }
            });
        }
    }

    private void updateToolTipText(MouseEvent  e)
    {
        Point point = e.getPoint();
        int indexWiersz = tablePojazdy.rowAtPoint(point);
        int indexKolumna = tablePojazdy.columnAtPoint(point);

        if (indexWiersz != -1 && indexKolumna != -1)
        {
            Object[] objects = stworzObjectTable(indexWiersz);
            String tekst = createToolTipText(objects);

            UIManager.put("ToolTip.background", new Color(184, 207, 229));
            UIManager.put("ToolTip.foreground", new Color(35, 15, 35));
            UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.BLACK));

            Rectangle cellRect = tablePojazdy.getCellRect(indexWiersz, tablePojazdy.getColumnCount() - 1, false);
            Point locationOnScreen = tablePojazdy.getLocationOnScreen();
            tablePojazdy.setToolTipText(null);
            ToolTipManager.sharedInstance().mouseMoved(
                    new MouseEvent(tablePojazdy, 0, 0, 0,
                            locationOnScreen.x + cellRect.x + cellRect.width + 10,
                            locationOnScreen.y + cellRect.y,
                            0, false));

            tablePojazdy.setToolTipText(tekst);
        }
        else tablePojazdy.setToolTipText(null);
    }
    
    private Object[] stworzObjectTable(int indexWiersz)
    {
        Object[] objects = new Object[13];
        TableModel model = tablePojazdy.getModel();

        for (int i = 0; i < model.getColumnCount(); i++)
            objects[i] = model.getValueAt(indexWiersz, i);
        objects[0] = renameRodzajBaza((String) objects[0]);
        objects[1] = renameNadwozieBaza((String) objects[1]);
        objects[4] = renameKolorBaza((String) objects[4]);
        
        return objects;
    }

    private String createToolTipText(Object[] objects)
    {
        for (Object[] pojazd : pojazdyListWyswietlTabela)
        {
            boolean bool = porownajPojazdPojazd(pojazd, objects);
            if (bool)
            {
                StringBuilder tekst = new StringBuilder();
                if (objects[0].equals("Samochod_Osobowy"))
                    tekst.append("<html>Dodatkowe informacje:").append("<br>Liczba drzwi: ").append(pojazd[13]).append("<br>Pojemność bagażnika (l): ").append(pojazd[14]).append("</html>");
                else if (objects[0].equals("Samochod_Ciezarowy"))
                    tekst.append("<html>Dodatkowe informacje:").append("<br>Liczba drzwi: ").append(pojazd[13]).append("<br>Ładowność (l): ").append(pojazd[14]).append("<br>Liczba kół: ").append(pojazd[15]).append("</html>");
                else if (objects[0].equals("Ciagnik_Rolniczy"))
                    tekst.append("<html>Dodatkowe informacje:").append("<br>Liczba drzwi: ").append(pojazd[13]).append("<br>Maksymalna masa ciągnięcia (kg): ").append(pojazd[14]).append("</html>");
                else if (objects[0].equals("Autobus"))
                    tekst.append("<html>Dodatkowe informacje:").append("<br>Liczba drzwi: ").append(pojazd[13]).append("<br>Pojemność bagażnika (l): ").append(pojazd[14]).append("<br>Liczba kół: ").append(pojazd[15]).append("</html>");
                else if (objects[0].equals("Motocykl"))
                    tekst.append("<html>Dodatkowe informacje:").append("<br>Liczba kół: ").append(pojazd[13]).append("</html>");
                return String.valueOf(tekst);
            }
        }
        return null;
    }

    public static boolean porownajPojazdPojazd(Object[] pojazd1, Object[] pojazd2)
    {
        return pojazd1[0].equals(pojazd2[0]) && pojazd1[1].equals(pojazd2[1]) &&
                pojazd1[2].equals(pojazd2[2]) && pojazd1[3].equals(pojazd2[3]) &&
                pojazd1[4].equals(pojazd2[4]) && (double) pojazd1[5] == (double) pojazd2[5] &&
                (int) pojazd1[6] == (int) pojazd2[6] && (double) pojazd1[7] == (double) pojazd2[7] &&
                (int) pojazd1[8] == (int) pojazd2[8] && (int) pojazd1[9] == (int) pojazd2[9] &&
                (int) pojazd1[10] == (int) pojazd2[10] && (int) pojazd1[11] == (int) pojazd2[11] &&
                (int) pojazd1[12] == (int) pojazd2[12];
    }

    public static void validateSpinnerValue(JSpinner spinner)
    {
        SpinnerNumberModel numberModel = (SpinnerNumberModel) spinner.getModel();
        Number maxWartosc = (Number) numberModel.getMaximum();
        Number minWartosc = (Number) numberModel.getMinimum();
        Number poprzedniaWartosc = (Number) spinner.getValue();

        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor defaultEditor)
        {
            JTextField textField = defaultEditor.getTextField();
            String spinnerWartosc = textField.getText();
            spinner.setValue(0);

            try
            {
                spinnerWartosc = spinnerWartosc.replace(",", ".");
                double doubleWartosc = Double.parseDouble(spinnerWartosc);
                if (maxWartosc != null && doubleWartosc > maxWartosc.doubleValue())
                    spinner.setValue(maxWartosc);
                else if (minWartosc != null && doubleWartosc < minWartosc.doubleValue())
                    spinner.setValue(minWartosc);
                else spinner.setValue(doubleWartosc);
            }
            catch (Exception e)
            {
                try
                {
                    int intWartosc = Integer.parseInt(spinnerWartosc);
                    if (maxWartosc != null && intWartosc > maxWartosc.intValue())
                        spinner.setValue(maxWartosc.intValue());
                    else if (minWartosc != null && intWartosc < minWartosc.intValue())
                        spinner.setValue(minWartosc.intValue());
                    else spinner.setValue(intWartosc);
                }
                catch (Exception ex)
                {
                    if (poprzedniaWartosc instanceof Double)
                        spinner.setValue((double) poprzedniaWartosc);
                    else if (poprzedniaWartosc instanceof Integer)
                        spinner.setValue((int) poprzedniaWartosc);
                    else spinner.setValue(poprzedniaWartosc);
                }
            }
        }
    }
}
