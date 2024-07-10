package Projekt.PlikiJava;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class SortedTableModel extends AbstractTableModel
{
    private final List<List<Object>> data;
    private final String[] columnNames;

    public SortedTableModel(String[] columnNames)
    {
        this.columnNames = columnNames;
        this.data = new ArrayList<>();
    }

    public void addRow(Object[] rowData)
    {
        data.add(new ArrayList<>(Arrays.asList(rowData)));
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    @Override
    public int getRowCount() { return data.size(); }
    @Override
    public int getColumnCount() { return columnNames.length; }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { return data.get(rowIndex).get(columnIndex); }
    @Override
    public String getColumnName(int column) { return columnNames[column]; }

    public void sortData(int columnIndex, boolean ascending)
    {
        Comparator<List<Object>> comparator = Comparator.comparing(o -> (Comparable) o.get(columnIndex));
        if (!ascending) { comparator = comparator.reversed(); }
        data.sort(comparator);
        fireTableDataChanged();
    }
}
