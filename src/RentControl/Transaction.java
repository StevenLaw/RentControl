package RentControl;

import java.util.Date;
import java.util.ArrayList;
import RentDB.*;

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
    /**
    * This is the list of reservations in this transaction.
    * 
    * @element-type Reservation
    */
    private ArrayList<Reservation>  rentals;
    /**
    * This is the list of purchases in this transaction.
    * 
    * @element-type Purchase
    */
    private ArrayList<Purchase>  sales;
    private ReservationDB rentalDB;
    private PurchaseDB saleDB;
            

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
        rentals = new ArrayList<Reservation>();
        sales = new ArrayList<Purchase>();
//        rentalDB = new ReservationDB();
//        saleDB = new PurchaseDB();
    }

    /**
     * This method generates a string format receipt.
     * 
     * @return the receipt in string format
     */
    public String generateReceipt() {
        String receipt = "Rent It\n"
                + "Transaction Number: " + TNo +"\n"
                + "Date: " + transDate + "\n";
        return receipt;
    }

    /**
     * This method takes a reservation and adds it to the list of reservations.
     * 
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        rentals.add(reservation);
    }

    public ArrayList getReservations(){
        return rentals;
    }
    
    /**
     * This method takes a purchase and adds it to the list of purchases.
     * 
     * @param purchase the purchase to be added
     */
    public void addPurchase(Purchase purchase) {
        sales.add(purchase);
    }
    
    public ArrayList getPurchases(){
        return sales;
    }

    public boolean creditPayment() {
        return false;
    }

    public void cashPayment() {
    }

    public boolean debitPayment() {
        return false;
    }
    
    private boolean storeTransaction(){
//        for (Purchase p : sales){
//            if(!saleDB.addPurchase(p))
//                return false;
//        }
        return true;
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