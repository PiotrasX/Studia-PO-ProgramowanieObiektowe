package Lab5.ZadaniaLekcja.Przyklad6;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class Przyklad6 extends JFrame
{
    private JPanel JMainPanel;
    private JTextField newTextField = new JTextField(10);
    private JList<String> sourceList = new JList<>(new DefaultListModel<>());
    private JList<String> destList = new JList<>(new DefaultListModel<>());

    public static void main(String[] args)
    {
        Przyklad6 przyklad6GUI = new Przyklad6();
        przyklad6GUI.pack();
        przyklad6GUI.setVisible(true);
    }

    public Przyklad6()
    {
        for (int i = 0; i < 15; i++)
        {
            ((DefaultListModel<String>) sourceList.getModel()).add(i,"A" + i + " ");
            ((DefaultListModel<String>) destList.getModel()).add(i,"B" + i + " ");
        }

        JPanel namePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        JLabel nameLabel = new JLabel("New: ");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        namePanel.add(nameLabel, gbc);
        JTextField newTextField = new JTextField(10);
        namePanel.add(newTextField, gbc);
        namePanel.setPreferredSize(new Dimension(400, 200));
        namePanel.setMinimumSize(new Dimension(200, 100));
        namePanel.setMaximumSize(new Dimension(600, 300));

        Box sourceBox = Box.createVerticalBox();
        JLabel sourceLabel = new JLabel("Source");
        sourceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sourceBox.add(sourceLabel);
        sourceBox.setPreferredSize(new Dimension(200, 100));
        sourceBox.setMinimumSize(new Dimension(100, 50));
        sourceBox.setMaximumSize(new Dimension(300, 150));
        sourceBox.add(new JScrollPane(sourceList));

        Box destBox = Box.createVerticalBox();
        JLabel destLabel = new JLabel("Destination");
        destLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        destBox.add(destLabel);
        destBox.setPreferredSize(new Dimension(200, 100));
        destBox.setMinimumSize(new Dimension(100, 50));
        destBox.setMaximumSize(new Dimension(300, 150));
        destBox.add(new JScrollPane(destList));

        Box listBox = Box.createHorizontalBox();
        listBox.add(sourceBox);
        listBox.add(Box.createHorizontalStrut(50));
        listBox.add(destBox);

        Box allBox = Box.createVerticalBox();
        allBox.add(namePanel);
        allBox.add(Box.createVerticalStrut(30));
        allBox.add(listBox);

        this.getContentPane().add(allBox, BorderLayout.CENTER);

        sourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        destList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        newTextField.setDragEnabled(true);
        sourceList.setDragEnabled(true);
        destList.setDragEnabled(true);

        sourceList.setDropMode(DropMode.INSERT);
        destList.setDropMode(DropMode.INSERT);

        sourceList.setTransferHandler(new ListTransferHandler());
        destList.setTransferHandler(new ListTransferHandler());

        this.setTitle("Java Swing Drag and Drop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 520));
        this.setLocationRelativeTo(null);
    }

    private class ListTransferHandler extends TransferHandler
    {
        @Override
        public int getSourceActions(JComponent c) { return TransferHandler.COPY_OR_MOVE; }

        @Override
        protected Transferable createTransferable(JComponent source)
        {
            JList<String> sourceList = (JList<String>) source;
            String data = sourceList.getSelectedValue();
            Transferable t = new StringSelection(data);
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action)
        {
            @SuppressWarnings("unchecked")
            JList<String> sourceList = (JList<String>) source;
            String movedItem = sourceList.getSelectedValue();
            if (action == TransferHandler.MOVE)
            {
                DefaultListModel<String> listModel = (DefaultListModel<String>) sourceList.getModel();
                listModel.removeElement(movedItem);
            }
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support)
        {
            if (!support.isDrop()) { return false; }
            return support.isDataFlavorSupported(DataFlavor.stringFlavor);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support)
        {
            if (!this.canImport(support)) { return false; }
            Transferable t = support.getTransferable();
            String data = null;
            try
            {
                data = (String) t.getTransferData(DataFlavor.stringFlavor);
                if (data == null) { return false; }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }

            JList.DropLocation dropLocation = (JList.DropLocation) support.getDropLocation();
            int dropIndex = dropLocation.getIndex();
            JList<String> targetList = (JList<String>) support.getComponent();
            DefaultListModel<String> listModel = (DefaultListModel<String>) targetList.getModel();
            if (dropLocation.isInsert()) { listModel.add(dropIndex, data); }
            else { listModel.set(dropIndex, data); }
            return true;
        }
    }
}
