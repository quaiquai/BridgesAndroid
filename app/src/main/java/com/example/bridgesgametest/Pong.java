package com.example.bridgesgametest;

public class Pong extends NGCKGame_AndroidVersion {
    // Values for the players paddle
    private int[] loc;
    private int[] prevLoc;
    private NamedColor paddleColor;
    private NamedSymbol paddleSymbol;

    // Values for the computers paddle
    private int[] compLoc;
    private int[] compPrevLoc;
    private NamedColor compPaddleColor;
    private NamedSymbol compPaddleSymbol;

    // Values for the ball
    private int[] ballLoc;
    private int[] ballPrevLoc;
    private NamedColor ballColor;
    private NamedSymbol ballSymbol;
    private boolean moveUpDown; // Value true makes the ball move down, false moves the ball up.
    private int moveLeftRightCenter; // Value 1 moves the ball right, value -1 moves the ball left, value 0 the ball moves straight up or down.

    // Reaction strategy represents the computers randomized errors. Harder levels start at [0] and get progressively easier until the easiest (computer has more errors) at [8].
    // Value at [0] represents the random bounds of reactionCountdown. Value at [1] represents countdown to next error.
    private final int reactionStrategy[][] = {{1, 18}, {2, 17}, {3, 16}, {4, 15}, {5, 14}, {6, 13}, {7, 12}, {8, 11}, {9, 10}};
    private int compScore;
    private int playerScore;
    private int reactionCountdown; // Time between moves. The longer it takes to react the worse the computer plays.
    private int errorCountdown; // Time between computer paddle errors.
    private int errorDuration; // Duration of computer paddle errors.
    private boolean error;
    private int level; // Iterates through the strategy array setting the computers play reaction and error counter.

    boolean gameOver = false;
    private int restartDelay = 20;
    boolean toggleLR = false; // Toggles the direction the ball bounces off the compPaddle when the paddle is still.

    // Set up the first state of the game grid.
    private void initialize() {

        prevLoc = new int[]{29, 15};
        loc = new int[]{29, 15};
        compPrevLoc = new int[]{0, 15};
        compLoc = new int[]{0, 15};
        ballLoc = new int[]{15, 15};
        ballPrevLoc = new int[]{15, 15};

        compScore = 0;
        playerScore = 0;
        reactionCountdown = 5;
        errorCountdown = reactionStrategy[8][1];
        errorDuration = 5;
        error = false;
        level = 3;

        // paint screen
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                if (i % 2 == j % 2) {
                    SetBGColor(i, j, NamedColor.navy);
                } else {
                    SetBGColor(i, j, NamedColor.darkblue);
                }
                removeObject(i, j);
            }
        }

        // Draw player paddle
        paddleSymbol = NamedSymbol.square;
        paddleColor = NamedColor.khaki;
        grid.drawObject(loc[0], loc[1], paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol);

        // Draw computer paddle
        compPaddleSymbol = NamedSymbol.square;
        compPaddleColor = NamedColor.khaki;
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol, compPaddleColor);
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol, compPaddleColor);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol, compPaddleColor);

        // Draw ball
        ballSymbol = NamedSymbol.circle;
        ballColor = NamedColor.aqua;
        grid.drawObject(ballLoc[0], ballLoc[1], ballSymbol);

        updateScore();
    }

    private void drawPlayerPaddle() {
        removeObject(prevLoc[0], prevLoc[1]); // Remove old playerPaddle object
        removeObject(prevLoc[0], prevLoc[1] + 1);
        removeObject(prevLoc[0], prevLoc[1] + 2);
        grid.drawObject(loc[0], loc[1], paddleSymbol, paddleColor); // Draw new playerPaddle object
        grid.drawObject(loc[0], loc[1] + 1, paddleSymbol, paddleColor);
        grid.drawObject(loc[0], loc[1] + 2, paddleSymbol, paddleColor);
    }

    public void drawComputerPaddle() {
        removeObject(compPrevLoc[0], compPrevLoc[1]); // Remove old computerPaddle object
        removeObject(compPrevLoc[0], compPrevLoc[1] + 1);
        removeObject(compPrevLoc[0], compPrevLoc[1] + 2);
        grid.drawObject(compLoc[0], compLoc[1], compPaddleSymbol, compPaddleColor); // Draw new computerPaddle object
        grid.drawObject(compLoc[0], compLoc[1] + 1, compPaddleSymbol, compPaddleColor);
        grid.drawObject(compLoc[0], compLoc[1] + 2, compPaddleSymbol, compPaddleColor);
    }

    public void handleBall() {

        //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.black);
        ballPrevLoc[0] = ballLoc[0]; // Set prev location val.
        ballPrevLoc[1] = ballLoc[1]; // Set prev location val.
        removeObject(ballPrevLoc[0], ballPrevLoc[1]); // Erase ball object from prev location.

        if (ballLoc[0] == 1) { // Ball has reached top of the board.
            if (ballLoc[1] == compLoc[1] || ballLoc[1] == (compLoc[1] + 1) || ballLoc[1] == (compLoc[1] + 2)) { // Check for collision with computer paddle.
                if (compLoc[1] < compPrevLoc[1]) { // If the computers paddle is moving left on collision ball bounces right.
                    ballLoc[1]++;
                    moveLeftRightCenter = 1;
                } else if (compLoc[1] > compPrevLoc[1]) { // If the computers paddle is moving right on collision ball bounces left.
                    ballLoc[1]--;
                    moveLeftRightCenter = -1;
                } else { // If the computers paddle is not moving when the ball collides the ball is not pushed in either direction.
                    if (toggleLR) {
                        moveLeftRightCenter = -1;
                        toggleLR = false;
                    } else {
                        moveLeftRightCenter = 1;
                        toggleLR = true;
                    }
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.green);
            } else { // If the ball reaches x:0 on the grid and doesn't hit the computers paddle player wins.
                ballLoc[1]--;
                compScore++;
                if (level > 0) {
                    level--;
                }
                updateScore();
                if (compScore > 5) {
                    lose();
                }
            }
            ballLoc[0]++;
            moveUpDown = true;
        } else if (ballLoc[0] == 28) { // Ball has reached bottom of the grid.
            if (ballLoc[1] == loc[1] - 1 || ballLoc[1] == loc[1] || ballLoc[1] == (loc[1] + 1) || ballLoc[1] == (loc[1] + 2) || ballLoc[1] == loc[1] + 3) { // Check for collision with player paddle.
                if (loc[1] < prevLoc[1]) { // If the players paddle is moving left on collision ball bounces right.
                    ballLoc[1]++;
                    moveLeftRightCenter = 1;
                } else if (loc[1] > prevLoc[1]) { // If the players paddle is moving right on collision ball bounces left.
                    ballLoc[1]--;
                    moveLeftRightCenter = -1;
                } else { // If the players paddle is not moving when the ball collides the ball is not pushed in either direction.
                    moveLeftRightCenter = 0;
                }
                //SetFGColor(ballLoc[0], ballLoc[1], NamedColor.red);
            } else { // If the ball reaches x:29 on the grid and doesn't hit the players paddle computer wins.
                ballLoc[1]++;
                playerScore++;
                if (level < 9) {
                    level++;
                }
                updateScore();
                if (playerScore > 5) {
                    win();
                }
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
            if (ballLoc[1] == 28) { // Ball bounces off the right side of the grid
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

    private void redrawBall() {
        ballLoc = new int[]{15, 15};
        ballPrevLoc = new int[]{14, 14};
        restartDelay = 20;
        moveLeftRightCenter = 0;
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
                errorDuration = (int) (Math.random() * 3);
            }
        }

        int countdownBounds = reactionStrategy[level][0];
        reactionCountdown = (int) (Math.random() * countdownBounds);
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
            if (((compLoc[1] + 1) < ballLoc[1]) && (compLoc[1] < 26)) {
                compLoc[1]++;
            }
            if (((compLoc[1] + 1) > ballLoc[1]) && (compLoc[1] > 0)) {
                compLoc[1]--;
            }
        }
    }

    private void compError() { // Cause computer to over-correct during the error duration.
        if (compLoc[1] < 26 && compLoc[1] <= ballLoc[1]) {
            compLoc[1]++;
            compLoc[1]++;
        } else if (compLoc[1] > 1 && compLoc[1] > ballLoc[1]) {
            compLoc[1]--;
            compLoc[1]--;
        }
    }

    private void updateScore() {

        clearScoreArea();

        grid.drawObject(8, 29, NamedSymbol.values()[compScore + 53], NamedColor.red);

        grid.drawObject(10, 29, NamedSymbol.star, NamedColor.skyblue);
        grid.drawObject(11, 29, NamedSymbol.S, NamedColor.skyblue);
        grid.drawObject(12, 29, NamedSymbol.C, NamedColor.skyblue);
        grid.drawObject(13, 29, NamedSymbol.O, NamedColor.skyblue);
        grid.drawObject(14, 29, NamedSymbol.R, NamedColor.skyblue);
        grid.drawObject(15, 29, NamedSymbol.E, NamedColor.skyblue);
        grid.drawObject(16, 29, NamedSymbol.star, NamedColor.skyblue);

        grid.drawObject(18, 29, NamedSymbol.values()[playerScore + 53], NamedColor.green);

        redrawBall();
    }

    private void win() {

        clearScoreArea();

        grid.drawObject(5, 29, NamedSymbol.values()[compScore + 53], NamedColor.red);

        grid.drawObject(7, 29, NamedSymbol.star, NamedColor.skyblue);
        grid.drawObject(8, 29, NamedSymbol.W, NamedColor.skyblue);
        grid.drawObject(9, 29, NamedSymbol.I, NamedColor.skyblue);
        grid.drawObject(10, 29, NamedSymbol.N, NamedColor.skyblue);
        grid.drawObject(11, 29, NamedSymbol.N, NamedColor.skyblue);
        grid.drawObject(12, 29, NamedSymbol.E, NamedColor.skyblue);
        grid.drawObject(13, 29, NamedSymbol.R, NamedColor.skyblue);
        grid.drawObject(14, 29, NamedSymbol.star, NamedColor.skyblue);

        grid.drawObject(16, 29, NamedSymbol.values()[playerScore + 53], NamedColor.green);

        gameOver = true;

    }

    private void lose() {

        clearScoreArea();

        grid.drawObject(5, 29, NamedSymbol.values()[compScore + 53], NamedColor.red);

        grid.drawObject(7, 29, NamedSymbol.star, NamedColor.yellow);
        grid.drawObject(8, 29, NamedSymbol.G, NamedColor.skyblue);
        grid.drawObject(9, 29, NamedSymbol.A, NamedColor.skyblue);
        grid.drawObject(10, 29, NamedSymbol.M, NamedColor.skyblue);
        grid.drawObject(11, 29, NamedSymbol.E, NamedColor.skyblue);

        grid.drawObject(13, 29, NamedSymbol.O, NamedColor.skyblue);
        grid.drawObject(14, 29, NamedSymbol.V, NamedColor.skyblue);
        grid.drawObject(15, 29, NamedSymbol.E, NamedColor.skyblue);
        grid.drawObject(16, 29, NamedSymbol.R, NamedColor.skyblue);
        grid.drawObject(17, 29, NamedSymbol.star, NamedColor.yellow);

        grid.drawObject(19, 29, NamedSymbol.values()[playerScore + 53], NamedColor.green);

        gameOver = true;
    }

    private void promptNewGame() {

        grid.drawObject(29, 3, NamedSymbol.Y, NamedColor.green);

        grid.drawObject(15, 9, NamedSymbol.star, NamedColor.yellow);
        grid.drawObject(15, 10, NamedSymbol.P, NamedColor.skyblue);
        grid.drawObject(15, 11, NamedSymbol.L, NamedColor.skyblue);
        grid.drawObject(15, 12, NamedSymbol.A, NamedColor.skyblue);
        grid.drawObject(15, 13, NamedSymbol.Y, NamedColor.skyblue);

        grid.drawObject(15, 15, NamedSymbol.A, NamedColor.skyblue);
        grid.drawObject(15, 16, NamedSymbol.G, NamedColor.skyblue);
        grid.drawObject(15, 17, NamedSymbol.A, NamedColor.skyblue);
        grid.drawObject(15, 18, NamedSymbol.I, NamedColor.skyblue);
        grid.drawObject(15, 19, NamedSymbol.N, NamedColor.skyblue);
        grid.drawObject(15, 20, NamedSymbol.star, NamedColor.yellow);

        grid.drawObject(29, 23, NamedSymbol.N, NamedColor.red);

        if (3 == loc[1] || 3 == (loc[1] + 1) || 3 == (loc[1] + 2)) {
            gameOver = false;
            initialize();
        } else if (25 == loc[1] || 25 == (loc[1] + 1) || 25 == (loc[1] + 2)) {
            System.exit(0);
        }
    }

    public void clearScoreArea() {
        for (int i = 0; i < 30; i++) {
            removeObject(i, 29);
            grid.setBGColor(i, 29, NamedColor.black);
        }
    }

    public void pongGame() {

        // Player controls.
        handleInput();
        drawPlayerPaddle();

        if (restartDelay == 0) {
            SetFGColor(15, 15, NamedColor.white);
            removeObject(15, 15);
            handleBall();

            ballSymbol.setColor(ballColor);

            if (reactionCountdown <= 0) {
                handleComputerInput();
                drawComputerPaddle();
            }
            reactionCountdown--;
        } else {
            // Delay after the ball has been reset.
            if (restartDelay > 15) {
                grid.drawObject(15, 15, NamedSymbol.values()[3 + 53], NamedColor.red);
            } else if (restartDelay > 10) {
                grid.drawObject(15, 15, NamedSymbol.values()[2 + 53], NamedColor.yellow);
            } else if (restartDelay > 5) {
                grid.drawObject(15, 15, NamedSymbol.values()[1 + 53], NamedColor.green);
            }
            if (restartDelay == 0) {

                restartDelay = 0;
            } else {
                restartDelay--;
            }
        }
    }

    // Game loop will run many times per second.
    public void GameLoop() {

        if (!gameOver) {
            pongGame();
        } else {
            promptNewGame();
            handleInput();
            drawPlayerPaddle();
        }
    }

    // Called by the BufferedStart activity to begin running this game.
    public void main() {
        initialize();

        // start running the game
        start();
    }
}
