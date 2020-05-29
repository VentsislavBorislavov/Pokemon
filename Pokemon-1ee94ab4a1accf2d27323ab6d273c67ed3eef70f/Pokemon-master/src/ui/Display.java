package ui;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;

import javax.swing.*;

public class Display extends JFrame {

    private Player player;
    private Timer timer;
    private ArenaPanel arenaPanel;
    private PokemonChooserPanel chooserP;
    private PlayPanel playPanel;
    private final Pokemon[] enemyPokemons = new PokemonsList().getEnemyPokemons();
    private String[] enemyNames = {"Team Rocket","Maxie", "Cyrus", "Giovanni", "Team Flare"};
    private int indexOfStage = 0;

    public Display() throws Exception {
        setUpDisplay();
    }

    private void setUpDisplay() {

        player = new Player();
        playPanel = new PlayPanel();

        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setTitle("Pokemon Tournament");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        timer = new Timer(100, new GameLoop(this));
        timer.start();
        setContentPane(playPanel);
    }

    public void doOneLoop() {
        if (arenaPanel!= null && arenaPanel.isOver()) {
            setContentPane(chooserP);
            this.player = arenaPanel.getPlayer();
            arenaPanel.resetOver();
        }
        if (chooserP != null && chooserP.hasPlayerPickedLoadout()) {
            this.player = chooserP.getPlayer();
            arenaPanel = new ArenaPanel(player, enemyPokemons[indexOfStage],enemyNames[indexOfStage]);
            setContentPane(arenaPanel);
            chooserP.setHasPlayerPickedLoadout();

        }
        if(playPanel.isGameStarted()){
            chooserP = new PokemonChooserPanel(player);
            setContentPane(chooserP);
            playPanel.setGameStarted();
        }
        }
    }