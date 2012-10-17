package RentDB;

import java.util.List;
import RentControl.EquipmentType;
import java.util.ArrayList;

public class EquipmentTypeDB {

    // fake database in ArrayList form
    private ArrayList<EquipmentType> types;
    
    /**
     * This constructor is currently instantiating the fake database.
     */
    public EquipmentTypeDB() {
        // dummy code to emulate an actual database
        types = new ArrayList<EquipmentType>();
        
        EquipmentType tmp1 = new EquipmentType(5920, "Pruner, Gas power 12\"", 
                35.0f, 35.0f, 50.0f, 175.0f, 175.0f, 450.0f, 1000.0f);
        EquipmentType tmp2 = new EquipmentType(4530, "Shingle Scraper", 14f, 
                7f, 10f, 20f, 30f, 40f, 150f);
        types.add(tmp1);
        types.add(tmp2);
    }

    public boolean addEquipmentType(EquipmentType type) {
        return false;
    }

    public boolean updateEquipmentType(EquipmentType type) {
        return false;
    }

    /**
     * This method returns the EquipmentType with the EqID that is passed as a 
     * parameter. <br />
     * <br />
     * Currently dummied using a list that contains equipment types.
     * 
     * @param EqID the equipment type id that is to be searched for
     * @return the EquipmentType that uses that id
     */
    public EquipmentType getEquipmentType(int EqID) {
        EquipmentType current = null;
        for(EquipmentType et : types) {
            if (et.getEqID() == EqID) {
                current = et;
                break;
            }
        }
        return current;
    }

    /**
     * This method's purpose is to return an ArrayList containing the 
     * EquipmentTypes that contain the search string.   <br />
     * <br />
     * Currently dummied using a list that contains equipment types.
     * 
     * @param search the string to search for
     * @return the list of EquipmentTypes whose names contain that search string
     */
    public ArrayList<EquipmentType> getEquipmentType(String search) {
        ArrayList<EquipmentType> current = new ArrayList<EquipmentType>();
        for(EquipmentType et : types) {
            String tmp = et.getEquipmentName().toLowerCase();
            if (tmp.contains(search.toLowerCase())) {
                current.add(et);
            }
        }
        return current;
    }
}