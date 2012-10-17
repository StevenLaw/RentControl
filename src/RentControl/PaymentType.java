/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentControl;

/**
 * This enum is used to store the type of payment that a customer pays with.
 * 
 * @author Steven Law
 */
public enum PaymentType {
    Credit ('C'),
    Cash ('$'), 
    Debit ('D');

    private char code;
    
    PaymentType(char code){
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
