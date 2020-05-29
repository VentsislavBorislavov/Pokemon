package ui;

import javax.swing.*;

public class PokemonImageLbl extends JLabel {

    public PokemonImageLbl(ImageIcon imageIcon, int x, int y) {
        setIcon(imageIcon);
        setBounds(x, y, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
    }

}
