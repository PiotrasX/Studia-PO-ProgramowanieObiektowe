package Projekt.PlikiJava;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import static Projekt.PlikiJava.PanelBazaSamochodow.sortTableMap;

public class NaglowekTabeli extends JLabel implements TableCellRenderer
{
    public NaglowekTabeli()
    {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(TOP);
        setFont(UIManager.getFont("TableHeader.font").deriveFont(Font.BOLD));
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setBackground(new Color(31, 36, 65));
        setForeground(new Color(255, 255, 255));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column)
    {
        String tekst = value.toString();
        Boolean isSortedAscending = sortTableMap.get(table.convertColumnIndexToModel(column));
        if (isSortedAscending != null)
            tekst += isSortedAscending ? "<br>⮟" : "<br>⮝";
        setText("<html><div style='text-align: center;'>" + tekst + "</div></html>");
        return this;
    }
}
