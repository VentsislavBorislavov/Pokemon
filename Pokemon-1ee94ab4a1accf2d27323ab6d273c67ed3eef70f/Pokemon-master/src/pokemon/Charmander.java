package pokemon;

import abilities.Ability;
import abilities.FireBreath;
import abilities.Punch;

public class Charmander extends Pokemon{


    public Charmander(String defaultName, int maxHP, int defence, int attack, Type type, /*Size size,*/ Ability firstAbility, Ability secondAbility) {
        super("Charmader", 39, 43, 52, Type.FIRE, /*Size.SMALL,*/ new Punch(), new FireBreath(),PokemonName.CHARMANDER);
    }
}
