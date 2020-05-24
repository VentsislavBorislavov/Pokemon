package pokemon;

import abilities.Overgrow;

public class Bulbasaur extends Pokemon {
    private static final String DEFAULT_NAME = "Bulbasaur";
    private static final Type TYPE = Type.PLANT;

    public Bulbasaur(int health, int defence, int attack, double height, double weight, Size size) {
        super(DEFAULT_NAME, health, defence, attack, height, weight, TYPE, size);
        abilities.add(new Overgrow());
    }

    @Override
    public int useAbility1(Type attackedPokemonType) {
       return abilities.get(1).dealDamage(attack, attackedPokemonType);
    }
}
