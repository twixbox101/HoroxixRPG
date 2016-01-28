package Items;

import java.util.HashMap;
import java.util.Map;

/**
Created by holden johnson on 10/24/2015.
 */
public class Item {

    protected int price;
    protected int heal;
    protected int sell;
    protected String name;
    protected int quantity;

    //<editor-fold desc="Getters and Setters">

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//</editor-fold>

    //creates map for items
    public static Map<Item, Integer> mapOfItems= new HashMap<Item, Integer>();
    //list of items and their values
    public static Item potion = new Item("Potion", 20, 40, 5, 0);
    public static Item elixir = new Item("Elixir", 50, 20, 24, 0);
    //adds Items.Item to mapOfItems(To get them use .get)
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





