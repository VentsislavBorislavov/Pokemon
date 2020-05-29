package ui.components;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    public GameButton(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
    }
}
