package ui;

import abilities.FireBreath;
import abilities.Punch;
import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonName;

import javax.swing.*;

public class Display extends JFrame {
    private Pokemon charmander;
    private Player player = new Player();
    private Timer timer;
    private ArenaPanel arenaPanel;

    public Display() throws Exception {
       setUpDisplay();
    }

    private void setUpDisplay() throws Exception {
        setSize(Constants.GAME_WIDTH,Constants.GAME_HEIGHT);
        charmander = new Pokemon("Charmander",30,30,30,pokemon.Type.FIRE,new Punch(),new FireBreath(), PokemonName.CHARMANDER);
        setTitle("Pokemon Tournament");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        arenaPanel= new ArenaPanel(charmander);
//        setContentPane(arenaPanel);
        add(arenaPanel);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        timer = new Timer(100,new GameLoop(this));
    }

    public void doOneLoop() {
        System.out.println(arenaPanel.getPokemonHealth());
    }
}