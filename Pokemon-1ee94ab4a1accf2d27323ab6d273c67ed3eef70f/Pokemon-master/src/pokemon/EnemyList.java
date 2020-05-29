package pokemon;

public class EnemyList {
    Enemy[] enemies = new Enemy[5];
    private PokemonsList pokemonsList = new PokemonsList();
    public EnemyList() {
        enemies[0] = new Enemy("Enemy 1",pokemonsList.getBulbasaur());
        enemies[1] = new Enemy("Enemy 2",pokemonsList.getPikachu());
        enemies[2] = new Enemy("Enemy 3",pokemonsList.getCharmander());
        enemies[3] = new Enemy("Enemy 4",pokemonsList.getDiglett());
        enemies[4] = new Enemy("Enemy 5",pokemonsList.getSquirtle());
    }
}
