/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentEncryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.crypto.SecretKey;

/**
 * 
 * @author Steven Law
 */
public class AESEncryptStore {
    
    private KeyStore ks;
    private String keyStoreName;
    private char[] password;

    public AESEncryptStore(String keyStoreName, char[] password) {
        this.keyStoreName = keyStoreName;
        this.password = password;
    }
    
    public void createStore() throws Exception {
        ks = KeyStore.getInstance("JCEKS");

        FileInputStream fis = null;
        try {
            File f = new File(keyStoreName);
            if (!f.exists()) {
                f.createNewFile();
            }
            fis = new FileInputStream(f);
            ks.load(null);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    
    public void loadStore() throws Exception {
        ks = KeyStore.getInstance("JCEKS");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(keyStoreName);
            ks.load(fis, password);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
    
    public void addSecretKey(String alias, SecretKey sk) throws Exception {
        KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(sk);
        ks.setKeyEntry(alias, sk, password, null);
    }
    
    public AESSecretKey getSecretKey(String alias, char[] password) throws Exception {
        AESSecretKey skEntry = (AESSecretKey) ks.getKey(alias, password);
        return skEntry;
    }
    
    public void store(OutputStream stream, char[] password) throws Exception {
        ks.store(stream, password);
        stream.close();
    }
}
