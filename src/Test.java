import pokemon.Charmander;
import pokemon.Pokemon;
import pokemon.Size;
import pokemon.Type;

public class Test {
    public static void main(String[] args) {
        Pokemon charmander = new Charmander(53,69,51,4,3, Size.SMALL);
        Pokemon charmander2 = new Charmander(53,69,51,4,3, Size.SMALL);
        System.out.println(charmander.useAbility1(Type.PLANT));
    }
}
