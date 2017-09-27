package comulez.github.encryptlib;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    private byte[] key;

    private static final String ALGORITHM = "AES";

    public Encrypt(byte[] key) {
        this.key = key;
    }

    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to aesEncrypt
     */
    public byte[] aesEncrypt(byte[] plainText) throws Exception {
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
    public byte[] aesDecrypt(byte[] cipherText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
}
