package Locations;

import Creatures.Monster;
import Items.Item;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by horox_000 on 1/12/2016.
 */
    public class DarkForest extends Location {


//Initiates the dropList ArrayList
    public static List<Item> dropList = new ArrayList<Item>();

    //Adds items to the Locations.Plains droppable item's list
    {
        dropList.add(Item.potion);
    }

    //Initiates the enemyList ArrayList
    public static List<Monster> enemyList= new ArrayList<Monster>();

//Adds monsters to the Locations.Plains random encounters
    {
        enemyList.add(Monster.bat);
        enemyList.add(Monster.centaur);
        enemyList.add(Monster.darkElf);
        enemyList.add(Monster.pixie);
    }

    //<editor-fold desc="Getters and Setters">
    public List<Item> getDropList() {
        return dropList;
    }

    public void setDropList(ArrayList<Item> dropList) {
        this.dropList = dropList;
    }

    public List<Monster> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Monster> enemyList) {
        this.enemyList = enemyList;
    }
    //</editor-fold>


    public DarkForest(String name, int levelRequired, List<Monster> enemyList, List<Item> dropList){
        super(name, levelRequired);
        this.dropList = dropList;
        this.enemyList = enemyList;

    }

    public void inForest() {

    }
    protected static DarkForest Forest = new DarkForest("Dark Forest", 5, enemyList, dropList);
}
