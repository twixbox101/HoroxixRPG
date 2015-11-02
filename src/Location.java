

import java.util.Scanner;



/**
 * Created by hjohnson on 10/23/2015.
 */
public class Location {

    String myLocation;
    String myLocationName;
    String myLocationChoice = "";


    public Location (){

    }

    public String toString() {
            return getClass().getSimpleName() + myLocationChoice;
    }

    public void getLocationChoice(String choice) {
        System.out.print("Please choose a location!");
        Scanner inputChoice = new Scanner(System.in);
        while (!myLocationChoice.equalsIgnoreCase("forest") && !myLocationChoice.equalsIgnoreCase("dungeon") && !myLocationChoice.equalsIgnoreCase("mountains")){
            System.out.println("[Forest][Dungeons][Mountains]");
            myLocationChoice = inputChoice.next();
            if(myLocationChoice.equalsIgnoreCase("forest") || myLocationChoice.equalsIgnoreCase("dungeon") || myLocationChoice.equalsIgnoreCase("mountains")) {
                System.out.println("You travel to the " + myLocationChoice + "!");
            }
            else{
                System.out.println("Please choose a valid location!");
            }

            }
        }






    public static void main(String[] args) {
        Location Choice = new Location();
        Location Forest = new Location();
        Location Dungeon = new Location();
        Location Mountains = new Location();
        Choice.getLocationChoice("");

    }
}


