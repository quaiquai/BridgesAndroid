package com.example.bridgesgametest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BridgesView bridgesview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        bridgesview = new BridgesView(this);
        bridgesview.setShape("square");
        bridgesview.setShape("oval");
        setContentView(bridgesview);
    }
}
