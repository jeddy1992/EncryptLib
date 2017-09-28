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
            byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
            byte[] origin = "Hello world!".getBytes(StandardCharsets.UTF_8);
            Encrypt encrypt = new Encrypt(encryptionKey);
            byte[] result = encrypt.aesEncrypt(origin);
            byte[] decryptedCipherText = encrypt.aesDecrypt(result);
            e(new String(origin));
            e(new String(result));
            e(new String(decryptedCipherText));
            byte[] bytes = u.AES_ECB_encrypt("Hello world!", "MZygpewJsCpRrfOr");
            e("ndk,"+new String(bytes));
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
