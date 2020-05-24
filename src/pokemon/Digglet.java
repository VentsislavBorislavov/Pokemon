package pokemon;

import abilities.SandForce;

public class Digglet extends Pokemon {
    private static final Type TYPE = Type.EARTH;
    private static final String DEFAULT_NAME = "Digglet";

    public Digglet(String defaultName, int health, int defence, int attack, double height, double weight, Type type, Size size) {
        super(defaultName, health, defence, attack, height, weight, type, size);
        abilityList.add(new SandForce());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
        return abilityList.get(1).dealDamage(attack, attackedPokemonType);
    }
}
