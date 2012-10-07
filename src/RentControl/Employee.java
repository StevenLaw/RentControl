package RentControl;

import java.util.List;

/**
 * This class stores the employee's information.
 * 
 * @author Steven Law
 */
public class Employee {

    private int EID;
    private String firstName;
    private String lastName;

    /**
     * This basic constructor sets the required attributes for the class.
     * 
     * @param EID the employee's id
     * @param firstName the employee's first name
     * @param lastName the employee's las name
     */
    public Employee(int EID, String firstName, String lastName) {
        this.EID = EID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @element-type Transaction
     */
    
    public List getEmployeeHistory() {
        return null;
    }

    public int getEID() {
        return EID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}