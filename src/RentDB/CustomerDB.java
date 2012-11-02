package RentDB;

import RentControl.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDB {

    /**
     * This method creates the initial Customer table in the database.
     *
     * @throws Exception if there is a database connection error
     */
    public static void createCustomerList() throws Exception {
        Connection conn = null;
        Statement stmt;

        try {
            conn = DBConnector.getConnection();
            stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Customer"
                    + "(CID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "FName varchar(25) NOT NULL, "
                    + "LName varchar(25) NOT NULL, "
                    + "MName varchar(25), "
                    + "Street varchar(50), "
                    + "City varchar(25), "
                    + "PostalCode char(6), "
                    + "Country varchar(40), "
                    + "Phone varchar(12), "
                    + "Email varchar(40), "
                    + "CreditCard integer, "
                    + "Discount real, "
                    + "CancelAbuse char(1) DEFAULT 'N', "
                    + "CONSTRAINT Check_CancelAbuse_cc CHECK (CancelAbuse in ('Y', 'N'))"
                    + ")");
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }

    /**
     * This method's purpose is to insert a new customer into the database.
     *
     * @param customer the customer to be added
     * @throws Exception if unsuccessful
     */
    public static void addCustomer(Customer customer) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement("INSERT into Customer (FName, LName, "
                    + "MName, Street, City, PostalCode, Country, Phone, Email, "
                    + "CreditCard, Discount) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getMiddleName());
            pstmt.setString(4, customer.getStreet());
            pstmt.setString(5, customer.getCity());
            pstmt.setString(6, customer.getPostalCode());
            pstmt.setString(7, customer.getCountry());
            pstmt.setString(8, customer.getPhone());
            pstmt.setString(9, customer.getEmail());
            pstmt.setInt(10, customer.getCreditCard());
            pstmt.setFloat(11, customer.getDiscount());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
        //return false;
    }

    /**
     * UpdateCustomer takes in a Customer Object and extracts the CID to use to 
     * update that particular record in the database.  It converts the 
     * true/false value of the abuse flag into Y or N in the process.
     * 
     * @param customer the updated customer to be propagated to the database
     * @return true if more than one record was updated
     * @throws Exception if there was a database error
     */
    public static boolean updateCustomer(Customer customer) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt;
        int rows = 0;

        try {
            pstmt = conn.prepareStatement("UPDATE Customer "
                    + "Set FName=?, "
                    + "LName=?, "
                    + "MName=?, "
                    + "Street=?, "
                    + "City=?, "
                    + "PostalCode=?, "
                    + "Country=?, "
                    + "Phone=?, "
                    + "Email=?, "
                    + "CreditCard=?, "
                    + "Discount=?, "
                    + "CancelAbuse=? "
                    + "Where CID=?");
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getMiddleName());
            pstmt.setString(4, customer.getStreet());
            pstmt.setString(5, customer.getCity());
            pstmt.setString(6, customer.getPostalCode());
            pstmt.setString(7, customer.getCountry());
            pstmt.setString(8, customer.getPhone());
            pstmt.setString(9, customer.getEmail());
            pstmt.setInt(10, customer.getCreditCard());
            pstmt.setFloat(11, customer.getDiscount());
            if (customer.isAbusive()) {
                pstmt.setString(12, "Y");
            } else {
                pstmt.setString(12, "N");
            }
            pstmt.setInt(13, customer.getCID());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
        
        if (rows == 0)
            return false;
        else
            return true;
    }

    /**
     * getCustomer returns the single Customer that has the selected CID.  If 
     * that CID is not in the database there is something wrong with the system
     * because the CID should be hidden and should not be accessed directly.  
     * Therefore it indicated a database error.
     * 
     * @param CID the CID of the Customer to retrieve
     * @return the retrieved Customer
     * @throws Exception if there is a database error
     */
    public static Customer getCustomer(int CID) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt;
        Customer c;

        try {
            pstmt = conn.prepareStatement("SELECT * From Customer where CID=?");
            pstmt.setInt(1, CID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            c = new Customer(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            c.setMiddleName(rs.getString(4));
            c.setStreet(rs.getString(5));
            c.setCity(rs.getString(6));
            c.setPostalCode(rs.getString(7));
            c.setCountry(rs.getString(8));
            c.setPhone(rs.getString(9));
            c.setEmail(rs.getString(10));
            c.setCreditCard(rs.getInt(11));
            c.setDiscount(rs.getFloat(12));
            char tmp = rs.getString(13).charAt(0);
            if (tmp == 'Y') {
                c.setAbuse(true);
            } else {
                c.setAbuse(false);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }

        return c;
    }

    /**
     * This will return an ArrayList of all the customers in the system.  I felt
     * that it is best to use this system because it allows for better partial 
     * name searching.
     * 
     * @return the ArrayList of all the Customers in the system
     * @throws Exception if there is a database error
     */
    public static ArrayList<Customer> getCustomerList() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement stmt = conn.createStatement();
        String statement = "SELECT * From Customer";
        ArrayList<Customer> list = new ArrayList<Customer>();

        try {
            ResultSet rs = stmt.executeQuery(statement);
            Customer c;

            if (!rs.wasNull()) {
                while (rs.next()) {
                    c = new Customer(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3));
                    c.setMiddleName(rs.getString(4));
                    c.setStreet(rs.getString(5));
                    c.setCity(rs.getString(6));
                    c.setPostalCode(rs.getString(7));
                    c.setCountry(rs.getString(8));
                    c.setPhone(rs.getString(9));
                    c.setEmail(rs.getString(10));
                    c.setCreditCard(rs.getInt(11));
                    c.setDiscount(rs.getFloat(12));
                    //System.out.println(rs.getString(13));
                    char tmp = rs.getString(13).charAt(0);
                    if (tmp == 'Y') {
                        c.setAbuse(true);
                    } else {
                        c.setAbuse(false);
                    }
                    list.add(c);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }

        return list;
    }
}