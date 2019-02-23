package com.example.bridgesgametest;

import android.graphics.Color;

public class BugStomp extends NGCKGame_AndroidVersion{


    int[] loc = {0,0}; // row, col
    int[] boardSize;
    int[] bug;
    int bugttl = 100;
    int score = 0;
    int bugColor;

    static java.util.Random randomizer;

    public void init() {
        boardSize = grid.getDimensions();

        for(int i = 0; i < grid.getDimensions()[0]; i++) { // each row
            for(int j = 0; j < grid.getDimensions()[1]; j++) { // each column
                grid.setBGColor(i, j, Color.GRAY);
            }
        }

        bug = new int[]{10,10};
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
        if(loc[0] < 1) loc[0] = 1;
        // check row bottom
        if(loc[0] > boardSize[0]-1) loc[0] = boardSize[0]-1;
        // check column left
        if(loc[1] < 0) loc[1] = 0;
        // check column right
        if(loc[1] > boardSize[1]-1) loc[1] = boardSize[1]-1;
    }

    public void handlebug() {
        if(bugttl < 1) {
            bug = new int[]{20, 20};
            bugttl = 3;
            bugColor = Color.YELLOW;
            score--;
            if(score < 0) score = 0;
        } else {
            bugttl--;
            if(overlap(bug, loc)) {
                bug = new int[]{10, 10};
                bugColor = Color.RED;
                score++;
            }
        }
    }

    public Boolean overlap(int[] bug, int[] loc) {
        return Math.abs(bug[0] - loc[0]) < 2 && Math.abs(bug[1] - loc[1]) < 2;
    }

    public void paintScreen() {
        // paint black
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                SetBGColor(i, j, Color.BLACK);
            }
        }

        if(score >= 10) {
            win();
            return;
        }

        paintScore(score);


        // paint bug
        grid.drawObject(bug[0], bug[1], NamedSymbol.bug3, bugColor);

        // paint current location
        grid.drawObject(loc[0], loc[1], NamedSymbol.man, Color.BLUE);
    }

    public void win() {
        // paint winner!
        grid.drawObject(0,0, NamedSymbol.A);
        grid.drawObject(0,1, NamedSymbol.A);
        grid.drawObject(0,7, NamedSymbol.A);
    }

    public void paintScore(int score) {
        // paint score
        grid.drawObject(0,0, NamedSymbol.A);
    }

    public void GameLoop() {
        //if(score >= 10) System.exit(0);
        handlebug();
        handleInput();
        paintScreen();
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = randomizer.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public void main() {
        // start running the game
        //grid.setFGColor(20,20,Color.RED);
        init();
        start();
    }

}
