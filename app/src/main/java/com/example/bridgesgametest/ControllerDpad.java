package com.example.bridgesgametest;

import android.graphics.Color;
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
    private ImageView xButton;
    private ImageView yButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.control_dpad, parent, false);

        ImageView arrowUp = (ImageView) v.findViewById(R.id.btnUp);
        ImageView arrowDown = (ImageView) v.findViewById(R.id.btnDown);
        ImageView arrowLeft = (ImageView) v.findViewById(R.id.btnLeft);
        arrowRight = (ImageView) v.findViewById(R.id.btnRight);
        xButton = (ImageView) v.findViewById(R.id.btnX);
        yButton = (ImageView) v.findViewById(R.id.btnY);

        connectToControls(v);

        return v;
    }

    private void connectToControls(View vi){

        // Below are the click listeners for six buttons representing a d-pad and x and y buttons
        arrowUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                arrowUp.setColorFilter(null);
                return false;
            }
        });

        arrowDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                arrowDown.setColorFilter(null);
                return false;
            }
        });

        arrowLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                arrowLeft.setColorFilter(null);
                return false;
            }
        });

        arrowRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        arrowRight.setColorFilter(Color.GREEN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                arrowRight.setColorFilter(null);
                return false;
            }
        });
    }
}
