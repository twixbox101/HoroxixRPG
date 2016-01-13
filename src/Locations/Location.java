package Locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hjohnson on 10/23/2015.
 */
public class Location {

    protected String name;
    protected int levelRequired;


    //<editor-fold desc="Getters and Setters">
    public String getName() {
        return name;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }
    //</editor-fold>

    public Location(String name, int levelRequired) {
        this.name = name;
        this.levelRequired = levelRequired;
    }

    public String toString() {
            return getClass().getSimpleName();
    }

    public static void main(String[] args) {
    }
}


