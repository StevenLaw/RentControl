package RentControl;

import java.util.List;

public class Employee {

    private int EID;
    private String firstName;
    private String lastName;

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

    public void setEID(int EID) {
        this.EID = EID;
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