package com.example.nocturne.Intents;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.obstreperous.R;

public class ExplicitBroadcastTwo extends IntentsMain implements View.OnClickListener{


    private static final String TAG = "Broadcast";
    private IntentFilter receiveFilter;
    MyReceiver myReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_broadcast_two);
        Button send = (Button) findViewById(R.id.button32);
        send.setOnClickListener(this);
        myReceiver = new MyReceiver();

        // Creates the filter for the receiver to look for once broadcasted.
        intentFilter = new IntentFilter("com.example.guidepoint.obstreperous.Intents.USER_ACTION");

    }


    // Registers MyReceiver to handle the intent.

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);

    }

    // Unregisters MyReceiver once intent has been handled.

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button32) {
            sending(v);

        }
    }


    public void sending(View v) {


        Intent intent = new Intent("com.example.guidepoint.obstreperous.Intents.USER_ACTION");


        final EditText username = (EditText)
                findViewById(R.id.editText19);
        String user = username.getText().toString();

        final EditText password = (EditText)
                findViewById(R.id.editText20);
        String pass = password.getText().toString();


        intent.putExtra("Password", pass);
        intent.putExtra("Username", user);


        sendBroadcast(intent);
    }
}




/*

    This example shows a broadcast being sent explicitly to the application package to handle the intent.
    Even though LocalBroadcastManager is not implemented, this is secure as it can only be handled
    internally by the application.

 */