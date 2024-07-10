package Lab5.Zad2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

public class Zadanie2 extends JFrame
{
    private JPanel JMainPanel;
    private JTextField textFieldName;
    private JButton buttonClear;
    private JButton buttonAdd;
    private JLabel labelNewClient;
    private JLabel labelName;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JLabel labelAddress;
    private JTextField textFieldEmail;
    private JTextField textFieldPhone;
    private JTextField textFieldAddress;
    private JLabel labelListOfClients;
    private JButton buttonDelete;
    private JTable tableClients;
    private final LinkedList<Object[]> data = new LinkedList<>();

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight)
    {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args)
    {
        Zadanie2 zadanie2GUI = new Zadanie2();
        zadanie2GUI.setVisible(true);
    }

    public Zadanie2()
    {
        super("Dashboard");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        ImageIcon addIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\add.png")));
        addIcon = resize(addIcon, 25, 25);
        buttonAdd.setIcon(addIcon);
        ImageIcon clearIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\clear.png")));
        clearIcon = resize(clearIcon, 25, 25);
        buttonClear.setIcon(clearIcon);
        ImageIcon binIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\bin.png")));
        binIcon = resize(binIcon, 25, 25);
        buttonDelete.setIcon(binIcon);
        ImageIcon groupIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaZad2\\group.png")));
        groupIcon = resize(groupIcon, 55, 55);
        labelListOfClients.setIcon(groupIcon);
        labelListOfClients.setText(" List of Clients");

        data.add(new Object[]{"Piotr Rojek", "piotr@gmail.com", "123123123", "Rzeszów"});
        data.add(new Object[]{"Emilia Alberska", "emilia@gmail.com", "535301789", "Krosno"});
        data.add(new Object[]{"Michał Przypek", "michas1337gamer@o2.pl", "753190257", "Warszawa"});
        data.add(new Object[]{"Monika Smoła", "smolasmoni@wp.pl", "987652165", "Stalowa wola"});
        stworzTabele();

        UIManager.put("OptionPane.messageFont", new Font("Centaur", Font.PLAIN, 28));
        UIManager.put("OptionPane.messageForeground", new Color(0,0,0));
        UIManager.put("OptionPane.background", new Color(147,239,152));
        UIManager.put("Panel.background", new Color(147,239,152));
        UIManager.put("Button.background", new Color(65,7,0));
        UIManager.put("Button.foreground", new Color(255,255,255));
        UIManager.put("Button.font", new Font("Centaur", Font.PLAIN, 28));

        buttonDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { setButtonDelete(); }
        });

        buttonAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { setButtonAdd(); }
        });

        buttonClear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { setButtonClear(); }
        });
    }

    private void setButtonDelete()
    {
        int indeks = tableClients.getSelectedRow();
        if (indeks == -1)
            JOptionPane.showMessageDialog(null, "No row selected", "No row selected", JOptionPane.WARNING_MESSAGE);
        else
        {
            data.remove(indeks);
            stworzTabele();
            JOptionPane.showMessageDialog(null, "Data deleted", "Data deleted", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void setButtonClear()
    {
        setTextNull();
        JOptionPane.showMessageDialog(null, "Fields cleared", "Fields cleared", JOptionPane.INFORMATION_MESSAGE);
    }

    private void setButtonAdd()
    {
        String name = textFieldName.getText();
        String email = textFieldEmail.getText();
        String phone = textFieldPhone.getText();
        String address = textFieldAddress.getText();
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty())
            JOptionPane.showMessageDialog(null, "Complete all fields", "Complete all fields", JOptionPane.WARNING_MESSAGE);
        else
        {
            data.add(new Object[]{name, email, phone, address});
            stworzTabele();
            setTextNull();
            JOptionPane.showMessageDialog(null, "New data added", "New data added", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void setTextNull()
    {
        textFieldName.setText("");
        textFieldAddress.setText("");
        textFieldPhone.setText("");
        textFieldEmail.setText("");
    }

    private void stworzTabele()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Name","Email","Phone","Address"});
        for (Object[] row : data) { model.addRow(row); }
        tableClients.setModel(model);
        tableClients.setEnabled(true);
        tableClients.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = tableClients.getColumnModel();
        columnModel.getColumn(0).setMinWidth(200);
        columnModel.getColumn(1).setMinWidth(300);
        columnModel.getColumn(2).setMinWidth(100);
        columnModel.getColumn(3).setMinWidth(200);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(cellRenderer);
        columnModel.getColumn(1).setCellRenderer(cellRenderer);
        columnModel.getColumn(2).setCellRenderer(cellRenderer);
        columnModel.getColumn(3).setCellRenderer(cellRenderer);
    }
}
