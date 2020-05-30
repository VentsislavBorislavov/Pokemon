package ui;

import pokemon.Enemy;
import pokemon.Player;
import pokemon.Pokemon;
import pokemon.PokemonsList;
import ui.components.Constants;
import ui.components.GameLoop;
import ui.panels.*;

import javax.swing.*;

public class App extends JFrame {

    private Player player;
    private Timer timer;
    private ArenaPanel arenaPanel;
    private PokemonChooserPanel pokemonChooserPanel;
    private PlayPanel playPanel;
    private PokemonsList pokemonsList = new PokemonsList();
    private Pokemon[] enemyPokemons = pokemonsList.getEnemyPokemons();
    private String[] enemyNames = {"Team Rocket","Maxie", "Cyrus", "Giovanni", "Team Flare"};
    private int indexOfStage = 0;
    private WinPanel winPanel;
    private LosePanel losePanel;
    private PokemonMenuPanel pokemonMenuPanel;
    private Enemy[] enemies = new Enemy[5];

    public App() throws Exception {
        setUpDisplay();
    }

    private void setUpDisplay() {

        player = new Player();
        playPanel = new PlayPanel();
        winPanel = new WinPanel();
        losePanel = new LosePanel();

        setUpEnemies();
        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setTitle("Pokemon Tournament");
        setIconImage(new ImageIcon(Constants.POKEMON_ICON_URL).getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        timer = new Timer(10, new GameLoop(this));
        timer.start();
        setContentPane(playPanel);
    }

    private void setUpEnemies() {
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(enemyNames[i],enemyPokemons[i]);
        }
    }

    public void doOneLoop() {
        update();
        repaint();
    }

    private void update() {
        if (arenaPanel!= null && arenaPanel.isOver()) {
            if(arenaPanel.hasWon()){
                if(indexOfStage==4){
                    setContentPane(winPanel);
                }else {
                    this.player = arenaPanel.getPlayer();
                    pokemonMenuPanel = new PokemonMenuPanel(player);
                    setContentPane(pokemonMenuPanel);
                }
                arenaPanel.resetOver();
                arenaPanel.resetHasWon();
            }else {
                setContentPane(losePanel);
                arenaPanel.resetOver();
                arenaPanel.setVisible(false);
            }
        }
        if (pokemonChooserPanel != null && pokemonChooserPanel.hasPlayerPickedLoadout()) {
            this.player = pokemonChooserPanel.getPlayer();
            arenaPanel = new ArenaPanel(player, enemies[indexOfStage]);
            arenaPanel.setVisible(true);
            setContentPane(arenaPanel);
            pokemonChooserPanel.setHasPlayerPickedLoadout();
        }
        if(playPanel.isGameStarted()){
            player = new Player();
            pokemonChooserPanel = new PokemonChooserPanel(player);
            setContentPane(pokemonChooserPanel);
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
        if(pokemonMenuPanel != null && pokemonMenuPanel.getContinueForward()){
            this.player = pokemonMenuPanel.getPlayer();
            indexOfStage++;
            setContentPane(arenaPanel);
            pokemonMenuPanel.reset();
        }
    }
}