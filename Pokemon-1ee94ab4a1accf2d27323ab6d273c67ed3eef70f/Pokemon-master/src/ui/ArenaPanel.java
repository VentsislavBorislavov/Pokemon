package ui;

import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ArenaPanel extends JPanel implements Runnable {

    private AbilityButton abilityButton1;
    private AbilityButton ablitiyButton2;
    private JPanel dialoguePanel;
    private JLabel dialogueLabel;
    private ImageIcon arenaImage;
    private BufferedImage image;
    private BufferedImage finalImage;
    private Pokemon pokemon;
    JLabel picLabel;

    public ArenaPanel(Pokemon pokemon) throws Exception {
        this.pokemon = pokemon;
        setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
        arenaImage = new ImageIcon(Constants.ARENA_IMAGE_URL);
        setLayout(null);
        String ability1Name = pokemon.getAbilityList().get(0).getAbilityName();
        String ability2Name = pokemon.getAbilityList().get(1).getAbilityName();

        abilityButton1 = new AbilityButton(400,400,100,30);
        abilityButton1.addActionListener(e -> pokemon.takeDamage(30));
        ablitiyButton2 = new AbilityButton(400,440,100,30);

        dialogueLabel = new JLabel();
        dialogueLabel.setBounds(60, 400, 310, 70);
        dialogueLabel.setForeground(Color.BLACK);

        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(40, 400, 310, 70);
        dialoguePanel.setBackground(Color.GRAY);

        setImage();
        picLabel = new JLabel(new ImageIcon(image));
        picLabel.setBounds(40, 180, 180, 200);

        add(dialogueLabel);
        add(dialoguePanel);
        add(abilityButton1);
        add(ablitiyButton2);
        add(picLabel);
    }

    public void setImage() throws Exception {
        try {
            image = ImageIO.read(new File(PokemonImageCreator.getPokemonImage(pokemon.getPokemonName())));
        } catch (Exception e) {
        }
    }

    private void changePokemonView(){
        try {
            image = ImageIO.read(new File(Constants.BULBASAUR_IMAGE_URL));
            picLabel = new JLabel(new ImageIcon(image));
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {

    }
}
