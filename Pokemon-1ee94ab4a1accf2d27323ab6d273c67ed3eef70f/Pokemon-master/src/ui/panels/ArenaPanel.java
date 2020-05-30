package ui.panels;

import pokemon.*;
import ui.components.Constants;
import ui.components.GameButton;
import ui.components.GameLoop;
import ui.components.PokemonImageCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArenaPanel extends JPanel implements ActionListener {

    private GameButton abilityButton1;
    private GameButton ablitiyButton2;
    private JButton switchBtn;
    private JPanel dialoguePanel;
    private JLabel dialogueLabel;
    private JLabel pokemonPicLbl;
    private Player player;
    private boolean isOver = false;
    private int indexOfPokemon = 0;
    private Timer timer;
    private Pokemon pokemon;
    private JLabel pokemonHealthPoints;
    private JLabel enemyPokemonHealthPoints;
    private JLabel enemyPokemonPicLbl;
    private TypeDamageModifier typeDamageModifier = new TypeDamageModifier();
    private Enemy enemy;
    private boolean hasWon = false;
    private Random random;
    private int indexOfEnemyAbility;
    private int turn = 2;

    public ArenaPanel(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        pokemonHealthPoints = new JLabel();
        pokemonHealthPoints.setBounds(220, 330, 60, 30);
        pokemonHealthPoints.setForeground(Color.green);

        enemyPokemonHealthPoints = new JLabel();
        enemyPokemonHealthPoints.setBounds(280, 190, 60, 30);
        enemyPokemonHealthPoints.setForeground(Color.red);


        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        setLayout(null);

        pokemon = player.getPokemons().get(indexOfPokemon);

        switchBtn = new GameButton(400,360,100,30);
        switchBtn.setText("Switch");
        switchBtn.addActionListener(e -> {
            if(indexOfPokemon< player.getPokemons().size() - 1)
            indexOfPokemon++;
            else indexOfPokemon = 0;
        });

        abilityButton1 = new GameButton(400, 400, 100, 30);
        abilityButton1.addActionListener(this);
        ablitiyButton2 = new GameButton(400, 440, 100, 30);
        ablitiyButton2.addActionListener(this);

        dialogueLabel = new JLabel();
        dialogueLabel.setBounds(60, 400, 310, 70);
        dialogueLabel.setForeground(Color.BLACK);

        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(40, 400, 310, 70);
        dialoguePanel.setBackground(Color.GRAY);

        enemyPokemonPicLbl = new JLabel(new ImageIcon(PokemonImageCreator.getPokemonImage(enemy.getEnemyPokemon().getPokemonType())));
        enemyPokemonPicLbl.setBounds(340, 40, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);

        pokemonPicLbl = new JLabel(new ImageIcon(Constants.PIKACHU_IMAGE_URL));
        pokemonPicLbl.setBounds(40, 180, Constants.POKEMON_WIDTH, Constants.POKEMON_HEIGHT);

        timer = new Timer(1000, new GameLoop(this));

        add(dialogueLabel);
        add(dialoguePanel);
        add(abilityButton1);
        add(ablitiyButton2);
        add(pokemonPicLbl);
        add(pokemonHealthPoints);
        add(enemyPokemonHealthPoints);
        add(switchBtn);
        add(enemyPokemonPicLbl);

        timer.start();
    }

    public boolean isOver() {
        return isOver;
    }

    public void resetOver() {
        isOver = false;
        System.out.println("Over");
    }

    public Player getPlayer() {
        return player;
    }

    private void diePokemon(){
        if(player.getPokemons().get(indexOfPokemon).getHealth() <= 0){
            player.removePokemon(player.getPokemons().get(indexOfPokemon));
            indexOfPokemon = 0;
        }
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void resetHasWon() {
        this.hasWon = false;
    }

    public void doOneLoop() {
        update();
    }

    private void update() {
        if (player.getPokemons().size() > 0) {
            pokemon = player.getPokemons().get(indexOfPokemon);
            String healthPoints = "" + pokemon.getHealth();
            pokemonHealthPoints.setText(healthPoints);
            String ehealthPoints = "" + enemy.getEnemyPokemon().getHealth();
            enemyPokemonHealthPoints.setText(ehealthPoints);
            pokemonPicLbl.setIcon(new ImageIcon(PokemonImageCreator.getPokemonImage(pokemon.getPokemonType())));
            abilityButton1.setText(pokemon.getAbilityList().get(0).getAbilityName());
            ablitiyButton2.setText(pokemon.getAbilityList().get(1).getAbilityName());
            diePokemon();
            if(player.getPokemons().size()==0){
                isOver = true;
            }
        }
        if(enemy.getEnemyPokemon().getHealth()<0){
            isOver = true;
            hasWon = true;
            enemy.getEnemyPokemon().setHealth(100);
            player.addCrystals((int) (Math.random()*2));
        }
        if(turn%2==0){
            player.getPokemons().get(indexOfPokemon).takeDamage(DamageCalculator.calculateDamage(enemy.getEnemyPokemon(),pokemon,0));
            dialogueLabel.setText(enemy.getEnemyName() + "Attacked with " + enemy.getEnemyPokemon().getName() + "with " + enemy.getEnemyPokemon().getAbilityList().get(0).getAbilityName());
            turn++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==abilityButton1 && turn%2==1){
            enemy.getEnemyPokemon().takeDamage(DamageCalculator.calculateDamage(pokemon,enemy.getEnemyPokemon(),0));
            turn++;
        }
        if(e.getSource()==ablitiyButton2 && turn%2==1){
            enemy.getEnemyPokemon().takeDamage(DamageCalculator.calculateDamage(pokemon,enemy.getEnemyPokemon(),1));
            turn++;
        }
    }
}
