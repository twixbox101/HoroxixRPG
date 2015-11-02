/**
 Created by holden johnson on 10/24/2015.
 */
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Event {

    Weapon myWeapon;
    Armor myArmor;
    public static Skill mySkill;
    Monster monsterHealth;
    public static String skillChoice;
    public static String shopChoice;

    public Event(){
    }
//uses a potion to restore 30 health!
    public static void usePotion(Character myCharacter){
        int howMany = Character.inventory.get(Item.potion);
        if(howMany > 0) {
            Character.inventory.put(Item.potion, howMany-1);
            System.out.println("You have used a potion.");
            System.out.println("30 Health healed!");
            myCharacter.currentHealth +=Item.potion.heal;
            if(myCharacter.currentHealth > myCharacter.maxHealth){
                myCharacter.currentHealth = myCharacter.maxHealth;
            }
        }
        else
        {
            System.out.println("You don't have any potions!");
        }
    }
//Uses an elixir to heal 20 mana.
    public static void useElixir(Character myCharacter){
        int howMany = Character.inventory.get(Item.elixir);
        if(howMany > 0) {
            Character.inventory.put(Item.elixir, howMany-1);
            System.out.println("You have used an elixir.");
            System.out.println("20 Mana restored!");
            myCharacter.currentMana +=Item.elixir.heal;
            if(myCharacter.currentMana > myCharacter.maxMana){
                myCharacter.currentMana = myCharacter.maxMana;
            }
        }
        else
        {
            System.out.println("You don't have any elixers!");
        }
    }
//Adds item to My Character's Inventory
    public static void addItem(Item myItem, Character myCharacter){
        Integer howMany = Character.inventory.get(myItem);
        if(howMany == null) {
            Character.inventory.put(myItem, 1);
        }
        else
        {
            Character.inventory.put(myItem, howMany+1);
        }
    }
//Enters the shop and displays a list of items.
    public static void enterShop(){
        System.out.println("Welcome to the shop!");
        System.out.println("What can I get you?");
        for (Map.Entry<Item, Integer> entry : Item.mapOfItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
            while(!shopChoice.equalsIgnoreCase("potion") && !shopChoice.equalsIgnoreCase("elixir") && !shopChoice.equalsIgnoreCase("exit")){
                Scanner myInput = new Scanner(System.in);
                shopChoice = myInput.next();
                switch (shopChoice.toLowerCase()){
                    case "potion":
                        if(Character.myCharacter.gold >= Item.potion.price){
                            System.out.println("You have purchased a Potion!");
                            Character.inventory.put(Item.potion, 1);
                            Character.myCharacter.gold -= Item.potion.price;
                            }
                        else{
                            System.out.println("You don't have enough gold!");
                            }
                        break;
                    case "elixir":
                        if(Character.myCharacter.gold >= Item.elixir.price){
                            System.out.println("You have purchased an Elixir!");
                            Character.inventory.put(Item.elixir, 1);
                            Character.myCharacter.gold -= Item.elixir.price;
                        }
                        else{
                            System.out.println("You don't have enough gold!");
                        }
                        break;
                    case "exit":
                        System.out.println("You leave the shop");
                        break;
                        }
                    }
                }
//Generate random number
    public int generateRandom(){
        Random randomNumber = new Random();
        return randomNumber.nextInt(6);
    }
//Generate random monster based on value
    public Monster generateMonster(){
        int value = generateRandom();
        switch (value){
            case 0:
                Monster.currentMonster = Monster.goblin;
                break;
            case 1:
                Monster.currentMonster = Monster.bat;
                break;
            case 2:
                Monster.currentMonster = Monster.troll;
                break;
            case 3:
                Monster.currentMonster = Monster.skeleton;
                break;
            case 4:
                Monster.currentMonster = Monster.barbarian;
                break;
            case 5:
                Monster.currentMonster = Monster.dragon;
                break;
        }
    return Monster.currentMonster;
    }


//Deal damage
    public void attackDamage(){
        int totalDamage = Character.myCharacter.power + Character.myCharacter.myWeapon.power;
        Monster.currentMonster.health -= totalDamage += Monster.currentMonster.defense;
        double damageDealt = totalDamage -= Monster.currentMonster.defense;
        System.out.println("Damage dealt: " + damageDealt + "!");
        System.out.println(Monster.currentMonster.health);
    }
//Level Up!
    public static void levelUP(Character myCharacter){
        System.out.println("Congratulations! You have leveled up.");
        if(myCharacter.charClass.equalsIgnoreCase("knight")) {
            myCharacter.maxHealth *=1.65;
            myCharacter.defense *=1.25;
            myCharacter.level +=1;
            myCharacter.power *=1.25;
            myCharacter.maxMana *=1.10;
            myCharacter.currentHealth = myCharacter.maxHealth;
        }
        else if(myCharacter.charClass.equalsIgnoreCase("ranger")) {
            myCharacter.maxHealth *=1.45;
            myCharacter.defense *=1.15;
            myCharacter.level +=1;
            myCharacter.power *=1.45;
            myCharacter.maxMana *=1.25;
            myCharacter.currentHealth = myCharacter.maxHealth;
        }
        else if(myCharacter.charClass.equalsIgnoreCase("wizard")) {
            myCharacter.maxHealth *=1.25;
            myCharacter.defense *=1.10;
            myCharacter.level +=1;
            myCharacter.power *=1.65;
            myCharacter.maxMana *=1.50;
            myCharacter.currentHealth = myCharacter.maxHealth;
        }
        else if(myCharacter.charClass.equalsIgnoreCase("druid")) {
            myCharacter.maxHealth *=1.50;
            myCharacter.defense *=1.20;
            myCharacter.level +=1;
            myCharacter.power *=1.30;
            myCharacter.maxMana *=1.30;
            myCharacter.currentHealth = myCharacter.maxHealth;
        }
        else if(myCharacter.charClass.equalsIgnoreCase("priest")) {
            myCharacter.maxHealth *=1.40;
            myCharacter.defense *=1.15;
            myCharacter.level +=1;
            myCharacter.power *=1.10;
            myCharacter.maxMana *=1.45;
            myCharacter.currentHealth = myCharacter.maxHealth;
        }
    }
    // equips a weapon. change myWeapon to the weapon you want to equip.
    public void equipMyWeapon(Weapon myWeapon) {
        this.myWeapon = myWeapon;
        System.out.println("You have equipped " + myWeapon);
    }
    // equips armor. change myArmor to the piece of armor you want to equip.
    public void equipMyArmor(Armor myArmor) {
        this.myArmor = myArmor;
        System.out.println("You have equipped " + myArmor);
    }

//Uses a skill. If it's a healing spell, or healing is > 0, it will run the healing code. Else it will run the damage code.
    public static void useSkill(Skill aMySkill) {
        mySkill = aMySkill;
        System.out.println("You use " + mySkill + "!");
        if (mySkill.heal > 0) {
            Character.myCharacter.currentHealth += mySkill.heal;
            if (Character.myCharacter.currentHealth > Character.myCharacter.maxHealth) {
                Character.myCharacter.currentHealth = Character.myCharacter.maxHealth;
            }
            System.out.println("Healed for " + mySkill.heal + "!");
            System.out.println(Character.myCharacter.currentHealth);
        }
        else {
            Monster.currentMonster.health -= mySkill.damage += Monster.currentMonster.defense;
            double damageDealt = mySkill.damage -= Monster.currentMonster.defense;
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(Monster.currentMonster.health);
        }
    }/*Asks to choose a skill. You input a skill name (currently a letter) and it will see if you have that in your
    skills.If it does, it executes. If not it will not execute. This currently only works for Knights. */
    public static void getSkillChoice() {
        Scanner inputChoice = new Scanner(System.in);
        System.out.println("Choose a skill!");
        skillChoice = inputChoice.next();
        if (skillChoice != null) {
            if(Character.myCharacter.skills.containsKey(Skill.doubleSlash.name) && skillChoice.equalsIgnoreCase("d")){
                useSkill(Skill.doubleSlash);
            }
            else{
                System.out.println("You don't have that skill!");
            }
        }
        else{
            System.out.println("Please select a skill.");
        }
    }
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        System.out.println(inv);
        Character.myCharacter.equipMyWeapon(Weapon.excalibur);
        System.out.println(Character.myCharacter.myWeapon);
        useSkill(Skill.doubleSlash);
        useSkill(Skill.cure);
        Character.myCharacter.skills = Skill.knightSkills;
        getSkillChoice();
        enterShop();

    }

}




