package com.example.nocturne.Cryptography;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class CryptoMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_main);

        Button button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(this);

        Button button23 = (Button) findViewById(R.id.button23);
        button23.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button22:
                Intent button22 = new Intent(CryptoMain.this, InsecureCrypto.class);
                startActivity(button22);
                break;

            case R.id.button23:
                Intent button23 = new Intent(CryptoMain.this, SecureCrypto.class);
                startActivity(button23);
                break;

            default:
                break;
        }
    }
}


