package pokemon;

public class DamageCalculator {

    private static TypeDamageModifier typeDamageModifier = new TypeDamageModifier();

    public static int calculateDamage(Pokemon pokemon, Pokemon pokemon2, int i){

        int damage = (int) (pokemon.getAbilityList().get(i).getDamage() - (pokemon2.getDefence() * typeDamageModifier.getDamageModifier(pokemon.getType(),pokemon2.getType())));
        return Math.abs(damage);
    }

}
