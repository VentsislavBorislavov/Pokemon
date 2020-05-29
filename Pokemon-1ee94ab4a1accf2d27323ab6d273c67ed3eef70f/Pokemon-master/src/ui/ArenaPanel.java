package ui;

import pokemon.Player;
import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class ArenaPanel extends JPanel {

    private AbilityButton abilityButton1;
    private AbilityButton ablitiyButton2;
    private JPanel dialoguePanel;
    private JLabel dialogueLabel;
    private JLabel pokemonPicLbl;
    private Player player;
    private boolean isOver = false;
    private int indexOfPokemon = 0;
    private Timer timer;
    private Pokemon pokemon;

    public ArenaPanel(Player player) throws Exception {
        this.player = player;
        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        setLayout(null);

        abilityButton1 = new AbilityButton(400, 400, 100, 30);
        abilityButton1.addActionListener(e -> System.out.println("Clicked"));
        ablitiyButton2 = new AbilityButton(400, 440, 100, 30);
        ablitiyButton2.addActionListener(e -> System.out.println("Clicked"));

        dialogueLabel = new JLabel();
        dialogueLabel.setBounds(60, 400, 310, 70);
        dialogueLabel.setForeground(Color.BLACK);

        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(40, 400, 310, 70);
        dialoguePanel.setBackground(Color.GRAY);

        pokemonPicLbl = new JLabel(new ImageIcon(Constants.PIKACHU_IMAGE_URL));
        pokemonPicLbl.setBounds(40, 180, 180, 180);

        timer = new Timer(10, new GameLoop(this));

        add(dialogueLabel);
        add(dialoguePanel);
        add(abilityButton1);
        add(ablitiyButton2);
        add(pokemonPicLbl);

        timer.start();
    }


    public void doOneLoop() {
        update();
    }

    private void update() {
        if(player.getPokemons().size()>0) {
            pokemon = player.getPokemons().get(indexOfPokemon);
            pokemonPicLbl.setIcon(new ImageIcon(PokemonImageCreator.getPokemonImage(pokemon.getPokemonName())));
            abilityButton1.setText(pokemon.getAbilityList().get(0).getAbilityName());
            ablitiyButton2.setText(pokemon.getAbilityList().get(1).getAbilityName());
            if (pokemon.getHealth() == 0) {
                isOver = true;
            }
        }
    }

    public boolean isOver() {
        return isOver;
    }
}
