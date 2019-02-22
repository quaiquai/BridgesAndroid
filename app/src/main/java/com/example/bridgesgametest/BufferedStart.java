package com.example.bridgesgametest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    NGCKGame_AndroidVersion BG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the game grid object and connect it to the currently static corresponding fragment in the main activity.
        BG = (NGCKGame_AndroidVersion) getSupportFragmentManager().findFragmentById(R.id.GameView);
    }
}
