package comulez.github.encryptlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.sample_text);
        Uti u = new Uti();
        tv.setText(u.stringFromJNI() + "::" + u.stringFromJNI2());
        try {
            String txt = "Hello world!";
            String keyyy = "MZygpewJsCpRrfOr";
            e("加密前，txt=" + txt);
            e("加密前，key=" + keyyy);
            byte[] origin = txt.getBytes(StandardCharsets.UTF_8);
            byte[] encryptionKey = keyyy.getBytes(StandardCharsets.UTF_8);
            e("txt byte size=" + origin.length);
            e("key byte size=" + encryptionKey.length);

            Encrypt encrypt = new Encrypt(encryptionKey);
            byte[] result = encrypt.aesEncrypt(origin);
            byte[] decryptedCipherText = encrypt.aesDecrypt(result);
            e(new String(origin));
            e(new String(result));
            e(new String(decryptedCipherText));

            byte[] bytes_result = u.AES_ECB_encrypt_byte(origin, encryptionKey);
            e("ndk,加密后==" + new String(bytes_result));
            byte[] bytes1 = u.AES_ECB_decrypt_byte(bytes_result, encryptionKey);
            e("ndk,解密后==" + new String(bytes1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(String s) {
        Log.e("lcy", s);
    }

    public static void i(String s) {
        Log.i("lcy", s);
    }
}
