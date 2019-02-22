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

    // dimensions
    public int gridX = 30;
    public int gridY = 30;

    private Bitmap bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.symbols);
    private Bitmap subImage;

    //width and height for the sprite sheet
    private int WIDTH = bitmapImage.getWidth() / 16;
    private int HEIGHT = bitmapImage.getHeight() / 16;

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
    public void drawObject(int x, int y, NamedSymbol spriteName){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        //int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        GameGrid[(x*y)].setImageBitmap(sprite);//set bitmap image
    }

    // Draw object at specified grid location. Color hexValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, int color){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        //int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        setFGColor(x, y, color);//set bitmap color
    }

    // Draw object at specified grid location. Color rgbValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, int red, int blue, int green){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        //int sprite = getResources().getIdentifier(spriteName, "drawable", getActivity().getPackageName());
        setFGColor(x, y, red, blue, green);//set the bitmaps color
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
        Bitmap sprite = ((BitmapDrawable)GameGrid[(x*y)].getDrawable()).getBitmap();//gets the bitmap at certain imageview
        sprite.eraseColor(colorHex);//sets color of pixels to input rgb
        GameGrid[(x*y)].setImageBitmap(sprite);//sets image view to new bitmap
    }

    // Set foreground color of a grid cell using rgb values.
    public void setFGColor(int x, int y, int r, int g, int b){
        Bitmap sprite = ((BitmapDrawable)GameGrid[(x*y)].getDrawable()).getBitmap(); //gets the bitmap at certain imageview
        sprite.eraseColor(Color.rgb(r,g,b));//sets color of pixels to input rgb
        GameGrid[(x*y)].setImageBitmap(sprite);//sets image view to new bitmap
    }

    private Bitmap setSprite(NamedSymbol spriteName){
        switch(spriteName){
            case A:
                subImage = Bitmap.createBitmap(bitmapImage, 1* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case B:
                subImage = Bitmap.createBitmap(bitmapImage, 2* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case C:
                subImage = Bitmap.createBitmap(bitmapImage, 3* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case D:
                subImage = Bitmap.createBitmap(bitmapImage, 4* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case E:
                subImage = Bitmap.createBitmap(bitmapImage, 5* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
        }
        return subImage;
    }
}
