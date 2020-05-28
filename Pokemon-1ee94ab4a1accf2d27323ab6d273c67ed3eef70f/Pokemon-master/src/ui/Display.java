package ui;

import abilities.FireBreath;
import abilities.Punch;
import pokemon.Pokemon;
import pokemon.PokemonName;

import javax.swing.*;

public class Display extends JFrame {
    Pokemon charmander;
    public Display() throws Exception {
       setUpDisplay();
    }

    private void setUpDisplay() throws Exception {
        setSize(Constants.GAME_WIDTH,Constants.GAME_HEIGHT);
        charmander = new Pokemon("Charmander",30,30,30,pokemon.Type.FIRE,new Punch(),new FireBreath(), PokemonName.CHARMANDER);
        setContentPane(new ArenaPanel(charmander));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}