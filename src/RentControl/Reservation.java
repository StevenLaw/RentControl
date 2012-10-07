package RentControl;

import java.util.Date;

/**
 * This class stores information about reservations.
 * 
 * @author Steven Law
 */
public class Reservation {

    private Date startTime;
    private Date endTime;
    private ChargeScale chargeScale;
    private boolean returned;
    private boolean paid;
    // instead of storing an instance of the item we represent it with a number
    private int itemNo;

    /**
     * This is the constructor that initialises the required attributes.
     * 
     * @param startTime when the reservation begins
     * @param endTime when the reservation ends
     * @param chargeScale the representation of how the customer is paying
     * @param returned whether or not the item has been returned
     * @param paid whether or not the reservation has been paid for
     * @param itemNo the number of the item reserved
     */
    public Reservation(Date startTime, Date endTime, ChargeScale chargeScale, 
            boolean returned, boolean paid, int itemNo) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.chargeScale = chargeScale;
        this.returned = returned;
        this.paid = paid;
        this.itemNo = itemNo;
    }

    /**
     * This method is used to check if the current date is later than the 
     * endTime attribute.
     * 
     * @return true if the reservation has expired false otherwise.
     */
    public boolean isExpired() {
        // get the current date
        Date currDate = new Date();
        if (currDate.after(endTime))
            return true; // if the endTime has passed return true
        else
            return false; // otherwise return false
    }

    public ChargeScale getChargeScale() {
        return chargeScale;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getItemNo() {
        return itemNo;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isReturned() {
        return returned;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}