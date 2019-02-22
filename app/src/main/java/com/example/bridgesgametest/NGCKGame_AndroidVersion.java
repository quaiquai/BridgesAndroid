package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class NGCKGame_AndroidVersion extends Fragment {

    // / the game map.
    private int rows = 30;
    private int cols = 30;
    protected GameGrid grid;

    // /helper class to make Input Management a bit easier.
    private ControllerDpad dp;

    // Handler for loop management.
    private Handler h = new Handler();
    // Sets the delay for the GameLoop.
    private int frameDelay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_main, parent, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // This is the activity view that shows up on the phone screen when the game starts.
        getActivity().setContentView(R.layout.activity_main);

        // Create the game grid object and connect it to the currently static corresponding fragment in the main activity.
        grid = (GameGrid) getActivity().getSupportFragmentManager().findFragmentById(R.id.GridFragment);

        // Create the dpad object and connect it to the currently static corresponding fragment in the main activity.
        dp = (ControllerDpad) getActivity().getSupportFragmentManager().findFragmentById(R.id.Dpad);

        return v;
    }

    // / @return true if "left" is pressed
    protected boolean KeyLeft() {
        return dp.left();
    }

    // / @return true if "right" is pressed
    protected boolean KeyRight() {
        return dp.right();
    }

    // / @return true if "up" is pressed
    protected boolean KeyUp() {
        return dp.up();
    }

    // / @return true if "down" is pressed
    protected boolean KeyDown() {
        return dp.down();
    }

    // /set background color of cell x, y to c
    // /
    protected void SetBGColor(int x, int y, int c) {
        grid.setBGColor(y, x, c);
    }

    // /set foreground color of cell x, y to c
    // /
    protected void SetFGColor(int x, int y, int c) {
        grid.setFGColor(y, x, c);
    }

    // /set symbol of cell x, y to s
    // /
    protected void SetSymbol(int x, int y, String s) {
        grid.drawObject(y, x, s);
    }

    // /set symbol of cell x, y to s
    // /
    protected void DrawObject(int x, int y, String s) {
        grid.drawObject(y, x, s);
    }

    // set symbol and foreground color of cell x, y to s and c
    protected void DrawObject(int x, int y, String s, int c) {
        grid.drawObject(y, x, s, c);
    }

    public abstract void GameLoop();

    public void start(){

        h.postDelayed(new Runnable(){
            public void run(){

                // Code here gets looped.
                GameLoop();

                h.postDelayed(this, frameDelay);
            }
        }, frameDelay);
    }
}
