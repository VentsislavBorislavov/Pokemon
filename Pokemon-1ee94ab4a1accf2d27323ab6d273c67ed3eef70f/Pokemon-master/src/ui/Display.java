package ui;

import pokemon.Player;

import javax.swing.*;

public class Display extends JFrame {

    private Player player;
    private Timer timer;
    private ArenaPanel arenaPanel;
    private PokemonChooser chooserP;
    private PlayPanel playPanel;

    public Display() throws Exception {
        setUpDisplay();
    }

    private void setUpDisplay() throws Exception {

        playPanel = new PlayPanel();
        player = new Player();
        arenaPanel = new ArenaPanel(player);
        chooserP = new PokemonChooser(player);

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
        if (arenaPanel.isOver()) {
            setContentPane(chooserP);
            this.player = chooserP.getPlayer();
        }
        if (chooserP.hasPlayerPickedLoadout()) {
            setContentPane(arenaPanel);

        }
        if(playPanel.isGameStarted()){
            setContentPane(chooserP);
            playPanel.setGameStarted();
        }
        }
    }