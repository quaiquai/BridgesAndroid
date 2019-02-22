package com.example.bridgesgametest;

import android.graphics.Color;

public class BridgesStudentGameBugStomp extends NGCKGame_AndroidVersion{

    int[] loc = {0,0}; // row, col
    int[] boardSize = grid.getDimensions();
    int[] bug;
    int bugttl = 100;
    int score = 0;
    int bugColor;

    static java.util.Random randomizer;

    public void initializeMethod() {
        for(int i = 0; i < grid.getDimensions()[0]; i++) { // each row
            for(int j = 0; j < grid.getDimensions()[1]; j++) { // each column
                grid.setBGColor(i, j, Color.WHITE);
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
            bug = new int[]{randomizer.nextInt(29)+1, randomizer.nextInt(29)+1};
            bugttl = randomizer.nextInt(100-50)+50;
            bugColor = randomizer.nextInt(Color.WHITE);
            score--;
            if(score < 0) score = 0;
        } else {
            bugttl--;
            if(overlap(bug, loc)) {
                bug = new int[]{randomizer.nextInt(29)+1, randomizer.nextInt(29)+1};
                bugColor = randomizer.nextInt(Color.WHITE);
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
                SetSymbol(i, j, "bug");
            }
        }

        if(score >= 10) {
            win();
            return;
        }

        paintScore(score);


        // paint bug
        grid.drawObject(bug[0], bug[1], "bug", bugColor);

        // paint current location
        grid.drawObject(loc[0], loc[1], "bug", Color.WHITE);
    }

    public void win() {
        // paint winner!
        grid.drawObject(0,0, "pixel_guy");
        grid.drawObject(0,1, "w");
        grid.drawObject(0,2, "i");
        grid.drawObject(0,3, "n");
        grid.drawObject(0,4, "n");
        grid.drawObject(0,5, "e");
        grid.drawObject(0,6, "r");
        grid.drawObject(0,7, "pixel_guy");
    }

    public void paintScore(int score) {
        // paint score
        grid.drawObject(0,0, "s");
        grid.drawObject(0,1, "c");
        grid.drawObject(0,2, "o");
        grid.drawObject(0,3, "r");
        grid.drawObject(0,4, "e");
    }

    public void GameLoop() {
        if(score >= 10) System.exit(0);
        handlebug();
        handleInput();
        paintScreen();
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = randomizer.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public void initialMethod() {
     // Initialize our nonblocking game
     //BridgesStudentGameBugStomp mg = new BridgesStudentGameBugStomp();

     // start running the game
     //mg.start();
    }
}
