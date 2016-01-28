package Game; /**
 Created by holden johnson on 10/24/2015.
 */
import Creatures.Character;
import Creatures.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import Locations.AbandonedCastle;
import Locations.DarkForest;
import Locations.Island;
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
    //TODO - // FIXME: 1/22/2016

    public void usePotion(Character myCharacter) {
        int inventoryLength = myCharacter.inventory.size();
        for (int i = 0; i < inventoryLength; i++)
            if (myCharacter.inventory.contains(Item.potion)) {
                myCharacter.inventory.remove(Item.potion);
                System.out.println("You have used a potion.");
                System.out.println(Item.potion.getHeal() + " Health restored!");
                myCharacter.setCurrentHealth(myCharacter.getCurrentHealth() + Item.potion.getHeal());
                if (myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                    myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                }
            } else {
                System.out.println("You don't have any elixirs!");
            }
    }


    //Uses an elixir to heal 20 mana.
    //TODO - fix
    public void useElixir(Character myCharacter) {
        int inventoryLength = myCharacter.inventory.size();
        for (int i = 0; i < inventoryLength; i++)

        if (myCharacter.inventory.contains(Item.elixir)) {
            myCharacter.inventory.remove(Item.elixir);
            System.out.println("You have used an elixir.");
            System.out.println(Item.elixir.getHeal() + " Mana restored!");
            myCharacter.setCurrentMana(myCharacter.getCurrentMana() + Item.elixir.getHeal());
            if (myCharacter.getCurrentMana() > myCharacter.getMaxMana()) {
                myCharacter.setCurrentMana(myCharacter.getMaxMana());
            }
        } else {
            System.out.println("You don't have any elixirs!");
        }
    }

    //Adds item to My Creatures.Character's Inventories.Inventory
    public void addItem(Item myItem, Character myCharacter) {

        if (myCharacter.inventory.contains(myItem)) {
            myItem.setQuantity(+1);
        } else {
            myCharacter.inventory.add(myItem);
            myItem.setQuantity(1);
        }
    }
    //Travel Menu. Select a destination.
    public void travel(Character myCharacter) {
        myCharacter.setLocation("travel");
        System.out.println("You have decided to travel");
        System.out.println("Where would you like to go?");
        Scanner myInput = new Scanner(System.in);
        while (myCharacter.getLocation().equals("travel")) {
            System.out.println("[P]lains|[F]orest|[C]astle|[I]sland|[S]wamp]|i[N]fo]|e[X]it|");
            travelChoice = myInput.next();
            switch (travelChoice.toLowerCase()) {
                case "p":
                    myCharacter.setLocation("plains");
                    atLocation(myCharacter, myCharacter.getLocation());
                    break;
                case "f":
                    if (myCharacter.getLevel() < 5) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("forest");
                        atLocation(myCharacter, myCharacter.getLocation());
                    }
                    break;
                case "c":
                    if (myCharacter.getLevel() < 10) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("castle");
                        atLocation(myCharacter, myCharacter.getLocation());
                    }
                    break;
                case "i":
                    if (myCharacter.getLevel() < 15) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("island");
                        atLocation(myCharacter, myCharacter.getLocation());
                    }
                    break;
                case "s":
                    if (myCharacter.getLevel() < 20) {
                        System.out.println("Your level is not high enough for this area");
                    } else {
                        myCharacter.setLocation("swamp");
                        atLocation(myCharacter, myCharacter.getLocation());
                    }
                    break;
                case "dev":
                    myCharacter.setLevel(25);
                    myCharacter.setGold(9999);
                    myCharacter.setMyWeapon(Weapon.ultimaWeapon);
                    myCharacter.setMyArmor(Armor.rubyArmor);
                    System.out.println("dev!");
                    break;
                case "n":
                    System.out.println("[Plains : Levels 1-5]\n" +
                            "[Dark Forest: Levels 5-10]\n" +
                            "[Abandoned Castle : Levels 10-15]\n" +
                            "[Island : Levels 15-20]\n" +
                            "[Swamp : Levels 20+]\n"
                    );
                    break;
                case "x":
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
            System.out.println("[E]xplore|[I]nventory|e[X]it|");
            String choice = myInput.next();
            switch (choice.toLowerCase()) {
                case "e":
                    System.out.println("You explore.");
                    generateRandom();
                    if (generateRandom() <= 2) {
                        findGold(myCharacter, currentLocation);
                    } else
                        enterBattle(myCharacter);
                    break;
                case "i":
                    inInventory(myCharacter);
                    break;
                case "x":
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
                int foundGold = randomGold.nextInt(10) + 1;
                myCharacter.setGold(myCharacter.getGold() + foundGold);
                System.out.println("You discover " + foundGold + " gold!");
                System.out.println("Total : " + myCharacter.getGold());
                break;
            case "forest":
                foundGold = randomGold.nextInt(25) + 10;
                myCharacter.setGold(myCharacter.getGold() + foundGold);
                System.out.println("You discover " + foundGold + " gold!");
                System.out.println("Total : " + myCharacter.getGold());
                break;
            case "castle":
                foundGold = randomGold.nextInt(33) + 12;
                myCharacter.setGold(myCharacter.getGold() + foundGold);
                System.out.println("You discover " + foundGold + " gold!");
                System.out.println("Total : " + myCharacter.getGold());
                break;
            case "island":
                foundGold = randomGold.nextInt(50) + 15;
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
                        myCharacter.inventory.add(Item.potion);
                        Item.potion.setQuantity(Item.potion.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.potion.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "elixir":
                    if (myCharacter.getGold() >= Item.elixir.getPrice()) {
                        System.out.println("You have purchased an Elixir!");
                        myCharacter.inventory.add(Item.elixir);
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
        Monster value = new Monster("test", 0, 0, 0, 0, 0, 0, 0, 0, 0, Item.elixir);
        String location = myCharacter.getLocation();
        Random generator = new Random();
            switch (location) {
                case "plains":
                    int randomIndex = generator.nextInt(Plains.enemyList.size());
                    Monster monster = Plains.enemyList.get(randomIndex);
                    System.out.println(monster.getName());
                    return monster;
                case "forest":
                    int randomIndex2 = generator.nextInt(DarkForest.enemyList.size());
                    Monster monster2 = DarkForest.enemyList.get(randomIndex2);
                    System.out.println(monster2.getName());
                    return monster2;
                case "castle":
                    int randomIndex3 = generator.nextInt(AbandonedCastle.enemyList.size());
                    Monster monster3 = AbandonedCastle.enemyList.get(randomIndex3);
                    System.out.println(monster3.getName());
                    return monster3;
                case "island":
                    int randomIndex4 = generator.nextInt(Island.enemyList.size());
                    Monster monster4 = Island.enemyList.get(randomIndex4);
                    System.out.println(monster4.getName());
                    return monster4;

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
    //TODO - Run system, Item System
    public void fight(Character myCharacter, Monster currentMonster) {
        int currentMonsterHealth = currentMonster.getMaxHealth();
        String currentLocation = myCharacter.getLocation();
        myCharacter.setLocation("fight");
        while (myCharacter.getCurrentHealth() >= 1 && currentMonsterHealth >= 1 && !myCharacter.getLocation().equals(currentLocation)) {
            String battleChoice;
            Scanner battleInput = new Scanner(System.in);
            System.out.println("What do you do?");
            System.out.println("[A]ttack|[S]kill|[I]tem|[R]un|");
            battleChoice = battleInput.next();
            switch (battleChoice.toLowerCase()) {
                case "a":
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
                case "s":
                    getSkillChoice(myCharacter, currentMonster);
                    break;
                case "i":
                    inInventory(myCharacter);
                    break;
                case "r":
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
        myCharacter.inventory.add(currentMonster.getDropItem());
        levelCheck(myCharacter);
        int ifDrop = generateRandom();
        if(ifDrop < 3){
        System.out.println("The " + currentMonster + " dropped " + currentMonster.getDropItem() + "!");
        }
        myCharacter.setLocation(currentLocation);
    }


    //MainMenu 1.0 WIP
    public void mainMenu(Character myCharacter) {
        String menuChoice;
        Scanner menuInput = new Scanner(System.in);
        while(myCharacter.getLocation().equals("mainMenu")){
        System.out.println("[T]ravel|[S]hop|[I]nventory|St[A]ts|");
        menuChoice = menuInput.next();
        switch (menuChoice.toLowerCase()) {
            case "t":
                travel(myCharacter);
                break;
            case "s":
                enterShop(myCharacter);
                break;
            case "i":
                inInventory(myCharacter);
                break;
            case "a":
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
        System.out.println("[E]quip|[U]se|e[X]it|");
        String invChoice;
        Scanner menuInput = new Scanner(System.in);
        invChoice = menuInput.next();
        switch(invChoice.toLowerCase()){
            case "e":
                equipMenu(myCharacter);
                break;
            case "u":
                useMenu(myCharacter);
                break;
            case "x":
                System.out.println("You leave.");
                break;
            default:
                System.out.println("Please select a valid option.");
        }

    }

    public void useMenu(Character myCharacter){
        String useChoice;
        System.out.println(myCharacter.inventory);
        System.out.println("What item would you like to use?");
        System.out.println("[P]otion|[E]lixir|e[X]it|");
        Scanner menuInput = new Scanner(System.in);
        useChoice = menuInput.next();
        switch(useChoice.toLowerCase()){
            case "p":
                usePotion(myCharacter);
                break;
            case "e":
                useElixir(myCharacter);
                break;
            case "x":
                System.out.println("You exit.");
                break;
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
    //TODO - quantity, change to display inventory, add armor based on number?
    public void equipArmor(Character myCharacter){
        String armorChoice;
        Scanner menuInput = new Scanner(System.in);
        armorChoice = menuInput.next();
        System.out.println("Please type the name of the armor you'd like to equip.");
        int inventoryLength = myCharacter.inventory.size();
        for (int i = 0; i < inventoryLength; i++) {
            if (armorChoice.equals(myCharacter.inventory.get(i).getName())) {
                Item armorItem = myCharacter.inventory.get(i);
                int checkAmount = armorItem.getQuantity();
                if (checkAmount > 0) {
                    armorItem.setQuantity(armorItem.getQuantity() - 1);
                    equipMyArmor(armorItem);
                } else {
                    System.out.println("You don't have any!");
                }
            }
        }}

    /*public Item findInInventory(Character myCharacter, String menuChoice){
        boolean done = false;
        Item result;
        while (!done) {
            System.out.println ("Please enter a name:");
            String searchName = input.nextLine();
            if (searchName.equals("DONE")) {
                done = true;
            } else {
                System.out.println ("Please enter a gender:");
                String searchGender = input.nextLine();
                // Search the ArrayList.
                for (YourObject item: nameList) {
                    // See if the gender is in the ArrayList
                    if (searchGender.equals(item.getGender())) {
                        // See if the name matches the gender in the ArrayList
                        if (searchName.equals(item.getName())) {
                            result = item;

    }*/

    public void levelCheck(Character myCharacter){
        if(myCharacter.getExp() >= myCharacter.getExpLevel()){
            levelUP(myCharacter);
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
                myCharacter.setExpLevel((int) Math.round(myCharacter.getExpLevel() * 1.5));
                myCharacter.setExp(0);
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.25));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.15));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "ranger":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.45));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.15));
                myCharacter.setExpLevel((int) Math.round(myCharacter.getExpLevel() * 1.5));
                myCharacter.setExp(0);
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.45));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.25));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "wizard":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.25));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.10));
                myCharacter.setExpLevel((int) Math.round(myCharacter.getExpLevel() * 1.5));
                myCharacter.setExp(0);
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.65));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.50));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "druid":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.50));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.20));
                myCharacter.setExpLevel((int) Math.round(myCharacter.getExpLevel() * 1.5));
                myCharacter.setExp(0);
                myCharacter.setLevel(myCharacter.getLevel() + 1);
                myCharacter.setPower((int) Math.round(myCharacter.getPower() * 1.30));
                myCharacter.setMaxMana((int) Math.round(myCharacter.getMaxMana() * 1.30));
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                break;
            case "priest":
                myCharacter.setMaxHealth((int) Math.round(myCharacter.getMaxHealth() * 1.40));
                myCharacter.setDefense((int) Math.round(myCharacter.getDefense() * 1.15));
                myCharacter.setExpLevel((int) Math.round(myCharacter.getExpLevel() * 1.5));
                myCharacter.setExp(0);
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
    public void useSkill(Character myCharacter, Skill skill, Monster currentMonster) {
        mySkill = skill;
        System.out.println("You use " + mySkill + "!");
        if (mySkill.getHeal() > 0) {
            myCharacter.setCurrentHealth(myCharacter.getCurrentHealth() + (int) Math.round(mySkill.getHeal()));
            if(myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
            }
            System.out.println("Healed for " + mySkill.getHeal() + "!");
            System.out.println(myCharacter.getCurrentHealth() + myCharacter.getMaxHealth());
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
        System.out.println("[1][2][3][4][5][Skill List]");
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




