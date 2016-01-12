import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjohnson on 10/24/2015.
 */
public class aMain {



    public static void main(String[] args)
    {
        Character newCharacter = new Character();
        newCharacter.chooseName();
        newCharacter.chooseClass();
        newCharacter.chooseGender(newCharacter);
        Event mainEvent = new Event();
        mainEvent.levelUP(newCharacter);
        mainEvent.levelUP(newCharacter);
        mainEvent.mainMenu(newCharacter);
        //Game newGame = new Game();
        //newGame.start();
    }
}
