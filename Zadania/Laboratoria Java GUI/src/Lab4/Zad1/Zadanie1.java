package Lab4.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;

public class Zadanie1 extends JFrame
{
    private JPanel JMainPanel;
    private JLabel lista1Label;
    private JLabel lista2Label;
    private JButton button4;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane1;
    private JList list1;
    private JList list2;
    private JButton dodawanie1Button;
    private JButton usuwanieButton;
    private JTextField textField;
    private JButton dodawanie2Button;

    public static void main(String[] args)
    {
        Zadanie1 zadanie1GUI = new Zadanie1();
        zadanie1GUI.setVisible(true);
    }

    public Zadanie1()
    {
        super("Zadanie 1");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1205, 800));
        this.setLocationRelativeTo(null);
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiar

        DefaultListModel<String> modelList1 = (DefaultListModel<String>) list1.getModel();
        DefaultListModel<String> modelList2 = (DefaultListModel<String>) list2.getModel();

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (list1.getSelectedIndex() != -1)
                {
                    modelList2.addElement((String) list1.getSelectedValue());
                    modelList1.remove(list1.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Przeniesiono element z listy 1 do listy 2", "Przeniesiono element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (modelList1.getSize() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Brak elementów do przeniesienia z listy 1", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnego elementu w liście 1", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (modelList1.getSize() != 0)
                {
                    for (int i = modelList1.getSize() - 1; i >= 0; i--)
                    {
                        modelList2.addElement(modelList1.get(i));
                        modelList1.remove(i);
                    }
                    JOptionPane.showMessageDialog(null, "Przeniesiono wszystkie elementy z listy 1 do listy 2", "Przeniesiono elementy!", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Brak elementów do przeniesienia z listy 1", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
            }
        });

        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (list2.getSelectedIndex() != -1)
                {
                    modelList1.addElement((String) list2.getSelectedValue());
                    modelList2.remove(list2.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Przeniesiono element z listy 2 do listy 1", "Przeniesiono element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (modelList2.getSize() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Brak elementów do przeniesienia z listy 2", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnego elementu w liście 2", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (modelList2.getSize() != 0)
                {
                    for (int i = modelList2.getSize() - 1; i >= 0; i--)
                    {
                        modelList1.addElement(modelList2.get(i));
                        modelList2.remove(i);
                    }
                    JOptionPane.showMessageDialog(null, "Przeniesiono wszystkie elementy z listy 2 do listy 1", "Przeniesiono elementy!", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Brak elementów do przeniesienia z listy 2", "Nie przeniesiono żadnego elementu!", JOptionPane.WARNING_MESSAGE);
            }
        });

        dodawanie1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tekst = textField.getText();
                if (!tekst.isEmpty())
                {
                    modelList1.addElement(tekst);
                    textField.setText("");
                    JOptionPane.showMessageDialog(null, "Dodano element do listy 1", "Dodano element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Nie wprowadzono żadnego tekstu do pola tekstowego", "Brak danych!", JOptionPane.ERROR_MESSAGE);
            }
        });

        dodawanie2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tekst = textField.getText();
                if (!tekst.isEmpty())
                {
                    modelList2.addElement(tekst);
                    textField.setText("");
                    JOptionPane.showMessageDialog(null, "Dodano element do listy 2", "Dodano element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Nie wprowadzono żadnego tekstu do pola tekstowego", "Brak danych!", JOptionPane.ERROR_MESSAGE);
            }
        });

        usuwanieButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (list1.getSelectedIndex() != -1 && list2.getSelectedIndex() != -1)
                {
                    JOptionPane.showMessageDialog(null, "Nie usunięto żadnego elementu z listy, gdyż maksymalnie może być zaznaczony jeden obiekt do usunięcia", "Nie usunięto żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
                else if (list1.getSelectedIndex() != -1)
                {
                    modelList1.remove(list1.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Usunięto element z listy 1", "Usunięto element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (list2.getSelectedIndex() != -1)
                {
                    modelList2.remove(list2.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Usunięto element z listy 2", "Usunięto element!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nie usunięto żadnego elementu z listy, gdyż żaden element nie jest zaznaczony", "Nie usunięto żadnego elementu!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        list2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) { list1.clearSelection(); }
        });

        list1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) { list2.clearSelection(); }
        });
    }
}
