/**
 Created by Holden Johnson on 10/24/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class Inventory {



//creates the inventory hashmap
    public Map<Item,Integer> inventory = new HashMap<>();

//adds item to inventory.
    public void addItem(Item myItem){
        inventory.put(myItem, 1);
   }
// displays Item : Value
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Item,Integer> entry : inventory.entrySet())
        {
            str.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return str.toString();
    }
//unused
    public Map<Item, Integer> getInventory() {
        return inventory;
    }
//test
    public static void main(String[] args) {


    }
}
