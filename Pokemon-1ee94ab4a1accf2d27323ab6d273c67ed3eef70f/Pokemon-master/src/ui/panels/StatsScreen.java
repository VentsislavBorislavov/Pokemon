package ui.panels;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonStats;
import ui.components.Constants;
import ui.components.GameButton;
import ui.components.GameLoop;
import ui.components.PokemonImageCreator;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;

public class StatsScreen extends JFrame {

    private int pokemonIndex = 0;
    private JLabel image;
    private GameButton switchBtn;
    private Player player;
    private JLabel result;
    private GameButton healBtn;
    Timer timer;

    public StatsScreen(Player player){
        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setTitle("Pokemon Stats");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        healBtn = new GameButton(180,360,100,30);
        healBtn.setText("Heal");

        this.player = player;

        result = new JLabel();
        result.setBounds(250,180,200,200);
        result.setForeground(Color.BLACK);
        timer = new Timer(10,new GameLoop(this));

        image = new JLabel(new ImageIcon(Constants.PIKACHU_IMAGE_URL));
        image.setBounds(0,180,Constants.POKEMON_WIDTH,Constants.POKEMON_HEIGHT);
        switchBtn = new GameButton(0,360,100,30);
        switchBtn.setText("Switch");
        switchBtn.addActionListener(e -> {
            if(pokemonIndex< player.getPokemons().size() - 1)
                pokemonIndex++;
            else pokemonIndex = 0;
        });

        add(image);
        add(switchBtn);
        add(result);
        add(healBtn);

        timer.start();

    }

    public void doOneLoop() {
        image.setIcon(new ImageIcon(PokemonImageCreator.getPokemonImage(player.getPokemons().get(pokemonIndex).getPokemonType())));
        result.setText(PokemonStats.getPokemonStats(player.getPokemons().get(pokemonIndex)));
    }
}
