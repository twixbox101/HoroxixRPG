package Creatures;

/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Monster extends Creature {

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

    public Monster(String name, int level, int currentHealth, int maxHealth, int currentMana, int maxMana, int power, int defense, int exp, int gold){
        super(name, level, currentHealth, maxHealth, currentMana, maxMana, power, defense, exp, gold);
    }
    //Creating Creatures.Monster instances
    public static Monster currentMonster = new Monster("",0,0,1,0,0,0,0,0,1);
    public static Monster goblin = new Monster("Goblin",2,150,150,0,0,30,5,20,5);
    public static Monster bat = new Monster("Bat",1,80,80,5,5,40,2,10,3);
    public static Monster troll = new Monster("Troll",8,300,300,25,25,90,45,80,25);
    public static Monster skeleton = new Monster("Skeleton",10,250,250,50,50,120,10,75,30);
    public static Monster barbarian = new Monster("Barbarian",15,750,750,100,100,500,100,200,75);
    public static Monster dragon = new Monster("Dragon",25,1000,1000,500,500,800,250,500,250);

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

    public void setGol(int gold) { this.gold = gold; }

    //</editor-fold>






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