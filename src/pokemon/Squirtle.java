package pokemon;

import abilities.Torrent;

public class Squirtle extends Pokemon {
    private static final String DEFAULT_NAME = "Squirtle";
    private static final Type TYPE = Type.WATER;

    public Squirtle(int health, int defence, int attack, double height, double weight, Size size) {
        super(DEFAULT_NAME, health, defence, attack, height, weight, Type.WATER, size);
        abilities.add(new Torrent());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
        return abilities.get(1).dealDamage(attack, attackedPokemonType);
    }
}
