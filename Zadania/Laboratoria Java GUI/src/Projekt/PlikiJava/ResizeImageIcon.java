package Projekt.PlikiJava;

import javax.swing.*;
import java.awt.*;

public interface ResizeImageIcon
{
    static ImageIcon resize(ImageIcon src, int destWidth, int destHeight)
    {
        double widthRatio = (double) destWidth / src.getIconWidth();
        double heightRatio = (double) destHeight / src.getIconHeight();
        double ratio = Math.max(widthRatio, heightRatio);

        int scaledWidth = (int) (src.getIconWidth() * ratio);
        int scaledHeight = (int) (src.getIconHeight() * ratio);

        return new ImageIcon(src.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH));
    }
}
