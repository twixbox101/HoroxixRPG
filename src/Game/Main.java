package Game;

import Creatures.Character;
import UI.UIMain;
import javafx.stage.Stage;

/**
 * Created by hjohnson on 10/24/2015.
 */
public class Main {




    public static void main(String[] args)
    {
        Character newCharacter = new Character("", "", "", 1, 1, 1, 1, 1, 1, 0, 0, 0);
        newCharacter.chooseName();
        newCharacter.chooseClass();
        newCharacter.chooseGender(newCharacter);
        Event mainEvent = new Event();
        mainEvent.levelUP(newCharacter);
        mainEvent.levelUP(newCharacter);
        mainEvent.levelUP(newCharacter);
        mainEvent.levelUP(newCharacter);
        UIMain mainUI = new UIMain();
        mainUI.launch(mainUI.getClass());
        mainEvent.mainMenu(newCharacter);

        //Game newGame = new Game();
        //newGame.start();
    }
}
