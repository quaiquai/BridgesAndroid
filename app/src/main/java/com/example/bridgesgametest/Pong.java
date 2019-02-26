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
    private NamedColor ballColor;
    private NamedSymbol ballSymbol;
    private int moveUpDown = 1; // Value 1 makes the ball move down, -1 moves the ball up.
    private int moveLeftRight = 1; // Value 1 makes the ball move right, -1 moves the ball left, 0 means the ball will not move left or right.

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

        if (ballLoc[0] == 0) { // Ball has reached top of the board
            if (ballLoc[1] == compLoc[1] || ballLoc[1] == (compLoc[1] + 1) || ballLoc[1] == (compLoc[1] + 2)) { // Check for collision
                moveUpDown = 1;
                if (compLoc[1] < compPrevLoc[1]) { // If the computers paddle is moving left ball bounces right
                    moveLeftRight = 1;
                } else if (compLoc[1] > compPrevLoc[1]) { // If the computers paddle is moving right ball bounces left
                    moveLeftRight = -1;
                } else { // If the computers paddle is not moving when the ball collides the ball is not pushed in either direction.
                    moveLeftRight = 0;
                }
            } else { // If the ball reaches x:0 on the grid and doesn't hit the computers paddle player wins.
                // win
            }
        } else if (ballLoc[0] == 29) { // Ball has reached bottom of the board
            if (ballLoc[1] == loc[1] || ballLoc[1] == (loc[1] + 1) || ballLoc[1] == (loc[1] + 2)) { // Check for collision
                moveUpDown = -1;
                if (loc[1] < prevLoc[1]) { // If the players paddle is moving left ball bounces right
                    moveLeftRight = 1;
                } else if (loc[1] > prevLoc[1]) { // If the players paddle is moving right ball bounces left
                    moveLeftRight = -1;
                } else { // If the players paddle is not moving when the ball collides the ball is not pushed in either direction.
                    moveLeftRight = 0;
                }
            } else { // If the ball reaches x:29 on the grid and doesn't hit the players paddle computer wins.
                // lose
            }
        }

        if (ballLoc[0] == 0) { // Ball bounces off the left side of the grid
            moveLeftRight = 1;
        }
        if (ballLoc[0] == 29) { // Ball bounces off the right side of the grid
            moveLeftRight = -1;
        }
    }

    private void moveBall() {
        removeObject(ballLoc[0], ballLoc[1]); // Erase ball object from prev location.
        grid.drawObject((ballLoc[0] + moveUpDown), (ballLoc[1] + moveLeftRight), ballSymbol); // Draw ball object in new location.
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

    private void paintScreen() {
        // paint screen
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                SetBGColor(i, j, NamedColor.white);
            }
        }

        drawPlayerPaddle();
        handleBall();
    }

    // Game loop will run many times per second.
    public void GameLoop() {
        handleInput();
        drawPlayerPaddle();
        moveBall();
    }

    // Called by the BufferedStart activity to begin running this game.
    public void main() {
        initialize();

        // start running the game
        start();
    }
}
