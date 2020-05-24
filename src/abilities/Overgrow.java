package abilities;

import pokemon.Type;

public class Overgrow implements Ability{

    @Override
    public int dealDamage(int damage, Type attackedPokemonType) {
        if (attackedPokemonType == Type.FIRE)
            return (int) (damage * 0.1);
        if (attackedPokemonType == Type.AIR)
            return (int) (damage * 0.8);
        else return (int) (damage * 0.5);
    }

    @Override
    public String abilityName() {
        return "Overgrow";
    }
}
