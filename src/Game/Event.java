package Game; /**
 Created by holden johnson on 10/24/2015.
 */
import Creatures.Character;
import Creatures.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import Locations.*;
import Skills.Skill;

import java.util.*;

public class Event {

    Weapon myWeapon;
    Armor myArmor;
    public static Skill mySkill;
    public static String skillChoice;
    public static String shopChoice;
    Monster monsterHealth;
    String travelChoice;

    List<Location> locations = new ArrayList<>();


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
                    Shop shop = new Shop();
                    shop.enterShop(myCharacter);
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



    //uses a potion to restore 30 currentHealth!
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

    //Generate random number
    public int generateRandom() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(6);
    }


    //Enters Battle, generates the monster that the character fights
    public void enterBattle(Character myCharacter) {
        Monster monster = new Monster();
        Monster currentMonster = monster.generateMonster(myCharacter);
        currentMonster.setCurrentHealth(currentMonster.getMaxHealth());
        System.out.println("You have encountered a " + currentMonster + "!");
        fight(myCharacter, currentMonster);
    }

    //Battle System 1.0
    //TODO - Run system, Item System
    public void fight(Character myCharacter, Monster currentMonster) {
        String currentLocation = myCharacter.getLocation();
        boolean run = false;
        myCharacter.setLocation("fight");
        while (myCharacter.getCurrentHealth() >= 1 && currentMonster.getCurrentHealth() >= 1 && !myCharacter.getLocation().equals(currentLocation)) {
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
                        currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - damage);
                        System.out.println(currentMonster.getName() + " health remaining: " + currentMonster.getCurrentHealth() + "/ " + currentMonster.getMaxHealth());
                    }
                    if(currentMonster.getCurrentHealth() > 0){
                    attackBack(myCharacter, currentMonster);
                    }
                    break;
                case "s":
                    getSkillChoice(myCharacter, currentMonster);
                    if(currentMonster.getCurrentHealth() > 0){
                        attackBack(myCharacter, currentMonster);
                    }
                    break;
                case "i":
                    inInventory(myCharacter);
                    break;
                case "r":
                    System.out.println("coward");
                    myCharacter.setLocation(currentLocation);
                    run = true;
                    break;
                default:
                    System.out.println("Select an action!");
                    break;
            }
        }
        if(!run){
        victory(myCharacter, currentMonster, currentLocation);}
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



    //Inventories.Inventory 1.0 WIP
    public void inInventory(Character myCharacter){
        System.out.println(myCharacter.inventory);
        System.out.println("Gold : " + myCharacter.getGold());
        System.out.println("What would you like to do?");
        System.out.println("[E]quip|[U]se|[C]raft|e[X]it|");
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
            case "c":
                craftMenu(myCharacter);
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
    //TODO make craft menu
    public void craftMenu(Character myCharacter){
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
        System.out.println("[A]rmor][W]eapon]|e[X]it");
        Scanner menuInput = new Scanner(System.in);
        equipChoice = menuInput.next();
        switch(equipChoice.toLowerCase()){
            case "a":
                equipArmor(myCharacter);
                break;
            case "w":
                equipWeapon(myCharacter);
                break;
            case "x":
                System.out.println("You exit.");
                break;
            default :
                System.out.println("Please select a valid option");
        }

    }

    public void equipWeapon(Character myCharacter){
        String weaponChoice;
        Scanner menuInput = new Scanner(System.in);
        System.out.println("Please type the name of the armor you'd like to equip.");
        weaponChoice = menuInput.nextLine();
        int inventoryLength = myCharacter.inventory.size();
        for (int i = 0; i < inventoryLength; i++) {
            if (weaponChoice.equals(myCharacter.inventory.get(i).getName())) {
                Item weaponItem = myCharacter.inventory.get(i);
                int checkAmount = weaponItem.getQuantity();
                if (checkAmount > 0 && weaponItem instanceof Weapon) {
                    weaponItem.setQuantity(weaponItem.getQuantity() - 1);
                    equipMyWeapon(myCharacter, (Weapon)weaponItem);
                } else {
                    System.out.println("You don't have any!");
                }
            }
            else System.out.println("You don't have any!");
        }
    }
    //equip armor by choice WIP
    //TODO - quantity, change to display inventory, add armor based on number?
    public void equipArmor(Character myCharacter){
        String armorChoice;
        Scanner menuInput = new Scanner(System.in);
        armorChoice = menuInput.nextLine();
        System.out.println("Please type the name of the armor you'd like to equip.");
        int inventoryLength = myCharacter.inventory.size();
        for (int i = 0; i < inventoryLength; i++) {
            if (armorChoice.equals(myCharacter.inventory.get(i).getName())) {
                Item armorItem = myCharacter.inventory.get(i);
                int checkAmount = armorItem.getQuantity();
                if (checkAmount > 0 && armorItem instanceof Armor) {
                    armorItem.setQuantity(armorItem.getQuantity() - 1);
                    equipMyArmor(myCharacter, (Armor)armorItem);
                } else {
                    System.out.println("You don't have any!");
                }
            }
            else System.out.println("You don't have any!");
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
        System.out.println("EXP: " + myCharacter.getExp() + "/" + myCharacter.getExpLevel());
        System.out.println("Health: " + myCharacter.getCurrentHealth() + "/" + myCharacter.getMaxHealth());
        System.out.println("Mana: " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
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
        System.out.println("Level: " + myCharacter.getLevel());
        Skill.skillCheck(myCharacter);
    }
    //Equips a weapon. change myWeapon to the weapon you want to equip.
    public void equipMyWeapon(Character myCharacter, Weapon myWeapon) {
        myCharacter.setMyWeapon(myWeapon);
        System.out.println("You have equipped " + myWeapon);
    }
    //Equips armor. change myArmor to the piece of armor you want to equip.
    public void equipMyArmor(Character myCharacter, Armor myArmor) {
        myCharacter.setMyArmor(myArmor);
        System.out.println("You have equipped " + myArmor);
    }
    //Uses a skill. If it's a healing spell, or healing is > 0, it will run the healing code. Else it will run the damage code.
    //TODO - calculate MANA costs
    public void useSkill(Character myCharacter, Skill skill, Monster currentMonster) {
        mySkill = skill;
        System.out.println("You use " + mySkill + "!");
        Random random = new Random();
        int value = random.nextInt(100);
        switch(mySkill.getType()){
            case "heal":
                int healValue = mySkill.getHeal() * myCharacter.getPower();
                myCharacter.setCurrentHealth(myCharacter.getCurrentHealth() + healValue);
                myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                if(myCharacter.getCurrentHealth() > myCharacter.getMaxHealth()) {
                    myCharacter.setCurrentHealth(myCharacter.getMaxHealth());
                }
                System.out.println("Healed for " + healValue + "!");
                System.out.println(myCharacter.getCurrentHealth() + "/" + myCharacter.getMaxHealth());
                System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                break;
            case "double":
                if(value < mySkill.getAccuracy()) {
                    currentMonster.setCurrentHealth((currentMonster.getCurrentHealth() - myCharacter.getPower() * 2 - currentMonster.getDefense()));
                    int dealt = myCharacter.getPower() * 2 - currentMonster.getDefense();
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("Dealt " + dealt + " damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());}

                else{
                    System.out.println("Your skill missed!");
                }
                break;
            case "triple":
                if(value < mySkill.getAccuracy()) {
                    currentMonster.setCurrentHealth((currentMonster.getCurrentHealth() - myCharacter.getPower() * 3 - currentMonster.getDefense()));
                    int dealt2 = myCharacter.getPower() * 3 - currentMonster.getDefense();
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("Dealt " + dealt2 + " damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                    }

                else{
                    System.out.println("Your skill missed!");
                }
                break;
            case "death":
                if(value < mySkill.getAccuracy()) {
                    System.out.println("Your skill hits!");
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    currentMonster.setCurrentHealth(0);
                    System.out.println("Death Strikes!");
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                } else {
                    System.out.println("Your skill missed!");
                }
                break;
            case "self":
                if(value < mySkill.getAccuracy()) {
                    System.out.println("Your skill hits!");
                    currentMonster.setCurrentHealth((currentMonster.getCurrentHealth() - myCharacter.getPower() * 4 - currentMonster.getDefense()));
                    int dealt3 = myCharacter.getPower() * 4 - currentMonster.getDefense();
                    myCharacter.setCurrentHealth((myCharacter.getCurrentHealth() - myCharacter.getPower() - 50));
                    int selfDealt = myCharacter.getPower() - 50;
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("You deal " + dealt3 + " damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("The " + mySkill.getName() + " deals " + selfDealt + " damage to yourself!");
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                } else {
                    System.out.println("Your skill missed!");
                }
                break;
            case "healDamage":
                if(value < mySkill.getAccuracy()) {
                    System.out.println("Your skill hits!");
                    int dealt3 = mySkill.getDamage() - currentMonster.getDefense();
                    currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - mySkill.getDamage() - currentMonster.getDefense());
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("Dealt " + dealt3 + " damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("Healed for " + dealt3 + "!");
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                    myCharacter.setCurrentHealth(myCharacter.getCurrentHealth() + dealt3);

                } else {
                    System.out.println("Your skill missed!");
                }
                break;
            case "crit":
                if(value < mySkill.getAccuracy()) {
                    System.out.println("Your skill hits!");
                    currentMonster.setCurrentHealth((currentMonster.getCurrentHealth() - myCharacter.getPower() * 2 + value));
                    int dealt4 = myCharacter.getPower() * 2 + value;
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("Dealt " + dealt4 + " critical damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                } else {
                    System.out.println("Your skill missed!");
                }
                break;
            case "multi":
                if(value < mySkill.getAccuracy()) {
                    int multiHits = getMulti();
                    System.out.println("Hits " + multiHits + " times!");
                    int dealt5 = myCharacter.getPower() * multiHits - currentMonster.getDefense();
                    currentMonster.setCurrentHealth((currentMonster.getCurrentHealth() - dealt5));
                    myCharacter.setCurrentMana(myCharacter.getCurrentMana() - mySkill.getManaCost());
                    System.out.println("Dealt " + dealt5 + " total damage!");
                    System.out.println(currentMonster.getName() + " health remaining : " + currentMonster.getCurrentHealth());
                    System.out.println("Mana : " + myCharacter.getCurrentMana() + "/" + myCharacter.getMaxMana());
                } else {
                    System.out.println("Your skill missed!");
                }
                break;
            case "buff":
                break;

        }
    }

    public int getMulti(){
        Random multi = new Random();
        int value = multi.nextInt(5);
        return value;
    }
    /*Asks to choose a skill. You input a skill name (currently a letter) and it will see if you have that in your
    skills.If it does, it executes. If not it will not execute. This currently only works for Knights. */
    //TODO - fix
    public void getSkillChoice(Character myCharacter, Monster currentMonster) {
        Scanner inputChoice = new Scanner(System.in);
        System.out.println("Choose a skill!");
        System.out.println("[1:" + myCharacter.skills.get(0) + "][2:" + myCharacter.skills.get(1) + "][3:" + myCharacter.skills.get(2) + "]" +
                "[4:" + myCharacter.skills.get(3) + "][5:" + myCharacter.skills.get(4) + "][6:"  + myCharacter.skills.get(5) + "][S]kill List|");
        skillChoice = inputChoice.next();
        switch(skillChoice.toLowerCase()){
            case "1":
                System.out.println("You use the skill: " + myCharacter.skills.get(0));
                useSkill(myCharacter, myCharacter.skills.get(0), currentMonster);
                break;
            case "2":
                if(myCharacter.getLevel() < 5){
                    System.out.println("You don't have that skill!");
                }
                else{
                    System.out.println("You use the skill: " + myCharacter.skills.get(1));
                    useSkill(myCharacter, myCharacter.skills.get(1), currentMonster);
                }
                break;
            case "3":
                if(myCharacter.getLevel() < 10){
                    System.out.println("You don't have that skill!");
                }
                else{
                    System.out.println("You use the skill: " + myCharacter.skills.get(2));
                    useSkill(myCharacter, myCharacter.skills.get(2), currentMonster);
                }
                break;
            case "4":
                if(myCharacter.getLevel() < 15){
                    System.out.println("You don't have that skill!");
                }
                else {
                    System.out.println("You use the skill: " + myCharacter.skills.get(3));
                    useSkill(myCharacter, myCharacter.skills.get(3), currentMonster);
                }
                break;
            case "5":
                if(myCharacter.getLevel() < 20){
                    System.out.println("You don't have that skill!");
                }
                else {
                    System.out.println("You use the skill: " + myCharacter.skills.get(4));
                    useSkill(myCharacter, myCharacter.skills.get(4), currentMonster);
                }
                break;
            case "6":
                if(myCharacter.getLevel() < 25){
                    System.out.println("You don't have that skill!");
                }
                else {
                    System.out.println("You use the skill: " + myCharacter.skills.get(5));
                    useSkill(myCharacter, myCharacter.skills.get(5), currentMonster);
                }
                break;
            case "s":
                viewSkills(myCharacter);
        }
    }

    public int diceRoller(){
        Random dice = new Random();
        int roll = dice.nextInt(6) + 1;
        return roll;
    }

    public void viewSkills(Character myCharacter){
        System.out.println("[1] - " + myCharacter.skills.get(0));
        if(myCharacter.getLevel() >= 5){
            System.out.println("[2] - " + myCharacter.skills.get(1));
        }
        if(myCharacter.getLevel() >= 10){
            System.out.println("[3] - " + myCharacter.skills.get(2));
        }
        if(myCharacter.getLevel() >= 15){
            System.out.println("[4] - " + myCharacter.skills.get(3));
        }
        if(myCharacter.getLevel() >= 20){
            System.out.println("[5] - " + myCharacter.skills.get(4));
        }
    }




    public static void main(String[] args) {



    }

}




