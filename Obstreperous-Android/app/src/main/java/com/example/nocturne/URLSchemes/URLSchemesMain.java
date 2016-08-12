package com.example.nocturne.URLSchemes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class URLSchemesMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlschemes_main);



        Button button28 = (Button) findViewById(R.id.button28);
        button28.setOnClickListener(this);

        Button button29 = (Button) findViewById(R.id.button29);
        button29.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button28:
                Intent button28 = new Intent(URLSchemesMain.this, CustomURL.class);
                startActivity(button28);
                break;

            case R.id.button29:
                Intent button29 = new Intent(URLSchemesMain.this, AndroidURL.class);
                startActivity(button29);
                break;

            default:
                break;
        }
    }
}