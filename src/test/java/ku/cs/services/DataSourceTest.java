package ku.cs.services;

import ku.cs.game.models.Gun;
import ku.cs.game.models.Weapon;
import ku.cs.game.models.WeaponList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSourceTest {

    @Test
    void testHardcodeWeaponList() {
        DataSource<WeaponList> dataSource = new WeaponHardcodeDataSource();

        WeaponList list = dataSource.readData();

        assertEquals(3, list.count());
    }

    @Test
    void testHardcodeWeaponListHasKunai() {
        DataSource<WeaponList> dataSource = new WeaponHardcodeDataSource();

        WeaponList list = dataSource.readData();

        Weapon kunai = list.searchWeaponByName("Kunai");
        assertTrue(kunai instanceof Gun);
    }

    @Test
    void testWriteWeaponListToFile() {
        DataSource<WeaponList> dataSource = new WeaponHardcodeDataSource();
        WeaponList list = dataSource.readData();

        DataSource<WeaponList> fileDS = new WeaponFileDataSource("unit-test", "weapon.csv");
        fileDS.writeData(list); // <-- test this method

        WeaponList readList = fileDS.readData();
        assertEquals(3, readList.count());
        assertEquals(list.toCsv(), readList.toCsv());
    }

    @Test
    void testReadWeaponListFromWeapon99() {
        DataSource<WeaponList> dataSource = new WeaponFileDataSource("unit-test", "weapon-99.csv");
        WeaponList list = dataSource.readData();

        Weapon weapon = list.searchWeaponByName("Katana-X");
        weapon.use();
        assertEquals(104, weapon.getDurability());
    }

}