package SaveGame;

import java.io.Serializable;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class SaveGame implements Serializable {
    public Date saveDate;
    public int secondsInGame;
    public Calendar gameTime;
    public int posX;
    public int posY;
    public int posZ;
    public int health;
    public int stamina;
    public int mana;
    public int hunger;
    public int coins;
    public int points;
    public String[] items;
    public String[] endedQuests;
    public String[] findItems;

    @Override
    public String toString() {
        return saveDate + "; health: "+health;
    }
}
