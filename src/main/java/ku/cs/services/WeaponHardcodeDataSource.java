package ku.cs.services;

import ku.cs.game.models.Gun;
import ku.cs.game.models.Weapon;
import ku.cs.game.models.WeaponList;

public class WeaponHardcodeDataSource implements DataSource<WeaponList>{

    private WeaponList weapons;

    public WeaponHardcodeDataSource() {
        weapons = new WeaponList();
        hardcode();
    }

    private void hardcode() {
        weapons.addWeapon(new Weapon("Katana", 1000, 100));
        weapons.addWeapon(new Weapon("Bamboo Sword", 5, 120));
        weapons.addWeapon(new Gun("Kunai", 10, 100, 30, 95));
    }

    @Override
    public WeaponList readData() {
        return weapons;
    }

    @Override
    public void writeData(WeaponList weaponList) {
        this.weapons = weaponList;
    }
}
