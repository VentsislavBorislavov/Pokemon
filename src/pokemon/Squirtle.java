package pokemon;

import abilities.Torrent;

public class Squirtle extends Pokemon {
    private static final String DEFAULT_NAME = "Squirtle";
    private static final Type TYPE = Type.WATER;

    public Squirtle(int health, int defence, int attack, double height, double weight, Size size) {
        super(DEFAULT_NAME, health, defence, attack, height, weight, Type.WATER, size);
        abilityList.add(new Torrent());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
        return abilityList.get(1).dealDamage(attack, attackedPokemonType);
    }
}
