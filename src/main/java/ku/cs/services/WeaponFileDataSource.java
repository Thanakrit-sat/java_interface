package ku.cs.services;

import ku.cs.game.models.Gun;
import ku.cs.game.models.Weapon;
import ku.cs.game.models.WeaponList;

import java.io.*;

public class WeaponFileDataSource implements DataSource<WeaponList>{

    private String directoryName;
    private String filename;

    /**
     * Production purpose
     */
    public WeaponFileDataSource() {
        this("data_csv", "weapons.csv");
    }

    /**
     * Testing purpose
     * @param directoryName
     * @param filename
     */
    public WeaponFileDataSource(String directoryName, String filename) {
        this.directoryName = directoryName;
        this.filename = filename;
        initialFileIfNotExist();
    }

    /**
     * สร้างไฟล์ ถ้ายังไม่มี
     */
    private void initialFileIfNotExist() {
        File file = new File(directoryName);
        if (!file.exists()) {
            file.mkdir();
        }

        String path = directoryName + File.separator + filename;
        file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public WeaponList readData() {
        WeaponList list = new WeaponList();

        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";
            while( (line = buffer.readLine()) != null ) {
                String[] data = line.split(",");
                String type = data[0];
                if (type.equals("Weapon")) {
                    list.addWeapon(
                            new Weapon(
                                    data[1],
                                    Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3])
                            )
                    );
                } else if (type.equals("Gun")) {
                    list.addWeapon(
                            new Gun(
                                    data[1],
                                    Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3]),
                                    Integer.parseInt(data[4]),
                                    Double.parseDouble(data[5])
                            )
                    );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void writeData(WeaponList weaponList) {
        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;

        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(weaponList.toCsv());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
