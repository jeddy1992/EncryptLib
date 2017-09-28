package comulez.github.encryptlib;

/**
 * Created by Ulez on 2017/9/27.
 * Email：1104128773@qq.com
 */


public class Uti {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    public native String stringFromJNI2();

    public native byte[] AES_ECB_encrypt(String origin, String key);

    public native byte[] AES_ECB_encrypt_byte(byte[] origin, byte[] key);

    public native byte[] AES_ECB_decrypt_byte(byte[] origin, byte[] key);
}
