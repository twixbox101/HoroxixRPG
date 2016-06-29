package Game;
import Creatures.Character;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Holden Johnson on 1/29/2016.
 */

public class Shop {
    //TODO Add shops for each class.
    //Enters the shop and displays a list of items.
    public void enterShop(Character myCharacter) {
        myCharacter.setLocation("shop");
        System.out.println("[E]quipment Shop]|  [I]tem Shop | e[X]it");
        String shopChoice;
        while ("shop".equals(myCharacter.getLocation())) {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "e" :
                    switch (myCharacter.getCharClass().toLowerCase()) {
                        case "knight":
                            enterKnightShop(myCharacter);
                        case "hunter":
                            enterKnightShop(myCharacter);
                        case "druid":
                            enterKnightShop(myCharacter);
                        case "priest":
                            enterKnightShop(myCharacter);
                        case "wizard":
                            enterKnightShop(myCharacter);
                        default:
                            System.out.println("Please select a valid option.");
                    }
                case "i" :
                    enterItemShop(myCharacter);
                case "x" :
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");

            }
            }
        }


    public void enterKnightShop(Character myCharacter){
        String shopChoice;
        myCharacter.setLocation("knightShop");
        System.out.println("You arrive at the shop.");
        System.out.println("A burly man in tarnished armor stands behind the counter, glaring down at you through a thick moustache.\nHe spits into a mug as you approach and plants his thick fingers on the counter top.");
        System.out.println("Welcome to the Knight's shop. What can I get you?");
        System.out.println("[Type the first letter of each word in the Item's name to select.]e[X]it");
        for (Map.Entry<Item, Integer> entry : Item.mapOfKnightItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
        while ("knightShop".equals(myCharacter.getLocation())) {
            Scanner myInput = new Scanner(System.in);
            shopChoice = myInput.next();
            switch (shopChoice.toLowerCase()) {
                case "wa":
                    if (myCharacter.getGold() >= Armor.woodArmor.getPrice()) {
                        System.out.println("You have purchased a set of Wood Armor!");
                        myCharacter.inventory.add(Armor.woodArmor);
                        Item.potion.setQuantity(Armor.woodArmor.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Armor.woodArmor.getPrice());
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                    break;
                case "ws":
                    if (myCharacter.getGold() >= Weapon.woodSword.getPrice()) {
                        System.out.println("You have purchased a Wood Sword!");
                        myCharacter.inventory.add(Weapon.woodSword);
                        Item.elixir.setQuantity(Weapon.woodSword.getQuantity() + 1);
                        myCharacter.setGold(myCharacter.getGold() - Weapon.woodSword.getPrice());
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


    //TODO - make secret shop. Make character for item shop.
    public void enterItemShop(Character myCharacter) {
        String shopChoice;
        myCharacter.setLocation("itemShop");
        System.out.println("Welcome to the Item shop!");
        System.out.println("What can I get you?");
        System.out.println("Type the first letter of the item name, or [X] to exit the shop.");
        for (Map.Entry<Item, Integer> entry : Item.mapOfItems.entrySet()) {
            Item key = entry.getKey();
            System.out.println(key + " : " + entry.getValue());
        }
        while ("itemShop".equals(myCharacter.getLocation())) {
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
                    System.out.println("You leave the Item Shop");
                    myCharacter.setLocation("mainMenu");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}
