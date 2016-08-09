package com.example.obstreperous.ServiceExportation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.obstreperous.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class ServiceExportationMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exportation_main);


        Button button18 = (Button) findViewById(R.id.button20);
        button18.setOnClickListener(this);

        Button button19 = (Button) findViewById(R.id.button21);
        button19.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button20:
                Intent button20 = new Intent(ServiceExportationMain.this, StartExportedServiceActivity.class);
                startActivity(button20);
                break;

            case R.id.button21:
                Intent button21 = new Intent(ServiceExportationMain.this, StartSecureServiceActivity.class);
                startActivity(button21);
                break;

            default:
                break;
        }
    }
}

/*

    As I was building this out the objective was to restrict a service from being started by
    having a key entered by a user and having the service be non-exported to prevent access
    from other apps. However, I learned that if a device is rooted, a system call overrides this
    restriction and the service can still be called. So with the exported value being false,
    it is only secure if the device is not rooted.

 */