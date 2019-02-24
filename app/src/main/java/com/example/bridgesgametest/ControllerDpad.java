package com.example.bridgesgametest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ControllerDpad extends Fragment {

    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;
    private boolean isUpPressed = false;
    private boolean isDownPressed = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.control_dpad, parent, false);

        // Initialize object variables for the buttons and connect them to their corresponding XML ImageViews
        ImageView arrowUp = (ImageView) v.findViewById(R.id.btnUp);
        ImageView arrowDown = (ImageView) v.findViewById(R.id.btnDown);
        ImageView arrowLeft = (ImageView) v.findViewById(R.id.btnLeft);
        arrowRight = (ImageView) v.findViewById(R.id.btnRight);

        // Action listeners:
        arrowLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isLeftPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isLeftPressed = false;
                        break;
                }
                return false;
            }
        });

        arrowRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isRightPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isRightPressed = false;
                        break;
                }
                return false;
            }
        });

        arrowUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isUpPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isUpPressed = false;
                        break;
                }
                return false;
            }
        });

        arrowDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isDownPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isDownPressed = false;
                        break;
                }
                return false;
            }
        });
        return v;
    }

    // functions to return the current state of button presses on the Dpad.
    public boolean left(){
        return isLeftPressed;
    }
    public boolean right(){
        return isRightPressed;
    }
    public boolean up(){
        return isUpPressed;
    }
    public boolean down(){
        return isDownPressed;
    }
}
