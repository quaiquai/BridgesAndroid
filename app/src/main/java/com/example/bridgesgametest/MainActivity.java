package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BridgesView bridgesview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        bridgesview = new BridgesView(this);
        bridgesview.generateGridParams(30,30,"circle");
        //bridgesview.setShape("square", 2, 2);
        setContentView(bridgesview);
    }
}
