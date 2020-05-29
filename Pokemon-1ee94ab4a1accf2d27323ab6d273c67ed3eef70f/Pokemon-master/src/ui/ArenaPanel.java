package ui;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ArenaPanel extends JPanel {

    private AbilityButton abilityButton1;
    private AbilityButton ablitiyButton2;
    private JPanel dialoguePanel;
    private JLabel dialogueLabel;
    private Pokemon pokemon;
    private JLabel pokemonPicLbl;
    Timer timer;

    public ArenaPanel(Pokemon pokemon) throws Exception {
        this.pokemon = pokemon;
        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        setLayout(null);
        String ability1Name = pokemon.getAbilityList().get(0).getAbilityName();
        String ability2Name = pokemon.getAbilityList().get(1).getAbilityName();

        abilityButton1 = new AbilityButton(400,400,100,30);
        abilityButton1.addActionListener(e -> pokemon.takeDamage(30));
        ablitiyButton2 = new AbilityButton(400,440,100,30);

        dialogueLabel = new JLabel();
        dialogueLabel.setBounds(60, 400, 310, 70);
        dialogueLabel.setForeground(Color.BLACK);

        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(40, 400, 310, 70);
        dialoguePanel.setBackground(Color.GRAY);

        pokemonPicLbl = new JLabel(new ImageIcon(PokemonImageCreator.getPokemonImage(pokemon.getPokemonName())));
        pokemonPicLbl.setBounds(40, 180, 180, 180);

        timer = new Timer(10,new GameLoop(this));
        timer.start();

        add(dialogueLabel);
        add(dialoguePanel);
        add(abilityButton1);
        add(ablitiyButton2);
        add(pokemonPicLbl);
    }


    public void doOneLoop() {
        update();
    }
    private void update(){
        pokemonPicLbl.setIcon(new ImageIcon(PokemonImageCreator.getPokemonImage(pokemon.getPokemonName())));
        abilityButton1.setText(pokemon.getAbilityList().get(0).getAbilityName());
        ablitiyButton2.setText(pokemon.getAbilityList().get(1).getAbilityName());
    }

    public int getPokemonHealth(){
        return (int) pokemon.getHealth();
    }
}
