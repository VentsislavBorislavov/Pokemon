package pokemon;

import abilities.SandForce;

public class Digglet extends Pokemon {
    private static final Type TYPE = Type.EARTH;
    private static final String DEFAULT_NAME = "Digglet";

    public Digglet(String defaultName, int health, int defence, int attack, double height, double weight, Type type, Size size) {
        super(defaultName, health, defence, attack, height, weight, type, size);
        abilities.add(new SandForce());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
        return abilities.get(1).dealDamage(attack, attackedPokemonType);
    }
}
