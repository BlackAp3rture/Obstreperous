package com.example.nocturne.ClientSideInjections;

import android.os.Bundle;

import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class ClientSideInjectionMain extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_side_injection_main);
    }
}
