package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    BridgesStudentGameBugStomp sg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game_view);

    }

    @Override
    protected void onResume(){
        super.onResume();

        sg = new BridgesStudentGameBugStomp();

        sg.handleFragment(this);
        sg.main();
    }
}
