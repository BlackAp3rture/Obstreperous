package com.example.nocturne.Cryptography;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.obstreperous.R;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InsecureCrypto extends CryptoMain {


    public static final String MyPREFERENCES = "InsecureCrypto" ;
    SharedPreferences sharedpreferences;
    public static final String EncodedPass = "EncodedPass";
    public static final String MD5HashedPass = "MD5HashedPass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_crypto);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_WORLD_READABLE);


        Button b1 = (Button) findViewById(R.id.button33);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    EditText pass = (EditText) findViewById(R.id.editText10);
                    String text = pass.getEditableText().toString();
                    byte[] password = text.getBytes("UTF-8");
                    String base64 = Base64.encodeToString(password, Base64.DEFAULT);

                    SharedPreferences.Editor editor = sharedpreferences.edit();


                    editor.putString(EncodedPass, base64);
                    editor.commit();

                    Toast.makeText(InsecureCrypto.this, "Check shared_prefs in adb", Toast.LENGTH_LONG).show();




                    try {

                        final MessageDigest digest = MessageDigest.getInstance("md5");
                        digest.update(text.getBytes());
                        final byte[] bytes = digest.digest();
                        final StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < bytes.length; i++) {
                            sb.append(String.format("%02X", bytes[i]));
                            String hash = sb.toString();

                            editor.putString(MD5HashedPass, hash);
                            editor.commit();

                        }

                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        });
    }
}


/*
    Encoding and Hashing are both broken security features when implemented wrong. Both MD5 hashes
    and Base64 encoded strings can easily be decrypted and decoded with a simple
    Google search. It is recommended to never use Base64 for storing or passing sensitive
    information and if using MD5 to hash information, always salt the hash to provide
    adequate security.
 */

