package pokemon;

import abilities.FireBreath;
import abilities.Punch;

public class Enemy {
    private String enemyName;
    private Pokemon enemyPokemon;
    private PokemonsList pokemonsList = new PokemonsList();

    public Enemy(String enemyName, Pokemon enemyPokemon) {
        this.enemyName = enemyName;
        this.enemyPokemon = enemyPokemon;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }

    public PokemonsList getPokemonsList() {
        return pokemonsList;
    }

    public void setPokemonsList(PokemonsList pokemonsList) {
        this.pokemonsList = pokemonsList;
    }
}
