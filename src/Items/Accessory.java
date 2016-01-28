package Items;

import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Accessory extends Item {

//assigns variables for defense and currentHealth
    private int defense;
    private int health;
    private String name;

    //<editor-fold desc="Getters and Setters">
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>

    //creates hashmap of armor
    Map<String, Accessory> mapOfAccessories = new HashMap<>();
//lists all armor to add to hashmap
    public static Accessory ironWristBand = new Accessory("Iron Wristband", 45, 10, 10, 25);


//adds Items.Armor to mapOfArmor. (To grab use .get())
     {
        mapOfAccessories.put("Iron Wristband", ironWristBand);

    }

//paramater descriptions
    /**
     * @param accName name of the Items.Armor.
     * @param accPrice price of the Items.Armor for the store.
     * @param accDefense defense value of the Items.Armor.
     * @param accSell sell value of the Items.Armor.
     * @param accHealth added currentHealth value of the Items.Armor.
     */
//defines armor and it's parameters
    public Accessory(String accName, int accPrice, int accDefense, int accSell, int accHealth){
        super(accName,accPrice, 0, accSell, 0);
        price = accPrice;
        name = accName;
        sell = accSell;
        defense = accDefense;
        health = accHealth;

    }
//returns name of armor
    public String toString() {
        return name;
    }



}


