package com.example.obstreperous.BinaryProtections;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.obstreperous.R;

import java.io.File;

public class MoreInfo extends BinaryProtectionMain implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        Button button48 = (Button) findViewById(R.id.button48);
        button48.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button48:

                String su = "su";
                boolean found = false;
                if (!found) {
                    String[] places = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/",
                            "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
                    for (String where : places) {
                        if ( new File( where + su ).exists() ) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found == true)
                    Toast.makeText(getApplicationContext(), "Device is rooted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Device is not rooted", Toast.LENGTH_LONG).show();
            }

        }
    }
