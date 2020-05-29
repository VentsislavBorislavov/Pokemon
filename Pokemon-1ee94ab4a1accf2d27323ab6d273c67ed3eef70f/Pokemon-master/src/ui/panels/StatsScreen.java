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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StatsScreen extends JFrame implements ActionListener {

    private int pokemonIndex = 0;
    private JLabel image;
    private GameButton switchBtn;
    private Player player;
    private JLabel result;
    private GameButton healBtn;
    Timer timer;

    public StatsScreen(Player player) {
        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setTitle("Pokemon Stats");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        healBtn = new GameButton(360, 360, 100, 30);
        healBtn.setText("Heal");
        healBtn.addActionListener(this);

        this.player = player;

        result = new JLabel();
        result.setBounds(360, 180, 200, 200);
        result.setForeground(Color.BLACK);
        timer = new Timer(10, new GameLoop(this));

        image = new JLabel(new ImageIcon(Constants.PIKACHU_IMAGE_URL));
        image.setBounds(110, 180, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
        switchBtn = new GameButton(130, 360, 100, 30);
        switchBtn.setText("Switch");
        switchBtn.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == switchBtn) {
            if (pokemonIndex < player.getPokemons().size() - 1)
                pokemonIndex++;
            else pokemonIndex = 0;
        }
        if(e.getSource() == healBtn){
            if(player.getCrystals()>0){
                System.out.println(player.getCrystals());
                player.getPokemons().get(pokemonIndex).heal();
                player.useCrystal();
            }
        }
    }
}
