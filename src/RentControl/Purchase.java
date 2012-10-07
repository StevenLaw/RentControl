package RentControl;

/**
 * This class stores information about a purchase.
 * 
 * @author Steven Law
 */
public class Purchase {

    private int itemNo;

    /**
     * This constructor is just basic
     * 
     * @param itemNo the number of the item being purchased
     */
    public Purchase(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getItemNo() {
        return itemNo;
    }
}