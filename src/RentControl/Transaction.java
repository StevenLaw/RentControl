package RentControl;

import java.util.Date;

/**
 * This class stores information about transactions, creates reservations and 
 * payments, calculates the total, calculates the deposit, makes the payments, 
 * and generates the receipt.
 * 
 * @author Steven Law
 */
public class Transaction {

    private int TNo;
    private Date transDate;
    private float total;  // we may want to calculate this dynamically
    private PaymentType paymentType;
    private int EID;
    private int CID;
//    /**
//   * 
//   * @element-type Reservation
//   */
//  public Vector  rentals;
//    /**
//   * 
//   * @element-type Purchase
//   */
//  public Vector  sales;

    /**
     * This constructor creates the transaction.  The transaction date is 
     * generated automatically.<br />
     * <br />
     * The links to the Employees and Customers is modeled using EID and CID 
     * through the database.
     * 
     * @param TNo the transaction number
     * @param paymentType the type of 
     * @param EID
     * @param CID 
     */
    public Transaction(int TNo, PaymentType paymentType, int EID, int CID) {
        this.TNo = TNo;
        this.transDate = new Date();
        this.paymentType = paymentType;
        this.EID = EID;
        this.CID = CID;
    }

    /**
     * This method generates a string format receipt.
     * 
     * @return the receipt in string format
     */
    public String generateReceipt() {
        return null;
    }

    public void addReservation(Reservation reservation) {
    }

    public void addPurchase(Purchase purchase) {
    }

    public boolean creditPayment() {
        return false;
    }

    public void cashPayment() {
    }

    public boolean debitPayment() {
        return false;
    }

    /**
     * This method calculates the deposit for debit and cash payments.
     * 
     * @return the deposit value
     */
    public float calculateDeposit() {
        return getTotal() * (float)0.25;
    }

    public void setDiscount(float discount) {
    }

    public int getCID() {
        return CID;
    }

    public int getEID() {
        return EID;
    }

    public int getTNo() {
        return TNo;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public float getTotal() {
        return total;
    }

    public Date getTransDate() {
        return transDate;
    }
}