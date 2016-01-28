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
    Map<String, Accessory> mapOfArmor = new HashMap<>();
//lists all armor to add to hashmap
    public static Accessory woodArmor = new Accessory("Wood Items.Armor", 45, 10, 10, 25);
    public static Accessory knightArmor = new Accessory("Knight's Items.Armor", 0, 3, 1, 5);
    public static Accessory rangerArmor = new Accessory("Ranger's Items.Armor", 0, 1, 1, 3);
    public static Accessory wizardArmor = new Accessory("Wizard's Robes", 0, 1, 1, 2);
    public static Accessory druidArmor = new Accessory("Druid's Items.Armor", 0, 3, 1, 4);
    public static Accessory priestArmor = new Accessory("Priest's Robes", 0, 0, 1, 9);
    public static Accessory silverArmor = new Accessory("Silver Items.Armor", 120, 35, 50, 60);
    public static Accessory goldArmor = new Accessory("Gold Items.Armor", 425, 80, 50, 125);
    public static Accessory mythrilArmor = new Accessory("Mythril Items.Armor", 800, 155, 300, 225);
    public static Accessory rubyArmor = new Accessory("Ruby Items.Armor", 1400, 355, 625, 450);
    public static Accessory samuraiArmor = new Accessory("Samurai Items.Armor", 1600, 300, 400, 600);

//adds Items.Armor to mapOfArmor. (To grab use .get())
     {
        mapOfArmor.put("Wood Items.Armor", woodArmor);
        mapOfArmor.put("Silver Items.Armor", silverArmor);
        mapOfArmor.put("Gold Items.Armor", goldArmor);
        mapOfArmor.put("Mythril Items.Armor", mythrilArmor);
        mapOfArmor.put("Ruby Items.Armor", rubyArmor);
        mapOfArmor.put("Samurai Items.Armor", samuraiArmor);
    }

//paramater descriptions
    /**
     * @param armorName name of the Items.Armor.
     * @param armorPrice price of the Items.Armor for the store.
     * @param armorDefense defense value of the Items.Armor.
     * @param armorSell sell value of the Items.Armor.
     * @param armorHealth added currentHealth value of the Items.Armor.
     */
//defines armor and it's parameters
    public Accessory(String armorName, int armorPrice, int armorDefense, int armorSell, int armorHealth){
        super(armorName,armorPrice, 0, armorSell, 0);
        price = armorPrice;
        name = armorName;
        sell = armorSell;
        defense = armorDefense;
        health = armorHealth;

    }
//returns name of armor
    public String toString() {
        return name;
    }



}


