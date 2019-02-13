package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BridgesView bridgesview;

    // player starts here on grid. Number between 1 and 900.
    private int startingSpace = 40;
    private int curCellNum;
    //private int curCellNum2;

    // Image view objects to give buttons onclick listeners
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView xButton;
    private ImageView yButton;

    // Object that represents current player space. Can be anywhere from 1 to 900 for
    // the 30x30 board.
    private ImageView currentCell;
    //private ImageView currentCell2;
    private ImageView upCell;
    private ImageView downCell;
    private ImageView leftCell;
    private ImageView rightCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // Set initial spaces using predetermined starting position.
        setSpaces(startingSpace);

        // Below are the click listeners for six buttons representing a d-pad and x and y buttons
        arrowUp = (ImageView) findViewById(R.id.btnUp);
        arrowUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((curCellNum-30)>0) {
                    setSpaces(curCellNum - 30);
                }
            }
        });

        arrowDown = (ImageView) findViewById(R.id.btnDown);
        arrowDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((curCellNum+30)<900) {
                    setSpaces(curCellNum + 30);
                }
            }
        });

        arrowLeft = (ImageView) findViewById(R.id.btnLeft);
        arrowLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if ((curCellNum-1)>0) {
                    setSpaces(curCellNum - 1);
                }
            }
        });

        arrowRight = (ImageView) findViewById(R.id.btnRight);
        arrowRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if ((curCellNum+1)<900) {
                    setSpaces(curCellNum + 1);
                }
            }
        });

        xButton = (ImageView) findViewById(R.id.btnX);
        xButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        yButton = (ImageView) findViewById(R.id.btnY);
        yButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        /**
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        bridgesview = new BridgesView(this);
        bridgesview.generateGridParams(30,30,"circle");
        //bridgesview.setShape("square", 2, 2);
        setContentView(bridgesview);
         **/
    }

    // This method takes in the users current position on the game grid sized 30x30.
    // It then preDetermines the spaces the player can move from this position and sets
    // their ID values.
    private void setSpaces(int curNum){
        // The integer represents a game grid cell from 1 to 900 on a 30x30 grid.
        curCellNum = curNum;
        //curCellNum2 = curNum+1;
        int upCellNum = curCellNum-30;
        int downCellNum = curCellNum+30;
        int leftCellNum = curCellNum-1;
        int rightCellNum = curCellNum+1;

        // All the cells are named gameCell[] with [] being a number between 1 and 900.
        String curCellName = "gameCell"+curCellNum;
        String upCellName = "gameCell"+upCellNum;
        String downCellName = "gameCell"+downCellNum;
        String leftCellName = "gameCell"+leftCellNum;
        String rightCellName = "gameCell"+rightCellNum;

        // Get the ID of the game cells in play.
        int curCellID = getResources().getIdentifier(curCellName, "id", getPackageName());
        int upCellID = getResources().getIdentifier(upCellName, "id", getPackageName());
        int downCellID = getResources().getIdentifier(downCellName, "id", getPackageName());
        int leftCellID = getResources().getIdentifier(leftCellName, "id", getPackageName());
        int rightCellID = getResources().getIdentifier(rightCellName, "id", getPackageName());

        // Sets the current space object and spaces around the current space
        currentCell = (ImageView) findViewById(curCellID);
        upCell = (ImageView) findViewById(upCellID);
        downCell = (ImageView) findViewById(downCellID);
        leftCell = (ImageView) findViewById(leftCellID);
        rightCell = (ImageView) findViewById(rightCellID);

        // Turns the cell at the users position into the blue square image.
        currentCell.setBackgroundColor(Color.rgb(100, 100, 50));
        currentCell.setImageResource(R.drawable.blue_square);
//        String curCellName2 = "gameCell"+curCellNum2;
//        int curCellID2 = getResources().getIdentifier(curCellName2, "id", getPackageName());
//        currentCell2 = (ImageView) findViewById(curCellID2);
//        currentCell2.setColorFilter(android.graphics.Color.BLACK, PorterDuff.Mode.MULTIPLY);
    }

}
