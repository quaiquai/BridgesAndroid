package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Image view objects to give buttons onclick listeners
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView xButton;
    private ImageView yButton;

    // TableLayout object that holds the grid cells.
    private TableLayout base;

    // Grid cell as object for players current and previous location
    // (so previous location can be reset).
    // Can be anywhere from 1 to 900 for a 30x30 board.
    private ImageView prevCell;
    private ImageView currentCell;

    // Cell as object for bug.
    private ImageView bugCell;

    // Integer to change directions in grid.
    private int direction;
    private int playerSpeed = 100;
    private boolean move = false;

    // player starts here on grid. Number between 1 and 900.
    private int curPlayerLocation = 1;
    private int prevPlayerLocation;

    // Bug current location on grid. Number 1 through 900 on a 30x30 board.
    private int curBugLocation = 1;

    // Base sprite choices.
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
        setGamePreferences("pixel_guy", "bug", Color.BLUE, 10000, 100);

        // Set playerStart position
        setPlayerStartPosition(40);

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
        movePlayerTimer();
    }

    private void makeBug(){
        // Takes space from current bug location and returns it to empty grid sprite.
        int prevBugID = getResources().getIdentifier(("gameCell"+curBugLocation), "id", getPackageName());
        ImageView prevBugSpace = (ImageView) findViewById(prevBugID);
        prevBugSpace.setImageResource(android.R.color.transparent);

        // Gets random new location for bug.
        Random r = new Random();
        int bugNewLoc = (r.nextInt(899))+1;

        // Places new bug at new location between 1 and 900 on game grid.
        int bugCellID = getResources().getIdentifier(("gameCell"+bugNewLoc), "id", getPackageName());
        bugCell = (ImageView) findViewById(bugCellID);
        bugCell.setImageResource(bugSprite);

        // Sets new current location.
        curBugLocation = bugNewLoc;
    }

    // Allows a student to alter the look and speed of the game.
    private void setGamePreferences(String pSprite, String bSprite, int gColor, int bSpeed, int pSpeed){

        // Player speed and bug generation speed.
        bugSpeed = bSpeed;
        playerSpeed = pSpeed;

        // Set sprites.
        playerSprite = getResources().getIdentifier(pSprite, "drawable", getPackageName());
        bugSprite = getResources().getIdentifier(bSprite, "drawable", getPackageName());

        // Set grid background object.
        base = (TableLayout) findViewById(R.id.gridBase);
        // Change grid color
        setBackgroundColor(gColor);
    }

    // Set background color with Color.ColorName value.
    private void setBackgroundColor(int c){
        base.setBackgroundColor(c);
    }

    // Set background color with argb value
    private void setBackgroundColor(int a, int r, int g, int b){
        base.setBackgroundColor(Color.argb(a,r,g,b));
    }

    // setPlayerSprite from drawable resources where pSprite is the name of the image without the file extension.
    private void setPlayerSprite(String pSprite){
        playerSprite = getResources().getIdentifier(pSprite, "drawable", getPackageName());
    }

    // Sets the sprite for the bug using drawable resource. String is name of image without file extension.
    private void setBugSprite(String bSprite){
        bugSprite = getResources().getIdentifier(bSprite, "drawable", getPackageName());
    }

    // Sets speed of player motion, the higher the number the slower the player moves.
    private void setPlayerSpeed(int pSpeed){
        playerSpeed = pSpeed;
    }

    // Sets speed of bug motion, the higher the number the slower the bug refreshes.
    private void setBugSpeed(int bSpeed){
        bugSpeed = bSpeed;
    }

    // Set player starting position.
    private void setPlayerStartPosition(int sp){
        // Gets ImageVew at int sp position.
        int curCellID = getResources().getIdentifier(("gameCell"+sp), "id", getPackageName());
        currentCell = (ImageView) findViewById(curCellID);
        // Turns the cell at the users position into the chosen player sprite.
        currentCell.setImageResource(playerSprite);
        // Set Activitys current position value.
        curPlayerLocation = sp;
    }

    // Character moves in the direction clicked at the speed set by the player.
    // These speeds can be used to signify difficulty levels for the game.
    protected void movePlayerTimer(){
        h.postDelayed(new Runnable(){
            public void run(){
                if (move) {
                    movePlayer(curPlayerLocation, direction);
                }
                h.postDelayed(this, playerSpeed);
            }
        }, playerSpeed);
    }

    // This method takes in the users current position on the game grid sized 30x30.
    // It then preDetermines the spaces the player can move from this position and sets
    // their ID values.
    private void movePlayer(int newNum, int dir){

        newNum = newNum + dir;
        checkForSquish();

        if (newNum == curPlayerLocation || newNum < 1 || newNum > 900){
            // Grid bounds reached or player has not moved.
        } else {
            // The integer represents a game grid cell from 1 to 900 on a 30x30 grid.
            // The current sell is now the previous cell and the new cell is the newNum value.
            prevPlayerLocation = curPlayerLocation;
            curPlayerLocation = newNum;

            // All the cells are named gameCell[] with [] being a number between 1 and 900.
            String prevCellName = "gameCell"+prevPlayerLocation;
            String curCellName = "gameCell"+curPlayerLocation;

            // Get the ID of the game cells in play.
            int prevCellID = getResources().getIdentifier(prevCellName, "id", getPackageName());
            int curCellID = getResources().getIdentifier(curCellName, "id", getPackageName());

            // Sets the current space object and prev space object so the sprites can be updated.
            prevCell = (ImageView) findViewById(prevCellID);
            currentCell = (ImageView) findViewById(curCellID);

            // reverts the previous cell to the grid base sprite
            prevCell.setImageResource(android.R.color.transparent);

            // Turns the cell at the users position into the chosen player sprite.
            currentCell.setImageResource(playerSprite);
        }
    }

    // checks to see if player and bug are in the same cell. If true, increment score and update score TextView.
    private void checkForSquish(){
        if (curBugLocation == curPlayerLocation){
            score++;
            String scoreString = ""+score;
            TextView sV = (TextView) findViewById(R.id.scoreView);
            sV.setText(scoreString);

            // crude way to remove the bug location so the player can't go back and forth over that space adn get points.
            curBugLocation = 1;
        }
    }
}
