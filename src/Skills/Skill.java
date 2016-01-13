package Skills;

import Creatures.Character;

import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/28/2015.
 */
public class Skill {
    Character myCharacter;
    protected String name;
    protected double damage;
    protected int manaCost;
    protected double heal;

    //<editor-fold desc="Getters and Setters">
    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public double getHeal() {
        return heal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setHeal(double heal) {
        this.heal = heal;
    }
    //</editor-fold>

    //Different skill hashmaps for each class
    public static Map<String,Skill> knightSkills = new HashMap<>();
    public static Map<String,Skill> priestSkills = new HashMap<>();
    public static Map<String,Skill> druidSkills = new HashMap<>();
    public static Map<String,Skill> rangerSkills = new HashMap<>();
    public static Map<String,Skill> wizardSkills = new HashMap<>();
//Creating different skills.
    public static Skill doubleSlash = new Skill("Double Slash", 1.5, 8, 0);
    public static Skill cure = new Skill("Cure", 0, 10, 30);
//Adding skills to certain hashmaps
    static {
        knightSkills.put(doubleSlash.name, doubleSlash);
        priestSkills.put(cure.name, cure);

    }

    /**
     *
     * @param skillName name of the skill.
     * @param skillDamage damage value of the skill (if any)
     * @param skillManaCost mana cost of the skill.
     * @param skillHeal heal value of the skill (if any)
     */
//default assigning of skills.
    public Skill(String skillName, double skillDamage, int skillManaCost, double skillHeal){
        name = skillName;
        damage = skillDamage;
        manaCost = skillManaCost;
        heal = skillHeal;
//sets up skills to return as their name.
    }
    public String toString() {
        return name;
    }
}
