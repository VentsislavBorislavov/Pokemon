package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int crystals;
    private List<Pokemon> pokemons = new ArrayList<>();

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    //TODO pokemon chooser

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCrystals() {
        return crystals;
    }

    public void setCrystals(int crystals) {
        this.crystals += crystals;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void removePokemon(Pokemon pokemon){
        pokemons.remove(pokemon);
    }

}
