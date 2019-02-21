package com.example.bridgesgametest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GameGrid extends Fragment {

    // dimensions
    public int gridX = 30;
    public int gridY = 30;

    public int[] dimensions = {gridX, gridY};

    // Array of gridCells as ImageViews from XML game_grid.
    public ImageView[] GameGrid = new ImageView[900];

    // A single cell ImageView object so cells can be accessed one at a time.
    public ImageView singleCell;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.game_grid, parent, false);

        connectCells(v);

        return v;
    }

    // Set ImageView objects of game_grid xml to corresponding GameGrid ImageView array.
    public void connectCells(View v){
        String cellNameBase = "gameCell";
        String cellName;
        int cellID;
        for (int i = 0; i < 900; i++){
            cellName = cellNameBase+(i+1);
            cellID = getResources().getIdentifier(cellName, "id", getActivity().getPackageName());
            GameGrid[i] = v.findViewById(cellID);
        }
    }

    public void GameGrid(int i, int x, int c){

    }

    public void drawObject(int x, int y, String s){

    }

    public void drawObject(int x, int y, String s, int c){

    }

    public void drawObject(int x, int y, NamedSymbol ns){

    }

    // Change the color of a cell using an android hex value "Color.colorName"
    public void setCellColor(int location, int color){
        GameGrid[location].setBackgroundColor(color);
    }

    public int[] getDimensions(){
        return dimensions;
    }

    public void setBGColor(int x, int y, int c){

    }


}
