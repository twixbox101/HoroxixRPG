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
        newCharacter.chooseGender();
        Event mainEvent = new Event();
        mainEvent.mainMenu(newCharacter);
        //Game newGame = new Game();
        //newGame.start();
    }
}
