package com.example.obstreperous.ServiceExportation;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;


public class MyExportedService extends IntentService {

    private static final String TAG = "Yo";

    @Override
    protected void onHandleIntent(Intent arg0) {
        Log.i(TAG, "Intent Service started");

    }

    public MyExportedService() {
        super("MyIntentService");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand " + startId);

        final int currentId = startId;

        Runnable r = new Runnable() {
            public void run() {

                for (int i = 0; i < 1; i++)
                {
                    long endTime = System.currentTimeMillis() + 10*10;

                    while (System.currentTimeMillis() < endTime) {
                        synchronized (this) {
                            try {
                                wait(endTime -
                                        System.currentTimeMillis());
                            } catch (Exception e) {
                            }
                        }
                    }
                    Log.i(TAG, "Service running " + currentId);
                }
                stopSelf();
            }
        };

        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;
    }

}


/*

    As I was building this out the objective was to restrict a service from being started by
    having a key entered by a user and having the service be non-exported to prevent access
    from other apps. However, I learned that if a device is rooted, a system call overrides this
    restriction and the service can still be called. So with the exported value being false,
    it is only secure if the device is not rooted.

 */