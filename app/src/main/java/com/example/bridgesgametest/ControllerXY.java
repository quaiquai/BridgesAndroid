package com.example.bridgesgametest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ControllerXY extends Fragment {

    private ImageView xButton;
    private ImageView yButton;

    private boolean isXPressed = false;
    private boolean isYPressed = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.control_xy, parent, false);

        // Initialize object variables for the buttons and connect them to their corresponding XML ImageViews
        ImageView xButton = (ImageView) v.findViewById(R.id.btnX);
        ImageView yButton = (ImageView) v.findViewById(R.id.btnY);

        // Action listeners:
        xButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isXPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isXPressed = false;
                        break;
                }
                return false;
            }
        });

        yButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        isYPressed = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        isYPressed = false;
                        break;
                }
                return false;
            }
        });

        return v;
    }

    // functions to return the current state of button presses on the Dpad.
    public boolean X(){
        return isXPressed;
    }
    public boolean Y(){
        return isYPressed;
    }
}
