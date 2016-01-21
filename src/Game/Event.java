package Game; /**
 Created by holden johnson on 10/24/2015.
 */
import Creatures.Character;
import Creatures.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import Locations.Location;
import Locations.Plains;
import Skills.Skill;
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
        int howMany = myCharacter.inventory.get(Item.potion).getQuantity();
        if (howMany > 0) {
            myCharacter.inventory.put(Item.elixir.getName(), Item.potion);
            System.out.println("You have used a potion.");
            System.out.println("30 Health healed!");
            int myHealth = myCharacter.getCurrentHealth();
            myCharacter.setCurrentHealth(myHealth + Item.potion.getHeal());
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
        int howMany = myCharacter.inventory.get(Item.elixir).getQuantity();
        if (howMany > 0) {
            myCharacter.inventory.put(Item.elixir.getName(), Item.elixir);
            System.out.println("You have used an elixir.");
            System.out.println("20 Mana restored!");
            int currentMana = myCharacter.getCurrentMana();
            currentMana += Item.elixir.getHeal();
            myCharacter.setCurrentMana(currentMana);
            if (myCharacter.getCurrentMana() > myCharacter.getMaxMana()) {
                myCharacter.setCurrentMana(myCharacter.getMaxMana());
            }
        } else {
            System.out.println("You don't have any elixirs!");
        }
    }

    //Adds item to My Creatures.Character's Inventories.Inventory
    //TODO - refactor the quantity mechanic to a player value
    public void addItem(Item myItem, Character myCharacter) {
        Item invItem = myCharacter.inventory.get(myItem.getName());
        if (invItem == null) {
            myCharacter.inventory.put(myItem.getName(), myItem);
            //myItem.setQuantity();
        } else {
            //myItem.quantity++;
        }
    }
    //Travel Menu. Select a destination.
    public void travel(Character myCharacter) {
        myCharacter.setLocation("travel");
        System.out.println("You have decided to travel");
        System.out.println("Where would you like to go?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals("travel")) {
            System.out.println("[Plains][Forest][Mountains][Island][Swamp][Info][Exit]");
            travelChoice = myInput.next();
            switch (travelChoice.toLowerCase()) {
                case "plains":
                    myCharacter.setLocation("plains");
                    atLocation(myCharacter, myCharacter.getLocation());
                    break;
                case "forest":
                    if (myCharacter.getLevel() < 5) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("forest");
                        atLocation(myCharacter, myCharacter.getLocation());
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
                    System.out.println("[Locations.Plains : Levels 1-5]\n" +
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
    //Plains Menu.
    //TODO - can i make one method for At, and pass in the location?
    public void atLocation(Character myCharacter, String currentLocation) {
        System.out.println("You have arrived at the " + currentLocation);
        System.out.println("What would you like to do?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals(currentLocation)) {
            System.out.println("[Explore][Inventory][Leave]");
            String choice = myInput.next();
            switch (choice.toLowerCase()) {
                case "explore":
                    System.out.println("You explore.");
                    generateRandom();
                    if (generateRandom() <= 2) {
                        findGold(myCharacter, currentLocation);
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
    //Finds gold based on location
    //TODO - add the rest of the locations.
    public void findGold(Character myCharacter, String currentLocation) {
        Random randomGold = new Random();
        switch (currentLocation){
            case "plains":
                int foundGold = randomGold.nextInt(10);
                myCharacter.setGold(myCharacter.getGold() + foundGold);
                System.out.println("You discover " + foundGold + " gold!");
                System.out.println("Total : " + myCharacter.getGold());
                break;
            case "forest":
                foundGold = randomGold.nextInt(25);
                myCharacter.setGold(myCharacter.getGold() + foundGold);
                System.out.println("You discover " + foundGold + " gold!");
                System.out.println("Total : " + myCharacter.getGold());
                break;
        }
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
        while ("shop".equals(myCharacter.getLocation())) {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "potion":
                    if (myCharacter.getGold() >= Item.potion.getPrice()) {
                        System.out.println("You have purchased a Potion!");
                        myCharacter.inventory.put(Item.potion.getName(), Item.potion);
                        Item.potion.setQuantity(Item.potion.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.potion.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "elixir":
                    if (myCharacter.getGold() >= Item.elixir.getPrice()) {
                        System.out.println("You have purchased an Elixir!");
                        myCharacter.inventory.put(Item.elixir.getName(), Item.elixir);
                        Item.elixir.setQuantity(Item.elixir.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.elixir.getPrice());
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
        Monster value = new Monster("test", 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
    public void enterBattle(Character myCharacter) {
        Monster currentMonster = generateMonster(myCharacter);
        System.out.println("You have encountered a " + currentMonster + "!");
        fight(myCharacter, currentMonster);
    }

    //Battle System 1.0
    //TODO - Run system
    public void fight(Character myCharacter, Monster currentMonster) {
        int currentMonsterHealth = currentMonster.getMaxHealth();
        String currentLocation = myCharacter.getLocation();
        myCharacter.setLocation("fight");
        while (myCharacter.getCurrentHealth() >= 1 && currentMonsterHealth >= 1 && !myCharacter.getLocation().equals(currentLocation)) {
            String battleChoice;
            Scanner battleInput = new Scanner(System.in);
            System.out.println("What do you do?");
            System.out.println("[Attack][Skill][Item][Run]");
            battleChoice = battleInput.next();
            switch (battleChoice.toLowerCase()) {
                case "attack":
                    System.out.println("You attack!");
                    int value = hitOrMiss();
                    if(value < 2){
                        System.out.println("Your attack missed!");}
                    else {
                        int damage =  attackDamage(myCharacter, currentMonster);
                        System.out.println("Your attack deals " + damage + " damage!");
                        currentMonsterHealth -= damage;
                        System.out.println(currentMonster.getName() + " health remaining: " + currentMonsterHealth + "/ " + currentMonster.getMaxHealth());
                    }
                    if(currentMonsterHealth > 0){
                    attackBack(myCharacter, currentMonster);
                    }
                    break;
                case "skill":
                    getSkillChoice(myCharacter, currentMonster);
                    break;
                case "item":
                    System.out.println(myCharacter.inventory);
                    break;
                case "run":
                    System.out.println("coward");
                    myCharacter.setLocation(currentLocation);
                    break;
                default:
                    System.out.println("Select an action!");
                    break;
            }
        }
        victory(myCharacter, currentMonster, currentLocation);
    }

    //Deal damage
    public int attackDamage(Character myCharacter, Monster currentMonster) {
        return damageDealt(myCharacter) - currentMonster.getDefense();
    }

    //Hit or Miss
    public int hitOrMiss(){
        Random hitMiss = new Random();
        return hitMiss.nextInt(10);
    }

    //Calculates Damage Dealt including min/max
    public int damageDealt(Character myCharacter){
        Random damage = new Random();
        int power = myCharacter.getPower() + myCharacter.getMyWeapon().getPower();
        int maxDamage = power + 50;
        int minDamage = power - 25;
        return damage.nextInt(maxDamage-minDamage) + minDamage;
    }

    //Calculates the monster attacking back after either a failed or successful attack by the player.
    public int attackBack(Character myCharacter, Monster currentMonster){
        System.out.println("The " + currentMonster.getName() + " attacks!");
        int value = hitOrMiss();
        int resultDamage = 0;
        if(value < 3){
            System.out.println(currentMonster.getName() + "'s attack misses!");
        }
        else{
            System.out.println("It hits!");
            Random damage = new Random();
            int maxDmg = ((int) Math.round(currentMonster.getPower() * 1.25));
            int minDmg = ((int) Math.round(currentMonster.getPower() * -.25));
            resultDamage = damage.nextInt(maxDmg-minDmg) + minDmg;
            System.out.println("The " + currentMonster.getName() + " deals " + resultDamage);
            editHealth(myCharacter, resultDamage);
            return resultDamage;
        }
        return resultDamage;
    }

    //Method to edit the health of the player.
    public void editHealth(Character myCharacter, int resultDamage){
        myCharacter.setCurrentHealth(myCharacter.getCurrentHealth() - resultDamage);
        System.out.println("Health : " + myCharacter.getCurrentHealth() + " / " + myCharacter.getMaxHealth());
    }

    //Method that runs upon victory of a battle.
    //TODO - add victory taunt, exp, gold, drops, etc.
    public void victory(Character myCharacter, Monster currentMonster, String currentLocation){
        System.out.println(currentMonster + " has been slain!");
        System.out.println("Gained " + currentMonster.getExp() + " EXP.");
        myCharacter.setExp(myCharacter.getExp() + currentMonster.getExp());
        System.out.println("Total EXP: " + myCharacter.getExp());
        System.out.println(currentMonster.getName() + " dropped " + currentMonster.getGold() + " gold!");
        myCharacter.setGold(myCharacter.getGold() + currentMonster.getGold());
        myCharacter.setLocation(currentLocation);
    }


    //MainMenu 1.0 WIP
    public void mainMenu(Character myCharacter) {
        String menuChoice;
        Scanner menuInput = new Scanner(System.in);
        while(myCharacter.getLocation().equals("mainMenu")){
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
                viewStats(myCharacter);
                break;
            default:
                System.out.println("Please select a valid option.");
        }
        }
    }
    //Inventories.Inventory 1.0 WIP
    public void inInventory(Character myCharacter){
        System.out.println(myCharacter.inventory);
        System.out.println("Gold : " + myCharacter.getGold());
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
    //TODO - quantity
    public void equipArmor(Character myCharacter){
        String armorChoice;
        Scanner menuInput = new Scanner(System.in);
        armorChoice = menuInput.next();
        System.out.println("Please type the name of the armor you'd like to equip.");
        if(myCharacter.inventory.containsKey(armorChoice)){
            Item armorItem = myCharacter.inventory.get(armorChoice);
            int checkAmount = armorItem.getQuantity();
            if(checkAmount > 0) {
                //armorItem.quantity -= 1;
                equipMyArmor(armorItem);
            }
            else
            {
            System.out.println("You don't have any!");
            }
        }
    }

    public void viewStats(Character myCharacter) {
        System.out.println("Class: " + myCharacter.getCharClass());
        System.out.println("Level: " + myCharacter.getLevel());
        System.out.println("EXP: " + myCharacter.getExp());
        System.out.println("Health: " + myCharacter.getCurrentHealth() + "/" + myCharacter.getMaxHealth());
        System.out.println("Power: " + (myCharacter.getPower() + myCharacter.getMyWeapon().getPower()));
        System.out.println("Defense: " + (myCharacter.getDefense() + myCharacter.getMyArmor().getDefense()));
        System.out.println("Weapon: " + myCharacter.getMyWeapon());
        System.out.println("Armor: " + myCharacter.getMyArmor());
        System.out.println("Skills: " + myCharacter.getSkills());
    }

    //Level Up! Calls skillCheck.
    public void levelUP(Character myCharacter){
        System.out.println("Congratulations! You have leveled up.");
        switch (myCharacter.getCharClass().toLowerCase()){
            case "knight":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.65));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.25));
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.25));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.15));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "ranger":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.45));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.15));
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.45));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.25));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "wizard":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.25));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.10));
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.65));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.50));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "druid":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.50));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.20));
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.30));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.30));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "priest":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.40));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.15));
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.10));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.45));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
        }
        Skill.skillCheck(myCharacter);
    }
    //Equips a weapon. change myWeapon to the weapon you want to equip.
    public void equipMyWeapon(Item myWeapon) {
        this.myWeapon = (Weapon)myWeapon;
        System.out.println("You have equipped " + myWeapon);
    }
    //Equips armor. change myArmor to the piece of armor you want to equip.
    public void equipMyArmor(Item myArmor) {
        if(myArmor instanceof Armor)
        this.myArmor = (Armor)myArmor;
        System.out.println("You have equipped " + myArmor);
    }
    //Uses a skill. If it's a healing spell, or healing is > 0, it will run the healing code. Else it will run the damage code.
    public void useSkill(Character myCharacter, Skill aMySkill, Monster currentMonster) {
        mySkill = aMySkill;
        System.out.println("You use " + mySkill + "!");
        if (mySkill.getHeal() > 0) {
            int toHeal = myCharacter.getCurrentHealth();
            myCharacter.setCurrentHealth(toHeal += mySkill.getHeal());
            if(myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                int healthCheck = myCharacter.getMaxHealth();
                myCharacter.setCurrentHealth(healthCheck);
            }
            System.out.println("Healed for " + mySkill.getHeal() + "!");
            System.out.println(myCharacter.getCurrentHealth());
        }
        else {
            double newHealth;
            newHealth = currentMonster.getCurrentHealth() - mySkill.getDamage() + currentMonster.getDefense();
            currentMonster.setCurrentHealth((int) Math.round(newHealth));
            double damageDealt = mySkill.getDamage() - currentMonster.getDefense();
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(currentMonster.getCurrentHealth() + "/" + currentMonster.getMaxHealth());
        }
    }
    /*Asks to choose a skill. You input a skill name (currently a letter) and it will see if you have that in your
    skills.If it does, it executes. If not it will not execute. This currently only works for Knights. */
    //TODO - fix
    public void getSkillChoice(Character myCharacter, Monster currentMonster) {
        Scanner inputChoice = new Scanner(System.in);
        System.out.println("Choose a skill!");
        skillChoice = inputChoice.next();
        if (skillChoice != null) {
            if(myCharacter.getSkills().contains(Skill.doubleSlash.getName()) || skillChoice.equalsIgnoreCase("d")){
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




