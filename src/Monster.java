/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Monster {

    private int currentHealth;
    private int power;
    private int defense;
    private int exp;
    private int maxHealth;
    private String name;

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

    //</editor-fold>

    /**
     * default constructor
     * @param monsterName name of the monster.
     * @param monsterHealth current health of the monster.
     * @param monsterMaxHealth maximum health of the monster.
     * @param monsterPower power/damage of the monster.
     * @param monsterDefense defense of the monster.
     * @param monsterExp experience gained from defeating the monster.
     */


    public Monster(String monsterName, int monsterHealth, int monsterMaxHealth, int monsterPower, int monsterDefense, int monsterExp){
        name = monsterName;
        currentHealth = monsterHealth;
        maxHealth = monsterMaxHealth;
        power = monsterPower;
        defense = monsterDefense;
        exp = monsterExp;
    }

    public void init()
    {
        currentHealth = maxHealth;
    }
//    private static Monster currentMonster = new Monster("",0,1,0,0,0);
    public static Monster goblin = new Monster("Goblin",150,150,30,5,20);
    public static Monster bat = new Monster("Bat",80,80,40,2,10);
    public static Monster troll = new Monster("Troll",300,300,90,45,80);
    public static Monster skeleton = new Monster("Skeleton",250,250,120,10,75);
    public static Monster barbarian = new Monster("Barbarian",750,750,500,100,200);
    public static Monster dragon = new Monster("Dragon",1000,1000,800,250,500);

    public String toString() {
        return name;
    }

    public static void main(String[] args){


    }
}

//To Do: method for creating a monster based on the integer, give monsters an ID number, generate the ID number randomly with a method.