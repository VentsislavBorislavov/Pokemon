package abilities;

import pokemon.Type;

public interface Ability {
    double dealDamage(int damage, Type attackedPokemonType);
}