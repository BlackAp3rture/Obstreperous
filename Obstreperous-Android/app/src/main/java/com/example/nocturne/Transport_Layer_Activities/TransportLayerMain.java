package com.example.nocturne.Transport_Layer_Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nocturne.MainActivity.MainActivity;
import com.example.obstreperous.R;

public class TransportLayerMain extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_layer_main);


        Button one = (Button) findViewById(R.id.button14);
        one.setOnClickListener(this);

        Button two = (Button) findViewById(R.id.button15);
        two.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }

}

