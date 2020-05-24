package abilities;

import pokemon.Type;

public interface Ability {
    int dealDamage(int damage, Type attackedPokemonType);
    String abilityName();
}