package ui;

import javax.swing.*;

public class PokemonImageLbl extends JLabel {

    public PokemonImageLbl(ImageIcon imageIcon, int x, int y, int width, int height) {
        setIcon(imageIcon);
        setBounds(x, y, width, height);
    }

}
