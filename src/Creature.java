import java.util.Map;

/**
 * Created by horox_000 on 1/12/2016.
 */
public class Creature {

    protected String name;
    protected int level;
    protected int currentHealth;
    protected int maxHealth;
    protected int power;
    protected int defense;
    protected int exp;
    protected int currentMana;
    protected int maxMana;
    protected int gold;

    public Creature(String name, int level, int currentHealth, int maxHealth, int currentMana, int maxMana, int power, int defense, int exp, int gold) {
        this.name = name;
        this.level = level;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.currentMana = currentMana;
        this.maxMana = maxMana;
        this.power = power;
        this.defense = defense;
        this.exp = exp;
        this.gold = gold;
    }
}
