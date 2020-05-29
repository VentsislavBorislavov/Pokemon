package ui;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonChooser extends JPanel implements ActionListener {

    private Player player;
    private PokemonImageLbl[] pokemonImageLbls = new PokemonImageLbl[5];
    private int[] choosedPokemons = {0, 0, 0, 0, 0};
    private JButton[] chooseBtns = new JButton[5];
    Pokemon[] pokemons = new Pokemon[5];

    public PokemonChooser(Player player) {
        setLayout(null);
        ImageIcon[] images = new ImageIcon[5];
        pokemons[0] = PokemonsList.getBulbasaur();
        pokemons[1] = PokemonsList.getDiglett();
        pokemons[2] = PokemonsList.getCharmander();
        pokemons[3] = PokemonsList.getPikachu();
        pokemons[4] = PokemonsList.getSquirtle();
        pokemonImageLbls[0] = new PokemonImageLbl(images[0], 0, 0, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
        pokemonImageLbls[1] = new PokemonImageLbl(images[1], 180, 0, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
        pokemonImageLbls[2] = new PokemonImageLbl(images[2], 360, 0, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
        pokemonImageLbls[3] = new PokemonImageLbl(images[3], 0, 180, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
        pokemonImageLbls[4] = new PokemonImageLbl(images[4], 180, 180, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);

        for (int i = 0; i < pokemonImageLbls.length; i++) {
            setUpButtons(i);
            add(chooseBtns[i]);
            add(pokemonImageLbls[i]);
        }
    }

    private void setUpButtons(int i) {
        chooseBtns[i] = new JButton();
        chooseBtns[i].addActionListener(this);
        chooseBtns[i].setOpaque(false);
        chooseBtns[i].setContentAreaFilled(false);
        chooseBtns[i].setBorderPainted(false);
        chooseBtns[i].setBounds(pokemonImageLbls[i].getBounds());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtns[0]) {
            if (player.getPokemons().size() <= 3 && choosedPokemons[4] == 0) {
                player.addPokemon(PokemonsList.getBulbasaur());
                choosedPokemons[0] = 1;
            } else if (choosedPokemons[0] == 1) {
                player.removePokemon();
            }
        }
        if (e.getSource() == chooseBtns[1]) {
            if (player.getPokemons().size() <= 3 && choosedPokemons[4] == 0) {
                player.addPokemon(PokemonsList.getDiglett());
                choosedPokemons[1] = 1;
            } else if (choosedPokemons[1] == 1) {
                player.removePokemon();
            }
        }
        if (e.getSource() == chooseBtns[2]) {
            if (player.getPokemons().size() <= 3 && choosedPokemons[4] == 0) {
                player.addPokemon(PokemonsList.getCharmander());
                choosedPokemons[2] = 1;
            } else if (choosedPokemons[2] == 1) {
                player.removePokemon();
            }
        }
        if (e.getSource() == chooseBtns[3]) {
            if (player.getPokemons().size() <= 3 && choosedPokemons[4] == 0) {
                player.addPokemon(PokemonsList.getPikachu());
                choosedPokemons[3] = 1;
            } else if (choosedPokemons[3] == 1) {
                player.removePokemon();
            }
        }
        if (e.getSource() == chooseBtns[4]) {
            if (player.getPokemons().size() <= 3 && choosedPokemons[4] == 0) {
                player.addPokemon(PokemonsList.getSquirtle());
                choosedPokemons[4] = 1;
            } else if (choosedPokemons[4] == 1) {
                player.removePokemon();
            }
        }
    }
}
