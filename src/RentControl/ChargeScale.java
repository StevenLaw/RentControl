/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentControl;

/**
 * This enum is used to store the scale that is being used to calculate the 
 * total payment.
 * 
 * @author Steven Law
 */
public enum ChargeScale {
    Hourly ('H'),
    Daily ('D'),
    Weekend ('E'),
    Weekly ('W'),
    Month ('M');
    
    private char code;
    
    ChargeScale(char code){
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
