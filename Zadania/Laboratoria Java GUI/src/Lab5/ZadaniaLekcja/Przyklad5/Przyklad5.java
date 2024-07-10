package Lab5.ZadaniaLekcja.Przyklad5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Przyklad5 extends JFrame implements ActionListener
{
    private JPanel JMainPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;

    public static void main(String[] args)
    {
        Przyklad5 przyklad5GUI = new Przyklad5();
        przyklad5GUI.setVisible(true);
    }

    public Przyklad5()
    {
        super("JTable Popup Menu Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 200));
        this.setLocationRelativeTo(null);

        // Sample table data
        String[] columnNames = {"Title", "Author", "Publisher", "Published Date", "Pages", "Rating"};
        String[][] rowData = { {"Effective Java", "Joshua Bloch", "Addision-Wesley", "May 08th 2008", "346", "5"},
                               {"Thinking in Java", "Bruce Eckel", "Prentice Hall", "Feb 26th 2006", "1150", "4"},
                               {"Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media", "Feb 09th 2005", "688", "4.5"} };

        // Constructs the table with sample data
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // Constructs the popup menu and add item the popup menu
        popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Add New Row");
        menuItemRemove = new JMenuItem("Remove Current Row");
        menuItemRemoveAll = new JMenuItem("Remove All Rows");

        menuItemAdd.addActionListener(this);
        menuItemRemove.addActionListener(this);
        menuItemRemoveAll.addActionListener(this);

        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);

        // Sets the popup menu for the table
        table.setComponentPopupMenu(popupMenu);

        // Adds MouseListener to the table for right-click detection
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (SwingUtilities.isRightMouseButton(e))
                {
                    int r = table.rowAtPoint(e.getPoint());
                    if (r >= 0 && r < table.getRowCount()) { table.setRowSelectionInterval(r, r); }
                    else { table.clearSelection(); }

                    int rowIndex = table.getSelectedRow();
                    if (rowIndex < 0) return;
                    if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) { popupMenu.show(e.getComponent(), e.getX(), e.getY()); }
                }
            }
        });

        // Constructs JScrollPane with JTable
        scrollPane = new JScrollPane(table);
        JMainPanel = new JPanel(new BorderLayout());
        JMainPanel.add(scrollPane, BorderLayout.CENTER);

        // Sets the main panel as the content pane
        this.setContentPane(JMainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) { addNewRow(); }
        else if (menu == menuItemRemove) { removeCurrentRow(); }
        else if (menu == menuItemRemoveAll) { removeAllRows(); }
    }

    private void addNewRow() { tableModel.addRow(new String[0]); }

    private void removeCurrentRow()
    {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) // Check if a row is selected
        { tableModel.removeRow(selectedRow); }
    }

    private void removeAllRows() // It's more efficient to clear the data in the model directly
        { tableModel.setRowCount(0); }

    private class TableMouseListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
            // Selects the row at which point the mouse is clicked
            Point point = event.getPoint();
            int currentRow = table.rowAtPoint(point);
            if (currentRow >= 0) { table.setRowSelectionInterval(currentRow, currentRow); }
        }
    }
}
