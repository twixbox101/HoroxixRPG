/**
 Created by holden johnson on 10/24/2015.
 */
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Event {

    Weapon myWeapon;
    Armor myArmor;
    public static Skill mySkill;
    public static String skillChoice;
    public static String shopChoice;
    Monster monsterHealth;
    String travelChoice;



    public Event() {
    }

    //uses a potion to restore 30 currentHealth!
    public void usePotion(Character myCharacter) {
        int howMany = myCharacter.inventory.get(Item.potion).quantity;
        if (howMany > 0) {
            myCharacter.inventory.put(Item.elixir.name, Item.potion);
            System.out.println("You have used a potion.");
            System.out.println("30 Health healed!");
            int myHealth = myCharacter.getCurrentHealth();
            myCharacter.setCurrentHealth(myHealth + Item.potion.heal);
            if (myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                int healthCheck = myCharacter.getMaxHealth();
                myCharacter.setCurrentHealth(healthCheck);
            }
        } else {
            System.out.println("You don't have any potions!");
        }
    }

    //Uses an elixir to heal 20 mana.
    public void useElixir(Character myCharacter) {
        int howMany = myCharacter.inventory.get(Item.elixir).quantity;
        if (howMany > 0) {
            myCharacter.inventory.put(Item.elixir.name, Item.elixir);
            System.out.println("You have used an elixir.");
            System.out.println("20 Mana restored!");
            myCharacter.currentMana += Item.elixir.heal;
            if (myCharacter.currentMana > myCharacter.maxMana) {
                myCharacter.currentMana = myCharacter.maxMana;
            }
        } else {
            System.out.println("You don't have any elixirs!");
        }
    }

    //Adds item to My Character's Inventory
    public void addItem(Item myItem, Character myCharacter) {
        Item invItem = myCharacter.inventory.get(myItem.name);
        if (invItem == null) {
            myCharacter.inventory.put(myItem.name, myItem);
            myItem.quantity++;
        } else {
            myItem.quantity++;
        }
    }

    public void travel(Character myCharacter) {
        myCharacter.setLocation("travel");
        System.out.println("You have decided to travel");
        System.out.println("Where would you like to go?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals("travel")) {
            System.out.println("[Plains][Forest][Mountains][Island][Swamp][Info]");
            travelChoice = myInput.next();
            switch (travelChoice.toLowerCase()) {
                case "plains":
                    myCharacter.setLocation("plains");
                    atPlains(myCharacter);
                    break;
                case "forest":
                    if (myCharacter.getLevel() < 5) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("forest");
                        atForest(myCharacter);
                    }
                    break;
                case "mountains":
                    if (myCharacter.getLevel() < 10) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("mountains");
                    }
                    break;
                case "island":
                    if (myCharacter.getLevel() < 15) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("island");
                    }
                    break;
                case "swamp":
                    if (myCharacter.getLevel() < 20) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("swamp");
                    }
                    break;
                case "dev":
                    myCharacter.setLevel(25);
                    myCharacter.setGold(9999);
                    myCharacter.setMyWeapon(Weapon.ultimaWeapon);
                    myCharacter.setMyArmor(Armor.rubyArmor);
                    System.out.println("dev!");
                    break;
                case "info":
                    System.out.println("[Plains : Levels 1-5]\n" +
                            "[Forest: Levels 5-10]\n" +
                            "[Mountains : Levels 10-15]\n" +
                            "[Island : Levels 15-20]\n" +
                            "[Swamp : Levels 20+]\n"
                    );
                    break;
                case "exit":
                    System.out.println("You decide not to travel");
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");

            }
        }
    }

    public void atPlains(Character myCharacter) {
        System.out.println("You have arrived at the Thunder Plains. Dry fields span in front of you as far as the eye can see.");
        System.out.println("What would you like to do?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals("plains")) {
            System.out.println("[Explore][Inventory][Leave]");
            String plainsChoice = myInput.next();
            switch (plainsChoice.toLowerCase()) {
                case "explore":
                    System.out.println("You explore.");
                    generateRandom();
                    if (generateRandom() <= 2) {
                        findGoldPlains(myCharacter);
                    } else
                        enterBattle(myCharacter);
                    break;
                case "inventory":
                    inInventory(myCharacter);
                    break;
                case "leave":
                    System.out.println("You decide to leave");
                    myCharacter.setLocation("travel");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    public void atForest(Character myCharacter) {
        System.out.println("You have arrived at the forests of Eldra. The air is humid and the green leaves blow eerily in the wind.");
        System.out.println("What would you like to do?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals("forest")) {
            System.out.println("[Explore][Inventory][Leave]");
            String forestChoice = myInput.next();
            switch (forestChoice.toLowerCase()) {
                case "explore":
                    System.out.println("You explore.");
                    generateRandom();
                    if (generateRandom() <= 2) {
                        findGoldForest(myCharacter);
                    } else
                        enterBattle(myCharacter);
                    break;
                case "inventory":
                    inInventory(myCharacter);
                    break;
                case "leave":
                    System.out.println("You decide to leave");
                    myCharacter.setLocation("travel");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    public void findGoldPlains(Character myCharacter) {
        Random randomGold = new Random();
        int foundGold = randomGold.nextInt(10);
        int currentGold = myCharacter.getGold() + foundGold;
        myCharacter.setGold(currentGold);
        System.out.println("You discover " + foundGold + " gold!");
        System.out.println("Total : " + myCharacter.getGold());
    }

    public void findGoldForest(Character myCharacter) {
        Random randomGold = new Random();
        int foundGold = randomGold.nextInt(25);
        myCharacter.setGold(foundGold);
        System.out.println("You discover " + foundGold);
        System.out.println("Total " + myCharacter.getGold());
    }


    //Enters the shop and displays a list of items.
    public void enterShop(Character myCharacter) {
        myCharacter.setLocation("shop");
        System.out.println("Welcome to the shop!");
        System.out.println("What can I get you?");
        for (Map.Entry<Item, Integer> entry : Item.mapOfItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
        while (myCharacter.getLocation() == "shop") {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "potion":
                    if (myCharacter.gold >= Item.potion.price) {
                        System.out.println("You have purchased a Potion!");
                        myCharacter.inventory.put(Item.potion.name, Item.potion);
                        Item.potion.quantity++;
                        myCharacter.gold -= Item.potion.price;
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "elixir":
                    if (myCharacter.gold >= Item.elixir.price) {
                        System.out.println("You have purchased an Elixir!");
                        myCharacter.inventory.put(Item.elixir.name, Item.elixir);
                        Item.elixir.quantity++;
                        myCharacter.gold -= Item.elixir.price;
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "exit":
                    System.out.println("You leave the shop");
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    //Generate random number
    public int generateRandom() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(6);
    }


    //Generate random monster based on value
    //TODO - finish for each location. Verify that it's not modifying the original monster, and only a new instance of it.
    Monster generateMonster(Character myCharacter) {
        Monster value = new Monster("test", 0,0,0,0,0,0,0,0,0);
        String location = myCharacter.getLocation();
        switch (location) {
            case "plains":
                Random generator = new Random();
                int randomIndex = generator.nextInt(Plains.enemyList.size());
                Monster monster = Plains.enemyList.get(randomIndex);
                System.out.println(monster.getName());
                return monster;
            case "b":
                System.out.println("ok");
        }
        return value;
    }

//Enters Battle, generates the monster that the character fights
    public void enterBattle(Character myCharacter){
        Monster currentMonster = generateMonster(myCharacter);
        System.out.println("You have encountered a " + currentMonster + "!");
        fight(myCharacter, currentMonster);
    }
//Battle System 1.0
    //TODO - Run system
    public void fight(Character myCharacter, Monster currentMonster) {
        while (myCharacter.getCurrentHealth() >= 1 || currentMonster.getCurrentHealth() >= 1) {
            String battleChoice;
            Scanner battleInput = new Scanner(System.in);
            System.out.println("What do you do?");
            System.out.println("[Attack][Skill][Item][Run]");
            battleChoice = battleInput.next();
            switch (battleChoice.toLowerCase()){
                case "attack":
                    System.out.println("You attack!");
                    attackDamage(myCharacter, currentMonster);
                    break;
                case "skill":
                    getSkillChoice(myCharacter, currentMonster);
                    break;
                case "item":
                    System.out.println(myCharacter.inventory);
                    break;
                case "run":
                    System.out.println("coward");
                    break;
                default:
                    System.out.println("Select an action!");
                    break;
            }
        }
    }
//Deal damage
    public void attackDamage(Character myCharacter, Monster currentMonster){
        int value = hitOrMiss();
        if(value <3){
            System.out.println("Your attack missed!");
        }
        else{
            int totalDamage = damageDealt(myCharacter);
            int newHealth = currentMonster.getCurrentHealth() - totalDamage + currentMonster.getDefense();
            currentMonster.setCurrentHealth(newHealth);
            double damageDealt = totalDamage - currentMonster.getDefense();
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(currentMonster.getName() + " health remaining " + currentMonster.getCurrentHealth());
        }
    }

//Hit or Miss
    public int hitOrMiss(){
        Random hitMiss = new Random();
        return hitMiss.nextInt(10);
    }

//Calculates Damage Dealt including min/max
    public int damageDealt(Character myCharacter){
        Random damage = new Random();
        int power = myCharacter.getPower() + myCharacter.myWeapon.getPower();
        int maxDamage = power + 50;
        int minDamage = power - 25;
        int resultDamage = damage.nextInt(maxDamage-minDamage) + minDamage;
        return resultDamage;
    }


//MainMenu 1.0 WIP
    public void mainMenu(Character myCharacter) {
        String menuChoice;
        Scanner menuInput = new Scanner(System.in);
        while(myCharacter.getLocation() == "mainMenu"){
        System.out.println("[Travel][Shop][Inventory][Stats]");
        menuChoice = menuInput.next();
        switch (menuChoice.toLowerCase()) {
            case "travel":
                travel(myCharacter);
                break;
            case "shop":
                enterShop(myCharacter);
                break;
            case "inventory":
                inInventory(myCharacter);
                break;
            case "stats":
                System.out.println("Class: " + myCharacter.getCharClass());
                System.out.println("Level: " + myCharacter.getLevel());
                System.out.println("EXP: " + myCharacter.getExp());
                System.out.println("Health: " + myCharacter.getCurrentHealth() + "/" + myCharacter.getMaxHealth());
                System.out.println("Power: " + (myCharacter.getPower() + myCharacter.myWeapon.getPower()));
                System.out.println("Defense: " + (myCharacter.getDefense() + myCharacter.myArmor.getDefense()));
                System.out.println("Weapon: " + myCharacter.myWeapon);
                System.out.println("Armor: " + myCharacter.myArmor);
                break;
            default:
                System.out.println("Please select a valid option.");
        }
        }
    }
//Inventory 1.0 WIP
    public void inInventory(Character myCharacter){
        System.out.println(myCharacter.inventory);
        System.out.println("What would you like to do?");
        System.out.println("[Equip][Exit]");
        String invChoice;
        Scanner menuInput = new Scanner(System.in);
        invChoice = menuInput.next();
        switch(invChoice.toLowerCase()){
            case "equip":
                equipMenu(myCharacter);
                break;
            case "exit":
                System.out.println("You leave.");
                //mainMenu(myCharacter);
                break;
            default:
                System.out.println("Please select a valid option.");
        }

    }
//Equip Menu 1.0 WIP
    public void equipMenu(Character myCharacter){
        String equipChoice;
        System.out.println("What would you like to equip?");
        System.out.println("[Armor][Weapon]");
        Scanner menuInput = new Scanner(System.in);
        equipChoice = menuInput.next();
        switch(equipChoice.toLowerCase()){
            case "armor":
                equipArmor(myCharacter);
                break;
            case "weapon":
                break;
        }
    }
//equip armor by choice WIP
    public void equipArmor(Character myCharacter){
        String armorChoice;
        Scanner menuInput = new Scanner(System.in);
        armorChoice = menuInput.next();
        System.out.println("Please type the name of the armor you'd like to equip.");
        if(myCharacter.inventory.containsKey(armorChoice)){
            Item armorItem = myCharacter.inventory.get(armorChoice);
            int checkAmount = armorItem.quantity;
            if(checkAmount > 0) {
                armorItem.quantity -= 1;
                equipMyArmor(armorItem);
            }
            else
            {
            System.out.println("You don't have any!");
            }
        }
    }

//Level Up!
    public void levelUP(Character myCharacter){
        System.out.println("Congratulations! You have leveled up.");
        switch (myCharacter.getCharClass().toLowerCase()){
            case "knight":
                double maxHealthKnight = myCharacter.getMaxHealth();
                myCharacter.setMaxHealth((int) Math.round(maxHealthKnight * 1.65));
                double defenseKnight = myCharacter.getDefense();
                myCharacter.setDefense((int) Math.round(defenseKnight * 1.25));
                int newLevelKnight = myCharacter.getLevel();
                myCharacter.setLevel(newLevelKnight + 1);
                double powerKnight = myCharacter.getPower();
                myCharacter.setPower((int) Math.round(powerKnight * 1.25));
                myCharacter.maxMana *=1.10;
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "ranger":
                double maxHealthRanger = myCharacter.getMaxHealth();
                myCharacter.setMaxHealth((int) Math.round(maxHealthRanger * 1.45));
                double defenseRanger = myCharacter.getDefense();
                myCharacter.setDefense((int) Math.round(defenseRanger * 1.15));
                int newLevelRanger = myCharacter.getLevel();
                myCharacter.setLevel(newLevelRanger + 1);
                double powerRanger = myCharacter.getPower();
                myCharacter.setPower((int) Math.round(powerRanger * 1.45));
                myCharacter.maxMana *=1.25;
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "wizard":
                double maxHealthWizard = myCharacter.getMaxHealth();
                myCharacter.setMaxHealth((int) Math.round(maxHealthWizard * 1.25));
                double defenseWizard = myCharacter.getDefense();
                myCharacter.setDefense((int) Math.round(defenseWizard * 1.10));
                int newLevelWizard = myCharacter.getLevel();
                myCharacter.setLevel(newLevelWizard + 1);
                double powerWizard = myCharacter.getPower();
                myCharacter.setPower((int) Math.round(powerWizard * 1.65));
                myCharacter.maxMana *=1.50;
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "druid":
                double maxHealthDruid = myCharacter.getMaxHealth();
                myCharacter.setMaxHealth((int) Math.round(maxHealthDruid * 1.50));
                double defenseDruid = myCharacter.getDefense();
                myCharacter.setDefense((int) Math.round(defenseDruid * 1.20));
                int newLevelDruid = myCharacter.getLevel();
                myCharacter.setLevel(newLevelDruid + 1);
                double powerDruid = myCharacter.getPower();
                myCharacter.setPower((int) Math.round(powerDruid * 1.30));
                myCharacter.maxMana *=1.30;
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "priest":
                double maxHealthPriest = myCharacter.getMaxHealth();
                myCharacter.setMaxHealth((int) Math.round(maxHealthPriest * 1.40));
                double defensePriest = myCharacter.getDefense();
                myCharacter.setDefense((int) Math.round(defensePriest * 1.15));
                int newLevelPriest = myCharacter.getLevel();
                myCharacter.setLevel(newLevelPriest + 1);
                double powerPriest = myCharacter.getPower();
                myCharacter.setPower((int) Math.round(powerPriest * 1.10));
                myCharacter.maxMana *=1.45;
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
        }
    }
    // equips a weapon. change myWeapon to the weapon you want to equip.
    public void equipMyWeapon(Item myWeapon) {
        this.myWeapon = (Weapon)myWeapon;
        System.out.println("You have equipped " + myWeapon);
    }
    // equips armor. change myArmor to the piece of armor you want to equip.
    public void equipMyArmor(Item myArmor) {
        if(myArmor instanceof Armor)
        this.myArmor = (Armor)myArmor;
        System.out.println("You have equipped " + myArmor);
    }
//Uses a skill. If it's a healing spell, or healing is > 0, it will run the healing code. Else it will run the damage code.
    public void useSkill(Character myCharacter, Skill aMySkill, Monster currentMonster) {
        mySkill = aMySkill;
        System.out.println("You use " + mySkill + "!");
        if (mySkill.heal > 0) {
            int toHeal = myCharacter.getCurrentHealth();
            myCharacter.setCurrentHealth(toHeal += mySkill.heal);
            if(myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                int healthCheck = myCharacter.getMaxHealth();
                myCharacter.setCurrentHealth(healthCheck);
            }
            System.out.println("Healed for " + mySkill.heal + "!");
            System.out.println(myCharacter.getCurrentHealth());
        }
        else {
            double newHealth;
            newHealth = currentMonster.getCurrentHealth() - mySkill.damage + currentMonster.getDefense();
            currentMonster.setCurrentHealth((int) Math.round(newHealth));
            double damageDealt = mySkill.damage - currentMonster.getDefense();
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(currentMonster.getCurrentHealth() + "/" + currentMonster.getMaxHealth());
        }
    }
    /*Asks to choose a skill. You input a skill name (currently a letter) and it will see if you have that in your
    skills.If it does, it executes. If not it will not execute. This currently only works for Knights. */
    public void getSkillChoice(Character myCharacter, Monster currentMonster) {
        Scanner inputChoice = new Scanner(System.in);
        System.out.println("Choose a skill!");
        skillChoice = inputChoice.next();
        if (skillChoice != null) {
            if(myCharacter.skills.containsKey(Skill.doubleSlash.name) && skillChoice.equalsIgnoreCase("d")){
                useSkill(myCharacter, Skill.doubleSlash, currentMonster);
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



    }

}




