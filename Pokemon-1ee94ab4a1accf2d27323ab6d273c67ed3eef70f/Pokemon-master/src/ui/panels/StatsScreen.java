package ui.panels;

import pokemon.Player;
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
    private GameButton setPokemonNameBtn;
    private JTextField renamePokemonField;
    Timer timer;

    public StatsScreen(Player player) {
        setSize(Constants.GAME_WIDTH- 100, Constants.GAME_HEIGHT - 100);
        setTitle("Pokemon Stats");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setPokemonNameBtn = new GameButton(310,400,100,30);
        setPokemonNameBtn.setText("Rename");
        setPokemonNameBtn.addActionListener(this);

        renamePokemonField = new JTextField();
        renamePokemonField.setBounds(310,350,100,30);

        healBtn = new GameButton(310, 310, 100, 30);
        healBtn.setText("Heal");
        healBtn.addActionListener(this);

        this.player = player;

        result = new JLabel();
        result.setBounds(310, 130, 200, 200);
        result.setForeground(Color.BLACK);
        timer = new Timer(10, new GameLoop(this));

        image = new JLabel(new ImageIcon(Constants.PIKACHU_IMAGE_URL));
        image.setBounds(70, 130, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);

        switchBtn = new GameButton(80, 310, 100, 30);
        switchBtn.setText("Switch");
        switchBtn.addActionListener(this);

        add(image);
        add(switchBtn);
        add(result);
        add(healBtn);
        add(setPokemonNameBtn);
        add(renamePokemonField);
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
        if(e.getSource() == setPokemonNameBtn){
            player.getPokemons().get(pokemonIndex).setName(renamePokemonField.getText());
        }
    }
}
