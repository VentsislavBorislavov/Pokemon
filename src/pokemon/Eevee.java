package pokemon;

import abilities.AirStrike;

public class Eevee extends Pokemon {
    private static final String DEFAULT_NAME = "Eevee";
    private static final Type TYPE = Type.AIR;

    public Eevee(String defaultName, int health, int defence, int attack, double height, double weight, Type type, Size size) {
        super(defaultName, health, defence, attack, height, weight, type, size);
        abilities.add(new AirStrike());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
        abilities.get(1).dealDamage(attack, attackedPokemonType);
    }
}
