package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // player starts here on grid. Number between 1 and 900.
    private int curCellNum = 1;
    private int prevCellNum;

    // Image view objects to give buttons onclick listeners
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView xButton;
    private ImageView yButton;

    // Integer to change directions in grid.
    private int direction;
    private int playerSpeed = 100;
    private boolean move = false;

    // Object that represents current player space. Can be anywhere from 1 to 900 for
    // the 30x30 board.
    private ImageView prevCell;
    private ImageView currentCell;
    private ImageView upCell;
    private ImageView downCell;
    private ImageView leftCell;
    private ImageView rightCell;

    // Image view object for bug.
    private ImageView bugCell;

    // Cell size set dynamically so the grid can fit on different screen sizes
    int cellWidth;
    int cellHeight;

    // Bug current location so its space can be cleared after it moves.
    private int bugCurLoc = 1;

    // Base sprite choices.
    private int gridSprite;
    private int playerSprite;
    private int bugSprite;

    // Handler for enemy loop management. A higher number is slower
    private Handler h = new Handler();
    private int bugSpeed = 9000;

    // Score counter
    public int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // Set sprite preferences for player sprite, bug sprite, and grid background sprite. Set speed of player and bug generation.
        // Smaller numbers mean faster movement.
        setGamePreferences("pixel_guy", "bug", "white_square", 10000, 100);

        // Set initial spaces using predetermined starting position.
        setPlayerSpace(40);

        // Below are the click listeners for six buttons representing a d-pad and x and y buttons
        arrowUp = (ImageView) findViewById(R.id.btnUp);
        arrowUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        direction = -30;
                        move = true;
                        arrowUp.setColorFilter(Color.GREEN);
                        // Return true in order to listen for more actions. ie: action_up
                        // To make the player move without stopping on action_up return false here.
                        // Returning false here would be useful for games like snake where the player
                        // is not supposed to stop.
                        return true;
                    case MotionEvent.ACTION_UP:
                        direction = 0;
                        move = false;
                        break;
                }
                arrowUp.setColorFilter(null);
                return false;
            }
        });

        arrowDown = (ImageView) findViewById(R.id.btnDown);
        arrowDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        direction = 30;
                        move = true;
                        arrowDown.setColorFilter(Color.GREEN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        direction = 0;
                        move = false;
                        break;
                }
                arrowDown.setColorFilter(null);
                return false;
            }
        });

        arrowLeft = (ImageView) findViewById(R.id.btnLeft);
        arrowLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        direction = -1;
                        move = true;
                        arrowLeft.setColorFilter(Color.GREEN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        direction = 0;
                        move = false;
                        break;
                }
                arrowLeft.setColorFilter(null);
                return false;
            }
        });

        arrowRight = (ImageView) findViewById(R.id.btnRight);
        arrowRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        direction = 1;
                        move = true;
                        arrowRight.setColorFilter(Color.GREEN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        direction = 0;
                        move = false;
                        break;
                }
                arrowRight.setColorFilter(null);
                return false;
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
    }

    @Override
    protected void onStart(){
        super.onStart();
        // make initial bug on start.
        makeBug();
    }

    @Override
    protected void onResume(){
        super.onResume();

        // Sets a delay in bug movement which time can be set by the student to adjust difficulty.
        h.postDelayed(new Runnable(){
            public void run(){
                makeBug();
                h.postDelayed(this, bugSpeed);
            }
        }, bugSpeed);
        // After delay move character.
        moveCharacter();
    }

    // Character moves in the direction clicked at the speed set by the player.
    // These speeds can be used to signify difficulty levels for the game.
    protected void moveCharacter(){
        h.postDelayed(new Runnable(){
            public void run(){
                if (move) {
                    setPlayerSpace(curCellNum + direction);
                }
                h.postDelayed(this, playerSpeed);
            }
        }, playerSpeed);
    }

    private void makeBug(){
        // Takes space from current bug location and returns it to empty grid sprite.
        int prevBugID = getResources().getIdentifier(("gameCell"+bugCurLoc), "id", getPackageName());
        ImageView prevBugSpace = (ImageView) findViewById(prevBugID);
        prevBugSpace.setImageResource(gridSprite);

        // Gets random new location for bug.
        Random r = new Random();
        int bugNewLoc = (r.nextInt(899))+1;

        // Places new bug at new location between 1 and 900 on game grid.
        int bugCellID = getResources().getIdentifier(("gameCell"+bugNewLoc), "id", getPackageName());
        bugCell = (ImageView) findViewById(bugCellID);
        bugCell.setMaxHeight(cellHeight);
        bugCell.setMaxWidth(cellWidth);
        bugCell.setImageResource(bugSprite);

        // Sets new current location.
        bugCurLoc = bugNewLoc;
    }

    // Allows a student to alter the look and speed of the game.
    private void setGamePreferences(String pSprite, String bSprite, String gSprite, int bSpeed, int pSpeed){

        // Player speed and bug generation speed.
        bugSpeed = bSpeed;
        playerSpeed = pSpeed;

        // Set sprites.
        playerSprite = getResources().getIdentifier(pSprite, "drawable", getPackageName());
        bugSprite = getResources().getIdentifier(bSprite, "drawable", getPackageName());
        gridSprite = getResources().getIdentifier(gSprite, "drawable", getPackageName());
    }

    // This method takes in the users current position on the game grid sized 30x30.
    // It then preDetermines the spaces the player can move from this position and sets
    // their ID values.
    private void setPlayerSpace(int curNum){

        if (curNum == curCellNum || curNum < 1 || curNum > 900){
            // Grid bounds reached or player has not moved.
        } else {
            // The integer represents a game grid cell from 1 to 900 on a 30x30 grid.
            prevCellNum = curCellNum;
            curCellNum = curNum;
            int upCellNum = curCellNum-30;
            int downCellNum = curCellNum+30;
            int leftCellNum = curCellNum-1;
            int rightCellNum = curCellNum+1;

            // Checks if the user has hit the bug and adds to the score if true.
            checkForSquish();

            // All the cells are named gameCell[] with [] being a number between 1 and 900.
            String prevCellName = "gameCell"+prevCellNum;
            String curCellName = "gameCell"+curCellNum;
            String upCellName = "gameCell"+upCellNum;
            String downCellName = "gameCell"+downCellNum;
            String leftCellName = "gameCell"+leftCellNum;
            String rightCellName = "gameCell"+rightCellNum;

            // Get the ID of the game cells in play.
            int prevCellID = getResources().getIdentifier(prevCellName, "id", getPackageName());
            int curCellID = getResources().getIdentifier(curCellName, "id", getPackageName());
            int upCellID = getResources().getIdentifier(upCellName, "id", getPackageName());
            int downCellID = getResources().getIdentifier(downCellName, "id", getPackageName());
            int leftCellID = getResources().getIdentifier(leftCellName, "id", getPackageName());
            int rightCellID = getResources().getIdentifier(rightCellName, "id", getPackageName());

            // Sets the current space object and spaces around the current space
            prevCell = (ImageView) findViewById(prevCellID);
            currentCell = (ImageView) findViewById(curCellID);
            upCell = (ImageView) findViewById(upCellID);
            downCell = (ImageView) findViewById(downCellID);
            leftCell = (ImageView) findViewById(leftCellID);
            rightCell = (ImageView) findViewById(rightCellID);

            // reverts the previous cell to the grid base sprite
            prevCell.setImageResource(gridSprite);

            // Turns the cell at the users position into the chosen player sprite.
            currentCell.setImageResource(playerSprite);
        }
    }

    // checks to see if player and bug are in the same cell. If true, increment score and update score TextView.
    private void checkForSquish(){
        if (bugCurLoc == curCellNum){
            score++;
            String scoreString = ""+score;
            TextView sV = (TextView) findViewById(R.id.scoreView);
            sV.setText(scoreString);

            // crude way to remove the bug location so the player can't go back and forth over that space adn get points.
            bugCurLoc = 1;
        }
    }
}
