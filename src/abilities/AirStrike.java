package abilities;

import pokemon.Type;

public class AirStrike implements Ability{
    @Override
    public int dealDamage(int damage, Type attackedPokemonType) {
        if (attackedPokemonType == Type.PLANT)
            return (int) (damage * 0.1);
        if (attackedPokemonType == Type.EARTH)
            return (int) (damage * 0.8);
        else return (int) (damage * 0.5);
    }
}
