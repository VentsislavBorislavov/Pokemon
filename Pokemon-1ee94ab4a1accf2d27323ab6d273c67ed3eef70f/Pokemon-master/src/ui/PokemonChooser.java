package ui;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonChooser extends JPanel implements ActionListener {

    private Player player;
    private PokemonImageLbl[] pokemonImageLbls = new PokemonImageLbl[5];
    private int[] choosedPokemons = new int[]{0, 0, 0, 0, 0};
    private JButton[] chooseBtns = new JButton[5];
    private Pokemon[] pokemons = new Pokemon[5];
    private JButton continueBtn;
    private boolean hasPlayerPickedLoadout = false;
    public PokemonChooser(Player player) {
        setLayout(null);

        this.player = player;

        ImageIcon[] images = new ImageIcon[5];
        continueBtn = new JButton("Continue");
        continueBtn.setVisible(false);
        continueBtn.setBounds(250,0,100,30);
        continueBtn.addActionListener(this);
        add(continueBtn);
        pokemons[0] = PokemonsList.getBulbasaur();
        pokemons[1] = PokemonsList.getDiglett();
        pokemons[2] = PokemonsList.getCharmander();
        pokemons[3] = PokemonsList.getPikachu();
        pokemons[4] = PokemonsList.getSquirtle();


        int x = 30, y = 120;
        for (int i = 0; i < pokemons.length; i++) {
            images[i] = new ImageIcon(PokemonImageCreator.getPokemonImage(pokemons[i].getPokemonName()));
            if (x > 420) {
                x = 120;
                y += 180;
            }
            pokemonImageLbls[i] = new PokemonImageLbl(images[i], x, y, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);
            x += 180;

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

    public boolean hasPlayerPickedLoadout() {
        return hasPlayerPickedLoadout;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < chooseBtns.length; i++) {
            if (e.getSource() == chooseBtns[i] && player.getPokemons().size() <= 3) {
                if (choosedPokemons[i] == 0) {
                    System.out.println("Picked " + pokemons[i].getName() + "\n" + player.getPokemons().size());
                    player.addPokemon(pokemons[i]);
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
            hasPlayerPickedLoadout = true;
        }
    }
}
