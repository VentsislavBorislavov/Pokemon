package pokemon;

import abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    protected String defaultName;
    protected String name = "";
    protected int health;
    protected int defence;
    protected int attack;
    protected double height;
    protected double weight;
    protected Type type;
    PokemonName pokemonName;
    protected int maxHP;
   // protected Size size;
    protected List<Ability> abilityList = new ArrayList<>();

    public Pokemon(String defaultName, int maxHP, int defence, int attack, /*double height, double weight,*/ Type type, /*Size size,*/Ability firstAbility, Ability secondAbility, PokemonName p) {
        this.defaultName = defaultName;
        pokemonName = p;
        this.maxHP = maxHP;
        this.health = maxHP;
        this.defence = defence;
        this.attack = attack;
       /* this.height = height;
        this.weight = weight;*/
        this.type = type;
       // this.size = size;

        abilityList.add(firstAbility);
        abilityList.add(secondAbility);
    }

    public String getName() {
        if (name.equals("")) {
            return defaultName;
        } else return name;
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    /*public Size getSize() {
        return size;
    }*/

    public void setHealth(int health) {
        this.health = health;}


    public double getHealth() {
        return health;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Type getType() {
        return type;
    }

    public PokemonName getPokemonName() {
        return pokemonName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }


    public int getMaxHP() {
        return maxHP;
    }
}