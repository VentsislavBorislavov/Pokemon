package pokemon;

public class PokemonMenu {
    public void printPokemonStats(Pokemon pokemon) {
        System.out.println(
                pokemon.getName() + " stats: \n" +
                        "Type: " + pokemon.getType() + "\n" +
                        /*"Size: " + pokemon.getSize() + "\n"+*/
                        "Attack: " + pokemon.getAttack() + "\n" +
                        "Health: " + pokemon.getHealth() + "\n" +
                        "Defence: " + pokemon.getDefence() + "\n" +
                        "Height: " + pokemon.getHeight() + "\n" +
                        "Weight: " + pokemon.getWeight() + "\n"
        );
    }

    public void printPokemonAbilities(Pokemon pokemon) {
        for (int i = 0; i < pokemon.getAbilityList().size(); i++) {
            System.out.println(i + 1 + " " + pokemon.getAbilityList().get(i).getAbilityName());
        }
    }



}
