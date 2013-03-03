/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentEncryption;

import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This class controls the encryption and decryption of data entries for the 
 * database.
 * 
 * @author Steven Law
 */
public class AESEncrypt {
    private AESSecretKey key;

    /**
     * This constructor is to be used for creating a new secret key.
     * 
     * @throws Exception  should not happen due to the algorithm being hard 
     * coded.
     */
    public AESEncrypt() throws Exception {
        key = new AESSecretKey();
    }

    /**
     * This constructor is used when retrieving a secret key from the key store.
     * 
     * @param key the key retrieved from the store
     */
    public AESEncrypt(AESSecretKey key) {
        this.key = key;
    }
    
    /**
     * This method encrypts the 
     * @param data
     * @return
     * @throws Exception 
     */
    public String encrypt(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public AESSecretKey getKey() {
        return key;
    }
}
