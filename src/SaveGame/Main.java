package SaveGame;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    static public void main(String[]args){
        SaveGame save = new SaveGame();
        save.saveDate = new Date();
        save.secondsInGame = 41243;
        save.gameTime = Calendar.getInstance();
        save.gameTime.set(2019, 5, 13, 7, 31);
        save.posX = 121;
        save.posY = 423;
        save.posZ = 57;
        save.coins = 1113;
        save.endedQuests = new String[]{"first", "second"};
        save.findItems = new String[]{"el1", "el2"};
        save.health = 95;
        save.stamina = 100;
        save.mana = 73;
        save.hunger = 61;
        save.points = 119;
        save.items = new String[]{"item1", "item2", "item3"};
        String file = "./save.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(save);
            out.close();
            fileOut.close();
            System.out.println("Save ok!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        SaveGame load = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            load = (SaveGame) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("SaveGame class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Loading Ok!");
        System.out.println(load);
    }
}
