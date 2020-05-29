package ui.panels;

import ui.components.GameButton;

import javax.swing.*;

public class PlayPanel extends JPanel {
    private JButton button;
    private boolean isGameStarted = false;
    public PlayPanel(){
        setLayout(null);
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
