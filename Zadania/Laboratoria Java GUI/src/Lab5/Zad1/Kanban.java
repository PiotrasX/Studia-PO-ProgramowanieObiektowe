package Lab5.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Kanban extends JFrame
{
    private JPanel JMainPanel;
    private JTabbedPane tabbedPaneFileAbout;
    private JPanel filePanel;
    private JPanel aboutPanel;
    private JButton buttonAddNewTask;
    private JTextField textField1;
    private JButton buttonBack;
    private JButton buttonCLose;
    private JLabel labelInProgress;
    private JLabel labelDone;
    private JLabel labelToDo;
    private JList listToDo;
    private JList listInProgress;
    private JList listDone;
    private JButton buttonToDoInProgress;
    private JButton buttonInProgressDone;

    private JPopupMenu popupMenu;
    private JMenuItem menuDelete;
    private JMenuItem menuEdit;

    public DefaultListModel<Object> modelListToDo = (DefaultListModel<Object>) listToDo.getModel();
    public DefaultListModel<Object> modelListInProgress = (DefaultListModel<Object>) listInProgress.getModel();
    public DefaultListModel<Object> modelListDone = (DefaultListModel<Object>) listDone.getModel();
    private JList lastClickedList; // Ostatnio kliknięta lista

    private static ArrayList<Object[]> itemListToDo = new ArrayList<>(Arrays.asList(new Object[]{"Sprzątanie pokoju", "Low", "2023.11.19"}, new Object[]{"Odkurzanie pokoju", "Low", "2023.11.20"}));
    private static ArrayList<Object[]> itemListInProgress = new ArrayList<>(Arrays.asList(new Object[]{"Mycie podłogi", "High", "2023.12.20"}, new Object[]{"Mycie okien", "High", "2023.12.19"}));
    private static ArrayList<Object[]> itemListDone = new ArrayList<>(Arrays.asList(new Object[]{"Nauka JAVY", "Low", "2023.01.04"},  new Object[]{"Wizyta u doktora", "High", "2023.09.21"}));

    public static void main(String[] args)
    {
        Kanban kanbanGUI = new Kanban();
        kanbanGUI.setVisible(true);
    }

    public Kanban()
    {
        super("Kanban");
        inicjalizacjaKomponentow();
        tworzenieLayoutu();
        dodanieEventListeners();
    }

    public Kanban(Object[] daneNowe, String listObjectName, int index)
    {
        super("Kanban");
        if (listObjectName.equals("ToDo"))
        {
            if(index >= 0) { itemListToDo.set(index, daneNowe); }
            else { itemListToDo.add(daneNowe); }
        }
        else if (listObjectName.equals("InProgress")) { itemListInProgress.set(index, daneNowe); }
        inicjalizacjaKomponentow();
        tworzenieLayoutu();
        dodanieEventListeners();
    }

    private void inicjalizacjaKomponentow()
    {
        // Tworzenie popupMenu dla każdej listy
        setupPopupMenu(listToDo);
        setupPopupMenu(listInProgress);
        setupPopupMenuDone(listDone);
        wypelnijDaneX3();
        listToDo.setName("ToDo");
        listInProgress.setName("InProgress");
        listDone.setName("Done");
        listToDo.setCellRenderer(new WyswietlanieOpisowElementowListy());
        listInProgress.setCellRenderer(new WyswietlanieOpisowElementowListy());
        listDone.setCellRenderer(new WyswietlanieOpisowElementowListy());
    }

    private void setupPopupMenuDone(JList<Object> list)
    {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");

        popupMenu.add(deleteItem);

        deleteItem.addActionListener(e -> deleteSelectedItem(list));

        list.setComponentPopupMenu(popupMenu);
    }

    private void setupPopupMenu(JList<Object> list)
    {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        JMenuItem editItem = new JMenuItem("Edit");

        popupMenu.add(deleteItem);
        popupMenu.add(editItem);

        deleteItem.addActionListener(e -> deleteSelectedItem(list));
        editItem.addActionListener(e -> editSelectedItem(list));

        list.setComponentPopupMenu(popupMenu);
    }

    private void wypelnijDaneX3()
    {
        wypelnijDane(listToDo, itemListToDo);
        wypelnijDane(listInProgress, itemListInProgress);
        wypelnijDane(listDone, itemListDone);
    }

    private void wypelnijDane(JList<Object> list, ArrayList<Object[]> data)
    {
        DefaultListModel<Object> model = (DefaultListModel<Object>) list.getModel();
        for (Object[] item : data) { model.addElement(item); }
    }

    private void tworzenieLayoutu()
    {
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 800));
        this.setLocationRelativeTo(null);
    }

    private void dodanieEventListeners()
    {
        buttonAddNewTask.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddForm addFormGUI = new AddForm();
                addFormGUI.setVisible(true);
                dispose();
            }
        });

        buttonBack.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        buttonCLose.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        buttonToDoInProgress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { buttonToDoInProgressEvent(); }
        });

        buttonInProgressDone.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { buttonInProgressDoneEvent(); }
        });

        listDone.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) { listToDo.clearSelection(); listInProgress.clearSelection(); lastClickedList = listToDo; }
        });
        listToDo.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) { listDone.clearSelection(); listInProgress.clearSelection(); lastClickedList = listInProgress; }
        });
        listInProgress.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) { listToDo.clearSelection(); listDone.clearSelection(); lastClickedList = listDone; }
        });
    }

    public void buttonToDoInProgressEvent()
    {
        if(listToDo.getSelectedIndex() != -1)
        {
            modelListInProgress.addElement(listToDo.getSelectedValue());
            int selectedIndex = listToDo.getSelectedIndex();
            modelListToDo.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "The item has been moved", "Item moved!", JOptionPane.INFORMATION_MESSAGE);
            Object[] selectedItem = itemListToDo.get(selectedIndex);
            itemListInProgress.add(selectedItem);
            itemListToDo.remove(selectedIndex);
        }
        else if(modelListToDo.getSize() == 0) JOptionPane.showMessageDialog(null, "No items to moved", "No items moved!", JOptionPane.WARNING_MESSAGE);
        else JOptionPane.showMessageDialog(null, "No item selected", "No items moved!", JOptionPane.WARNING_MESSAGE);
    }

    public void buttonInProgressDoneEvent()
    {
        if (listInProgress.getSelectedIndex() != -1)
        {
            modelListDone.addElement(listInProgress.getSelectedValue());
            int selectedIndex = listInProgress.getSelectedIndex();
            modelListInProgress.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "The item has been moved", "Item moved!", JOptionPane.INFORMATION_MESSAGE);
            Object[] selectedItem = itemListInProgress.get(selectedIndex);
            itemListDone.add(selectedItem);
            itemListInProgress.remove(selectedIndex);
        }
        else if (modelListInProgress.getSize() == 0) JOptionPane.showMessageDialog(null, "No items to moved", "No items moved!", JOptionPane.WARNING_MESSAGE);
        else JOptionPane.showMessageDialog(null, "No item selected", "No items moved!", JOptionPane.WARNING_MESSAGE);
    }

    private void deleteSelectedItem(JList<Object> list)
    {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1)
        {
            ((DefaultListModel<Object>) list.getModel()).remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "An item has been removed from the list", "Item removed!", JOptionPane.INFORMATION_MESSAGE);
            String listObjectName = list.getName();
            if (listObjectName.equals("ToDo")) { itemListToDo.remove(selectedIndex); }
            else if (listObjectName.equals("InProgress")) { itemListInProgress.remove(selectedIndex); }
            else if (listObjectName.equals("Done")) { itemListDone.remove(selectedIndex); }
        }
        else if (list.getModel().getSize() == 0) JOptionPane.showMessageDialog(null, "No items to removed", "No item removed!", JOptionPane.WARNING_MESSAGE);
        else JOptionPane.showMessageDialog(null, "No item selected", "No item removed!", JOptionPane.WARNING_MESSAGE);
    }

    private void editSelectedItem(JList<Object> list)
    {
        int selectedIndex = list.getSelectedIndex();
        String listObjectName = list.getName();
        if (selectedIndex != -1)
        {
            if (listObjectName.equals("ToDo")) { AddForm addFormGUI = new AddForm(itemListToDo.get(selectedIndex), selectedIndex, listObjectName); addFormGUI.setVisible(true); dispose(); }
            else if (listObjectName.equals("InProgress")) { AddForm addFormGUI = new AddForm(itemListInProgress.get(selectedIndex), selectedIndex, listObjectName); addFormGUI.setVisible(true); dispose(); }
        }
        else if (list.getModel().getSize() == 0) JOptionPane.showMessageDialog(null, "No items to edit", "No item edit!", JOptionPane.WARNING_MESSAGE);
        else JOptionPane.showMessageDialog(null, "No item selected", "No item edit!", JOptionPane.WARNING_MESSAGE);
    }
}
