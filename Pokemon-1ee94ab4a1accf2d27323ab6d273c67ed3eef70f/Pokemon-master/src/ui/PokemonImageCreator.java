package ui;

import pokemon.PokemonType;

public class PokemonImageCreator {
    private PokemonImageCreator(){
    }

    public static String getPokemonImage(PokemonType pokemonName){
        switch (pokemonName){
            case DIGGLET:
                return Constants.DIGGLET_IMAGE_URL;
            case PIKACHU:
                return Constants.PIKACHU_IMAGE_URL;
            case CHARMANDER:
                return Constants.CHARMANDER_IMAGE_URL;
            case BULGASAUR:
                return Constants.BULBASAUR_IMAGE_URL;
            case SQUIRTLE:
                return Constants.SQUIRTLE_IMAGE_URL;
            default:
                return "";
        }
    }
}
