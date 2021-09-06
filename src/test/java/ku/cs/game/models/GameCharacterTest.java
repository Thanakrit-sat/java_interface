package ku.cs.game.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCharacterTest {

    @Test
    void testGetDamageWithWeapon() {
        Weapon weapon = new Weapon(100, 40);
        GameCharacter player = new GameCharacter("Player 1", 18, 3, weapon);
        assertEquals(103, player.getDamage());

    }

    @Test
    void testGetDamageWithNoWeapon() {
        GameCharacter player = new GameCharacter("Player 1", 18, 3);
        assertEquals(3, player.getDamage());
    }

    @Test
    void testGetDamageWithGun() {
        Gun gun = new Gun(11, 200, 6, 80);
        GameCharacter player = new GameCharacter("Player 1", 18, 3, gun);
        assertEquals(14, player.getDamage());
    }

    @Test
    void testIsAttackedWith() {
        GameCharacter player = new GameCharacter("Player 1", 18, 3);
        player.isAttackedWith(8);
        assertEquals(10, player.getHp());
        assertFalse(player.isDead());
    }

    @Test
    void testIsAttackedWithAndDie() {
        GameCharacter player = new GameCharacter("Player 1", 18, 3);
        player.isAttackedWith(20);
        assertEquals(0, player.getHp());
        assertTrue(player.isDead());
    }

    @Test
    void testAttackWithWeapon() {
        Weapon weapon = new Weapon(30, 300);
        GameCharacter player = new GameCharacter("Player 1", 18, 3, weapon);
        GameCharacter slime = new GameCharacter("Slime", 200, 15);

        player.attack(slime);

        assertEquals(167, slime.getHp());
        assertFalse(slime.isDead());
        assertEquals(18, player.getHp());
        assertEquals(299, weapon.getDurability());
    }

    @Test
    void testAttackWithGun() {
        Gun gun = new Gun(11, 400, 6, 80);
        GameCharacter player = new GameCharacter("Player 1", 18, 3, gun);
        GameCharacter slime = new GameCharacter("Slime", 200, 15);

        player.attack(slime);

        assertEquals(186, slime.getHp());
        assertFalse(slime.isDead());
        assertEquals(18, player.getHp());
        assertEquals(399, gun.getDurability());
        assertEquals(5, gun.getNumAmmo());
    }

    @Test
    void testAttackWithGunWithNoAmmo() {
        Gun gun = new Gun(11, 400, 0, 80);
        GameCharacter player = new GameCharacter("Player 1", 18, 3, gun);
        GameCharacter slime = new GameCharacter("Slime", 200, 15);

        player.attack(slime);

        assertEquals(197, slime.getHp());
        assertFalse(slime.isDead());
        assertEquals(18, player.getHp());
        assertEquals(399, gun.getDurability());
        assertEquals(0, gun.getNumAmmo());
    }

}