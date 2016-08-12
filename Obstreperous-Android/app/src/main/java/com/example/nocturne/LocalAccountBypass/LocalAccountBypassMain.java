package com.example.nocturne.LocalAccountBypass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class LocalAccountBypassMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_account_bypass_main);


        Button button42 = (Button) findViewById(R.id.button42);
        button42.setOnClickListener(this);

        Button button43 = (Button) findViewById(R.id.button43);
        button43.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button42:
                Intent button42 = new Intent(LocalAccountBypassMain.this, SecureAccountLogin.class);
                startActivity(button42);
                break;

            case R.id.button43:
                Intent button43 = new Intent(LocalAccountBypassMain.this, VulnerableAccountLogin.class);
                startActivity(button43);
                break;

            default:
                break;
        }
    }
}