package ui;

import javax.swing.*;

public class PlayPanel extends JPanel {
    private JButton button;
    private boolean isGameStarted = false;
    public PlayPanel(){
        setLayout(null);
        button = new JButton("Play");
        button.setBounds(250,250,50,50);
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
