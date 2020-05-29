package pokemon;

public class Player {
    private String playerName;
    private int crystals;
    private Pokemon[] pokemons = new Pokemon[3];
    private PokemonsList pokemonsList = new PokemonsList();

    public Player(String playerName) {
        this.playerName = playerName;
        this.crystals=0;
       /* pokemons[0]=pokemonsList.getCharmander();
        pokemons[1]=pokemonsList.getPikachu();
        pokemons[2]=pokemonsList.getSquirtle();*/

    }
    public Player() {

        this.crystals=0;


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
        this.crystals = crystals;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public PokemonsList getPokemonsList() {
        return pokemonsList;
    }

    public void setPokemonsList(PokemonsList pokemonsList) {
        this.pokemonsList = pokemonsList;
    }
}
