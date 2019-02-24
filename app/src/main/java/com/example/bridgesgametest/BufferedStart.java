package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    // Game objects
    //BugStomp bs;
    Snake sn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game_view);
    }

    @Override
    protected void onResume(){
        super.onResume();

        /**
        bs = new BugStomp(); // Initialize game object.
        bs.handleFragment(this); // This must be called before any game method.
        bs.main(); // Start the students game. **/

        sn = new Snake();
        sn.handleFragment(this);
        sn.main();
    }
}
