package abilities;

import pokemon.Type;

public class Punch implements Ability {

    @Override
    public int dealDamage(int damage, Type attackedPokemonType) {
        return (int) (damage * 0.4);
    }
}
