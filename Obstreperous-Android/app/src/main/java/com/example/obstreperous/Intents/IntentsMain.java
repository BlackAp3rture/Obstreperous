package com.example.obstreperous.Intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.obstreperous.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class IntentsMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_main);
        Button button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(this);

        Button button25 = (Button) findViewById(R.id.button25);
        button25.setOnClickListener(this);

        Button button39 = (Button) findViewById(R.id.button39);
        button39.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button24:
                Intent button24 = new Intent(IntentsMain.this, ExplicitBroadcast.class);
                startActivity(button24);
                break;

            case R.id.button25:
                Intent button25 = new Intent(IntentsMain.this, ExplicitBroadcastTwo.class);
                startActivity(button25);
                break;

            case R.id.button39:
                Intent button39 = new Intent(IntentsMain.this, ImplicitBroadcast.class);
                startActivity(button39);
                break;

            default:
                break;
        }
    }
}
