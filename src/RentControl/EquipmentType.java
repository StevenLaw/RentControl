package RentControl;

import java.util.List;

/**
 * This class stores information about the type of equipment used and contacts 
 * the database to find items of its type either available or all of them.
 *
 * @author Steven Law
 */
public class EquipmentType {

    private int EqID;
    private String equipmentName;
    private float minCharge;
    private float hourly;
    private float daily;
    private int weekend;
    private float weekly;
    private float month;
    private float cost;

    /**
     * This constructor sets the equipment type's name, id, charge scales, and
     * the cost to replace it.
     *
     * @param EqID the equipment type's id
     * @param equipmentName the equipment type's name
     * @param minCharge the minimum charge for the equipment type
     * @param hourly the hourly charge for the equipment type
     * @param daily the daily charge for the equipment type
     * @param weekend the weekend charge for the equipment type
     * @param weekly the weekly charge for the equipment type
     * @param month the monthly charge for the equipment type
     * @param cost the replacement charge for the equipment type
     */
    public EquipmentType(int EqID, String equipmentName, float minCharge, float hourly, float daily, int weekend, float weekly, float month, float cost) {
        this.EqID = EqID;
        this.equipmentName = equipmentName;
        this.minCharge = minCharge;
        this.hourly = hourly;
        this.daily = daily;
        this.weekend = weekend;
        this.weekly = weekly;
        this.month = month;
        this.cost = cost;
    }

    /**
     *
     * @element-type Item
     */
    public List listItems() {
        return null;
    }

    public List getAvailableItems() {
        return null;
    }

    public int getEqID() {
        return EqID;
    }

    public float getCost() {
        return cost;
    }

    public float getDaily() {
        return daily;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public float getHourly() {
        return hourly;
    }

    public float getMinCharge() {
        return minCharge;
    }

    public float getMonth() {
        return month;
    }

    public int getWeekend() {
        return weekend;
    }

    public float getWeekly() {
        return weekly;
    }
}