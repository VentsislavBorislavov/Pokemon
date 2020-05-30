package ui.panels;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;
import ui.components.Constants;
import ui.components.PokemonImageCreator;
import ui.components.PokemonImageLbl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonChooserPanel extends JPanel implements ActionListener {

    private Player player;
    private PokemonImageLbl[] pokemonImageLbls = new PokemonImageLbl[5];
    private int[] choosedPokemons = new int[]{0, 0, 0, 0, 0};
    private JButton[] chooseBtns = new JButton[5];
    PokemonsList pokemonList = new PokemonsList();
    private Pokemon[] pokemons = new Pokemon[5];
    private JButton continueBtn;
    private JLabel askForNameLbl;
    private JTextField nameField;
    private boolean hasPlayerPickedLoadout = false;

    public PokemonChooserPanel(Player player) {
        setLayout(null);
        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));

        this.player = player;

        ImageIcon[] images = new ImageIcon[5];
        continueBtn = new JButton("Continue");
        continueBtn.setVisible(false);
        continueBtn.setBounds(250,0,100,30);
        continueBtn.addActionListener(this);

        askForNameLbl = new JLabel("Your name:");
        askForNameLbl.setBounds(10,0,100,30);

        nameField = new JTextField();
        nameField.setBounds(120,0,100,30);

        pokemons[0] = pokemonList.getBulbasaur();
        pokemons[1] = pokemonList.getDiglett();
        pokemons[2] = pokemonList.getCharmander();
        pokemons[3] = pokemonList.getPikachu();
        pokemons[4] = pokemonList.getSquirtle();

        int x = 30, y = 120;
        for (int i = 0; i < pokemons.length; i++) {
            images[i] = new ImageIcon(PokemonImageCreator.getPokemonImage(pokemons[i].getPokemonType()));
            if (x > 420) {
                x = 120;
                y += 180;
            }
            pokemonImageLbls[i] = new PokemonImageLbl(images[i], x, y);
            x += 180;

            setUpButtons(i);
            add(chooseBtns[i]);
            add(pokemonImageLbls[i]);
        }
        add(askForNameLbl);
        add(nameField);
        add(continueBtn);
    }

    private void setUpButtons(int i) {
        chooseBtns[i] = new JButton();
        chooseBtns[i].addActionListener(this);
        chooseBtns[i].setOpaque(false);
        chooseBtns[i].setContentAreaFilled(false);
        chooseBtns[i].setBorderPainted(false);
        chooseBtns[i].setBounds(pokemonImageLbls[i].getBounds());
    }

    public boolean hasPlayerPickedLoadout() {
        return hasPlayerPickedLoadout;
    }

    public void setHasPlayerPickedLoadout() {
        this.hasPlayerPickedLoadout = false;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < chooseBtns.length; i++) {
            if (e.getSource() == chooseBtns[i]) {
                Pokemon pokemon = pokemons[i];
                if (choosedPokemons[i] == 0 && player.getPokemons().size() <= 3) {
                    player.addPokemon(pokemon);
                    choosedPokemons[i] = 1;
                    pokemonImageLbls[i].setBorder(BorderFactory.createLineBorder(Color.green));
                } else if (choosedPokemons[i] == 1) {
                    player.getPokemons().remove(pokemons[i]);
                    choosedPokemons[i] = 0;
                    pokemonImageLbls[i].setBorder(null);
                }
                if (player.getPokemons().size() == 3) {
                    continueBtn.setVisible(true);
                } else continueBtn.setVisible(false);
            }
        }
        if(e.getSource()==continueBtn){
            player.setPlayerName(nameField.getText());
            hasPlayerPickedLoadout = true;
        }
    }
}
