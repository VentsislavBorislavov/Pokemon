package pokemon;

import abilities.FireBreath;
import abilities.Punch;

public class Enemy {
    private String enemyName;
    private Pokemon enemyPokemon;

    public Enemy(String enemyName, Pokemon enemyPokemon) {
        this.enemyName = enemyName;
        this.enemyPokemon = enemyPokemon;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

}
