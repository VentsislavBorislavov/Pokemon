package ui;

import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;
import ui.components.Constants;
import ui.components.GameLoop;
import ui.panels.*;

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
    private WinPanel winPanel;
    private LosePanel losePanel;
    private PokemonMenuPanel pokemonMenuPanel;

    public Display() throws Exception {
        setUpDisplay();
    }

    private void setUpDisplay() {

        player = new Player();
        playPanel = new PlayPanel();
        winPanel = new WinPanel();
        losePanel = new LosePanel();
        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setTitle("Pokemon Tournament");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        timer = new Timer(1000, new GameLoop(this));
        timer.start();
        setContentPane(playPanel);
    }

    public void doOneLoop() {
        update();
        repaint();
    }

    private void update() {
        if (arenaPanel!= null && arenaPanel.isOver()) {
            this.player = arenaPanel.getPlayer();
            pokemonMenuPanel = new PokemonMenuPanel(player);
            setContentPane(pokemonMenuPanel);
            arenaPanel.resetOver();
            arenaPanel.setVisible(false);
        }
        if (chooserP != null && chooserP.hasPlayerPickedLoadout()) {
            this.player = chooserP.getPlayer();
            arenaPanel = new ArenaPanel(player, enemyPokemons[indexOfStage],enemyNames[indexOfStage]);
            arenaPanel.setVisible(true);
            setContentPane(arenaPanel);
            chooserP.setHasPlayerPickedLoadout();
            chooserP = null;
        }
        if(playPanel.isGameStarted()){
            player = new Player();
            chooserP = new PokemonChooserPanel(player);
            setContentPane(chooserP);
            playPanel.setGameStarted();
        }
        if(winPanel.wantToPlayAgain()){
            setContentPane(playPanel);
            player = new Player();
            indexOfStage = 0;
            arenaPanel = null;
            winPanel.reset();
        }
        if(losePanel.wantToPlayAgain()){
            setContentPane(playPanel);
            player = new Player();
            indexOfStage = 0;
            arenaPanel = null;
            losePanel.reset();
        }
    }
}