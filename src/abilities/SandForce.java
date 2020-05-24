package abilities;

import pokemon.Type;

public class SandForce implements Ability{
    @Override
    public int dealDamage(int damage, Type attackedPokemonType) {
            if (attackedPokemonType == Type.AIR)
                return (int) (damage * 0.1);
            if (attackedPokemonType == Type.WATER)
                return (int) (damage * 0.8);
            else return (int) (damage * 0.5);
    }
}
