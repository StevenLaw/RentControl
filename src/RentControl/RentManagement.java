package RentControl;

import java.util.Date;
import java.util.List;

/**
 * This class acts as the main controller of the data files.  It is here that 
 * most of the database calls originate as well as adding employees, customers, 
 * equipment types, and items.  It is also responsible for creating new 
 * transactions.
 * 
 * @author Steven Law
 */
public class RentManagement {

//  private java.util.Vector employees;
//
//  private java.util.Vector customers;
    private List equipmentTypes;

//    /**
//   * 
//   * @element-type Customer
//   */
//  public Vector  customers;
//    /**
//   * 
//   * @element-type Employee
//   */
//  public Vector  employees;
//    /**
//   * 
//   * @element-type Transaction
//   */
//  public Vector  myTransaction;
//                    public Vector  myDBConnector;
//    public Vector  myDBConnector;
//    public Vector  myDBConnector;
    /**
     * This constructor will initialise the variables and request the connection 
     * to the database
     */
    public RentManagement() {
        
    }

     public List getCurrentReservations() {
        return null;
    }

    public List getTransactions(Date start, Date end) {
        return null;
    }

    public List getUnpaid() {
        return null;
    }

    public List getExpired() {
        return null;
    }

    public void searchCustomers() {
    }

   public List getItems(EquipmentType type) {
        return null;
    }

    public boolean reserveItem(Item item, Date startTime, Date endTime) {
        return false;
    }

    public boolean makePayment() {
        return false;
    }
}