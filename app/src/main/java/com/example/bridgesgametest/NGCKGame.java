package com.example.bridgesgametest;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public abstract class NGCKGame {

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
    protected boolean KeyX() {
        return xy.X();
    }

    // Return true if y button is pressed.
    protected boolean KeyY() {
        return xy.Y();
    }

    // Set background color of cell x, y to c.
    protected void SetBGColor(int x, int y, NamedColor c) {
        grid.setBGColor(y, x, c);
    }

    // Set foreground color of cell x, y to c.
    protected void SetFGColor(int x, int y, NamedColor c) {
        grid.setFGColor(y, x, c);
    }

    // Set symbol of cell x, y to s.
    protected void DrawObject(int x, int y, NamedSymbol s) {
        grid.drawObject(y, x, s);
    }

    // Set symbol and foreground color of cell x, y to s and c.
    protected void DrawObject(int x, int y, NamedSymbol s, NamedColor c) {
        grid.drawObject(y, x, s, c);
    }

    // Removes image at x, y location.
    protected void removeObject(int x, int y) {
        grid.clearImageView(x, y);
    }

}