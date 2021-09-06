package ku.cs.game.models;

import java.util.ArrayList;

public class WeaponList {
    private ArrayList<Weapon> weapons;


    public WeaponList() {
        weapons = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public int count() {
        return weapons.size();
    }

    public Weapon searchWeaponByName(String name) {
        for (Weapon weapon: weapons) {
            if (weapon.isName(name)) {
                return weapon;
            }
        }
        return null;
    }

    public String toCsv() {
        String result = "";
        for (Weapon weapon: weapons) {
            result += weapon.toCsv() + "\n";
        }
        return result;
    }
}
