package com.example.nocturne.DataStorage;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.obstreperous.R;

public class InsecureSharedPrefs extends DataStorageMain {

    EditText username,password;
    Button b1;
    public static final String MyPREFERENCES = "InsecureSharedPrefs" ;
    public static final String Username = "usernameKey";
    public static final String Password = "passKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_shared_prefs);

        username = (EditText)findViewById(R.id.editText8);
        password = (EditText)findViewById(R.id.editText9);

        b1=(Button)findViewById(R.id.button31);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_WORLD_READABLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user  = username.getText().toString();
                String pass  = password.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                // Insecure storage of account information in a directory readable by any application
                editor.putString(Username, user);
                editor.putString(Password, pass);
                editor.commit();

                // Insecure logging of account information
                // Is usually used for debugging where developer forgets to remove after deploying app
                Log.d(user, pass);
                System.out.println("test");


                Toast.makeText(InsecureSharedPrefs.this,"Check shared_prefs in adb", Toast.LENGTH_LONG).show();


            }
        });
    }
}