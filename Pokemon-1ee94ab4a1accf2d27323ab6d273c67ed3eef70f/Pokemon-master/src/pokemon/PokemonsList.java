package pokemon;

import abilities.*;

public class PokemonsList {
    private static Pokemon charmander = new Pokemon("Charmander", 39, 42, 53, Type.FIRE, new Punch(), new FireBreath(),PokemonName.CHARMANDER);
    private static Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 49, Type.PLANT, new Punch(), new Overgrow(),PokemonName.BULGASAUR);
    private static Pokemon pikachu = new Pokemon("Pikachu", 35, 40, 55, Type.AIR, new Punch(), new LightningBolt(),PokemonName.PIKACHU);
    private static Pokemon squirtle = new Pokemon("Squirtle", 44, 66, 48, Type.WATER, new Punch(), new Torrent(),PokemonName.SQUIRTLE);
    private static Pokemon diglett = new Pokemon("Diglett", 10, 25, 55, Type.EARTH, new Punch(), new SandForce(),PokemonName.DIGGLET);



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
}
