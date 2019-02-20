package com.example.bridgesgametest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class BridgesAPITranslator extends AppCompatActivity {

    // Image view objects to give buttons onclick listeners
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView xButton;// not yet implemented
    private ImageView yButton;// not yet implemented
    ImageView[][] gameCells = new ImageView[30][30];

    private enum GameGrid {

        }

    public void setButtonObjectListeners(){

        arrowUp = (ImageView) findViewById(R.id.btnUp);
        arrowDown = (ImageView) findViewById(R.id.btnDown);
        arrowLeft = (ImageView) findViewById(R.id.btnLeft);
        arrowRight = (ImageView) findViewById(R.id.btnRight);
        xButton = (ImageView) findViewById(R.id.btnX);
        yButton = (ImageView) findViewById(R.id.btnY);

        // Below are the click listeners for six buttons representing a d-pad and x and y buttons
        arrowUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        arrowDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        arrowLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        arrowRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        xButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        yButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
}
}
