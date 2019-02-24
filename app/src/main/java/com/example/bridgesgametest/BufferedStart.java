package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    BugStomp bs;
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
        bs = new BugStomp();
        bs.handleFragment(this); // this must be called before the students main method
        bs.main();
         **/
        sn = new Snake();
        sn.handleFragment(this);
        sn.main();
    }
}
