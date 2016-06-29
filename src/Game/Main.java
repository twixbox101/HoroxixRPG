package Game;

import Creatures.Character;
import Locations.DarkForest;


/**
 * Created by hjohnson on 10/24/2015.
 */
public class Main {

    public static void main(String[] args)
    {
        Character newCharacter = new Character();
        DarkForest forest = new DarkForest("Dark Forest", 5, DarkForest.enemyList, DarkForest.dropList);
        forest.inForest();
        newCharacter.chooseName();
        newCharacter.chooseClass();
        newCharacter.chooseGender(newCharacter);
        Event mainEvent = new Event();
        mainEvent.mainMenu(newCharacter);

    }
}
