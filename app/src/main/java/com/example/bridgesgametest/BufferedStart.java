package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    ControllerDpad cdpad;
    GameGrid gg;
    NGCKGame_AndroidVersion ngck;
    BridgesStudentGameBugStomp bsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game_view);

        // Create the game grid object and connect it to the currently static corresponding fragment in the main activity.
        gg = (GameGrid) getSupportFragmentManager().findFragmentById(R.id.GridFragment);
        // Create the dpad object and connect it to the currently static corresponding fragment in the main activity.
        cdpad= (ControllerDpad) getSupportFragmentManager().findFragmentById(R.id.Dpad);

        ngck.init(gg, cdpad);

        bsg = new BridgesStudentGameBugStomp();

        //bsg = new BridgesStudentGameBugStomp();
    }
}
