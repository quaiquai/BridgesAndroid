package com.example.bridgesgametest;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class NGCKGame_AndroidVersion{

    AppCompatActivity a;
    Context c;

    ControllerDpad dp;
    GameGrid grid;

    public void getGrid(GameGrid g){
        grid = g;
    }
    public void getDP(ControllerDpad d){
        dp = d;
    }

    public void handleFragment(Context con){
        c = con;
        a = (AppCompatActivity) c;
        dp = (ControllerDpad) a.getSupportFragmentManager().findFragmentById(R.id.Dpad);
        grid = (GameGrid) a.getSupportFragmentManager().findFragmentById(R.id.GridFragment);
    }

    // Handler for loop management.
    private Handler h = new Handler();
    // Sets the delay for the GameLoop.
    private int frameDelay = 100;

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
    protected void DrawObject(int x, int y, NamedSymbol s) {
        grid.drawObject(y, x, s);
    }

    // set symbol and foreground color of cell x, y to s and c
    protected void DrawObject(int x, int y, NamedSymbol s, int c) {
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
