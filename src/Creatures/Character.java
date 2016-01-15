package Creatures; /**
 Created by Holden Johnson on 10/23/2015.
 */


import Items.Armor;
import Items.Item;
import Items.Weapon;
import Skills.Skill;

import java.util.*;

public class Character extends Creature {

//Defines variables for the character
    public String location;
    protected String gender;
    protected String charClass;
    protected Weapon myWeapon;
    protected Armor myArmor;
    public List<Skill> skills = new ArrayList<>();
    public static Character myCharacter = new Character("", "", "", 1, 1, 1, 1, 1, 1, 0, 0, 0);
    public Map<String, Item> inventory = new HashMap<>();

    /**
     *
     * @param name name of Creatures.Character
     * @param gender gender of Creatures.Character
     * @param myClass class of Creatures.Character
     * @param level current level of Creatures.Character
     * @param currentHealth current Health of Creatures.Character
     * @param maxHealth maximum health of Creatures.Character
     * @param currentMana current Mana of Creatures.Character
     * @param maxMana maximum mana of Creatures.Character
     * @param power power of Creatures.Character
     * @param defense defense of Creatures.Character
     * @param exp current experience of Creatures.Character
     * @param gold current gold carried by Creatures.Character
     */
//defines the Creatures.Character class with his//hers arguments
    public Character(String name, String gender, String myClass, int level, int currentHealth, int maxHealth, int currentMana, int maxMana, int power, int defense, int exp, int gold) {
        super(name, level, currentHealth, maxHealth, currentMana, maxMana, power, defense, exp, gold);
        this.gender = gender;
        this.charClass = myClass;
}

//<editor-fold desc="Getters and Setters">

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public List getSkills() {
        return skills;
    }

    public void setSkills(List skills) {
        this.skills = skills;
    }

    public Weapon getMyWeapon() {
        return myWeapon;
    }

    public void setMyWeapon(Weapon myWeapon) {
        this.myWeapon = myWeapon;
    }

    public Armor getMyArmor() {
        return myArmor;
    }

    public void setMyArmor(Armor myArmor) {
        this.myArmor = myArmor;
    }


    //</editor-fold>

    //ChooseName method for character
    public void chooseName(){
        Scanner inputName = new Scanner( System.in );
            System.out.print("Please name your Character!");
            name = inputName.next();
            System.out.println("Your Character has been named " + name);
    }
//ChooseClass method for character
    public void chooseClass() {
        while (!"knight".equalsIgnoreCase(charClass) && !"ranger".equalsIgnoreCase(charClass) && !"wizard".equalsIgnoreCase(charClass) && !"druid".equalsIgnoreCase(charClass) && !"priest".equalsIgnoreCase(charClass)) {
            Scanner inputClass = new Scanner(System.in);
            System.out.print("Please choose a class!");
            System.out.println("[Knight][Ranger][Wizard][Druid][Priest]");
            charClass = inputClass.next();
            if (!"knight".equalsIgnoreCase(charClass) && !"ranger".equalsIgnoreCase(charClass) && !"wizard".equalsIgnoreCase(charClass) && !"druid".equalsIgnoreCase(charClass) && !"priest".equalsIgnoreCase(charClass)) {
                System.out.println("Please select a valid class!");
            } else {
                System.out.println("You have chosen the " + charClass);
            }
        }
        switch (charClass.toLowerCase()) {
            case "knight":
                maxHealth = 120;
                level = 1;
                currentHealth = maxHealth;
                power = 80;
                defense = 15;
                maxMana = 25;
                currentMana = maxMana;
                skills.add(Skill.doubleSlash);
                equipMyWeapon(Weapon.knightSword);
                equipMyArmor(Armor.knightArmor);
                break;
            case "ranger":
                maxHealth = 95;
                level = 1;
                currentHealth = maxHealth;
                power = 95;
                defense = 8;
                maxMana = 50;
                currentMana = maxMana;
                skills.add(Skill.triShot);
                equipMyWeapon(Weapon.rangerBow);
                equipMyArmor(Armor.rangerArmor);
                break;
            case "wizard":
                maxHealth = 80;
                level = 1;
                currentHealth = maxHealth;
                power = 120;
                defense = 2;
                maxMana = 100;
                currentMana = maxMana;
                skills.add(Skill.fireBall);
                equipMyWeapon(Weapon.wizardStaff);
                equipMyArmor(Armor.wizardArmor);
                break;
            case "druid":
                maxHealth = 100;
                level = 1;
                currentHealth = maxHealth;
                power = 85;
                defense = 8;
                maxMana = 80;
                currentMana = maxMana;
                skills.add(Skill.death);
                equipMyWeapon(Weapon.druidClaws);
                equipMyArmor(Armor.druidArmor);
                break;
            case "priest":
                maxHealth = 85;
                level = 1;
                currentHealth = maxHealth;
                power = 105;
                defense = 4;
                maxMana = 90;
                currentMana = maxMana;
                skills.add(Skill.cure);
                equipMyWeapon(Weapon.priestStaff);
                equipMyArmor(Armor.priestArmor);
                break;
        }
    }
// gets weapon
    public Weapon getWeapon(){
        return myWeapon;
    }
// equips a weapon. change myWeapon to the weapon you want to equip.
    public void equipMyWeapon(Weapon myWeapon) {
        this.myWeapon = myWeapon;
    }
// equips armor. change myArmor to the piece of armor you want to equip.
    public void equipMyArmor(Armor myArmor) {
        this.myArmor = myArmor;
    }
//choose gender method
    public void chooseGender(Character myCharacter){
        Scanner inputGender = new Scanner( System.in );
        while(!"boy".equalsIgnoreCase(gender) && !"girl".equalsIgnoreCase(gender)) {
            System.out.print("Are you a Boy or a Girl?");
            gender = inputGender.next();
            if(!"boy".equalsIgnoreCase(gender) && !"girl".equalsIgnoreCase(gender)) {
                System.out.println("I don't understand what you're saying...");
            }
            else {
                System.out.println("Ah, that's right. You're a " + gender);
                myCharacter.location = "mainMenu";
            }
        }
    }




    public static void main(String[] args) {


        //equips a weapon to myCharacter
        //    myCharacter.equipMyWeapon(Items.Weapon.goldSword);
        //displays characters weapon + power
        //    System.out.println(myCharacter.power + myCharacter.getWeapon().power);


    }}