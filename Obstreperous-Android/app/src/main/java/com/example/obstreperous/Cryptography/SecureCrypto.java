package com.example.obstreperous.Cryptography;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.obstreperous.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;



public class SecureCrypto extends CryptoMain {

    public static final String MyPREFERENCES = "SecureCrypto";
    SharedPreferences sharedpreferences;
    public static final String SaltedPass = "SaltedPass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_crypto);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_WORLD_READABLE);


        Button b1 = (Button) findViewById(R.id.button34);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    String salt = getSalt();
                    EditText pass = (EditText) findViewById(R.id.editText12);
                    String password = pass.getEditableText().toString();
                    String securePassword = getSecurePassword(password, salt);

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(SaltedPass, securePassword);
                    editor.commit();

                    Toast.makeText(SecureCrypto.this, "Check shared_prefs in adb", Toast.LENGTH_LONG).show();

                } catch (NoSuchAlgorithmException e) {
                    Toast.makeText(SecureCrypto.this, "error in algorithm", Toast.LENGTH_LONG).show();

                } catch (NoSuchProviderException k) {
                    Toast.makeText(SecureCrypto.this, "error in provider", Toast.LENGTH_LONG).show();
                }
            }


            private String getSecurePassword(String password, String salt) {
                String generatedPassword = null;
                try {
                    // Create MessageDigest instance for MD5
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    //Add password bytes to digest
                    md.update(salt.getBytes());
                    //Get the hash's bytes
                    byte[] bytes = md.digest(password.getBytes());
                    //This bytes[] has bytes in decimal format;
                    //Convert it to hexadecimal format
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bytes.length; i++) {
                        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    //Get complete hashed password in hex format
                    generatedPassword = sb.toString();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return generatedPassword;
            }

            //Add salt
            private String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
                //Always use a SecureRandom generator
                SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
                //Create array for salt
                byte[] salt = new byte[16];
                //Get a random salt
                sr.nextBytes(salt);
                //return salt
                return salt.toString();
            }
        });
    }
}
