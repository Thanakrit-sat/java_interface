package ku.cs.game.models;

public class GameCharacter {
    private String name;
    private int hp;
    private int damage;
    private Weapon weapon;

    public GameCharacter(String name, int hp, int damage, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.weapon = weapon;
    }

    public GameCharacter(String name, int hp, int damage) {
        this(name, hp, damage, null);
    }

    public int getDamage() {
        if (weapon == null)
            return this.damage;
        return this.damage + weapon.getDamage();
    }

    public void isAttackedWith(int damage) {
        if (damage < 0) return;
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void attack(GameCharacter enemy) {
        int damage = 0;
        if (weapon != null) {
            damage = weapon.use();
            if (damage > 0) {
                enemy.isAttackedWith(getDamage());
            } else {
                enemy.isAttackedWith(this.damage);
            }
        } else {
            enemy.isAttackedWith(getDamage());
        }
    }

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }
}
