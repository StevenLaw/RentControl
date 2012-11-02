/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTest;
import RentControl.Customer;
import RentDB.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This is a simple database test class.
 * 
 * @author Steven Law
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        //If the database does not yet exist create it and attempt to drop 
        //  Customer
        try {
            conn = DBConnector.getConnection();
            Statement stmt = conn.createStatement();
            
            stmt.execute("DROP TABLE Customer");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        //Create table
        try {
            CustomerDB.createCustomerList();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Add customer
        try {
            Customer c1 = new Customer(0, "Steven", "Law");
            Customer c2 = new Customer(0, "Charanjeev", "Johal");
            Customer c3 = new Customer(0, "Charles", "Salonga");
            CustomerDB.addCustomer(c1);
            CustomerDB.addCustomer(c2);
            CustomerDB.addCustomer(c3);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Get customer list
        try {
            ArrayList<Customer> array = CustomerDB.getCustomerList();
            for (Customer c : array) {
                System.out.println("ID: " + c.getCID() + " " + c + ", " + c.isAbusive());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        
        //Test update and get by CID if out of range an exception is thrown
        try {
            Customer updateC = CustomerDB.getCustomer(3);
            System.out.println(updateC + ", Abuse Flag: " + updateC.isAbusive());
            System.out.println("Setting flag to true");
            updateC.setAbuse(true);
            CustomerDB.updateCustomer(updateC);
//            Customer testOutRange = CustomerDB.getCustomer(1000000);
//            if(testOutRange == null)
//                System.out.println("That Customer does not exist.");
        } catch(Exception e) {
            System.out.println(e);
        }
        
        //Reprint customer list
        try {
            ArrayList<Customer> array = CustomerDB.getCustomerList();
            for (Customer c : array) {
                System.out.println("ID: " + c.getCID() + " " + c + ", " + c.isAbusive());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
