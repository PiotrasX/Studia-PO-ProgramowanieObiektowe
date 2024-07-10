package Lab3.ZadaniaLekcja.Cwiczenie2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Cwiczenie2 extends JFrame
{
    private JPanel JMainPanel;
    private JScrollPane languageTableScrollPane;
    private JTable languageTable;

    public static void main(String[] args)
    {
        Cwiczenie2 cwiczenie2GUI = new Cwiczenie2();
        cwiczenie2GUI.setVisible(true);
    }

    public Cwiczenie2()
    {
        super("Table Ćwiczenie2");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(790, 127));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru
        stworzTabele();
    }

    private void stworzTabele()
    {
        Object[][] data = {
                {"Jan","Nowak","Informatyka",3},
                {"Adrian","Kowalski","Matematyka",1},
                {"Patrycja","Panek","Biotechnologia",3},
                {"Maksymilian","Przypek","Informatyka",2}};

        languageTable.setModel(new DefaultTableModel
        (
            data, new String[] {"Imię","Nazwisko","Kierunek","Semestr"}
        ));

        //languageTable.setEnabled(false);
        languageTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = languageTable.getColumnModel();
        columnModel.getColumn(0).setMinWidth(200);
        columnModel.getColumn(1).setMinWidth(300);
        columnModel.getColumn(2).setMinWidth(200);
        columnModel.getColumn(3).setMinWidth(50);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(cellRenderer);
        columnModel.getColumn(1).setCellRenderer(cellRenderer);
        columnModel.getColumn(2).setCellRenderer(cellRenderer);
        columnModel.getColumn(3).setCellRenderer(cellRenderer);
    }
}
