package RentControl;

/**
 * This item stores information about the item.
 * 
 * @author Steven Law
 */
public class Item {

    private int itemNo;
    private int EqID;
    private boolean onHand;
    private float salePrice;
    /**
     *
     * @element-type Reservation
     */

    /**
     * This constructor sets the two id numbers that the item needs and 
     * automatically sets the onHand attribute to true because a newly created 
     * item is automatically going to be on hand
     * 
     * @param itemNo
     * @param EqID 
     */
    public Item(int itemNo, int EqID) {
        this.itemNo = itemNo;
        this.EqID = EqID;
        this.onHand = true;
    }

    public void setItemSalePrice(float price) {
    }

    public boolean isAvailable() {
        return onHand;
    }

    public int getEqID() {
        return EqID;
    }

    public int getItemNo() {
        return itemNo;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setOnHand(boolean onHand) {
        this.onHand = onHand;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }
}