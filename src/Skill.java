import java.util.HashMap;
import java.util.Map;

/**
 Created by Holden Johnson on 10/28/2015.
 */
public class Skill {
    Character myCharacter;
    String name;
    double damage;
    int manaCost;
    double heal;

//Different skill hashmaps for each class
    public static Map<String,Skill> knightSkills = new HashMap<>();
    public static Map<String,Skill> priestSkills = new HashMap<>();
    public static Map<String,Skill> druidSkills = new HashMap<>();
    public static Map<String,Skill> rangerSkills = new HashMap<>();
    public static Map<String,Skill> wizardSkills = new HashMap<>();
//Creating different skills.
    public static Skill doubleSlash = new Skill("Double Slash", Character.myCharacter.power * 1.5, 8, 0);
    public static Skill cure = new Skill("Cure", 0, 10, Character.myCharacter.maxHealth * 0.33);
//Adding skills to certain hashmaps
    static {
        knightSkills.put(doubleSlash.name, doubleSlash);
        priestSkills.put(cure.name, cure);

    }
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
