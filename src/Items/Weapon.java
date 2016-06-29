package Items;//imports hashmap and map to use

import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/26/2015.
 */


public class Weapon extends Item {
//creates map for weapons
    public Map<String, Weapon> mapOfWeapons = new HashMap<String, Weapon>();

    //<editor-fold desc="Getters and Setters">
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    //</editor-fold>

//list of weapons and their values
    public static Weapon woodSword = new Weapon("Wood Sword", 40, 25, 8);
    public static Weapon knightSword = new Weapon("Knight's Sword", 0, 15, 1);
    public static Weapon woodBow = new Weapon("Wood Bow", 45, 28, 15);
    public static Weapon woodStaff = new Weapon("Wood Staff", 40, 20, 12);
    public static Weapon rangerBow = new Weapon("Ranger's Bow", 0, 9, 1);
    public static Weapon wizardStaff = new Weapon("Wizard's Staff", 0, 20, 1);
    public static Weapon druidClaws = new Weapon("Druid's Claws", 0, 12, 1);
    public static Weapon priestStaff = new Weapon("Priest's Staff", 0, 8, 1);
    public static Weapon silverSword = new Weapon("Silver Sword", 150, 80, 45);
    public static Weapon goldSword = new Weapon("Gold Sword", 450, 300, 125);
    public static Weapon mythrilSword = new Weapon("Mythril Sword", 750, 575, 325);
    public static Weapon rubySword = new Weapon("Ruby Sword", 1200, 825, 525);
    public static Weapon katana = new Weapon("Katana", 1400, 875, 600);
    public static Weapon excalibur = new Weapon("Excalibur", 2500, 1200, 1100);
    public static Weapon ultimaWeapon = new Weapon("Ultima Items.Weapon", 9999, 1800, 1);
//adds Items.Weapon to the mapOfWeapons(To get them use .get)

    {
        mapOfWeapons.put("Gold Sword", goldSword);
        mapOfWeapons.put("Wood Sword", woodSword);
        mapOfWeapons.put("Silver Sword", silverSword);
        mapOfWeapons.put("Mythril Sword", mythrilSword);
        mapOfWeapons.put("Ruby Sword", rubySword);
        mapOfWeapons.put("Katana", katana);
        mapOfWeapons.put("Excalibur", excalibur);
        mapOfWeapons.put("Ultima Items.Weapon", ultimaWeapon);
        mapOfWeapons.put("Knight's Sword", knightSword);
    }
//creates the variables/string

    private int power;

//sets up arguments for Items.Weapon
    public Weapon(String weaponName, int weaponPrice, int weaponPower, int weaponSell){
        //Sets weapons to an ITEM class
        super(weaponName, weaponPrice, 0, weaponSell, 0);
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
