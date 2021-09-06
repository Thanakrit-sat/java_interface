package ku.cs.game.models;

public class Gun extends Weapon {
    private int numAmmo;
    private double accuracy;

    public Gun(int damage, int durability, int numAmmo, double accuracy) {
        this("", damage, durability, numAmmo, accuracy);
    }

    public Gun(String name, int damage, int durability, int numAmmo, double accuracy) {
        super(name, damage, durability);
        this.numAmmo = numAmmo;
        this.accuracy = accuracy;
    }

    public int getNumAmmo() {
        return numAmmo;
    }

    public void addAmmo(int ammo) {
        if (ammo > 0) numAmmo += ammo;
    }

    @Override
    public int use() {
        int damage = super.use();
        if (damage > 0) {
            if (--numAmmo < 0) {
                numAmmo = 0;
                return 0;
            }
            return getDamage();
        }
        return 0;
    }

    @Override
    public String toCsv() {
        return "Gun," + getName() + "," + getDamage() + "," +
                getDurability() + "," + numAmmo + "," + accuracy;
    }
}
