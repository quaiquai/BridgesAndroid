package com.example.bridgesgametest;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public abstract class NGCKGame_AndroidVersion{

    AppCompatActivity a;
    Context c;

    GameGrid grid;
    ControllerDpad dp;
    ControllerXY xy;

    public void handleFragment(Context con){
        c = con;
        a = (AppCompatActivity) c;
        grid = (GameGrid) a.getSupportFragmentManager().findFragmentById(R.id.GridFragment);
        dp = (ControllerDpad) a.getSupportFragmentManager().findFragmentById(R.id.Dpad);
        xy =(ControllerXY) a.getSupportFragmentManager().findFragmentById(R.id.XY);
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

    // Return true if x button is pressed.
    protected boolean KeyX(){ return xy.X(); }

    // Return true if y button is pressed.
    protected boolean KeyY(){ return xy.Y(); }

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
