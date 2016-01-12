import java.util.ArrayList;

/**
 * Created by horox_000 on 1/12/2016.
 */
public class Plains extends Location{



//Initiates the dropList ArrayList
    public static ArrayList<Item> dropList = new ArrayList<>();

    //Adds items to the Plains droppable item's list
    {
        dropList.add(Item.potion);
    }

    //Initiates the enemyList ArrayList
    public static ArrayList<Monster> enemyList= new ArrayList<>();

//Adds monsters to the Plains random encounters
    {
        enemyList.add(Monster.goblin);
        enemyList.add(Monster.bat);
    }

    //<editor-fold desc="Getters and Setters">
    public ArrayList<Item> getDropList() {
        return dropList;
    }

    public void setDropList(ArrayList<Item> dropList) {
        this.dropList = dropList;
    }

    public ArrayList<Monster> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Monster> enemyList) {
        this.enemyList = enemyList;
    }
    //</editor-fold>


    protected Plains(String name, int levelRequired, ArrayList enemyList, ArrayList dropList){
        super(name, levelRequired);
        this.dropList = dropList;
        this.enemyList = enemyList;

    }

    protected static Plains Plains = new Plains("Plains", 1, enemyList, dropList);


}
