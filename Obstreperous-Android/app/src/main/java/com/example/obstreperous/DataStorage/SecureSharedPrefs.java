package com.example.obstreperous.DataStorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.obstreperous.R;

public class SecureSharedPrefs extends DataStorageMain {

    EditText username,password;
    Button b1;
    public static final String MyPREFERENCES = "SecureSharedPrefs" ;
    public static final String Username = "usernameKey";
    public static final String Password = "passKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_shared_prefs);


        username = (EditText)findViewById(R.id.editText15);
        password = (EditText)findViewById(R.id.editText16);

        b1=(Button)findViewById(R.id.button36);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                // Insecure storage of account information in a directory readable by any application
                editor.putString(Username, user);
                editor.putString(Password, pass);
                editor.commit();

                // Insecure logging of account information
                // Is usually used for debugging where developer forgets to remove after deploying app
                Log.d(user, pass);


                Toast.makeText(SecureSharedPrefs.this, "Check shared_prefs in adb", Toast.LENGTH_LONG).show();


            }
        });
    }
}