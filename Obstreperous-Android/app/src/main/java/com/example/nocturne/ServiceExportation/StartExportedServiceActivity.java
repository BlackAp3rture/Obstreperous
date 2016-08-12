package com.example.nocturne.ServiceExportation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.obstreperous.R;

public class StartExportedServiceActivity extends ServiceExportationMain {

    private EditText key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exported_service);

        key = (EditText) findViewById(R.id.editText23);

        Button login = (Button) findViewById(R.id.button40);
        login.setOnClickListener(this);
    }


    private boolean CheckFields() {
        key = (EditText) findViewById(R.id.editText23);
        String key1 = key.getEditableText().toString();
        if (key1.isEmpty() || key1.contentEquals("")) {
            return false;
        } else {
            return true;
        }
    }




    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button40) {



            try {
                if (CheckFields()) {

                    final String key1 = key.getEditableText().toString();

                    if (key1.equals("test")) {

                        Intent intent = new Intent(this, MyExportedService.class);
                        startService(intent);
                        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_LONG).show();

                    }

                }

            } catch (Exception e) {

            }

        }
    }
}


/*

    As I was building this out the objective was to restrict a service from being started by
    having a key entered by a user and having the service be non-exported to prevent access
    from other apps. However, I learned that if a device is rooted, a system call overrides this
    restriction and the service can still be called. So with the exported value being false,
    it is only secure if the device is not rooted.


     In adb shell, the service can be started by sending a system command
    "am start -n com.example.guidepoint.obstreperous/.ServiceExportation.StartExportedServiceActivity"

    This command will fail only if device is not rooted and the activity is not exported.


 */