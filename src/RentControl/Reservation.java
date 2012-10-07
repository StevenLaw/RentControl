package RentControl;

import java.util.Date;

public class Reservation {

    private Date startTime;
    private Date endTime;
    private Enum chargeScale;
    private boolean returned;
    private boolean paid;
    // instead of 
    private int itemNo;

    public Reservation(Date startTime, Date endTime, Enum chargeScale, boolean 
            returned, boolean paid, int itemNo) {
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
        
        return false;
    }

    public Enum getChargeScale() {
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