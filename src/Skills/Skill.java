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
    protected int damage;
    protected int manaCost;
    protected int heal;
    protected int accuracy;
    protected String type;

    //<editor-fold desc="Getters and Setters">
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeal() {
        return heal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
    //</editor-fold>

    public static List<Skill> skillList = new ArrayList<>();

    //Checks their level and adds skills to their skill List accordingly.
    //TODO - modify levels 10-25 to new skills other than stab.
    public static void skillCheck(Character myCharacter){
        switch(myCharacter.getCharClass()){
            case "knight":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.set(1,Skill.stab);
                    System.out.println("You have learned the " + Skill.stab.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.set(2,Skill.charge);
                    System.out.println("You have learned the " + Skill.charge.getName() + " skill!");}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.set(3,Skill.knightSwing);
                    System.out.println("You have learned the " + Skill.knightSwing.getName() + " skill!");}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.set(4,Skill.darkStab);
                    System.out.println("You have learned the " + Skill.darkStab.getName() + " skill!");}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.set(5,Skill.dragonsBane);
                    System.out.println("You have learned your Ultimate Skill, " + Skill.dragonsBane.getName() + "!");}
            case "ranger":
                if(myCharacter.getLevel() == 5){ myCharacter.skills.add(Skill.headShot);
                    System.out.println("You have learned the " + Skill.headShot.getName() + " skill!");}
                else if(myCharacter.getLevel() == 10){ myCharacter.skills.set(2,Skill.precision);
                    System.out.println("You have learned the " + Skill.precision.getName() + " skill!");}
                else if(myCharacter.getLevel() == 15){ myCharacter.skills.set(3,Skill.refresh);
                    System.out.println("You have learned the " + Skill.refresh.getName() + " skill!");}
                else if(myCharacter.getLevel() == 20){ myCharacter.skills.set(4,Skill.snipe);
                    System.out.println("You have learned the " + Skill.snipe.getName() + " skill!");}
                else if(myCharacter.getLevel() == 25){ myCharacter.skills.set(5,Skill.omniShot);
                    System.out.println("You have learned your Ultimate Skill, " + Skill.omniShot.getName() + "!");}
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
    //Knight Skills
    public static Skill doubleSlash = new Skill("Double Slash", 2, 8, 0, 100, "double");
    public static Skill stab = new Skill("Stab", 3, 20, 0, 80, "triple");
    public static Skill charge = new Skill("Charge", 2, 15, 0, 75, "self");
    public static Skill knightSwing = new Skill("Knight's Swing", 2, 30, 0, 100, "triple");
    public static Skill darkStab = new Skill("Dark Stab", 2, 50, 100, 88, "healDamage");
    public static Skill dragonsBane = new Skill("Dragon's Bane", 2, 100, 0, 99, "ultimateKnight");
    //Ranger Skills
    public static Skill triShot = new Skill("Tri-Shot", 3, 15, 0, 80, "triple");
    public static Skill headShot = new Skill("Head Shot", 5, 10, 0, 60, "crit");
    public static Skill precision = new Skill("Precision", 100, 15, 0, 100, "buff");
    public static Skill refresh = new Skill("Refresh", 5, 35, 2, 100, "heal");
    public static Skill snipe = new Skill("Snipe", 5, 55, 0, 60, "multi");
    public static Skill omniShot = new Skill("Omni-Shot", 5, 10, 0, 60, "ultimateRanger");


    public static Skill cure = new Skill("Cure", 0, 10, 2, 100, "heal");
    public static Skill fireBall = new Skill("Fireball", 2, 10, 0, 100, "double");
    public static Skill thunderBolt= new Skill("Thunder Bolt", 3, 25, 0, 95, "triple");
    public static Skill death = new Skill("Death", 100, 50, 0, 50, "death");

    public static Skill drain = new Skill("Drain", 45, 10, 45, 80, "healDamage");

    public static Skill shock = new Skill("Shock", 3, 25, 0, 100, "triple");

    public static Skill unknown = new Skill("?", 0, 0, 0, 0, "heal");


//default assigning of skills.
    public Skill(String name, int damage, int manaCost, int heal, int accuracy, String type){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.heal = heal;
        this.accuracy = accuracy;
        this.type = type;
//sets up skills to return as their name.
    }
    public String toString() {
        return name;
    }
}
