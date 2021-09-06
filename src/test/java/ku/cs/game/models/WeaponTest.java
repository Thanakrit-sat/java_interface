package ku.cs.game.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void testUse() {
        Weapon weapon = new Weapon(100, 30);
        assertEquals(100, weapon.use());
        assertEquals(29, weapon.getDurability());
    }

    @Test
    void testCannotUse() {
        Weapon weapon = new Weapon(100, 0);
        assertEquals(0, weapon.use());
        assertEquals(0, weapon.getDurability());
    }
}