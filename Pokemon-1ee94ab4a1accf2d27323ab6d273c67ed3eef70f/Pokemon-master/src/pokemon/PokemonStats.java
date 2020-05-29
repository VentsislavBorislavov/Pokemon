package pokemon;

public class PokemonStats {
    public static String  getPokemonStats(Pokemon pokemon) {
        String message = "";
        message += "<html>" + pokemon.getName() + "<br/>";
        message += "Attack: " + pokemon.getAttack() + "<br/>";
        message += "Health: " + pokemon.getHealth() + "<br/>";
        message += "Defence: " + pokemon.getDefence() + "<br/>";
        message += "Height: " + pokemon.getHeight() + "<br/>";
        message += "Weight: " + pokemon.getWeight() + "</html>";
        return message;
    }


}
