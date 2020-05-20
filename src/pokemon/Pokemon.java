package pokemon;

public abstract class Pokemon {
    protected String defaultName;
    protected String name = "";
    protected int health;
    protected int defence;
    protected int attack;
    protected double height;
    protected double weight;
    protected Type type;

    public Pokemon() {
    }

    public String getName() {
        if (name.equals("")) {
            return defaultName;
        } else return name;
    }

    public int getHealth() {
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

    public void resetName() {
        name = "";
    }

}
