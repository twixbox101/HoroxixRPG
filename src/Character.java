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
    String charClass = "";
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
    //public Character myCharacter = new Character("", "", "", 1, 1, 1, 1, 1, 1, 0, 0, 0);
    public Map <String,Item> inventory = new HashMap<>();


    /**
     *
     * @param myName chosen name of your Character.
     * @param myGender chosen gender of your Character.
     * @param myClass chosen class of your Character.
     * @param myLevel current level of your Character. Changes by levelUp()
     * @param myCurrentHealth current Health of your Character.
     * @param myHealth total possible Health value of your Character.
     * @param myPower your character's power, or damage value.
     * @param myDefense your character's defense value.
     * @param myEXP character's current experience value. Goes up by fighting.
     * @param myCurrentMana character's current mana value.
     * @param myMana character's maximum mana value.
     * @param myGold current gold amount value.
     */

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

    public Character() {
    }

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
                skills = Skill.knightSkills;
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
                skills = Skill.rangerSkills;
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
                skills = Skill.wizardSkills;
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
                skills = Skill.druidSkills;
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
                skills = Skill.priestSkills;
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
        //    myCharacter.equipMyWeapon(Weapon.goldSword);
        //displays characters weapon + power
        //    System.out.println(myCharacter.power + myCharacter.getWeapon().power);
    }
}
