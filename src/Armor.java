import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Armor extends Item {

//assigns variables for defense and currentHealth
    int defense;
    int health;
    String name;
//creates hashmap of armor
    public static Map<String,Armor> mapOfArmor = new HashMap<>();
//lists all armor to add to hashmap
    public static Armor woodArmor = new Armor("Wood Armor", 45, 10, 10, 25);
    public static Armor silverArmor = new Armor("Silver Armor", 120, 35, 50, 60);
    public static Armor goldArmor = new Armor("Gold Armor", 425, 80, 50, 125);
    public static Armor mythrilArmor = new Armor("Mythril Armor", 800, 155, 300, 225);
    public static Armor rubyArmor = new Armor("Ruby Armor", 1400, 355, 625, 450);
    public static Armor samuraiArmor = new Armor("Samurai Armor", 1600, 300, 400, 600);
//adds Armor to mapOfArmor. (To grab use .get())
    static {
        mapOfArmor.put("Wood Armor", woodArmor);
        mapOfArmor.put("Silver Armor", silverArmor);
        mapOfArmor.put("Gold Armor", goldArmor);
        mapOfArmor.put("Mythril Armor", mythrilArmor);
        mapOfArmor.put("Ruby Armor", rubyArmor);
        mapOfArmor.put("Samurai Armor", samuraiArmor);
    }

//paramater descriptions
    /**
     * @param armorName name of the Armor.
     * @param armorPrice price of the Armor for the store.
     * @param armorDefense defense value of the Armor.
     * @param armorSell sell value of the Armor.
     * @param armorHealth added currentHealth value of the Armor.
     */
//defines armor and it's parameters
    public Armor(String armorName, int armorPrice, int armorDefense, int armorSell, int armorHealth){
        super(armorName,armorPrice, 0, armorSell);
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


