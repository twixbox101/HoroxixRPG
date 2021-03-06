package Creatures;

import Items.Item;
import Locations.AbandonedCastle;
import Locations.DarkForest;
import Locations.Island;
import Locations.Plains;

import java.util.Random;

/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Monster extends Creature {
    private Item dropItem;

    /**
     *
     * @param name name of the monster
     * @param level level of the monster
     * @param currentHealth current health of the monster
     * @param maxHealth maximum health of the monster
     * @param currentMana current mana of the monster
     * @param maxMana maximum mana of the monster
     * @param power power of the monster
     * @param defense defense of the monster
     * @param exp experience obtained from defeating the monster
     * @param gold gold value obtained from defeating the monster
     */


    public Monster(String name, int level, int currentHealth, int maxHealth, int currentMana, int maxMana, int power, int defense, int exp, int gold, Item dropItem){
        super(name, level, currentHealth, maxHealth, currentMana, maxMana, power, defense, exp, gold);
        this.dropItem = dropItem;
    }
    //Creating Creatures.Monster instances

    public Monster(){}

    public static Monster currentMonster = new Monster("",0,0,1,0,0,0,0,0,1, Item.elixir);
    public static Monster goblin = new Monster("Goblin",1,75,75,0,0,25,2,20,5, Item.potion);
    public static Monster bat = new Monster("Bat",1,80,80,5,5,40,2,10,3, Item.elixir);
    public static Monster troll = new Monster("Troll",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster wanderingSpirit = new Monster("Wandering Spirit",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster darkElf = new Monster("Dark Elf",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster pixie = new Monster("Pixie",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster seaSerpent = new Monster("Sea Serpent",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster giantCrab = new Monster("Giant Crab",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster tropicalWarrior = new Monster("Tropical Warrior",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster skeletalParrot = new Monster("Skeletal Parrot",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster centaur = new Monster("Centaur",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster undeadGuard = new Monster("Undead Guard",8,300,300,25,25,90,45,80,25, Item.elixir);
    public static Monster hyena = new Monster("Hyena",3,130,130,2,2,60,4,35,25, Item.chippedTooth);
    public static Monster loneWolf = new Monster("Lone Wolf",2,125,125,5,5,55,2,30,10, Item.wolfFur);
    public static Monster skeleton = new Monster("Skeleton",10,250,250,50,50,120,10,75,30, Item.elixir);
    public static Monster barbarian = new Monster("Barbarian",2,150,150,25,25,45,5,35,5, Item.elixir);
    public static Monster dragon = new Monster("Dragon",25,1000,1000,500,500,800,250,500,250, Item.elixir);

    //<editor-fold desc="Getters and Setters">
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
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

    public Item getDropItem() {
        return dropItem;
    }

    public void setDropItem(Item dropItem) {
        this.dropItem = dropItem;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {return gold; }

    public void setGold(int gold) { this.gold = gold; }

    //</editor-fold>

    //Generate random monster based on value
    //TODO - finish for each location.
    public Monster generateMonster(Character myCharacter) {
        Monster value = new Monster();
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

    //Returns actual name of monster
    public String toString() {
        return name;
    }

    //Main tests
    public static void main(String[] args){

        System.out.println(goblin.currentHealth);
        System.out.println(bat.power);

    }
}

//To Do: method for creating a monster based on the integer, give monsters an ID number, generate the ID number randomly with a method.