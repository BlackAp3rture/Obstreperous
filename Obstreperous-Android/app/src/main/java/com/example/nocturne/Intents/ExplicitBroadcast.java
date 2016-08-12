package com.example.nocturne.Intents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.obstreperous.R;


public class ExplicitBroadcast extends IntentsMain {

    private static final String TAG = "LocalBroadcast";
    private IntentFilter receiveFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_broadcast);
        Button login = (Button) findViewById(R.id.button37);
        login.setOnClickListener(this);


        receiveFilter = new IntentFilter(getClass().getName());
        LocalBroadcastManager.getInstance(this).
                registerReceiver(handler, receiveFilter);

    }


    private BroadcastReceiver handler = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "BroadcastReceiver() {...}.onReceive()");


                if (intent.hasExtra("Username"))
                {

                    String user = intent.getExtras().getString("Username");
                    String pass = intent.getExtras().getString("Password");

       //             Uncomment this to verify strings being passed.
       //             System.out.println(user);
       //             System.out.println(pass);


                }
                else
                {
                    System.out.println("error");
                }

            Toast.makeText(ExplicitBroadcast.this,
                    "Message received", Toast.LENGTH_LONG).show();
        }
    };



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button37) {
            sending(v);

        }
    }


    public void sending(View v) {

        Intent intent = new Intent(getClass().getName());


        final EditText username = (EditText)
                findViewById(R.id.editText17);
        String user = username.getText().toString();

        final EditText password = (EditText)
                findViewById(R.id.editText18);
        String pass = password.getText().toString();


        intent.putExtra("Password", pass);
        intent.putExtra("Username", user);



                    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                }
            }






/*

            This example uses the LocalBroadcastManager to handle the intent internally within
            the activity itself. The broadcast is not seen by any other activity, which
            makes this implementation the most secure.

*/