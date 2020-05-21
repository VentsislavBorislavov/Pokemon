package abilities;

import pokemon.Type;

public class FireBreath implements Ability {
    @Override
    public double dealDamage(int damage, Type attackedPokemonType) {
        if (attackedPokemonType == Type.WATER)
            return damage * 0.1;
        if (attackedPokemonType == Type.PLANT)
            return damage * 0.8;
        else return damage * 0.5;
    }
}
