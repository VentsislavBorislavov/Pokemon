package ui.panels;

import pokemon.Player;
import pokemon.Pokemon;
import ui.components.GameButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonMenuPanel extends JPanel implements ActionListener {
    GameButton crystalsBtn;
    GameButton statsBtn;
    GameButton continueBtn;
    JLabel label;
    Player player;

    public PokemonMenuPanel( Player player){
        setLayout(null);
        this.player = player;

        label = new JLabel("You won the fight. This is the player menu");
        label.setBounds(175, 0 , 200,30);

        crystalsBtn = new GameButton(250,30,100,30);
        statsBtn = new GameButton(250,210,100,30);
        continueBtn = new GameButton(250,390,100,30);

        crystalsBtn.setText("Use Crystal");
        statsBtn.setText("See Pokemon Stats");
        continueBtn.setText("Continue");
        crystalsBtn.addActionListener(this);
        statsBtn.addActionListener(this);
        continueBtn.addActionListener(this);

        add(crystalsBtn);
        add(statsBtn);
        add(continueBtn);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == crystalsBtn){

        }
        if(e.getSource() == statsBtn){
            new StatsScreen(player);
        }
        if(e.getSource() == crystalsBtn);
    }
}
