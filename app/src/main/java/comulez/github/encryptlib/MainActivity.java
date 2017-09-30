package comulez.github.encryptlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.sample_text);
        Encrypt4C u = new Encrypt4C();
//        tv.setText(u.stringFromJNI() + "::" + u.stringFromJNI2());
        try {
            String txt = "hello world!";
            String keyyy = "MZygpewJsCpRrfOr";
            e("加密前，txt=" + txt);
            e("加密前，key=" + keyyy);
            byte[] origin = txt.getBytes(StandardCharsets.UTF_8);
            byte[] encryptionKey = keyyy.getBytes(StandardCharsets.UTF_8);
            e("txt byte size=" + origin.length);
            e("key byte size=" + encryptionKey.length);

            Encrypt4J encrypt = new Encrypt4J();
            byte[] result = encrypt.aesEncrypt(origin, encryptionKey);
            byte[] decryptedCipherText = encrypt.aesDecrypt(result, encryptionKey);
            e("in java=" + new String(origin));
            e("in java=" + new String(Base64.encode(result, Base64.DEFAULT)));
            e("in java=" + new String(decryptedCipherText));

            byte[] bytes_result = u.AES_ECB_encrypt_byte(origin, encryptionKey);
            byte[] bytes_result_base64 = Base64.encode(bytes_result, Base64.DEFAULT);
            e("ndk,加密后==" + new String(bytes_result_base64));

            byte[] result4wrwer = Base64.decode(bytes_result_base64, Base64.DEFAULT);
            byte[] bytes1 = u.AES_ECB_decrypt_byte(result4wrwer, encryptionKey);
            String dfsfsf = new String(bytes1);
            e("ndk,解密后==" + dfsfsf);
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
