package pokemon;

import abilities.*;

public class PokemonsList {
    private static Pokemon charmander = new Pokemon("Charmander", 39, 42, 53, Type.FIRE, new FireBreath(), PokemonType.CHARMANDER);
    private static Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 49, Type.PLANT, new Overgrow(), PokemonType.BULGASAUR);
    private static Pokemon pikachu = new Pokemon("Pikachu", 35, 40, 55, Type.AIR, new LightningBolt(), PokemonType.PIKACHU);
    private static Pokemon squirtle = new Pokemon("Squirtle", 44, 66, 48, Type.WATER, new Torrent(), PokemonType.SQUIRTLE);
    private static Pokemon diglett = new Pokemon("Diglett", 30, 25, 55, Type.EARTH, new SandForce(), PokemonType.DIGGLET);

    private static Pokemon[] enemyPokemons = new Pokemon[5];

    public PokemonsList() {
        setUpEnemyPokemons();
    }

    private void setUpEnemyPokemons() {
        enemyPokemons[0] = new Pokemon("Diglett", 30, 25, 55, Type.EARTH, new SandForce(), PokemonType.DIGGLET);
        enemyPokemons[1] = new Pokemon("Charmander", 50, 52, 53, Type.FIRE, new FireBreath(), PokemonType.CHARMANDER);
        enemyPokemons[2] = new Pokemon("Bulbasaur", 60, 70, 49, Type.PLANT, new Overgrow(), PokemonType.BULGASAUR);
        enemyPokemons[3] = new Pokemon("Squirtle", 80, 66, 48, Type.WATER, new Torrent(), PokemonType.SQUIRTLE);
        enemyPokemons[4] = new Pokemon("Pikachu", 100, 40, 55, Type.AIR, new LightningBolt(), PokemonType.PIKACHU);
    }


    public static Pokemon getCharmander() {
        return charmander;
    }

    public static Pokemon getBulbasaur() {
        return bulbasaur;
    }

    public static Pokemon getPikachu() {
        return pikachu;
    }

    public static Pokemon getSquirtle() {
        return squirtle;
    }

    public static Pokemon getDiglett() {
        return diglett;
    }

    public static Pokemon[] getEnemyPokemons() {
        return enemyPokemons;
    }
}
