package Lab5.Zad1;

import javax.swing.*;
import java.awt.*;

public class WyswietlanieOpisowElementowListy extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Object[] itemArray)
        {
            if (itemArray.length >= 3)
            {
                String name = (String) itemArray[0];
                String priority = (String) itemArray[1];
                String date = (String) itemArray[2];
                setText(name);  // Wyświetl tylko nazwę
                setToolTipText("Priorytet: " + priority + ", Data: " + date); // Tooltip z priorytetem i datą
            }
        }

        return c;
    }
}
