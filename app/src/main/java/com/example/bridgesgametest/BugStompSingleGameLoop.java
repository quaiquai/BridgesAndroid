package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import java.util.Random;

public class BugStompSingleGameLoop extends AppCompatActivity {

    private GameGrid grid;

    // Image view objects to give buttons onclick listeners
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView xButton;// not yet implemented
    private ImageView yButton;// not yet implemented

    // TableLayout object that holds the grid cells.
    private TableLayout base;

    // Grid cell as object for players current and previous location
    // so previous location can be reset when player moves.
    private ImageView prevCell;
    private ImageView currentCell;

    // Cell as object for bug.
    private ImageView bugCell;

    // Handler for enemy loop management. A higher number is slower
    private Handler h = new Handler();

    // Fps for game loop handler delay
    private int fps = 100;

    // Frame counter for refreshing bug
    private int frameCount = 0;

    // Integer to change directions in grid.
    // 0 means not moving, 1 moves player right, -1 moves player left,
    // -30 moves player up, 30 moves player down.
    // Boolean also needs to be true for the loop to run.
    private int direction;
    private boolean move;

    // Player locations on grid. Number between 1 and 900.
    private int curPlayerLocation;
    private int prevPlayerLocation;

    // Bug current location on grid. Number 1 through 900 on a 30x30 board.
    private int curBugLocation;

    // IDs for selected sprites.
    private int playerSprite;
    private int bugSprite;

    // Score counter
    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // Creates onTouch listeners for each button.
        setButtonObjectListeners();

        // Default game values for testing.
        useDefaultGameValues();

        // Loop that runs the game after values have been initialized.
        gameLoop();
    }

    public void gameLoop(){
        h.postDelayed(new Runnable(){
            public void run(){

                // Moves player to current location + direction.
                // Basic directions are -1 for left, 1 right, -30 up, 30 down.
                // Player can also move to different parts of the board by setting the
                // direction value to different numbers. The move player function is set not to
                // move the player outside of the grid bounds even if these values exceed the grid size.
                movePlayer(curPlayerLocation, direction);

                // The bug doesn't move every frame or it would be too fast.
                // Moving every 80 frames when the fps delay is 30 seems
                // to be an average speed.
                frameCount++;
                if (frameCount == 80){
                    makeBug();
                    frameCount = 0;
                }
                h.postDelayed(this, fps);
            }
        }, fps);
    }

    // Sets game default values for speed, and look of the game so that we can test functionality of new
    // methods without having to worry about game appearance.
    public void useDefaultGameValues(){

        setPlayerSprite("pixel_guy");
        setBugSprite("bug");

        direction = 0;
        score = 0;
        move = false;
        base = (TableLayout) findViewById(R.id.gridBase);

        grid.setCellColor(5, Color.GREEN);
        setFPS(100);
        setPlayerStartPosition(30);
        setBugStartPosition(2);
        setBugStartPosition(2);
    }

    // A method to alter the game variables all at once.
    public void setAllGamePreferences(String pSprite, String bSprite, int gColor, int frameSpeed, int pStartLocation, int bStartPosition){

        direction = 0;
        score = 0;
        move = false;

        setPlayerSprite(pSprite);
        setBugSprite(bSprite);

        base = (TableLayout) findViewById(R.id.gridBase);
        setBackgroundColor(gColor);
        setFPS(frameSpeed);
        setPlayerStartPosition(pStartLocation);
        setBugStartPosition(bStartPosition);
    }

    // Set background color with Color.ColorName value.
    public void setBackgroundColor(int c){
        base.setBackgroundColor(c);
    }

    // Set background color with argb value
    public void setBackgroundColor(int a, int r, int g, int b){
        base.setBackgroundColor(Color.argb(a,r,g,b));
    }

    // setPlayerSprite from drawable resources where pSprite is the name of the image without the file extension.
    public void setPlayerSprite(String pSprite){
        playerSprite = getResources().getIdentifier(pSprite, "drawable", getPackageName());
    }

    // Sets the sprite for the bug using drawable resource. String is name of image without file extension.
    public void setBugSprite(String bSprite){
        bugSprite = getResources().getIdentifier(bSprite, "drawable", getPackageName());
    }

    // Set fps
    public void setFPS(int newFPS){
        fps = newFPS;
    }

    // Set player starting position.
    public void setPlayerStartPosition(int sp){
        if(sp > 0 && sp < 901) {
            curPlayerLocation = sp;
            prevPlayerLocation = sp;
            // Gets ImageVew at int sp position.
            int curCellID = getResources().getIdentifier(("gameCell" + sp), "id", getPackageName());
            currentCell = (ImageView) findViewById(curCellID);
            // Turns the cell at the users position into the chosen player sprite.
            currentCell.setImageResource(playerSprite);
            // Set Activities current position value.
        }else{
            setPlayerStartPosition(30);
        }
    }

    // Sets the initial position of the bug sprite on the grid.
    public void setBugStartPosition(int bsp){
        if(bsp > 0 && bsp < 901) {
            curBugLocation = bsp;
            int curCellID = getResources().getIdentifier(("gameCell" + bsp), "id", getPackageName());
            bugCell = (ImageView) findViewById(curCellID);
            bugCell.setImageResource(bugSprite);
        }else{
            setBugStartPosition(2);
        }
    }

    // Removes old bug sprite and places a new one in a random location on the grid.
    public void makeBug(){
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

    // This method takes in the users current position on the grid as well as the direction the player is moving.
    // For example, by adding the current position to the direction where dir = -1 the character moves left.
    // 1 moves right, -30 moves up, and 30 moves down on the 30x30 grid.
    // The top leftmost cell is 1 and the bottom rightmost cell is 900.
    // To set the new space directly use the movePlayer(int directToCell) method.
    public void movePlayer(int cc, int dir){

        int newCell = cc + dir;

        checkForSquish();

        if (move) {
            if (newCell == curPlayerLocation || newCell < 1 || newCell > 900) {
                // Grid bounds reached or player has not moved.
            } else {
                // The integer represents a game grid cell from 1 to 900 on a 30x30 grid.
                // The current sell is now the previous cell and the new cell is the newNum value.
                prevPlayerLocation = curPlayerLocation;
                curPlayerLocation = newCell;

                // All the cells are named gameCell[] with [] being a number between 1 and 900.
                String prevCellName = "gameCell" + prevPlayerLocation;
                String curCellName = "gameCell" + curPlayerLocation;

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
        }else{
            // No buttons are being pressed
        }
    }

    // This method moves the player to a cell between 1 and 900 on a 30x30 grid.
    // The top leftmost cell is 1 and the bottom rightmost cell is 900.
    public void movePlayer(int directToCell){

        checkForSquish();

        if (move) {
            if (directToCell == curPlayerLocation || directToCell < 1 || directToCell > 900) {
                // Grid bounds reached or player has not moved.
            } else {
                // The integer represents a game grid cell from 1 to 900 on a 30x30 grid.
                // The current sell is now the previous cell and the new cell is the new value.
                prevPlayerLocation = curPlayerLocation;
                curPlayerLocation = directToCell;

                // All the cells are named gameCell_ with _ being a number between 1 and 900.
                String prevCellName = "gameCell" + prevPlayerLocation;
                String curCellName = "gameCell" + curPlayerLocation;

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
        }else{
            // No buttons are being pressed
        }
    }

    // checks to see if player and bug are in the same cell. If true, increment score and update score TextView.
    public void checkForSquish(){
        if (curBugLocation == curPlayerLocation){
            score++;
            String scoreString = ""+score;
            TextView sV = (TextView) findViewById(R.id.scoreView);
            sV.setText(scoreString);

            // crude way to remove the bug location so the player can't go back and forth over that space adn get points.
            curBugLocation = 1;
        }
    }

    public int getFPS(){
        return fps;
    }
    public int getScore(){
        return score;
    }
    public int getDirection(){
        return direction;
    }
    public int getBugPosition(){
        return curBugLocation;
    }
    public int getPrevPlayerPosition(){
        return prevPlayerLocation;
    }
    public int getPlayerPosition(){
        return curPlayerLocation;
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
