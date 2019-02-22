package com.example.bridgesgametest;

import android.graphics.Color;
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

    // Draw object at specified grid location. Color neutral.
    public void drawObject(int x, int y, String spriteName){
        int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        GameGrid[(x*y)].setImageResource(sprite);
    }

    // Draw object at specified grid location. Color hexValue.
    public void drawObject(int x, int y, String spriteName, int color){
        int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        GameGrid[(x*y)].setImageResource(sprite);
        setFGColor(x, y, color);
    }

    // Draw object at specified grid location. Color rgbValue.
    public void drawObject(int x, int y, String spriteName, int red, int blue, int green){
        int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        GameGrid[(x*y)].setImageResource(sprite);
        setFGColor(x, y, red, blue, green);
    }

    // Return grid dimensions to user.
    public int[] getDimensions(){
        return dimensions;
    }

    // Set background color of a grid cell using androidAPI value.
    public void setBGColor(int x, int y, int colorHex){
        GameGrid[(x*y)].setBackgroundColor(colorHex);
    }

    // Set background colors of a grid cell using rgb values.
    public void setBGColor(int x, int y, int r, int g, int b){
        GameGrid[(x*y)].setBackgroundColor(Color.rgb(r, g, b));
    }

    // Set foreground color of a grid cell using androidAPI value.
    public void setFGColor(int x, int y, int colorHex){
        GameGrid[(x*y)].setColorFilter(colorHex);
    }

    // Set foreground color of a grid cell using rgb values.
    public void setFGColor(int x, int y, int r, int g, int b){
        GameGrid[(x*y)].setColorFilter(Color.rgb(r, g, b));
    }
}
