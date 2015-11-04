/**
 Created by holden johnson on 10/24/2015.
 */
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Event {

    Weapon myWeapon;
    Armor myArmor;
    Skill mySkill;
    Monster monsterHealth;
    String skillChoice;
    String shopChoice;


    public Event(){
    }
//uses a potion to restore 30 currentHealth!
    public void usePotion(Character myCharacter){
        int howMany = myCharacter.inventory.get(Item.potion).quantity;
        if(howMany > 0) {
            myCharacter.inventory.put(Item.elixir.name, Item.potion);

            System.out.println("You have used a potion.");
            System.out.println("30 Health healed!");
            myCharacter.currentHealth += Item.potion.heal;
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
    public void useElixir(Character myCharacter){
        int howMany = myCharacter.inventory.get(Item.elixir).quantity;
        if(howMany > 0) {
            myCharacter.inventory.put(Item.elixir.name, Item.elixir);
            System.out.println("You have used an elixir.");
            System.out.println("20 Mana restored!");
            myCharacter.currentMana +=Item.elixir.heal;
            if(myCharacter.currentMana > myCharacter.maxMana){
                myCharacter.currentMana = myCharacter.maxMana;
            }
        }
        else
        {
            System.out.println("You don't have any elixirs!");
        }
    }
//Adds item to My Character's Inventory
    public void addItem(Item myItem, Character myCharacter){
        Item invItem = myCharacter.inventory.get(myItem.name);
        if(invItem == null) {
            myCharacter.inventory.put(myItem.name, myItem);
            myItem.quantity++;
        }
        else
        {
            myItem.quantity++;
        }
    }
//Enters the shop and displays a list of items.
    public void enterShop(Character myCharacter){
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
                        if(myCharacter.gold >= Item.potion.price){
                            System.out.println("You have purchased a Potion!");
                            myCharacter.inventory.put(Item.potion.name, Item.potion);
                            Item.potion.quantity++;
                            myCharacter.gold -= Item.potion.price;
                            }
                        else{
                            System.out.println("You don't have enough gold!");
                            }
                        break;
                    case "elixir":
                        if(myCharacter.gold >= Item.elixir.price){
                            System.out.println("You have purchased an Elixir!");
                            myCharacter.inventory.put(Item.elixir.name, Item.elixir);
                            Item.elixir.quantity++;
                            myCharacter.gold -= Item.elixir.price;
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
    public int generateRandom() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(6);
    }


//Generate random monster based on value
    public Monster generateMonster(){
        int value = generateRandom();
        Monster monster;
        switch (value){
            case 0:
                monster = Monster.goblin;
                break;
            case 1:
                monster = Monster.bat;
                break;
            case 2:
                monster = Monster.troll;
                break;
            case 3:
                monster = Monster.skeleton;
                break;
            case 4:
                monster = Monster.barbarian;
                break;
            case 5:
                monster = Monster.dragon;
                break;
            default:
                monster = Monster.dragon;
                break;
        }
        monster.init();
    return monster;
    }
//Enters Battle, generates the monster that the character fights
    public void enterBattle(Character myCharacter){
        Monster currentMonster = generateMonster();
        System.out.println("You have encountered a " + currentMonster + "!");
        fight(myCharacter, currentMonster);
    }
//Battle System 1.0
    public void fight(Character myCharacter, Monster currentMonster) {
        while (myCharacter.currentHealth > 0 || currentMonster.getCurrentHealth() > 0) {
            String battleChoice;
            Scanner battleInput = new Scanner(System.in);
            battleChoice = battleInput.next();
            System.out.println("What do you do?");
            System.out.println("[Attack][Skill][Item][Run]");
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
        Random hitMiss = new Random();
        int value = hitMiss.nextInt(10);
        if(value <3){
            System.out.println("Your attack missed!");
        }
        else{
            int totalDamage = myCharacter.power + myCharacter.myWeapon.getPower();
            int newHealth = currentMonster.getCurrentHealth() - totalDamage + currentMonster.getDefense();
            currentMonster.setCurrentHealth(newHealth);
            double damageDealt = totalDamage - currentMonster.getDefense();
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(currentMonster.getCurrentHealth());
        }
    }

//MainMenu 1.0 WIP
    public void mainMenu(Character myCharacter) {
        String menuChoice;
        Scanner menuInput = new Scanner(System.in);
        while(myCharacter.location == "mainMenu"){
        System.out.println("[Travel][Shop][Inventory][Stats]");
        menuChoice = menuInput.next();

        switch (menuChoice.toLowerCase()) {
            case "travel":
                break;
            case "shop":
                enterShop(myCharacter);
                break;
            case "inventory":
                inInventory(myCharacter);
                break;
            case "stats":
                System.out.println("Class: " + myCharacter.charClass);
                System.out.println("Level: " + myCharacter.level);
                System.out.println("EXP: " + myCharacter.exp);
                System.out.println("Health: " + myCharacter.currentHealth + "/" + myCharacter.maxHealth);
                System.out.println("Power: " + (myCharacter.power + myCharacter.myWeapon.getPower()));
                System.out.println("Defense: " + (myCharacter.defense + myCharacter.myArmor.getDefense()));
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
        switch (myCharacter.charClass){
            case "knight":
                myCharacter.maxHealth *=1.65;
                myCharacter.defense *=1.25;
                myCharacter.level +=1;
                myCharacter.power *=1.25;
                myCharacter.maxMana *=1.10;
                myCharacter.currentHealth = myCharacter.maxHealth;
                break;
            case "ranger":
                myCharacter.maxHealth *=1.45;
                myCharacter.defense *=1.15;
                myCharacter.level +=1;
                myCharacter.power *=1.45;
                myCharacter.maxMana *=1.25;
                myCharacter.currentHealth = myCharacter.maxHealth;
                break;
            case "wizard":
                myCharacter.maxHealth *=1.25;
                myCharacter.defense *=1.10;
                myCharacter.level +=1;
                myCharacter.power *=1.65;
                myCharacter.maxMana *=1.50;
                myCharacter.currentHealth = myCharacter.maxHealth;
                break;
            case "druid":
                myCharacter.maxHealth *=1.50;
                myCharacter.defense *=1.20;
                myCharacter.level +=1;
                myCharacter.power *=1.30;
                myCharacter.maxMana *=1.30;
                myCharacter.currentHealth = myCharacter.maxHealth;
                break;
            case "priest":
                myCharacter.maxHealth *=1.40;
                myCharacter.defense *=1.15;
                myCharacter.level +=1;
                myCharacter.power *=1.10;
                myCharacter.maxMana *=1.45;
                myCharacter.currentHealth = myCharacter.maxHealth;
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
            myCharacter.currentHealth += mySkill.heal;
            if (myCharacter.currentHealth > myCharacter.maxHealth) {
                myCharacter.currentHealth = myCharacter.maxHealth;
            }
            System.out.println("Healed for " + mySkill.heal + "!");
            System.out.println(myCharacter.currentHealth);
        }
        else {
            double newHealth;
            newHealth = currentMonster.getCurrentHealth() - mySkill.damage + currentMonster.getDefense();
            currentMonster.setCurrentHealth((int) Math.round(newHealth));
            double damageDealt = mySkill.damage - currentMonster.getDefense();
            System.out.println("Damage dealt: " + damageDealt + "!");
            System.out.println(currentMonster.getCurrentHealth());
        }
    }/*Asks to choose a skill. You input a skill name (currently a letter) and it will see if you have that in your
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




