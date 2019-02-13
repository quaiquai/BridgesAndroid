package com.example.bridgesgametest;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {

    private Bitmap image;
    private int xpos;
    private int ypos;

    public CharacterSprite(Bitmap bmp, int x, int y){
        image = bmp;
        xpos = x;
        ypos = y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image, xpos, ypos, null);
    }
}
