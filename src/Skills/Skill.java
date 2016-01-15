package Skills;

import Creatures.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Created by Holden Johnson on 10/28/2015.
 */
public class Skill {
    protected String name;
    protected double damage;
    protected int manaCost;
    protected double heal;
    protected int accuracy;

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

    public static List<Skill> skillList = new ArrayList<>();

    //Checks their level and adds skills to their skill List accordingly.
    //TODO - modify levels 10-25 to new skills other than stab.
    public static void skillCheck(Character myCharacter){
        switch(myCharacter.getCharClass()){
            case "knight":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.stab);
                    System.out.println("You have learned the " + Skill.stab.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.add(Skill.stab);}
            case "ranger":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.headShot);
                    System.out.println("You have learned the " + Skill.headShot.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.add(Skill.stab);}
            case "wizard":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.thunderBolt);
                    System.out.println("You have learned the " + Skill.thunderBolt.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.add(Skill.stab);}
            case "druid":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.drain);
                    System.out.println("You have learned the " + Skill.drain.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.add(Skill.stab);}
            case "priest":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.shock);
                    System.out.println("You have learned the " + Skill.shock.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.add(Skill.stab);}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.add(Skill.stab);}
        }
    }

//Creating different skills.
    public static Skill doubleSlash = new Skill("Double Slash", 2.0, 8, 0, 100);
    public static Skill cure = new Skill("Cure", 0, 10, 2.0, 100);
    public static Skill fireBall = new Skill("Fireball", 2.0, 10, 0, 100);
    public static Skill thunderBolt= new Skill("Thunder Bolt", 3.5, 25, 0, 95);
    public static Skill death = new Skill("Death", 100, 50, 0, 50);
    public static Skill triShot = new Skill("Tri-Shot", 3.0, 15, 0, 80);
    public static Skill drain = new Skill("Drain", 2.0, 10, 2.0, 80);
    public static Skill headShot = new Skill("Head Shot", 5.0, 10, 0, 60);
    public static Skill shock = new Skill("Shock", 3.0, 25, 0, 100);
    public static Skill stab = new Skill("Stab", 3.0, 20, 0, 80);

//default assigning of skills.
    public Skill(String name, double damage, int manaCost, double heal, int accuracy){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.heal = heal;
        this.accuracy = accuracy;
//sets up skills to return as their name.
    }
    public String toString() {
        return name;
    }
}
