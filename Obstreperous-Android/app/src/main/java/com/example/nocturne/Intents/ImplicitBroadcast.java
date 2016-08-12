package com.example.nocturne.Intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.obstreperous.R;

public class ImplicitBroadcast extends IntentsMain {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_broadcast);

        Button send = (Button) findViewById(R.id.button38);

        send.setOnClickListener(this);
    }


    public void onClick(View v) {

        if (v.getId() == R.id.button38) {
            sending(v);

        }
    }


    public void sending(View v) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);



        final EditText username = (EditText)
                findViewById(R.id.editText21);
        String user = username.getText().toString();

        final EditText password = (EditText)
                findViewById(R.id.editText22);
        String pass = password.getText().toString();

        intent.putExtra("Password", pass);
        intent.putExtra("Username", user);
        intent.setType("text/*");
        startActivity(intent);


    }
}

/*
    This example is insecure as it send out a broadcast with the username and password strings attached
    looking for an activity to handle them. An attacker can create a malicious application with
    an activity to handle this specific broadcast to receive the data.
 */
