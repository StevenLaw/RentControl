package RentDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This Classes purpose is to create a connection to the database
 * 
 * @author Steven Law
 */
public class DBConnector {

    /**
     * This static method returns a connection to the Rental database.
     * 
     * @return the database connector
     * @throws Exception if a database access error occurs
     */
    public static Connection getConnection() throws Exception {
        String url = "jdbc:derby:RentalDB;create=true";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}