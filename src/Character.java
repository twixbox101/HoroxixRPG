/**
 Created by Holden Johnson on 10/23/2015.
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Character {

//Defines variables for the character
    String name;
    String gender;
    String charClass;
    String location;
    int level;
    int currentHealth;
    int maxHealth;
    int power;
    int defense;
    int exp;
    int currentMana;
    int maxMana;
    int gold;
    Map skills;
    Weapon myWeapon;
    Armor myArmor;
    public static Character myCharacter = new Character("", "", "", 1, 1, 1, 1, 1, 1, 0, 0, 0);
    public static Map<Item,Integer> inventory = new HashMap<>();


//defines the Character class with his//hers arguments
    public Character(String myName, String myGender, String myClass, int myLevel, int myCurrentHealth, int myHealth, int myPower, int myDefense, int myEXP, int myCurrentMana, int myMana, int myGold) {
        name = myName;
        gender = myGender;
        charClass = myClass;
        level = myLevel;
        maxHealth = myHealth;
        power = myPower;
        defense = myDefense;
        exp = myEXP;
        currentMana = myCurrentMana;
        maxMana = myMana;
        gold = myGold;
        currentHealth = myCurrentHealth;
    }
//ChooseName method for character
    public void chooseName(){
        Scanner inputName = new Scanner( System.in );
        while(name.equals("")) {
            System.out.print("Please name your Character!");
            name = inputName.next();
            System.out.println("Your Character has been named " + name);
        }
    }
//ChooseClass method for character
    public void chooseClass(){
        Scanner inputClass = new Scanner( System.in );
        while(!charClass.equalsIgnoreCase("knight") && !charClass.equalsIgnoreCase("ranger") && !charClass.equalsIgnoreCase("wizard") && !charClass.equalsIgnoreCase("druid") && !charClass.equalsIgnoreCase("priest")) {
            System.out.print("Please choose a class!");
            System.out.println("[Knight][Ranger][Wizard][Druid][Priest]");
            charClass = inputClass.next();
            if(!charClass.equalsIgnoreCase("knight") && !charClass.equalsIgnoreCase("ranger") && !charClass.equalsIgnoreCase("wizard") && !charClass.equalsIgnoreCase("druid") && !charClass.equalsIgnoreCase("priest")) {
                System.out.println("Please select a valid class!");
            }
            else {
                System.out.println("You have chosen the " + charClass);
            }
        }
        if(charClass.equalsIgnoreCase("knight")){
            maxHealth = 120;
            currentHealth = maxHealth;
            power = 80;
            defense = 15;
            maxMana = 25;
            currentMana = maxMana;
            skills = Skill.knightSkills;
        }
        else if(charClass.equalsIgnoreCase("ranger")) {
            maxHealth = 95;
            currentHealth = maxHealth;
            power = 95;
            defense = 8;
            maxMana = 50;
            currentMana = maxMana;
            skills = Skill.rangerSkills;
        }
        else if(charClass.equalsIgnoreCase("wizard")) {
            maxHealth = 80;
            currentHealth = maxHealth;
            power = 120;
            defense = 2;
            maxMana = 100;
            currentMana = maxMana;
            skills = Skill.wizardSkills;
        }
        else if(charClass.equalsIgnoreCase("druid")) {
            maxHealth = 100;
            currentHealth = maxHealth;
            power = 85;
            defense = 8;
            maxMana = 80;
            currentMana = maxMana;
            skills = Skill.druidSkills;
        }
        else if(charClass.equalsIgnoreCase("priest")) {
            maxHealth = 85;
            currentHealth = maxHealth;
            power = 105;
            defense = 4;
            maxMana = 90;
            currentMana = maxMana;
            skills = Skill.priestSkills;
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
    public void chooseGender(){
        Scanner inputGender = new Scanner( System.in );
        while(!gender.equalsIgnoreCase("boy") && !gender.equalsIgnoreCase("girl")) {
            System.out.print("Are you a Boy or a Girl?");
            gender = inputGender.next();
            if(!gender.equalsIgnoreCase("boy") && !gender.equalsIgnoreCase("girl")) {
                System.out.println("I don't understand what you're saying...");
            }
            else {
                System.out.println("Ah, that's right. You're a " + gender);
            }
        }
    }




    public static void main(String[] args) {
        myCharacter.chooseName();
        myCharacter.chooseGender();
        myCharacter.chooseClass();
        System.out.println(myCharacter.charClass);
        System.out.println(myCharacter.name);
        System.out.println(myCharacter.gender);
        System.out.println(myCharacter.power);
        System.out.println(myCharacter.defense);
        System.out.println(myCharacter.maxHealth);
        Event.addItem(Weapon.goldSword, myCharacter);
        Event.addItem(Weapon.goldSword, myCharacter);
        Event.levelUP(myCharacter);
        System.out.println(myCharacter.level);
        System.out.println(myCharacter.power);
        System.out.println(myCharacter.defense);
        System.out.println(myCharacter.maxHealth);
        System.out.println(myCharacter.skills);

        //equips a weapon to myCharacter
        //    myCharacter.equipMyWeapon(Weapon.goldSword);
        //displays characters weapon + power
        //    System.out.println(myCharacter.power + myCharacter.getWeapon().power);
    }
}
