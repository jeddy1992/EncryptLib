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
}
