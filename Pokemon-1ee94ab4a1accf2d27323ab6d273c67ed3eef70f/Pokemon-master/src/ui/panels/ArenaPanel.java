package ui.panels;

import pokemon.Player;
import pokemon.Pokemon;
import ui.components.Constants;
import ui.components.GameButton;
import ui.components.GameLoop;
import ui.components.PokemonImageCreator;

import javax.swing.*;
import java.awt.*;

public class ArenaPanel extends JPanel {

    private GameButton abilityButton1;
    private GameButton ablitiyButton2;
    private JButton switchBtn;
    private JPanel dialoguePanel;
    private JLabel dialogueLabel;
    private JLabel pokemonPicLbl;
    private Player player;
    private boolean isOver = false;
    private int indexOfPokemon = 0;
    private Timer timer;
    private Pokemon pokemon;
    private JLabel pokemonHealthPoints;
    private JLabel enemyPokemonHealthPoints;
    private Pokemon enemyPokemon;
    private String enemyName;

    public ArenaPanel(Player player, Pokemon enemyPokemon, String enemyName) {
        this.player = player;
        this.enemyPokemon = enemyPokemon;
        this.enemyName = enemyName;

        pokemonHealthPoints = new JLabel();
        pokemonHealthPoints.setBounds(220, 330, 60, 30);
        pokemonHealthPoints.setForeground(Color.green);
        enemyPokemonHealthPoints = new JLabel();


        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        setLayout(null);

        pokemon = player.getPokemons().get(indexOfPokemon);

        switchBtn = new GameButton(400,360,100,30);
        switchBtn.setText("Switch");
        switchBtn.addActionListener(e -> {
            if(indexOfPokemon< player.getPokemons().size() - 1)
            indexOfPokemon++;
            else indexOfPokemon = 0;
        });

        abilityButton1 = new GameButton(400, 400, 100, 30);
        abilityButton1.addActionListener(e -> player.getPokemons().get(indexOfPokemon).takeDamage(10));
        ablitiyButton2 = new GameButton(400, 440, 100, 30);
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
        add(pokemonHealthPoints);
        add(switchBtn);

        timer.start();
    }


    public void doOneLoop() {
        update();
    }

    private void update() {
        if (player.getPokemons().size() > 0) {

            pokemon = player.getPokemons().get(indexOfPokemon);
            String healthPoints = "" + pokemon.getHealth();
            pokemonHealthPoints.setText(healthPoints);
            pokemonPicLbl.setIcon(new ImageIcon(PokemonImageCreator.getPokemonImage(pokemon.getPokemonType())));
            abilityButton1.setText(pokemon.getAbilityList().get(0).getAbilityName());
            ablitiyButton2.setText(pokemon.getAbilityList().get(1).getAbilityName());
            diePokemon();
            if(player.getPokemons().size()==0){
                isOver = true;
            }
        }
    }

    private void diePokemon(){
        if(player.getPokemons().get(indexOfPokemon).getHealth() <= 0){
            player.removePokemon(player.getPokemons().get(indexOfPokemon));
            indexOfPokemon = 0;
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public void resetOver() {
        isOver = false;
    }

    public Player getPlayer() {
        return player;
    }
}
