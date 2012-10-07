package RentControl;

import java.util.List;

/**
 * This class stores the customer's information.
 * 
 * @author Steven Law
 */
public class Customer {

    private int CID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
    private String email;
    private int creditCard;

    /**
     *
     * @element-type Transaction
     */
    
    /**
     * This basic constructor sets the required attributes for the customer
     * 
     * @param CID the customer's id
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     */
    public Customer(int CID, String firstName, String lastName) {
        this.CID = CID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List getCustomerHistory() {
        return null;
    }

    public int getCID() {
        return CID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * This returns the customer's name as a string
     * 
     * @return the first and last name seperated by a space
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}