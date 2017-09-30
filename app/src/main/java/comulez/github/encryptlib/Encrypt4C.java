package comulez.github.encryptlib;

/**
 * Created by Ulez on 2017/9/30.
 * Email：1104128773@qq.com
 */


public class Encrypt4C implements Encrypt {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public byte[] aesEncrypt(byte[] plainText, byte[] key) throws Exception {
        return AES_ECB_encrypt_byte(plainText, key);
    }

    @Override
    public byte[] aesDecrypt(byte[] cipherText, byte[] key) throws Exception {
        return AES_ECB_decrypt_byte(cipherText, key);
    }

    public native byte[] AES_ECB_encrypt_byte(byte[] origin, byte[] key) throws Exception;

    public native byte[] AES_ECB_decrypt_byte(byte[] origin, byte[] key) throws Exception;
}
