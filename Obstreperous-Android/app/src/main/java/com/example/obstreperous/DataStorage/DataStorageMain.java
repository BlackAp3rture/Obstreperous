package com.example.obstreperous.DataStorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.obstreperous.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class DataStorageMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage_main);

        Button button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(this);

        Button button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button16:
                Intent button16 = new Intent(DataStorageMain.this, InsecureSharedPrefs.class);
                startActivity(button16);
                break;

            case R.id.button17:
                Intent button17 = new Intent(DataStorageMain.this, SecureSharedPrefs.class);
                startActivity(button17);
                break;

            default:
                break;
        }
    }
}










// shared preferences example -----  https://stackoverflow.com/questions/29491017/
// how-can-i-parse-a-given-edittext-value-from-one-activity-to-another-the-value-s
