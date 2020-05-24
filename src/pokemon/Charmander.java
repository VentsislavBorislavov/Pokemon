package pokemon;

import abilities.FireBreath;

public class Charmander extends Pokemon {

    private static final Type TYPE = Type.FIRE;
    private static final String DEFAULT_NAME = "Charmander";


    public Charmander(int health, int defence, int attack, double height, double weight, Size size) {
        super(DEFAULT_NAME, health, defence, attack, height, weight, TYPE, size);
        abilityList.add(new FireBreath());
    }


    @Override
    public int useAbility1(Type attackedPokemonType) {
        return abilityList.get(1).dealDamage(attack, attackedPokemonType);
    }
}
