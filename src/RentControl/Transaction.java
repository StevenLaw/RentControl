package RentControl;

import java.util.Date;

public class Transaction {

  private int TNo;

  private Date transDate;

  private float total;

  private Enum paymentType;

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
    public Employee myEmployee;
    public Customer myCustomer;
  
  public String generateRecipt() {
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

  public float calculateDeposit() {
    return (float) 0.0;
  }

  public void setDiscount(float discount) {
  }

}