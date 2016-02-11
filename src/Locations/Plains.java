package Locations;

import Creatures.Monster;
import Items.Item;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by horox_000 on 1/12/2016.
 */
    public class Plains extends Location {



//Initiates the dropList ArrayList
    public static List<Item> dropList = new ArrayList<Item>();

    //Adds items to the Locations.Plains droppable item's list
    {
        dropList.add(Item.potion);
    }

    //Initiates the enemyList ArrayList

    //TODO - init monsters to their various objects lists in Location.
    public static List<Monster> enemyList= new ArrayList<Monster>();

//Adds monsters to the Locations.Plains random encounters
    {
        enemyList.add(Monster.goblin);
        enemyList.add(Monster.barbarian);
        enemyList.add(Monster.loneWolf);
        enemyList.add(Monster.hyena);
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


    protected Plains(String name, int levelRequired, List<Monster> enemyList, List<Item> dropList){
        super(name, levelRequired);
        this.dropList = dropList;
        this.enemyList = enemyList;

    }
    protected static Plains Plains = new Plains("Plains", 1, enemyList, dropList);
}
