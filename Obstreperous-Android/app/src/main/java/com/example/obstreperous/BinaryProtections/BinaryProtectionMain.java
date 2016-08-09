package com.example.obstreperous.BinaryProtections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.obstreperous.AuthenticationAndAuthorization.InsecureAuthentication;
import com.example.obstreperous.AuthenticationAndAuthorization.SecureAuthentication;
import com.example.obstreperous.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class BinaryProtectionMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_protection_main);


        Button button47 = (Button) findViewById(R.id.button47);
        button47.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button47:
                Intent button47 = new Intent(BinaryProtectionMain.this, MoreInfo.class);
                startActivity(button47);
                break;

            default:
                break;
        }
    }
}