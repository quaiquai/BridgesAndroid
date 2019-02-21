package com.example.bridgesgametest;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;

public class TestFragmentClass extends AppCompatActivity {

    public GameGrid gm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        gm = (GameGrid) getSupportFragmentManager().findFragmentById(R.id.GridFragment);

        gm.setCellColor(8, Color.BLUE);
        gm.setCellColor(800, Color.GREEN);

    }
}