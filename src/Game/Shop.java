package Game;
import Creatures.Character;
import Items.Item;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Holden Johnson on 1/29/2016.
 */

public class Shop {
    //Enters the shop and displays a list of items.
    public void enterShop(Character myCharacter) {
        String shopChoice;
        myCharacter.setLocation("shop");
        System.out.println("Welcome to the shop!");
        System.out.println("What can I get you?");
        System.out.println("Type the first letter of the item name, or [X] to exit the shop.");
        for (Map.Entry<Item, Integer> entry : Item.mapOfItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
        while ("shop".equals(myCharacter.getLocation())) {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "p":
                    if (myCharacter.getGold() >= Item.potion.getPrice()) {
                        System.out.println("You have purchased a Potion!");
                        myCharacter.inventory.add(Item.potion);
                        Item.potion.setQuantity(Item.potion.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.potion.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "e":
                    if (myCharacter.getGold() >= Item.elixir.getPrice()) {
                        System.out.println("You have purchased an Elixir!");
                        myCharacter.inventory.add(Item.elixir);
                        Item.elixir.setQuantity(Item.elixir.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.elixir.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "x":
                    System.out.println("You leave the shop");
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    //TODO - make secret shop
    public void enterShop2(Character myCharacter) {
        String shopChoice;
        myCharacter.setLocation("shop");
        System.out.println("Welcome to the shop!");
        System.out.println("What can I get you?");
        System.out.println("Type the first letter of the item name, or [X] to exit the shop.");
        for (Map.Entry<Item, Integer> entry : Item.mapOfItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
        while ("shop".equals(myCharacter.getLocation())) {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "p":
                    if (myCharacter.getGold() >= Item.potion.getPrice()) {
                        System.out.println("You have purchased a Potion!");
                        myCharacter.inventory.add(Item.potion);
                        Item.potion.setQuantity(Item.potion.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.potion.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "e":
                    if (myCharacter.getGold() >= Item.elixir.getPrice()) {
                        System.out.println("You have purchased an Elixir!");
                        myCharacter.inventory.add(Item.elixir);
                        Item.elixir.setQuantity(Item.elixir.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Item.elixir.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "x":
                    System.out.println("You leave the shop");
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}
