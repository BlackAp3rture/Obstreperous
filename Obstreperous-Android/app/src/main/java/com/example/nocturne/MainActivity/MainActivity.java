package com.example.nocturne.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nocturne.VulnerabilityList.VulnerabilityList;
import com.example.obstreperous.R;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {


        Button one = (Button) findViewById(R.id.button);
        one.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VulnerabilityList.class);
                startActivity(intent);
            }

        });
        }
}