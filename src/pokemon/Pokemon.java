package pokemon;

import abilities.Ability;
import abilities.Punch;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
    protected String defaultName;
    protected String name = "";
    protected int health;
    protected int defence;
    protected int attack;
    protected double height;
    protected double weight;
    protected Type type;
    protected int maxHP;
    Size size;
    protected List<Ability> abilities = new ArrayList<>();

    public Pokemon(String defaultName, int health, int defence, int attack, double height, double weight, Type type, Size size) {
        this.defaultName = defaultName;
        this.health = health;
        this.maxHP = health;
        this.defence = defence;
        this.attack = attack;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.size = size;

        abilities.add(new Punch());
    }

    public String getName() {
        if (name.equals("")) {
            return defaultName;
        } else return name;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public double punch() {
        return abilities.get(0).dealDamage(attack,Type.NONE);
    }

    public abstract int useAbility1(Type attackedPokemonType);
}
