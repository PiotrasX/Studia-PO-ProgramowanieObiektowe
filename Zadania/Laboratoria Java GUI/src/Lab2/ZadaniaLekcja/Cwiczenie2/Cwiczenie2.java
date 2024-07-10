package Lab2.ZadaniaLekcja.Cwiczenie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Cwiczenie2 extends JFrame
{
    private JPanel JMainPanel;
    private JRadioButton linuxRadioButton;
    private JRadioButton windowsRadioButton;
    private JRadioButton macOSRadioButton;
    private JPanel JButtonPanel;
    private JPanel JImagePanel;
    private JLabel iconLabel;
    private JPanel JButton2Panel;
    private JButton okButton;
    private final ImageIcon iconLinux = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaCwiczenie2\\linux.png")));
    private final ImageIcon iconWindows = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaCwiczenie2\\windows.png")));
    private final ImageIcon iconMacOS = new ImageIcon(Objects.requireNonNull(getClass().getResource("ZdjeciaCwiczenie2\\apple.png")));

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight)
    {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args)
    {
        Cwiczenie2 cwiczenie2GUI = new Cwiczenie2();
        cwiczenie2GUI.setVisible(true);
    }

    public Cwiczenie2()
    {
        super("System operacyjny");
        this.setContentPane(this.JMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 350));
        this.setLocationRelativeTo(null); // Okno GUI pojawia się na środku ekranu
        // this.setResizable(false); // Okno GUI nie może zmieniać wymiaru

        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selectOption = "";
                if (linuxRadioButton.isSelected()) selectOption="Linux";
                if (windowsRadioButton.isSelected()) selectOption="Windows";
                if (macOSRadioButton.isSelected()) selectOption="MacOS";
                JOptionPane.showMessageDialog(Cwiczenie2.this, "Wybrano system: " + selectOption, "Wybór systemu informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (linuxRadioButton.isSelected()) iconLabel.setIcon(resize(iconLinux,120,120));
                if (windowsRadioButton.isSelected()) iconLabel.setIcon(resize(iconWindows,120,120));
                if (macOSRadioButton.isSelected()) iconLabel.setIcon(resize(iconMacOS,120,120));
            }
        };
        linuxRadioButton.addActionListener(listener);
        windowsRadioButton.addActionListener(listener);
        macOSRadioButton.addActionListener(listener);
    }
}
