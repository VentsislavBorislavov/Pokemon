package ui;

import javax.swing.*;
import java.awt.*;

public class AbilityButton extends JButton {
    public AbilityButton(int x, int y, int width,int height) {
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
    }
}
