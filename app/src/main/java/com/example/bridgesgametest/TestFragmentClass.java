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
    public ControllerDpad dp;

    // Handler for enemy loop management. A higher number is slower
    private Handler h = new Handler();
    // Fps for game loop handler delay
    private int fps = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // This is the activity view that shows up on the phone screen when the game starts.
        setContentView(R.layout.activity_main);

        // Create the game grid object and connect it to the currently static corresponding fragment in the main activity.
        gm = (GameGrid) getSupportFragmentManager().findFragmentById(R.id.GridFragment);

        // Create the dpad object and connect it to the currently static corresponding fragment in the main activity.
        dp = (ControllerDpad) getSupportFragmentManager().findFragmentById(R.id.Dpad);

        // Run game:
        GameLoop();
    }

    public void testButtons(){
        if (dp.left()){
            gm.setCellColor(100, Color.RED);
        }else{
            gm.setCellColor(100, Color.BLUE);
        }

        if (dp.right()){
            gm.setCellColor(400, Color.CYAN);
        }else{
            gm.setCellColor(400, Color.GRAY);
        }

        if (dp.up()){
            gm.setCellColor(500, Color.GREEN);
        }else{
            gm.setCellColor(500, Color.GRAY);
        }

        if (dp.down()){
            gm.setCellColor(600, Color.BLACK);
        }else{
            gm.setCellColor(600, Color.MAGENTA);
        }
    }

    public void GameLoop(){
        h.postDelayed(new Runnable(){
            public void run(){

                // loop code goes here
                testButtons();

                h.postDelayed(this, fps);
            }
        }, fps);
    }
}