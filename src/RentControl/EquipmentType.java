package RentControl;

import java.util.List;

public class EquipmentType {

    protected int EqID;
    protected String equipmentName;
    protected float minCharge;
    protected float hourly;
    protected float daily;
    protected int weekend;
    protected float weekly;
    protected float month;
    protected float cost;

    public EquipmentType(int EqID, String equipmentName, float minCharge, float 
            hourly, float daily, int weekend, float weekly, float month, float cost) {
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