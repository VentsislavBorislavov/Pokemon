package pokemon;

import abilities.*;

public class PokemonsList {
    private Pokemon charmander = new Pokemon("Charmander", 39, 42, 53, Type.FIRE, new Punch(), new FireBreath(),PokemonName.CHARMANDER);
    public Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 49, Type.PLANT, new Punch(), new Overgrow(),PokemonName.BULGASAUR);
    private Pokemon pikachu = new Pokemon("Pikachu", 35, 40, 55, Type.AIR, new Punch(), new LightningBolt(),PokemonName.PIKACHU);
    private Pokemon squirtle = new Pokemon("Squirtle", 44, 66, 48, Type.WATER, new Punch(), new Torrent(),PokemonName.SQUIRTLE);
    private Pokemon diglett = new Pokemon("Diglett", 10, 25, 55, Type.EARTH, new Punch(), new SandForce(),PokemonName.DIGGLET);

    public PokemonsList() {


      /*  Pokemon charmander = new Pokemon("Charmander", 39, 42, 53, Type.FIRE, new Punch(), new FireBreath(),PokemonName.CHARMANDER);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 49, Type.PLANT, new Punch(), new Overgrow(),PokemonName.BULGASAUR);
        Pokemon pikachu = new Pokemon("Pikachu", 35, 40, 55, Type.AIR, new Punch(), new LightningBolt(),PokemonName.PIKACHU);
        Pokemon squirtle = new Pokemon("Squirtle", 44, 66, 48, Type.WATER, new Punch(), new Torrent(),PokemonName.SQUIRTLE);
        Pokemon diglett = new Pokemon("Diglett", 10, 25, 55, Type.EARTH, new Punch(), new SandForce(),PokemonName.DIGGLET);*/
    }

    public Pokemon getCharmander() {
        return charmander;
    }

    public Pokemon getBulbasaur() {
        return bulbasaur;
    }

    public Pokemon getPikachu() {
        return pikachu;
    }

    public Pokemon getSquirtle() {
        return squirtle;
    }

    public Pokemon getDiglett() {
        return diglett;
    }
}
