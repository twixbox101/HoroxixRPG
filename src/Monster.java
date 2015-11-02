/**
 Created by Holden Johnson on 10/24/2015.
 */
public class Monster {

    int health;
    int power;
    int defense;
    int exp;
    String name;


    public Monster(String monsterName, int monsterHealth, int monsterPower, int monsterDefense, int monsterExp){
        name = monsterName;
        health = monsterHealth;
        power = monsterPower;
        defense = monsterDefense;
        exp = monsterExp;
    }
    public static Monster currentMonster = new Monster("",0,0,0,0);
    public static Monster goblin = new Monster("Goblin", 150, 30, 5, 20);
    public static Monster bat = new Monster("Bat", 80, 40, 2, 10);
    public static Monster troll = new Monster("Troll", 300, 90, 45, 80);
    public static Monster skeleton = new Monster("Skeleton", 250, 120, 10, 75);
    public static Monster barbarian = new Monster("Barbarian", 750, 500, 100, 200);
    public static Monster dragon = new Monster("Dragon", 1000, 800, 250, 500);

    public String toString() {
        return name;
    }

    public static void main(String[] args){
        System.out.println(goblin.health);
        System.out.println(bat.power);

    }
}

//To Do: method for creating a monster based on the integer, give monsters an ID number, generate the ID number randomly with a method.