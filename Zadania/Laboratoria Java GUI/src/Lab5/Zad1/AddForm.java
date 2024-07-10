package Lab5.Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddForm extends JFrame
{
    private JPanel JMainPanel;
    private JTextField textFieldTitle;
    private JTextField textFieldExpDate;
    private JComboBox comboBoxPriority;
    private JLabel labelAddTask;
    private JLabel labelTitle;
    private JLabel labelPriority;
    private JLabel labelExpDate;
    private JButton buttonAddNewTask;
    private JButton buttonCancel;
    private Object[] dane = new Object[3];
    private int indexDane = -1;
    private String listObjectName = "ToDo";

    public static void main(String[] args)
    {
        AddForm addFormGUI = new AddForm();
        addFormGUI.setVisible(true);
    }

    public AddForm()
    {
        super("Add Form");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        actionListener();
    }

    public AddForm(Object[] dane, int indexDane, String listObjectName)
    {
        super("Edit Form");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 800));
        this.setLocationRelativeTo(null);
        actionListener();
        labelAddTask.setText("Edit task");
        buttonAddNewTask.setText("Edit task");
        this.dane = dane;
        this.indexDane = indexDane;
        this.listObjectName = listObjectName;
        textFieldTitle.setText((String) dane[0]);
        comboBoxPriority.setSelectedItem(dane[1]);
        textFieldExpDate.setText((String) dane[2]);
    }

    public void actionListener()
    {
        buttonAddNewTask.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                Date dateToday = new Date();
                String yearToday = dateFormat.format(dateToday).substring(0,4);
                String monthToday = dateFormat.format(dateToday).substring(5,7);
                String dayToday = dateToday.toString().substring(8,10);

                String title = textFieldTitle.getText();
                String date = textFieldExpDate.getText();
                if (title.isEmpty() && date.isEmpty())
                    { JOptionPane.showMessageDialog(null, "Complete the 'Title' field and 'Exp date' field", "Data error!", JOptionPane.ERROR_MESSAGE); }
                else if (title.isEmpty())
                    { JOptionPane.showMessageDialog(null, "Complete the 'Title' field", "Data error!", JOptionPane.ERROR_MESSAGE); }
                else if (date.isEmpty())
                    { JOptionPane.showMessageDialog(null, "Complete the 'Exp date' field", "Data error!", JOptionPane.ERROR_MESSAGE); }
                else if ((date.length() != 10) || (date.charAt(4) != '.') || (date.charAt(7) != '.'))
                    { JOptionPane.showMessageDialog(null, "Complete the 'Exp date' in the format yyyy.mm.dd", "Data error!", JOptionPane.ERROR_MESSAGE); }
                else
                {
                    if (isValidDate(date, dateFormat))
                    {
                        Date dateYou;
                        try { dateYou = dateFormat.parse(date); }
                        catch (ParseException ex) { throw new RuntimeException(ex); }
                        String year = date.substring(0,4);
                        String month = date.substring(5,7);
                        String day = date.substring(8,10);
                        if (dateToday.before(dateYou) || (year.equals(yearToday) && month.equals(monthToday) && day.equals(dayToday)))
                        {
                            JOptionPane.showMessageDialog(null, "The correct data", "Correct data!", JOptionPane.INFORMATION_MESSAGE);
                            dane = new Object[]{title, comboBoxPriority.getSelectedItem(), date};
                            Kanban kanbanGUI = new Kanban(dane, listObjectName, indexDane);
                            kanbanGUI.setVisible(true);
                            dispose();
                        }
                        else { JOptionPane.showMessageDialog(null, "The task end date cannot be earlier than today's date", "Data error!", JOptionPane.ERROR_MESSAGE); }
                    }
                    else { JOptionPane.showMessageDialog(null, "The date provided is incorrect", "Data error!", JOptionPane.ERROR_MESSAGE); }
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Kanban kanbanGUI = new Kanban();
                kanbanGUI.setVisible(true);
                dispose();
            }
        });
    }

    public boolean isValidDate(String date, DateFormat dateFormat)
    {
        dateFormat.setLenient(false);
        try { dateFormat.parse(date); return true; }
        catch (ParseException e) { return false; }
    }
}
