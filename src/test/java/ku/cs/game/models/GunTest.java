package ku.cs.game.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunTest {

    @Test
    void testUse() {
        Gun gun = new Gun(11, 100, 6, 80);
        assertEquals(11, gun.use());
        assertEquals(99, gun.getDurability());
        assertEquals(5, gun.getNumAmmo());
    }

    @Test
    void testCannotUse() {
        Gun gun = new Gun(11, 0, 6, 80);
        assertEquals(0, gun.use());
        assertEquals(0, gun.getDurability());
        assertEquals(6, gun.getNumAmmo());
    }

    @Test
    void testUseWithNoAmmo() {
        Gun gun = new Gun(11, 100, 0, 80);
        assertEquals(0, gun.use());
        assertEquals(99, gun.getDurability());
        assertEquals(0, gun.getNumAmmo());
    }

    @Test
    void testAddAmmo() {
        Gun gun = new Gun(11, 100, 6, 80);
        gun.addAmmo(10);
        assertEquals(16, gun.getNumAmmo());
    }

    @Test
    void testAddNegativeAmmo() {
        Gun gun = new Gun(11, 100, 6, 80);
        gun.addAmmo(-10);
        assertEquals(6, gun.getNumAmmo());
    }
}