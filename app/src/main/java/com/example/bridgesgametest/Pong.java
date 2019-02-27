package com.example.bridgesgametest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Pong extends NGCKGame_AndroidVersion {
    // Values for the players paddle
    private int[] loc = {29, 0};
    private int[] prevLoc = {29, 0};
    private NamedColor paddleColor;
    private NamedSymbol paddleSymbol;

    // Values for the computers paddle
    private int[] compLoc = {0, 0};
    private int[] compPrevLoc = {0, 0};
    private NamedColor compPaddleColor;
    private NamedSymbol compPaddleSymbol;

    // Values for the ball
    private int[] ballLoc = {15, 15};
    private int[] ballPrevLoc = {14, 14};
    private NamedColor ballColor;
    private NamedSymbol ballSymbol;
    private boolean moveUpDown; // Value true makes the ball move down, false moves the ball up.
    private int moveLeftRightCenter; // Value 1 moves the ball right, value -1 moves the ball left, value 0 the ball moves straight up or down.

    private int reactionStrategy[][] = {{1, 18, 5}, {2, 17, 6}, {3, 16, 7}, {4, 15, 8}, {5, 14, 9}, {6, 13, 10}, {7, 12, 11}, {8, 11, 12}, {9, 10, 13}};
    private int compScore = 0;
    private int playerScore = 0;
    private int reactionCountdown = reactionStrategy[8][0]; // Time between moves. The longer it takes to react the worse the computer plays.
    private int errorCountdown = reactionStrategy[8][1]; // Time between computer paddle errors.
    private int errorDuration = reactionStrategy[8][2]; // Duration of computer paddle errors.
    private boolean error = false;
    private int level = 0; // Iterates through the strategy array setting the computers play reaction and error counter.

    // Set up the first state of the game grid.
    private void initialize() {
        // paint screen
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                if (i % 2 == j % 2) {
                    SetBGColor(i, j, NamedColor.gray);
                } else {
                    SetBGColor(i, j, NamedColor.darkgray);
                }
            }
        }

        // Draw player paddle
        paddleSymbol = NamedSymbol.square;
        paddleColor = NamedColor.aqua;
        grid.drawObject(loc[0], loc[1], paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol);

        // Draw computer paddle
        compPaddleSymbol = NamedSymbol.square;
        compPaddleColor = NamedColor.aqua;
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol);

        // Draw ball
        ballSymbol = NamedSymbol.circle;
        ballColor = NamedColor.aqua;
        grid.drawObject(ballLoc[0], ballLoc[1], ballSymbol);
    }

    private void drawPlayerPaddle() {
        removeObject(prevLoc[0], prevLoc[1]); // Remove old playerPaddle object
        removeObject(prevLoc[0], prevLoc[1] + 1);
        removeObject(prevLoc[0], prevLoc[1] + 2);
        grid.drawObject(loc[0], loc[1], paddleSymbol); // Draw new playerPaddle object
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol);
    }

    public void drawComputerPaddle() {
        removeObject(compPrevLoc[0], compPrevLoc[1]); // Remove old computerPaddle object
        removeObject(compPrevLoc[0], compPrevLoc[1] + 1);
        removeObject(compPrevLoc[0], compPrevLoc[1] + 2);
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol); // Draw new computerPaddle object
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol);
    }

    public void handleBall() {

        //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.black);
        ballPrevLoc[0] = ballLoc[0]; // Set prev location val.
        ballPrevLoc[1] = ballLoc[1]; // Set prev location val.
        removeObject(ballPrevLoc[0], ballPrevLoc[1]); // Erase ball object from prev location.

        if (ballLoc[0] == 1) { // Ball has reached top of the board.
            if (ballLoc[1] == compLoc[1] || ballLoc[1] == (compLoc[1] + 1) || ballLoc[1] == (compLoc[1] + 2)) { // Check for collision with computer paddle.
                if (compLoc[1] < compPrevLoc[1]) { // If the computers paddle is moving left ball bounces right.
                    ballLoc[1]++;
                    moveLeftRightCenter = 1;
                } else if (compLoc[1] > compPrevLoc[1]) { // If the computers paddle is moving right ball bounces left.
                    ballLoc[1]--;
                    moveLeftRightCenter = -1;
                } else { // If the computers paddle is not moving when the ball collides the ball is not pushed in either direction.
                    moveLeftRightCenter = 0;
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.green);
            } else { // If the ball reaches x:0 on the grid and doesn't hit the computers paddle player wins.
                playerScore++;
                if (level > 0) {
                    level--;
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.green);
            }
            ballLoc[0]++;
            moveUpDown = true;
        } else if (ballLoc[0] == 28) { // Ball has reached bottom of the grid.
            if (ballLoc[1] == loc[1] || ballLoc[1] == (loc[1] + 1) || ballLoc[1] == (loc[1] + 2)) { // Check for collision with player paddle.
                if (loc[1] < prevLoc[1]) { // If the players paddle is moving left ball bounces right.
                    ballLoc[1]++;
                    moveLeftRightCenter = 1;
                } else if (loc[1] > prevLoc[1]) { // If the players paddle is moving right ball bounces left.
                    ballLoc[1]--;
                    moveLeftRightCenter = -1;
                } else { // If the players paddle is not moving when the ball collides the ball is not pushed in either direction.
                    moveLeftRightCenter = 0;
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.red);
            } else { // If the ball reaches x:29 on the grid and doesn't hit the players paddle computer wins.
                compScore++;
                if (level < 8) {
                    level++;
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.red);
            }
            ballLoc[0]--;
            moveUpDown = false;
        } else { // This is reached when the ball is not interacting with either paddle or the top and bottom of the grid.

            if (moveUpDown) { // Continues moving the ball away from the computers paddle.
                ballLoc[0]++;
            } else if (!moveUpDown) { // Continues moving the ball away from the players paddle.
                ballLoc[0]--;
            }

            if (ballLoc[1] == 0) { // Ball bounces off the left side of the grid
                moveLeftRightCenter = 1;
            }
            if (ballLoc[1] == 29) { // Ball bounces off the right side of the grid
                moveLeftRightCenter = -1;
            }

            // Continues moving the ball in the direction it has been pushed. Either by the paddles or from bouncing off the wall of the grid.
            if (moveLeftRightCenter == 1) {
                ballLoc[1]++;
            } else if (moveLeftRightCenter == -1) {
                ballLoc[1]--;
            } else {
                // ball moves directly up or down
            }
        }
        grid.drawObject((ballLoc[0]), (ballLoc[1]), ballSymbol); // Draw ball object in new location.
    }

    private void handleInput() {
        prevLoc[0] = loc[0];
        prevLoc[1] = loc[1];
        if (KeyLeft())
            if (loc[1] > 0) {
                loc[1]--;
            }
        if (KeyRight())
            if (loc[1] < 27) {
                loc[1]++;
            }
    }

    private void handleComputerInput() {

        if (error) {
            compError();
            if (errorDuration == 0) {
                error = false;
                errorCountdown = reactionStrategy[level][1];
            }
        } else {
            compMove();
            if (errorCountdown == 0) {
                error = true;
                errorDuration = reactionStrategy[level][2];
            }
        }
    }

    private void compMove() {
        compPrevLoc[0] = compLoc[0];
        compPrevLoc[1] = compLoc[1];

        if (moveLeftRightCenter == -1) {
            if (compLoc[1] > 0) {
                compLoc[1]--;
            }
        }
        if (moveLeftRightCenter == 1) {
            if (compLoc[1] < 27) {
                compLoc[1]++;
            }
        }
        if (moveLeftRightCenter == 0) {
            if (((compLoc[1] + 1) < ballLoc[1]) && (compLoc[1] < 27)) {
                compLoc[1]++;
            }
            if (((compLoc[1] + 1) > ballLoc[1]) && (compLoc[1] > 0)) {
                compLoc[1]--;
            }
        }
    }

    private void compError() {
        if (compLoc[1] < 27) {
            compLoc[1]++;
        }
    }

    private void win(){

    }

    private void lose(){

    }

    // Game loop will run many times per second.
    public void GameLoop() {
        handleInput();
        drawPlayerPaddle();
        handleBall();

        ballSymbol.setColor(ballColor);

        if (reactionCountdown <= 0) {
            handleComputerInput();
            drawComputerPaddle();

            reactionCountdown = reactionStrategy[level][0];
        }

        reactionCountdown--;
    }

    // Called by the BufferedStart activity to begin running this game.
    public void main() {
        initialize();

        // start running the game
        start();
    }
}
