package ku.cs.game.models;

public class Weapon {
    private String name;
    private int damage;
    private int durability;

    public Weapon(int damage, int durability) {
        this("", damage, durability);
    }

    public Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public int getDurability() {
        return durability;
    }

    public int getDamage() {
        return damage;
    }

    public int use() {
        if (--durability < 0) {
            durability = 0;
            return 0;
        }
        return getDamage();
    }

    // CSV - Comma Separated Value
    public String toCsv() {
        return "Weapon," + name + "," + damage + "," + durability;
    }
}
