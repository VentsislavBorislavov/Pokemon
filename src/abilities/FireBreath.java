package abilities;

import pokemon.Type;

public class FireBreath implements Ability {


    @Override
    public int dealDamage(int damage, Type attackedPokemonType) {
        if (attackedPokemonType == Type.WATER)
            return (int) (damage * 0.1);
        if (attackedPokemonType == Type.PLANT)
            return (int) (damage * 0.8);
        else return (int) (damage * 0.5);
    }

    @Override
    public String abilityName() {
        return "Fire Breath";
    }
}
