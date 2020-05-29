package ui.panels;

import ui.components.GameButton;

import javax.swing.*;
import java.awt.*;

public class FinalPanel extends JPanel {
    protected JLabel label;
    protected GameButton playAgain;
    protected boolean wantToPlayAgain = false;


    public void setUp(){
        setLayout(null);
        label = new JLabel();
        label.setForeground(Color.BLACK);
        label.setBounds(100,200,400,100);

        playAgain = new GameButton(225,300,150,30);
        playAgain.setText("Play Again");
        playAgain.addActionListener(e -> wantToPlayAgain = true);

        add(playAgain);
        add(label);
    }

    public boolean wantToPlayAgain() {
        return wantToPlayAgain;
    }

    public void reset() {
        this.wantToPlayAgain = false;
    }
}
