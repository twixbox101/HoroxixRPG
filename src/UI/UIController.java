package UI;

import Creatures.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class UIController {
    @FXML
    private TableView<Character> characterStats;
    @FXML
    private TableColumn<Character, String> charNameColumn;
    @FXML
    private TableColumn<Character, Integer> charLevelColumn;

    @FXML
    private Label name;
    @FXML
    private Label gender;
    @FXML
    private Label charClass;
    @FXML
    private Label power;
    @FXML
    private Label defense;
    @FXML
    private Label health;
    @FXML
    private Label level;
    @FXML
    private Label experience;
    @FXML
    private Label weapon;
    @FXML
    private Label armor;


    // Reference to the main UI application.
    private UIMain uiMain;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public UIController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize(Character myCharacter) {
        // Clear person details.
       showStats(myCharacter);

        // Listen for selection changes and show the person details when changed.
        characterStats.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStats(myCharacter));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param
     */
    public void setMainApp(UIMain uiMain) {
        this.uiMain = uiMain; }



    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param myCharacter the person or null
     */
    private void showStats(Character myCharacter) {
        if (myCharacter != null) {
            // Fill the labels with info from the person object.
            name.setText(myCharacter.getName());
            gender.setText(myCharacter.getGender());
            charClass.setText(myCharacter.getCharClass());
            level.setText(Integer.toString(myCharacter.getLevel()));
            experience.setText(Integer.toString(myCharacter.getExp()));
            power.setText(Integer.toString(myCharacter.getPower()));
            defense.setText(Integer.toString(myCharacter.getDefense()));
            health.setText(Integer.toString(myCharacter.getMaxHealth()));
            weapon.setText(myCharacter.getMyWeapon().getName());
            armor.setText(myCharacter.getMyArmor().getName());

        } else {
            // Person is null, remove all the text.
            name.setText("");
            gender.setText("");
            charClass.setText("");
            level.setText("");
            experience.setText("");
            power.setText("");
            defense.setText("");
            health.setText("");
            weapon.setText("");
            armor.setText("");
        }
    }
}
