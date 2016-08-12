package com.example.nocturne.Intents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {



        if (intent.hasExtra("Username"))
        {

            String user = intent.getExtras().getString("Username");
            String pass = intent.getExtras().getString("Password");

            //             Uncomment this to verify strings being passed.
            //             System.out.println(user);
            //             System.out.println(pass);

            String message = "Message Received "
                    + intent.getAction();

            Toast.makeText(context, message,
                    Toast.LENGTH_LONG).show();


        }
        else
        {
            System.out.println("error");

            String message = "Message Not Received "
                    + intent.getAction();

            Toast.makeText(context, message,
                    Toast.LENGTH_LONG).show();

        }

    }
}
