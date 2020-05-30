package ui.panels;

import ui.components.Constants;
import ui.components.GameButton;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    private JButton button;
    private boolean isGameStarted = false;
    public PlayPanel(){
        setLayout(null);
        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        button = new GameButton(250,275,100,30);
        button.setText("Play");
        button.addActionListener(e -> isGameStarted = true);
        add(button);
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted() {
        isGameStarted = false;
    }
}
