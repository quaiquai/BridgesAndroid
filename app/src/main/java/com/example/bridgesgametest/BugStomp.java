package com.example.bridgesgametest;

import android.graphics.Color;

public class BugStomp extends NGCKGame_AndroidVersion {
    int[] loc = {0, 0}; // row, col
    int[] boardSize;
    int[] bug;
    int bugttl = 100;
    int score = 0;
    NamedColor bugColor;
    boolean gameWon = false;

    static java.util.Random randomizer;

    public void initialize() {

        boardSize = grid.getDimensions();

        randomizer = new java.util.Random();
        bugColor = randomEnum(NamedColor.class);

        for (int i = 0; i < grid.getDimensions()[0]; i++) { // each row
            for (int j = 0; j < grid.getDimensions()[1]; j++) { // each column
                grid.setBGColor(i, j, NamedColor.white);
            }
        }

        bug = new int[]{10, 10};
    }

    public void handleInput() {
        if (KeyLeft())
            loc[1]--;
        if (KeyRight())
            loc[1]++;
        if (KeyUp())
            loc[0]--;
        if (KeyDown())
            loc[0]++;

        // check row top
        if (loc[0] < 1) loc[0] = 1;
        // check row bottom
        if (loc[0] > boardSize[0] - 1) loc[0] = boardSize[0] - 1;
        // check column left
        if (loc[1] < 0) loc[1] = 0;
        // check column right
        if (loc[1] > boardSize[1] - 1) loc[1] = boardSize[1] - 1;
    }

    public void handlebug() {
        if(bugttl < 1) {
            bug = new int[]{randomizer.nextInt(29)+1, randomizer.nextInt(29)+1};
            bugttl = randomizer.nextInt(100-50)+50;
            bugColor = randomEnum(NamedColor.class);
            score--;
            if(score < 0) score = 0;
        } else {
            bugttl--;
            if(overlap()) {
                bug = new int[]{randomizer.nextInt(29)+1, randomizer.nextInt(29)+1};
                bugColor = randomEnum(NamedColor.class);
                score++;
            }
        }
    }

    public Boolean overlap() {
        return (loc[0] == bug[0] && loc[1] == bug[1]);
    }

    public void paintScreen() {
        // paint black
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                SetBGColor(i, j, NamedColor.black);
                removeObject(i, j);
            }
        }

        if (score >= 3) {
            win();
            return;
        }

        paintScore(score);

        // paint bug
        grid.drawObject(bug[0], bug[1], NamedSymbol.bug3, bugColor);

        // paint current location
        grid.drawObject(loc[0], loc[1], NamedSymbol.man, NamedColor.white);
    }

    public void win() {

        // paint winner!
        grid.drawObject(0, 0, NamedSymbol.man, NamedColor.orange);
        grid.drawObject(0, 1, NamedSymbol.W, NamedColor.aqua);
        grid.drawObject(0, 2, NamedSymbol.i, NamedColor.aqua);
        grid.drawObject(0, 3, NamedSymbol.n, NamedColor.aqua);
        grid.drawObject(0, 4, NamedSymbol.man, NamedColor.orange);

        score = 0;
        gameWon = true;
    }

    public void paintScore(int score) {
        // paint score
        grid.drawObject(0, 0, NamedSymbol.S, NamedColor.aqua);
        grid.drawObject(0, 1, NamedSymbol.c, NamedColor.aqua);
        grid.drawObject(0, 2, NamedSymbol.o, NamedColor.aqua);
        grid.drawObject(0, 3, NamedSymbol.r, NamedColor.aqua);
        grid.drawObject(0, 4, NamedSymbol.e, NamedColor.aqua);
        grid.drawObject(0, 6, NamedSymbol.values()[score + 53], NamedColor.red);
    }

    public void stompGame() {
        handlebug();
        handleInput();
        paintScreen();
    }

    public void playAgainMenu() {

        grid.drawObject(0, 7, NamedSymbol.P, NamedColor.aqua);
        grid.drawObject(0, 8, NamedSymbol.l, NamedColor.aqua);
        grid.drawObject(0, 9, NamedSymbol.a, NamedColor.aqua);
        grid.drawObject(0, 10, NamedSymbol.y, NamedColor.aqua);

        grid.drawObject(0, 12, NamedSymbol.A, NamedColor.aqua);
        grid.drawObject(0, 13, NamedSymbol.g, NamedColor.aqua);
        grid.drawObject(0, 14, NamedSymbol.a, NamedColor.aqua);
        grid.drawObject(0, 15, NamedSymbol.i, NamedColor.aqua);
        grid.drawObject(0, 16, NamedSymbol.n, NamedColor.aqua);

        grid.drawObject(0, 18, NamedSymbol.Y, NamedColor.aqua);

        grid.drawObject(0, 20, NamedSymbol.o, NamedColor.aqua);
        grid.drawObject(0, 21, NamedSymbol.r, NamedColor.aqua);

        grid.drawObject(0, 23, NamedSymbol.N, NamedColor.aqua);

        grid.drawObject(7, 7, NamedSymbol.Y, NamedColor.green);
        grid.drawObject(22, 7, NamedSymbol.N, NamedColor.red);

        if (loc[0] == 7 && loc[1] == 7){
            gameWon = false;
        }else if(loc[0] == 22 && loc[1] == 7){
            System.exit(0);
        }
        removeObject(loc[0], loc[1]);

    }

    public void GameLoop() {
        if (!gameWon) {
            stompGame();
        } else {
            playAgainMenu();
            handleInput();
            grid.drawObject(loc[0], loc[1], NamedSymbol.man, NamedColor.linen);

        }
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = randomizer.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public void main() {

        initialize();
        // start running the game
        start();
    }

}
