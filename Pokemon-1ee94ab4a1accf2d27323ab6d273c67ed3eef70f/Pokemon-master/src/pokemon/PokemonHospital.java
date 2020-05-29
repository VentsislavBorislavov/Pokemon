package pokemon;

public class PokemonHospital {
    Player player;
    int healCost =1;
    public PokemonHospital(Player player) {
        this.player = player;
    }
    public PokemonHospital() {

    }
    public void healAllPokemons(){
        if(player.getCrystals()>healCost){
            for (int i = 0; i <3; i++) {
                player.getPokemons()[i].setHealth( player.getPokemons()[i].getMaxHP());
            }
            System.out.println("All Pokemons are healed to max HP.");
        }
        else {
            System.out.println("You dont have enough crystals");

        }

    }
}
