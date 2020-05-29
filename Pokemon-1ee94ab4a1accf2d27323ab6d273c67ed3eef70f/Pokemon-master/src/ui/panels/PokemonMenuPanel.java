package ui.panels;

import pokemon.Player;
import ui.components.GameButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonMenuPanel extends JPanel implements ActionListener {
    private GameButton statsBtn;
    private GameButton continueBtn;
    private JLabel label;
    private Player player;
    private StatsScreen statsScreen;
    private boolean continueForward = false;

    public PokemonMenuPanel( Player player){
        setLayout(null);
        this.player = player;

        label = new JLabel("You won the fight. This is the player menu");
        label.setBounds(175, 0 , 200,30);


        statsBtn = new GameButton(200,70,200,30);
        continueBtn = new GameButton(250,390,100,30);

        statsBtn.setText("See Pokemon Stats");
        continueBtn.setText("Continue");
        statsBtn.addActionListener(this);
        continueBtn.addActionListener(this);

        add(statsBtn);
        add(continueBtn);
        add(label);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getContinueForward(){
        return continueForward;
    }

    public void reset(){
        continueForward = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == statsBtn){
            statsScreen = new StatsScreen(player);
            statsScreen.setVisible(true);
        }

        if(e.getSource()==continueBtn){
            continueForward = true;
        }
    }
}
