package com.example.bridgesgametest;

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
    private boolean moveLeftRight; // Value true moves the ball right, value false moves the ball left.

    // Set up the first state of the game grid.
    private void initialize() {
        // paint screen
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                SetBGColor(i, j, NamedColor.white);
            }
        }

        // Draw player paddle
        paddleSymbol = NamedSymbol.triangle_up;
        paddleColor = NamedColor.aqua;
        grid.drawObject(loc[0], loc[1], paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol);

        // Draw computer paddle
        compPaddleSymbol = NamedSymbol.triangle_up;
        compPaddleColor = NamedColor.aqua;
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol);

        // Draw ball
        ballSymbol = NamedSymbol.triangle_up;
        ballColor = NamedColor.aqua;
        grid.drawObject(ballLoc[0], ballLoc[1], ballSymbol);
    }

    private void drawPlayerPaddle() {
        removeObject(prevLoc[0], prevLoc[1]);
        removeObject(prevLoc[0], prevLoc[1] + 1);
        removeObject(prevLoc[0], prevLoc[1] + 2);
        grid.drawObject(loc[0], loc[1], paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol);
    }

    public void drawComputerPaddle() {
        removeObject(compPrevLoc[0], compPrevLoc[1]);
        removeObject(compPrevLoc[0], compPrevLoc[1] + 1);
        removeObject(compPrevLoc[0], compPrevLoc[1] + 2);
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol);
    }

    public void handleBall() {

        ballPrevLoc[0] = ballLoc[0]; // Set prev location val.
        ballPrevLoc[1] = ballLoc[1]; // Set prev location val.
        removeObject(ballPrevLoc[0], ballPrevLoc[1]); // Erase ball object from prev location.

        if (ballLoc[0] == 1) { // Ball has reached top of the board.
            ballLoc[0]++;
            moveUpDown = true;
            if (ballLoc[1] == compLoc[1] || ballLoc[1] == (compLoc[1] + 1) || ballLoc[1] == (compLoc[1] + 2)) { // Check for collision with computer paddle.
                if (compLoc[1] < compPrevLoc[1]) { // If the computers paddle is moving left ball bounces right.
                    ballLoc[1]++;
                    moveLeftRight = true;
                } else if (compLoc[1] > compPrevLoc[1]) { // If the computers paddle is moving right ball bounces left.
                    ballLoc[1]--;
                    moveLeftRight = false;
                } else { // If the computers paddle is not moving when the ball collides the ball is not pushed in either direction.

                }
            } else { // If the ball reaches x:0 on the grid and doesn't hit the computers paddle player wins.
                // win
            }
        } else if (ballLoc[0] == 28) { // Ball has reached bottom of the grid.
            ballLoc[0]--;
            moveUpDown = false;
            if (ballLoc[1] == loc[1] || ballLoc[1] == (loc[1] + 1) || ballLoc[1] == (loc[1] + 2)) { // Check for collision with player paddle.
                if (loc[1] < prevLoc[1]) { // If the players paddle is moving left ball bounces right.
                    ballLoc[1]++;
                    moveLeftRight = true;
                } else if (loc[1] > prevLoc[1]) { // If the players paddle is moving right ball bounces left.
                    ballLoc[1]--;
                    moveLeftRight = false;
                } else { // If the players paddle is not moving when the ball collides the ball is not pushed in either direction.

                }
            } else { // If the ball reaches x:29 on the grid and doesn't hit the players paddle computer wins.
                // lose
            }
        } else { // This is reached when the ball is not interacting with either paddle or the top and bottom of the grid.

            if (moveUpDown) { // Continues moving the ball away from the computers paddle.
                ballLoc[0]++;
            } else if (!moveUpDown) { // Continues moving the ball away from the players paddle.
                ballLoc[0]--;
            }

            if (ballLoc[1] == 0) { // Ball bounces off the left side of the grid
                moveLeftRight = true;
            }
            if (ballLoc[1] == 29) { // Ball bounces off the right side of the grid
                moveLeftRight = false;
            }

            // Continues moving the ball in the direction it has been pushed. Either by the paddles or from bouncing off the wall of the grid.
            if (moveLeftRight) {
                ballLoc[1]++;
            } else {
                ballLoc[1]--;
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

    // Game loop will run many times per second.
    public void GameLoop() {
        handleInput();
        drawPlayerPaddle();
        handleBall();
    }

    // Called by the BufferedStart activity to begin running this game.
    public void main() {
        initialize();

        // start running the game
        start();
    }
}
