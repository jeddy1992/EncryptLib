package comulez.github.encryptlib;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Ulez on 2017/9/30.
 * Email：1104128773@qq.com
 */


public class Encrypt4J implements Encrypt{

    private static final String ALGORITHM = "AES";

    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to aesEncrypt
     */
    @Override
    public byte[] aesEncrypt(byte[] plainText,byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText);
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to aesDecrypt
     */
    @Override
    public byte[] aesDecrypt(byte[] cipherText,byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(cipherText);
    }
}
