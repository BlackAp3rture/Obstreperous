package com.example.nocturne.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class AuthenticationMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_main);

        Button button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(this);

        Button button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button18:
                Intent button18 = new Intent(AuthenticationMain.this, InsecureAuthentication.class);
                startActivity(button18);
                break;

            case R.id.button19:
                Intent button19 = new Intent(AuthenticationMain.this, SecureAuthentication.class);
                startActivity(button19);
                break;

            default:
                break;
        }
    }
}

/*
Java Keyspec (KDR)
 */