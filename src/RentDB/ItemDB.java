package RentDB;

import RentControl.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemDB {

    private ArrayList<Item> items;
    
    /**
     * This constructor is currently instantiating the fake database.
     */
    public ItemDB() {
        // dummy code for a fake database;
        items = new ArrayList<Item>();
        Item[] tmp = new Item[30];
        for(int i = 0; i < 10; i++){
            tmp[i] = new Item(i+1, 5920);
        }
        tmp[4].setSalePrice(500f);
        tmp[7].setSalePrice(300f);
        for(int i = 10; i < 30; i++){
            tmp[i] = new Item(i+1, 4530);
        }
        tmp[14].setSalePrice(40f);
        tmp[16].setSalePrice(30f);
        tmp[19].setSalePrice(70f);
        tmp[23].setSalePrice(10f);
        for (int i = 0; i < 30; i++){
            items.add(tmp[i]);
        }
    }

    public boolean addItem(Item item) {
        return false;
    }

    public boolean updateItem(Item item) {
        return false;
    }

    public Item getItem(int ItemNo) {
        Item current = null;
        for(Item i : items) {
            if (i.getItemNo() == ItemNo){
                current = i;
                break;
            }
        }
        return current;
    }

    /**
     * 
     * @param EqID
     * @return 
     */
    public ArrayList<Item> getItemByType(int EqID) {
        //System.out.println("EqID: " + EqID + " Size: " + items.size());
        ArrayList<Item> current = new ArrayList<Item>();
        for(Item i : items){
            if (i.getEqID() == EqID){
                current.add(i);
            }
        }
        return current;
    }
}