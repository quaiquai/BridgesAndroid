package com.example.bridgesgametest;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import static android.app.PendingIntent.getActivity;

public class Snake {
    // player starts here on grid. Number between 1 and 900.
    private int startingSpace = 40;
    private int curCellNum = 40;
    //private int curCellNum2;

    long frameTime;
    long nextFrameTime;
    final long FRAMERATE = 1000000000 / 15;

    private String curDirection;

    private Activity activity;

    private long timeoflastframe = System.currentTimeMillis();

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

    public Snake(Activity activity){
        this.activity = activity;
        curDirection = "start";
        curCellNum = startingSpace;
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
        int curCellID = activity.getResources().getIdentifier(curCellName, "id", activity.getPackageName());
        int upCellID = activity.getResources().getIdentifier(upCellName, "id", activity.getPackageName());
        int downCellID = activity.getResources().getIdentifier(downCellName, "id", activity.getPackageName());
        int leftCellID = activity.getResources().getIdentifier(leftCellName, "id", activity.getPackageName());
        int rightCellID = activity.getResources().getIdentifier(rightCellName, "id", activity.getPackageName());

        // Sets the current space object and spaces around the current space
        currentCell = (ImageView) activity.findViewById(curCellID);
        upCell = (ImageView) activity.findViewById(upCellID);
        downCell = (ImageView) activity.findViewById(downCellID);
        leftCell = (ImageView) activity.findViewById(leftCellID);
        rightCell = (ImageView) activity.findViewById(rightCellID);

        // Turns the cell at the users position into the blue square image.
        currentCell.setBackgroundColor(Color.rgb(100, 100, 50));
        currentCell.setImageResource(R.drawable.blue_square);
    }

    public void handleInput(Activity activity){
        // Below are the click listeners for six buttons representing a d-pad and x and y buttons
        arrowUp = (ImageView) activity.findViewById(R.id.btnUp);
        arrowUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((curCellNum-30)>0) {
                    //setSpaces(curCellNum - 30);
                    curDirection = "up";
                }
            }
        });

        arrowDown = (ImageView) activity.findViewById(R.id.btnDown);
        arrowDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((curCellNum+30)<900) {
                    //setSpaces(curCellNum + 30);
                    curDirection = "down";
                }
            }
        });

        arrowLeft = (ImageView) activity.findViewById(R.id.btnLeft);
        arrowLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if ((curCellNum-1)>0) {
                    //setSpaces(curCellNum - 1);
                    curDirection = "left";
                }
            }
        });

        arrowRight = (ImageView) activity.findViewById(R.id.btnRight);
        arrowRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if ((curCellNum+1)<900) {
                    //setSpaces(curCellNum + 1);
                    curDirection = "right";
                }
            }
        });

        xButton = (ImageView) activity.findViewById(R.id.btnX);
        xButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        yButton = (ImageView) activity.findViewById(R.id.btnY);
        yButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }

    public void updatePosition(){
        switch(curDirection){
            case "up":
                curCellNum -= 30;
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
                int curCellID = activity.getResources().getIdentifier(curCellName, "id", activity.getPackageName());
                int upCellID = activity.getResources().getIdentifier(upCellName, "id", activity.getPackageName());
                int downCellID = activity.getResources().getIdentifier(downCellName, "id", activity.getPackageName());
                int leftCellID = activity.getResources().getIdentifier(leftCellName, "id", activity.getPackageName());
                int rightCellID = activity.getResources().getIdentifier(rightCellName, "id", activity.getPackageName());

                // Sets the current space object and spaces around the current space
                currentCell = (ImageView) activity.findViewById(curCellID);
                upCell = (ImageView) activity.findViewById(upCellID);
                downCell = (ImageView) activity.findViewById(downCellID);
                leftCell = (ImageView) activity.findViewById(leftCellID);
                rightCell = (ImageView) activity.findViewById(rightCellID);

                // Turns the cell at the users position into the blue square image.
                currentCell.setBackgroundColor(Color.rgb(100, 100, 50));
                currentCell.setImageResource(R.drawable.blue_square);
                break;
            case "right":
                curCellNum += 1;
                //curCellNum2 = curNum+1;
                upCellNum = curCellNum-30;
                downCellNum = curCellNum+30;
                leftCellNum = curCellNum-1;
                rightCellNum = curCellNum+1;

                // All the cells are named gameCell[] with [] being a number between 1 and 900.
                curCellName = "gameCell"+curCellNum;
                upCellName = "gameCell"+upCellNum;
                downCellName = "gameCell"+downCellNum;
                leftCellName = "gameCell"+leftCellNum;
                rightCellName = "gameCell"+rightCellNum;

                // Get the ID of the game cells in play.
                curCellID = activity.getResources().getIdentifier(curCellName, "id", activity.getPackageName());
                upCellID = activity.getResources().getIdentifier(upCellName, "id", activity.getPackageName());
                downCellID = activity.getResources().getIdentifier(downCellName, "id", activity.getPackageName());
                leftCellID = activity.getResources().getIdentifier(leftCellName, "id", activity.getPackageName());
                rightCellID = activity.getResources().getIdentifier(rightCellName, "id", activity.getPackageName());

                // Sets the current space object and spaces around the current space
                currentCell = (ImageView) activity.findViewById(curCellID);
                upCell = (ImageView) activity.findViewById(upCellID);
                downCell = (ImageView) activity.findViewById(downCellID);
                leftCell = (ImageView) activity.findViewById(leftCellID);
                rightCell = (ImageView) activity.findViewById(rightCellID);
                System.out.print(currentCell);

                // Turns the cell at the users position into the blue square image.
                currentCell.setBackgroundColor(Color.rgb(100, 100, 50));
                currentCell.setImageResource(R.drawable.blue_square);
                break;
            case "start":
                curCellNum += 1;
                //curCellNum2 = curNum+1;
                upCellNum = curCellNum-30;
                downCellNum = curCellNum+30;
                leftCellNum = curCellNum-1;
                rightCellNum = curCellNum+1;

                // All the cells are named gameCell[] with [] being a number between 1 and 900.
                curCellName = "gameCell"+curCellNum;
                upCellName = "gameCell"+upCellNum;
                downCellName = "gameCell"+downCellNum;
                leftCellName = "gameCell"+leftCellNum;
                rightCellName = "gameCell"+rightCellNum;

                // Get the ID of the game cells in play.
                curCellID = activity.getResources().getIdentifier(curCellName, "id", activity.getPackageName());
                upCellID = activity.getResources().getIdentifier(upCellName, "id", activity.getPackageName());
                downCellID = activity.getResources().getIdentifier(downCellName, "id", activity.getPackageName());
                leftCellID = activity.getResources().getIdentifier(leftCellName, "id", activity.getPackageName());
                rightCellID = activity.getResources().getIdentifier(rightCellName, "id", activity.getPackageName());

                // Sets the current space object and spaces around the current space
                currentCell = (ImageView) activity.findViewById(curCellID);
                upCell = (ImageView) activity.findViewById(upCellID);
                downCell = (ImageView) activity.findViewById(downCellID);
                leftCell = (ImageView) activity.findViewById(leftCellID);
                rightCell = (ImageView) activity.findViewById(rightCellID);

                // Turns the cell at the users position into the blue square image.
                currentCell.setBackgroundColor(Color.rgb(100, 100, 50));
                currentCell.setImageResource(R.drawable.blue_square);
                break;
        }
    }
    public void initiate(){
        frameTime = System.nanoTime();
        nextFrameTime = frameTime + FRAMERATE;
        handleInput(activity);
        updatePosition();
    }

    public void gameLoop(){

        handleInput(activity);
        updatePosition();
        //controlFrameRate();

    }

    private void controlFrameRate() {
        int fps = 20;
        double hz = 1. / fps;

        long currenttime = System.currentTimeMillis();
        long theoreticalnextframe = timeoflastframe + (int) (hz * 1000);
        long waittime = theoreticalnextframe - currenttime;

        if (waittime > 0) {
            try {
                Thread.sleep(waittime); // this is super crude
            } catch (InterruptedException ie) {
                // die?
            }
        }
        timeoflastframe = System.currentTimeMillis();
    }

}
