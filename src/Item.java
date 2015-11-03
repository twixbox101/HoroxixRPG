import java.util.HashMap;
import java.util.Map;

/**
Created by holden johnson on 10/24/2015.
 */
public class Item {

    int price;
    int heal;
    int sell;
    String name;
    int quantity;

    //creates map for items
    public static Map<Item, Integer> mapOfItems= new HashMap<>();
    //list of items and their values
    public static Item potion = new Item("Potion", 20, 40, 5, 0);
    public static Item elixir = new Item("Elixir", 50, 20, 24, 0);
    //adds Item to mapOfItems(To get them use .get)
    static
    {
        mapOfItems.put(potion, potion.price);
        mapOfItems.put(elixir, elixir.price);
    }

    /**
     *
     * @param itemName name of the item.
     * @param itemPrice price of the item in the store.
     * @param itemHeal heal value of the item.
     * @param itemSell sell value of the item.
     */

    public Item(String itemName, int itemPrice, int itemHeal, int itemSell, int itemQuantity){
        price = itemPrice;
        name = itemName;
        heal = itemHeal;
        sell = itemSell;
        quantity = itemQuantity;

    }
    public String toString() {
        return name;
    }
}





