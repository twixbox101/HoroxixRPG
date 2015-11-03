/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Monster {

    int currentHealth;
    int power;
    int defense;
    int exp;
    int maxHealth;
    String name;

    /**
     *
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
    public static Monster currentMonster = new Monster("",0,1,0,0,0);
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