/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentEncryption;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.*;


/**
 * This class is used to create Secret Keys for the encryption of Credit Card 
 * information and passwords.
 * 
 * @author Steven Law
 */
public class AESSecretKey implements SecretKey {

    private Key key;
    private String Algo =  "AES";

    public AESSecretKey() throws NoSuchAlgorithmException {
        generateKey();
    }

    /**
     * This constructor creates a key using the SecureRandom class.
     * 
     * @throws NoSuchAlgorithmException Should not happen because the algorithm
     * is hardcoded
     */
    private void generateKey() throws NoSuchAlgorithmException {
        KeyGenerator generator;
        generator = KeyGenerator.getInstance(Algo);
        generator.init(new SecureRandom());
        key = generator.generateKey();
    }

    /**
     * This overrides the getEncoded() method of SecretKey.
     * 
     * @return the encoded byte array
     */
    @Override
    public byte[] getEncoded() {
        return key.getEncoded();
    }

    /**
     * This overrides the getAlgorithm() method of SecretKey.
     * 
     * @return the algorithm string
     */
    @Override
    public String getAlgorithm() {
        return key.getAlgorithm();
    }

    /**
     * This overrides the getFormat() method of SecretKey.
     * 
     * @return the format string
     */
    @Override
    public String getFormat() {
        return key.getFormat();
    }
}
