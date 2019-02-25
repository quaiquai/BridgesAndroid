package com.example.bridgesgametest;

public class MinimalGameStub_Android extends NGCKGame_AndroidVersion {

    // We will keep track of the maximum bounds of the grid
    int maxRows, maxCols;

    // Set up the first state of the game grid.
    public void initialize(){

    }

    // Game loop will run many times per second.
    public void GameLoop(){
        if (KeyUp()) System.out.println("The up key is currently pressed!");

    }

    // Called by the BufferedStart activity to begin running this game.
    public void main (){

        // Populate the grid boundaries
        maxRows = grid.getDimensions()[0];
        maxCols = grid.getDimensions()[1];

        // start running the game
        start();
    }
}
