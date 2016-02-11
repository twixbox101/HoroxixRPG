package Game;

import Creatures.Character;



/**
 * Created by hjohnson on 10/24/2015.
 */
public class Main {

    public static void main(String[] args)
    {
        Character newCharacter = new Character();
        newCharacter.chooseName();
        newCharacter.chooseClass();
        newCharacter.chooseGender(newCharacter);
        Event mainEvent = new Event();
        mainEvent.mainMenu(newCharacter);

    }
}
