//imports hashmap and map to use
import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/26/2015.
 */
public class Weapon extends Item {
//creates map for weapons
    public static Map<String, Weapon> mapOfWeapons = new HashMap<>();
//list of weapons and their values
    public static Weapon woodSword = new Weapon("Wood Sword", 40, 25, 8);
    public static Weapon silverSword = new Weapon("Silver Sword", 150, 80, 45);
    public static Weapon goldSword = new Weapon("Gold Sword", 450, 300, 125);
    public static Weapon mythrilSword = new Weapon("Mythril Sword", 750, 575, 325);
    public static Weapon rubySword = new Weapon("Ruby Sword", 1200, 825, 525);
    public static Weapon katanaSword = new Weapon("Katana", 1400, 875, 600);
    public static Weapon excalibur = new Weapon("Excalibur", 2500, 1200, 1100);
    public static Weapon ultimaWeaponSword = new Weapon("Ultima Weapon", 9999, 1800, 1);
//adds Weapon to the mapOfWeapons(To get them use .get)
    static
    {
        mapOfWeapons.put("Gold Sword", goldSword);
        mapOfWeapons.put("Wood Sword", woodSword);
        mapOfWeapons.put("Silver Sword", silverSword);
        mapOfWeapons.put("Mythril Sword", mythrilSword);
        mapOfWeapons.put("Ruby Sword", rubySword);
        mapOfWeapons.put("Katana", katanaSword);
        mapOfWeapons.put("Excalibur", excalibur);
        mapOfWeapons.put("Ultima Weapon", ultimaWeaponSword);
    }
//creates the variables/string

    int power;

//sets up arguments for Weapon
    public Weapon(String weaponName, int weaponPrice, int weaponPower, int weaponSell){
        //Sets weapons to an ITEM class
        super(weaponName, weaponPrice, 0, weaponSell);
        price = weaponPrice;
        name = weaponName;
        sell = weaponSell;
        power = weaponPower;

    }
//simplifies object to a legible word
    public String toString() {
        return name;
    }


}
