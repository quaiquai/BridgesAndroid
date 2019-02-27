package com.example.bridgesgametest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GameGrid extends Fragment {

    private Bitmap spriteSheet;

    // dimensions
    public int gridX;
    public int gridY;

    public int[] dimensions;

    // Array of gridCells as ImageViews from XML game_grid.
    public ImageView[][] GameGrid = new ImageView[30][30];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.game_grid, parent, false);

        spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.symbols);

        gridX = 30;
        gridY = 30;
        dimensions = new int[] {gridX, gridY};

        connectCells(v);

        return v;
    }

    // Set ImageView objects of game_grid xml to corresponding GameGrid ImageView array.
    public void connectCells(View v){
        String cellNameBase = "gameCell";
        String cellName;
        int cellCounter = 1;
        int cellID;

        for (int i = 0; i < gridX; i++){
            for (int j = 0; j < gridY; j++){
                cellName = cellNameBase+(cellCounter);
                cellID = getResources().getIdentifier(cellName, "id", getActivity().getPackageName());
                GameGrid[i][j] = v.findViewById(cellID);
                cellCounter++;
            }
        }
    }

    // Draw object at specified grid location. Color neutral.
    public void drawObject(int x, int y, NamedSymbol spriteName){
        GameGrid[x][y].setImageBitmap(spriteName.setSprite(spriteSheet));//set bitmap image. Will get the subimage based on the sprite name
    }

    // Draw object at specified grid location. Color hexValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, NamedColor colorHex){
        GameGrid[x][y].setImageBitmap(spriteName.setSprite(spriteSheet));//will get the subimage based on the sprite name
        setFGColor(x, y, colorHex);//set bitmap color
    }

    // Draw object at specified grid location. Color rgbValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, int red, int blue, int green){
        GameGrid[x][y].setImageBitmap(spriteName.setSprite(spriteSheet)); //will get the subimage based on the sprite name
        setFGColor(x, y, red, blue, green);//set the bitmaps color
    }

    // Return grid dimensions to user.
    public int[] getDimensions(){
        return dimensions;
    }

    // Set background color of a grid cell using androidAPI value.
    public void setBGColor(int x, int y, NamedColor colorHex){
        int col = colorHex.getHex();
        GameGrid[x][y].setBackgroundColor(col);
    }

    // Set background colors of a grid cell using rgb values.
    public void setBGColor(int x, int y, int r, int g, int b){
        GameGrid[x][y].setBackgroundColor(Color.rgb(r, g, b));
    }

    // Set foreground color of a grid cell using androidAPI color value.
    public void setFGColor(int x, int y, NamedColor colorHex){
        int col = colorHex.getHex();
        GameGrid[x][y].setColorFilter(col);//sets image view to new bitmap
    }

    // Set foreground color of a grid cell using rgb values.
    public void setFGColor(int x, int y, int r, int g, int b){
        //Bitmap sprite = ((BitmapDrawable)GameGrid[x][y].getDrawable()).getBitmap(); //gets the bitmap at certain imageview
        //sprite.eraseColor(Color.rgb(r,g,b));//sets color of pixels to input rgb
        GameGrid[x][y].setColorFilter(Color.rgb(r,g,b));//sets image view to new bitmap
    }

    public void clearImageView(int x, int y){
        GameGrid[x][y].setImageDrawable(null);
    }
}
